/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.Candidat;
import com.gdc.services.Imetier;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;
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
import javax.mail.internet.MimeMessage;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;

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

    private List listecandidats;
    private DefaultTreeNode root;
    private Candidat selectedCandidat;

    public String archiverCandidat() {
        FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Annulation", " Tests!");
        RequestContext.getCurrentInstance().showMessageInDialog(msg1);
        return null;
    }

    public String notifierCandidat() {
        //**********************variable dans l'envoi du mail***************
        String from = "ahmetdamecisse";  // GMail user name (just the part before "@gmail.com")
        String PASSWORD = "ahmeth1989"; // GMail password
        String RECIPIENT = "ahmet.dame@hotmail.fr";
        String subject = "Java send mail example";
        String body = "Welcome to JavaMail!";
        //**********************variable dans l'envoi du mail***************
        String[] to = {RECIPIENT}; // list of recipient email addresses
        sendFromGMail(from, PASSWORD, to, subject, body);

        return null;
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
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

            message.setSubject(subject);
            message.setText(body);
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

    public String fixerEntretienCandidat() {
        FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Annulation", " Tests!");
        RequestContext.getCurrentInstance().showMessageInDialog(msg1);
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

}
