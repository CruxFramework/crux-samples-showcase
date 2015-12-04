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
package org.cruxframework.crossdeviceshowcase.client.resource.small;

import org.cruxframework.crossdeviceshowcase.client.resource.common.ShowcaseSamplesResourcesCommon;
import org.cruxframework.crux.core.client.resources.Resource;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive.Device;

import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * @author Samuel Almeida Cardoso (samuel@cruxframework.org)
 *
 */
@Resource(value="showcaseSamplesResources", supportedDevices={Device.smallDisplayArrows, Device.smallDisplayTouch})
public interface ShowcaseSamplesResourcesSmall extends ShowcaseSamplesResourcesCommon
{
	@Source({
		"org/cruxframework/crossdeviceshowcase/client/resource/common/anchorCommon.css", "anchorSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/breadcrumbCommon.css", "breadcrumbSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/carouselCommon.css", "carouselSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/colorpickerdialogCommon.css", "colorpickerdialogSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/comboboxCommon.css", "comboboxSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/confirmCommon.css", "confirmSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/cruxbuttonCommon.css", "cruxbuttonSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/cruxlabelCommon.css", "cruxlabelSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/datagridCommon.css", "datagridSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/dateCommon.css", "dateSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/dialogboxCommon.css", "dialogboxSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/dialogviewcontainerCommon.css", "dialogviewcontainerSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/downloadbuttonCommon.css", "downloadbuttonSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/fileuploaderCommon.css", "fileuploaderSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/filterCommon.css", "filterSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/formdisplayCommon.css", "formdisplaySmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/gwttextboxCommon.css", "gwttextboxSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/imageCommon.css", "imageSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/listshuttleCommon.css", "listshuttleSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/maskedlabelCommon.css", "maskedlabelSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/maskedtextboxCommon.css", "maskedtextboxSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/menuCommon.css", "menuSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/messageboxCommon.css", "messageboxSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/numbertextboxCommon.css", "numbertextboxSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/offlinedatabaseCommon.css", "offlinedatabaseSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/pagersCommon.css", "pagersSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/progressboxCommon.css", "progressboxSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/promobannerCommon.css", "promobannerSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/restCommon.css", "restSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/rollingpanelCommon.css", "rollingpanelSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/scrollbannerCommon.css", "scrollbannerSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/selectablepanelCommon.css", "selectablepanelSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/sideMenuDisposalCommon.css", "sideMenuDisposalSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/simpleviewcontainerCommon.css", "simpleviewcontainerSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/singleselectCommon.css", "singleselectSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/slideshowCommon.css", "slideshowSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/sortablelistCommon.css", "sortablelistSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/storyboardCommon.css", "storyboardSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/styledpanelCommon.css", "styledpanelSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/swappanelCommon.css", "swappanelSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/swapviewcontainerCommon.css", "swapviewcontainerSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/tabpanelCommon.css", "tabpanelSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/tabviewcontainerCommon.css", "tabviewcontainerSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/textareaCommon.css", "textareaSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/timerCommon.css", "timerSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/topmenudisposalCommon.css", "topmenudisposalSmall.css",
		"org/cruxframework/crossdeviceshowcase/client/resource/common/widgetlistCommon.css", "widgetlistSmall.css"
		})
	CssShowcaseSamplesSmall css();
	
	@Source("svg-icon-present.svg")
	DataResource svgIconPresent();
	
	@Source("banner1.jpg")
	ImageResource banner1promo();
	
	@Source("banner2.jpg")
	ImageResource banner2promo();
	
	@Source("banner3.jpg")
	ImageResource banner3promo();
	
	//Image
	@Source("coliseu.jpg")
	ImageResource coliseu();
	
	@Source("eiffel.jpg")
	ImageResource eiffel();
	
	@Source("liberty.jpg")
	ImageResource liberty();
	
	@Source("heads.png")
	ImageResource heads();
	
	@Source("tails.png")
	ImageResource tails();
	
	//SwapViewContainer	
	@Source("mobileProduct.png")
	ImageResource product();
	
	@Source("mobileAddedProduct.png")
	ImageResource addedProduct();
	
	@Source("mobilePurchaseCompleted.png")
	ImageResource purchaseCompleted();
}
