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
package org.cruxframework.crossdeviceshowcase.client.resource.common;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;

/**
 * @author Samuel Almeida Cardoso (samuel@cruxframework.org)
 *
 */
public interface ShowcaseSamplesResourcesCommon extends ClientBundle
{
	@Source(
		{
		"anchorCommon.css",
		"breadcrumbCommon.css",
		"carouselCommon.css",
		"colorpickerdialogCommon.css",
		"comboboxCommon.css",
		"confirmCommon.css",
		"cruxbuttonCommon.css",
		"cruxlabelCommon.css",
		"datagridCommon.css",
		"dateCommon.css",
		"dialogboxCommon.css",
		"dialogviewcontainerCommon.css",
		"downloadbuttonCommon.css",
		"fileuploaderCommon.css",
		"filterCommon.css",
		"formdisplayCommon.css",
		"gwttextboxCommon.css",
		"imageCommon.css",
		"listshuttleCommon.css",
		"maskedlabelCommon.css",
		"maskedtextboxCommon.css",
		"menuCommon.css",
		"messageboxCommon.css",
		"numbertextboxCommon.css",
		"offlinedatabaseCommon.css",
		"pagersCommon.css",
		"progressboxCommon.css",
		"promobannerCommon.css",
		"restCommon.css",
		"rollingpanelCommon.css",
		"scrollbannerCommon.css",
		"selectablepanelCommon.css",
		"sideMenuDisposalCommon.css",
		"simpleviewcontainerCommon.css",
		"singleselectCommon.css",
		"slideshowCommon.css",
		"sortablelistCommon.css",
		"storyboardCommon.css",
		"styledpanelCommon.css",
		"swappanelCommon.css",
		"swapviewcontainerCommon.css",
		"tabpanelCommon.css",
		"tabviewcontainerCommon.css",
		"textareaCommon.css",
		"timerCommon.css",
		"topmenudisposalCommon.css",
		"widgetlistCommon.css"
		})
	CssResource cssShowcaseSamplesCommon();
	
	@Source("guile.png")
	DataResource guile();
}
