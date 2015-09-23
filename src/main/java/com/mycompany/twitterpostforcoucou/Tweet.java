/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitterpostforcoucou;

/**
 *
 * @author janit_000
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.PagableResponseList;

//import twitter4j.Query;
//import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
//import twitter4j;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class Tweet {

    private static Logger logger;

    public static void main(String[] args) {
        try {

            new Tweet().publishStatusUpdateWithMedia("@amandineLefRTW #5in5 #saveadream #amandineleforestier http://tinyurl.com/pej2vqp back this project, 5 Euro, 5 minutes");

        } catch (MalformedURLException ex) {
            Logger.getLogger(Tweet.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(Tweet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tweetMessageToUser(String username) {
        try {
            publishStatusUpdateWithMedia(username
                    + " 60% funded & 13 days to go #kisskissbankbank #amandineleforestier "
                    + "http://tinyurl.com/pej2vqp");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Tweet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tweet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tweet() {
        logger = Logger.getLogger(Tweet.class.getName());
    }

    private void publishStatusUpdateWithMedia(String message) throws MalformedURLException, IOException {
        Status status = null;
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            try {
                RequestToken requestToken = twitter.getOAuthRequestToken();
                AccessToken accessToken = null;
                while (null == accessToken) {
                    logger.fine("Open the following URL and grant access to your account:");
                    logger.fine(requestToken.getAuthorizationURL());
                    try {
                        accessToken = twitter.getOAuthAccessToken(requestToken);
                    } catch (TwitterException te) {
                        if (401 == te.getStatusCode()) {
                            logger.severe("Unable to get the access token.");
                        } else {
                            te.printStackTrace();
                        }
                    }
                }
                logger.log(Level.INFO, "Got access token.");
                logger.log(Level.INFO, "Access token: {0}", accessToken.getToken());
                logger.log(Level.INFO, "Access token secret: {0}", accessToken.getTokenSecret());
            } catch (IllegalStateException ie) {
                // access token is already available, or consumer key/secret is not set.
                if (!twitter.getAuthorization().isEnabled()) {
                    logger.severe("OAuth consumer key/secret is not set.");
                    return;
                }
            }
            //Instantiate and initialize a new twitter status update
            StatusUpdate statusUpdate = new StatusUpdate(message);
            //attach any media, if you want to
            statusUpdate.setMedia(
                    //title of media
                    "Amandine Leforestier Spring Summer 2015 white",
                    new URL("https://issuu.com/kadiemurphy/docs/volume_xxi_issuu/52?e=0").openStream());
            //tweet or update status
            status = twitter.updateStatus(statusUpdate);

            //Status status = twitter.updateStatus(message);
            logger.log(Level.INFO, "Successfully updated the status to [{0}].", status.getText());
        } catch (TwitterException te) {
            te.printStackTrace();
            logger.log(Level.SEVERE, "Failed to get timeline: {0}", te.getMessage());
        }
    }

    public Twitter getTwitter() {
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            RequestToken requestToken = twitter.getOAuthRequestToken();
            AccessToken accessToken = null;
            while (null == accessToken) {
                logger.fine("Open the following URL and grant access to your account:");
                logger.fine(requestToken.getAuthorizationURL());
                try {
                    accessToken = twitter.getOAuthAccessToken(requestToken);
                } catch (TwitterException te) {
                    if (401 == te.getStatusCode()) {
                        logger.severe("Unable to get the access token.");
                    } else {
                        logger.log(Level.SEVERE, "Failed to get timeline: {0}", te.getMessage());
                    }
                }
            }
            logger.log(Level.INFO, "Got access token.");
            logger.log(Level.INFO, "Access token: {0}", accessToken.getToken());
            logger.log(Level.INFO, "Access token secret: {0}", accessToken.getTokenSecret());
        } catch (IllegalStateException ie) {
            // access token is already available, or consumer key/secret is not set.
            if (!twitter.getAuthorization().isEnabled()) {
                logger.log(Level.SEVERE, "OAuth consumer key/secret is not set: {0}", ie.getMessage());
                return null;
            }
        } catch (TwitterException te) {
            logger.log(Level.SEVERE, "OAuth request token: {0}", te.getMessage());
        }
        return twitter;
    }

    public void getFollowers(String username, Twitter twitter) {
        long cursor = -1;
        PagableResponseList<User> followers = null;
        do {
            try {
                followers = twitter.getFollowersList(username, cursor);
            } catch (TwitterException ex) {
                Logger.getLogger(Tweet.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            for (User follower : followers) {
                // TODO: Collect top 10 followers here
                System.out.println(follower.getName() + " has " + follower.getFollowersCount() + " follower(s)");
            }
        } while ((cursor = followers.getNextCursor()) != 0);
    }

    public void tweetMessageToUser(String username, String hashtags, String imageUrl, String targetUrl) {
        Twitter twitterHandle = this.getTwitter();
        //Instantiate and initialize a new twitter status update
        String message = username + " " + targetUrl + " " + hashtags + " #amandineleforestier" ;
        StatusUpdate statusUpdate = new StatusUpdate(message);
        try {
            //attach any media, if you want to
            statusUpdate.setMedia(
                    //title of media
                    "Amandine Leforestier Autumn Winter 2015 http://shop.amandineleforestier.fr",
                    new URL(imageUrl).openStream());
        } catch (MalformedURLException ex) {
            logger.log(Level.SEVERE, "Bad image Url {0}", ex.getMessage());
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Cannot open Url {0}", ex.getMessage());
        }
        //tweet or update status
        Status status = null;
        try {
            status = twitterHandle.updateStatus(statusUpdate);
        } catch (TwitterException te) {
            logger.log(Level.SEVERE, "Failed to get timeline: {0}", te.getMessage());
        }

        //Status status = twitter.updateStatus(message);
        if (status != null) {
            logger.log(Level.INFO, "Successfully updated the status to [{0}].", status.getText());
        } else {
            logger.log(Level.SEVERE, "Status update failed [{0}].", status);
        }
    }
}
