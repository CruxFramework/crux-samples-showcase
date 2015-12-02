/*
 * Copyright 2013 cruxframework.org.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.cruxframework.crossdeviceshowcase.client.resource.large;

import org.cruxframework.crossdeviceshowcase.client.resource.common.ShowcaseSamplesResourcesCommon;
import org.cruxframework.crux.core.client.resources.Resource;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive.Device;

/**
 * @author Samuel Almeida Cardoso (samuel@cruxframework.org)
 *
 */
@Resource(value="showcaseSamplesResources", supportedDevices={Device.largeDisplayArrows, Device.largeDisplayMouse, Device.largeDisplayTouch})
public interface ShowcaseSamplesResourcesLarge extends ShowcaseSamplesResourcesCommon
{
	@Source({
		"org/cruxframework/crossdeviceshowcase/client/resource/common/anchorCommon.css", "anchorLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/breadcrumbCommon.css", "breadcrumbLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/carouselCommon.css", "carouselLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/colorpickerdialogCommon.css", "colorpickerdialogLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/comboboxCommon.css", "comboboxLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/confirmCommon.css", "confirmLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/cruxbuttonCommon.css", "cruxbuttonLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/cruxlabelCommon.css", "cruxlabelLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/datagridCommon.css", "datagridLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/dateCommon.css", "dateLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/dialogboxCommon.css", "dialogboxLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/dialogviewcontainerCommon.css", "dialogviewcontainerLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/downloadbuttonCommon.css", "downloadbuttonLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/fileuploaderCommon.css", "fileuploaderLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/filterCommon.css", "filterLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/formdisplayCommon.css", "formdisplayLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/gwttextboxCommon.css", "gwttextboxLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/imageCommon.css", "imageLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/listshuttleCommon.css", "listshuttleLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/maskedlabelCommon.css", "maskedlabelLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/maskedtextboxCommon.css", "maskedtextboxLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/menuCommon.css", "menuLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/messageboxCommon.css", "messageboxLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/numbertextboxCommon.css", "numbertextboxLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/offlinedatabaseCommon.css", "offlinedatabaseLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/pagersCommon.css", "pagersLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/progressboxCommon.css", "progressboxLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/promobannerCommon.css", "promobannerLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/restCommon.css", "restLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/rollingpanelCommon.css", "rollingpanelLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/scrollbannerCommon.css", "scrollbannerLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/selectablepanelCommon.css", "selectablepanelLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/sideMenuDisposalCommon.css", "sideMenuDisposalLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/simpleviewcontainerCommon.css", "simpleviewcontainerLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/singleselectCommon.css", "singleselectLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/slideshowCommon.css", "slideshowLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/sortablelistCommon.css", "sortablelistLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/storyboardCommon.css", "storyboardLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/styledpanelCommon.css", "styledpanelLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/swappanelCommon.css", "swappanelLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/swapviewcontainerCommon.css", "swapviewcontainerLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/tabpanelCommon.css", "tabpanelLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/tabviewcontainerCommon.css", "tabviewcontainerLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/textareaCommon.css", "textareaLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/timerCommon.css", "timerLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/topmenudisposalCommon.css", "topmenudisposalLarge.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/widgetlistCommon.css", "widgetlistLarge.css"
		})
	CssShowcaseSamplesLarge css();
	
}
