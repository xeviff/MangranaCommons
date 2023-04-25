package tv.mangrana.plex.url;


import com.sun.org.apache.xerces.internal.dom.DeferredElementImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.mangrana.config.CommonConfigFileLoader;
import tv.mangrana.utils.Output;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class PlexLibrarySectionsResolver {

    private final PlexCommandLauncher commandLauncher;
    private final CommonConfigFileLoader<?> config;

    public PlexLibrarySectionsResolver(PlexCommandLauncher commandLauncher, CommonConfigFileLoader<?> config) {
        this.commandLauncher = commandLauncher;
        this.config = config;
    }

    public String resolveSectionByPath(String fullDestinationPath, String plexMountPath) {
        String keyFolder = fullDestinationPath.replaceFirst(plexMountPath,"").split("/")[1];
        Document xmlDocument = commandLauncher.retrieveSectionsInfo();
        XPath xPath = XPathFactory.newInstance().newXPath();
        String startingLocationText = plexMountPath.concat("/").concat(keyFolder).concat("/");
        String directoryNodeOfLocation = getDirectoryKeyValue(xmlDocument, xPath, startingLocationText);
        if (directoryNodeOfLocation == null) {
            startingLocationText = plexMountPath.concat("/").concat(keyFolder);
            Output.log("but going to retry with {0}", startingLocationText);
            return getDirectoryKeyValue(xmlDocument, xPath, startingLocationText);
        } else
            return directoryNodeOfLocation;
    }

    private String getDirectoryKeyValue(Document xmlDocument, XPath xPath, String startingLocationText) {
        String expression = "/MediaContainer/Directory/Location[starts-with(@path, '"+ startingLocationText +"')]";
        try {
            NodeList candidatesNodes = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            Node directoryNodeOfLocation  = candidatesNodes.item(0).getParentNode();
            return ((DeferredElementImpl) directoryNodeOfLocation).getAttribute("key");
        } catch (XPathExpressionException | NullPointerException e) {
            Output.log("could not resolve the section of the element in plex "+startingLocationText);
        }
        return null;
    }

}
