package tv.mangrana.sonarr.api.client.gateway;

import tv.mangrana.config.ConfigFileLoader;
import tv.mangrana.sonarr.api.schema.command.RefreshSerieCommand;
import tv.mangrana.sonarr.api.schema.history.SonarrHistory;
import tv.mangrana.sonarr.api.schema.queue.SonarrQueue;
import tv.mangrana.sonarr.api.schema.series.SonarrSerie;
import tv.mangrana.utils.EasyLogger;
import tv.mangrana.utils.Output;
import tv.mangrana.utils.rest.APIProxyBuilderSingleton;

import static tv.mangrana.config.ConfigFileLoader.ProjectConfiguration.SONARR_API_HOST;
import static tv.mangrana.config.ConfigFileLoader.ProjectConfiguration.SONARR_API_KEY;

public class SonarrApiGateway {

    private final String apiKey;
    private final SonarrAPIInterface proxy;
    private final EasyLogger logger;

    public SonarrApiGateway(ConfigFileLoader config) {
        apiKey = config.getConfig(SONARR_API_KEY);
        proxy = APIProxyBuilderSingleton.getSonarrInterface(config.getConfig(SONARR_API_HOST));
        logger = new EasyLogger();
    }

    public SonarrQueue getQueue() {
        return proxy.getQueue(apiKey);
    }

    public void deleteQueueElement(Integer idElement) {
        proxy.deleteQueueElement(idElement, false, apiKey);
        log("sent Delete command to Sonarr for the queue element with id "+idElement);
    }

    public SonarrSerie getSerieById(Integer seriesId) {
        SonarrSerie serie = null;
        try {
            serie = proxy.getSerieById(seriesId, apiKey);
            logger.nLog("retrieved serie from sonarr with id "+seriesId);
        } catch (Exception e) {
            logger.nHLog("Error while getSerieById: {0}", e.getMessage());
        }
        return serie;
    }

    public void refreshSerie(Integer seriesId) {
        proxy.refreshSeriesCommand(new RefreshSerieCommand(seriesId), apiKey);
        log("sent Refresh command to Sonarr for the serie with id "+seriesId);
    }

    public SonarrHistory getHistory () {
        return proxy.getHistory("date", "desc", 200, 1, apiKey);
    }

    private void log (String msg) {
        Output.log("SonarrApiGateway: "+msg);
    }

}
