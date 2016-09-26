/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.Candidat;
import com.gdc.model.Entretien;
import com.gdc.model.Notification;
import com.gdc.model.Profil;
import com.gdc.model.Recruteur;
import com.gdc.model.Suivreentrtien;
import com.gdc.services.Imetier;
import java.io.File;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author a618092
 */
@ManagedBean(name = "notificationsBean")
@SessionScoped
public class NotificationsBean implements Serializable {

    /**
     * Creates a new instance of NotificationsBean
     */
    //Spring User Service is injected...
    @ManagedProperty(value = "#{Metier}")
    Imetier metier;

    //Injecting Managed beans
    @ManagedProperty(value = "#{redigerCV}")
    private RedigerCV redigerCV;

    @PostConstruct
    public void init() {
        listecandidats = metier.getAllCandidat();
        root = new DefaultTreeNode(new Candidat());
        if (!listecandidats.isEmpty()) {
            for (int i = 0; i < listecandidats.size(); i++) {
                DefaultTreeNode unCandidat = new DefaultTreeNode(listecandidats.get(i), root);
            }
        }
    }

    private Entretien entretien = new Entretien();
    private List listecandidats;
    private DefaultTreeNode root;
    private Candidat selectedCandidat;
    private String etatProfil;
    //**********************variable dans l'envoi du mail***************
    private String from;
    private String PASSWORD;
    private String RECIPIENT;
    private String subject;
    private String body;
    private Notification notification = new Notification();
    private UploadedFile pieceJointe;
    private boolean afficherInterfaceMailActivator = false;
    //**********************variable dans l'envoi du mail***************

    public String fixerEntretienCandidat() {
        // entretien.setVersion(1);
        entretien.setUsername(metier.getRecruteurById(redigerCV.getUser().getUsername()));
        entretien.setResultat(BigInteger.ZERO);

        metier.addEntretien(entretien);

        Integer idEntreteintCree = entretien.getIdEntretien();
        String usernameCandidatConcerne = selectedCandidat.getUsername();
        Suivreentrtien suivreentrtien = new Suivreentrtien(usernameCandidatConcerne, idEntreteintCree);
        
        metier.addsuiviEntretien(suivreentrtien);

        FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Entretien", "Enregistré avec succès.");
        RequestContext.getCurrentInstance().showMessageInDialog(msg1);
        return null;
    }

    public String archiverCandidat() {
        Profil p = selectedCandidat.getIdTypeDeProfil();
        p.setEtatProfil(etatProfil);

        metier.addProfil(p);

        FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Archivage", " effectué avec succès.");
        RequestContext.getCurrentInstance().showMessageInDialog(msg1);
        return null;
    }

    public String notifierCandidat() {
        //**********************variable dans l'envoi du mail***************
        from = "ahmetdamecisse";  // GMail user name (just the part before "@gmail.com") On doit le faire avec compte et un mot de passe prévu à cet effet
        PASSWORD = "ahmeth1989"; // GMail password
        RECIPIENT = selectedCandidat.getUsers().getMail();
        subject = "Informations";
        //**********************variable dans l'envoi du mail debut persistence notification***************
        Recruteur recruteurQuiNotifie = metier.getRecruteurById(redigerCV.getUser().getUsername());
        notification.setUsername(recruteurQuiNotifie);
        notification.setDestinateur(recruteurQuiNotifie.getUsers().getPrenom() + " " + recruteurQuiNotifie.getUsers().getNom());
        notification.setDestinataire(selectedCandidat.getUsername());
        notification.setCorpsMessage(body);
        // notification.setPj(pieceJointe);
        notification.setDateNotification(new Date());
        metier.addNotification(notification);
        //**********************fin persistence notification***************
        String[] to = {RECIPIENT}; // list of recipient email addresses
        File file = new File("C:\\Users\\A618092\\Desktop\\mes bagages\\Version la plus récente\\memoire Thies\\ProjetMemoreGantt.gan");
        sendFromGMail(from, PASSWORD, to, subject, body, file);

        return null;
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body, File file) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            //converting an UploadedFile into a java File.

            FileDataSource datasource1 = new FileDataSource(file);
            DataHandler handler1 = new DataHandler(datasource1);
            MimeBodyPart partiePieceJointe = new MimeBodyPart();
            partiePieceJointe.setDataHandler(handler1);
            partiePieceJointe.setFileName(datasource1.getName());

            MimeBodyPart partieContenu = new MimeBodyPart();
            partieContenu.setContent(body, "text/plain");

            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(partieContenu);
            mimeMultipart.addBodyPart(partiePieceJointe);

            message.setSubject(subject);
            message.setContent(mimeMultipart);

            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", " envoyée avec succès!");
            RequestContext.getCurrentInstance().showMessageInDialog(msg1);
        } catch (AddressException ae) {
            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Echec", " de l'envoi de la notification!");
            RequestContext.getCurrentInstance().showMessageInDialog(msg1);
            ae.printStackTrace();
        } catch (MessagingException me) {
            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Echec", " de l'envoi de la notification!");
            RequestContext.getCurrentInstance().showMessageInDialog(msg1);
            me.printStackTrace();
        }
    }

    public String afficherInterfaceMail() {
        setAfficherInterfaceMailActivator(true);
        return null;
    }

    public Candidat getSelectedCandidat() {
        return selectedCandidat;
    }

    public void setSelectedCandidat(Candidat selectedCandidat) {
        this.selectedCandidat = selectedCandidat;
    }

    public List getListecandidats() {
        return listecandidats;
    }

    public Imetier getMetier() {
        return metier;
    }

    public void setMetier(Imetier metier) {
        this.metier = metier;
    }

    public void setListecandidats(List listecandidats) {
        this.listecandidats = listecandidats;
    }

    public DefaultTreeNode getRoot() {
        return root;
    }

    public void setRoot(DefaultTreeNode root) {
        this.root = root;
    }

    public NotificationsBean() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getRECIPIENT() {
        return RECIPIENT;
    }

    public void setRECIPIENT(String RECIPIENT) {
        this.RECIPIENT = RECIPIENT;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UploadedFile getPieceJointe() {
        return pieceJointe;
    }

    public void setPieceJointe(UploadedFile pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    public boolean isAfficherInterfaceMailActivator() {
        return afficherInterfaceMailActivator;
    }

    public void setAfficherInterfaceMailActivator(boolean afficherInterfaceMailActivator) {
        this.afficherInterfaceMailActivator = afficherInterfaceMailActivator;
    }

    public String getEtatProfil() {
        return etatProfil;
    }

    public void setEtatProfil(String etatProfil) {
        this.etatProfil = etatProfil;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public RedigerCV getRedigerCV() {
        return redigerCV;
    }

    public void setRedigerCV(RedigerCV redigerCV) {
        this.redigerCV = redigerCV;
    }

    public Entretien getEntretien() {
        return entretien;
    }

    public void setEntretien(Entretien entretien) {
        this.entretien = entretien;
    }

}
