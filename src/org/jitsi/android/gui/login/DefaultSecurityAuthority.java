/*
 * Jitsi, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package org.jitsi.android.gui.login;

import net.java.sip.communicator.service.protocol.*;

/**
 * Utility class that can be used in cases where components other than the main
 * user interface may need to launch provider registration. At the time I am
 * writing this, the <tt>DefaultSecurityAuthority</tt> is being used by the
 * systray and uri handlers.
 *
 * @author Yana Stamcheva
 * @author Emil Ivov
 */
public class DefaultSecurityAuthority
    implements SecurityAuthority
{
    private final ProtocolProviderService protocolProvider;

    private boolean isUserNameEditable = false;

    /**
     * Creates an instance of <tt>SecurityAuthorityImpl</tt>.
     *
     * @param protocolProvider The <tt>ProtocolProviderService</tt> for this
     * <tt>SecurityAuthority</tt>.
     */
    public DefaultSecurityAuthority(ProtocolProviderService protocolProvider)
    {
        this.protocolProvider = protocolProvider;
    }

    /**
     * Implements the <code>SecurityAuthority.obtainCredentials</code> method.
     * Creates and show an <tt>AuthenticationWindow</tt>, where user could enter
     * its password.
     * @param realm The realm that the credentials are needed for.
     * @param userCredentials the values to propose the user by default
     * @param reasonCode indicates the reason for which we're obtaining the
     * credentials.
     * @return The credentials associated with the specified realm or null if
     * none could be obtained.
     */
    public UserCredentials obtainCredentials(
            String realm,
            UserCredentials userCredentials,
            int reasonCode)
    {
        return userCredentials;
    }

    /**
     * Implements the <code>SecurityAuthority.obtainCredentials</code> method.
     * Creates and show an <tt>AuthenticationWindow</tt>, where user could enter
     * its password.
     * @param realm The realm that the credentials are needed for.
     * @param userCredentials the values to propose the user by default
     * @return The credentials associated with the specified realm or null if
     * none could be obtained.
     */
    public UserCredentials obtainCredentials(
            String realm,
            UserCredentials userCredentials)
    {
        return this.obtainCredentials(realm, userCredentials,
            SecurityAuthority.AUTHENTICATION_REQUIRED);
    }

    /**
     * Sets the userNameEditable property, which indicates if the user name
     * could be changed by user or not.
     * 
     * @param isUserNameEditable indicates if the user name could be changed by
     * user
     */
    public void setUserNameEditable(boolean isUserNameEditable)
    {
        this.isUserNameEditable = isUserNameEditable;
    }

    /**
     * Indicates if the user name is currently editable, i.e. could be changed
     * by user or not.
     * 
     * @return <code>true</code> if the user name could be changed,
     * <code>false</code> - otherwise.
     */
    public boolean isUserNameEditable()
    {
        return isUserNameEditable;
    }
}