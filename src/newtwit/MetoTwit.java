/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtwit;

import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import twitter4j.*;
import twitter4j.Twitter;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.DirectMessage;
/**
 *
 * @author Serg Bena
 */
public class MetoTwit {

    private Object sender;

    /**
     * Con este metodo obtendras el listado de twits de las personas que sigues.
     */
    public void GettinTimeline() {
         // The factory instance is re-useable and thread safe.

        List<Status> statuses = null;
        try {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("consumerKey")
                    .setOAuthConsumerSecret("consumerSecret")
                    .setOAuthAccessToken("accessToken")
                    .setOAuthAccessTokenSecret("accessTokenSecret");

            Twitter twitter = new TwitterFactory(cb.build()).getInstance();
            Status status = twitter.updateStatus("test");
            statuses = twitter.getHomeTimeline();
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(MetoTwit.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }
    }

    /**
     * Este Método servira para buscar los twits que busques.
     *
     * @throws TwitterException
     */
    public void buscaJastak() throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("consumerKey")
                .setOAuthConsumerSecret("consumerSecret")
                .setOAuthAccessToken("accessToken")
                .setOAuthAccessTokenSecret("accessTokenSecret");

        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        String bus = JOptionPane.showInputDialog("Que # esta buscando");
        Query query = new Query("#" + bus);//Coloca lo que buscas
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }

    /**
     * Con este método se enviara un twit en tu cuenta
     *
     * @throws TwitterException
     */
    public void post() throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("consumerKey")
                .setOAuthConsumerSecret("consumerSecret")
                .setOAuthAccessToken("accessToken")
                .setOAuthAccessTokenSecret("accessTokenSecret");

        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        String latestStatus = null;
        latestStatus = JOptionPane.showInputDialog("Introduzca el twit");
        Status status = twitter.updateStatus(latestStatus);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }
/**
 * Envia mensajes privados
 * @throws TwitterException 
 */
    public void mensajePrivado() throws TwitterException {
        String amigo;
        String mensaje;
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("consumerKey")
                .setOAuthConsumerSecret("consumerSecret")
                .setOAuthAccessToken("accessToken")
                .setOAuthAccessTokenSecret("accessTokenSecret");

        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        amigo=JOptionPane.showInputDialog("¿A quien quieres enviarlo?");
        mensaje=JOptionPane.showInputDialog("escribe tu mensaje");
        DirectMessage message = twitter.sendDirectMessage(amigo, mensaje);
        System.out.println("mensaje enviado"+message.getRecipientScreenName());
    }
}
