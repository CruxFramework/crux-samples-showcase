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
package org.cruxframework.showcasecore.client.resource.large;

import org.cruxframework.crux.core.client.resources.Resource;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive.Device;
import org.cruxframework.showcasecore.client.resource.common.ShowcaseResourcesCommon;

import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * @author Gesse Dafe
 *
 */
@Resource(value="showcaseCoreResources", supportedDevices={Device.largeDisplayArrows, Device.largeDisplayMouse, Device.largeDisplayTouch})
public interface ShowcaseResourcesLarge extends ShowcaseResourcesCommon
{
	@Source({"org/cruxframework/showcasecore/client/resource/common/cssShowcaseCommon.css", "cssShowcaseLarge.css", 
			 "org/cruxframework/showcasecore/client/resource/ie8/cssShowcaseLargeIe8.css"})
	CssShowcaseLarge css();
	
	@Source("icon-layout.png")
	DataResource layoutSectionIcon();
	
	@Source("icon-site.png")
	DataResource siteIcon();
	
	@Source("icon-project.png")
	DataResource projectIcon();
	
	@Source("svg-icon-present.svg")
	DataResource svgIconPresent();
	
	@Source("svg-icon-arrow.svg")
	DataResource svgIconArrow();
	
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
	
	
	
	@Source("crux.png")
	ImageResource crux();
	
	@Source("guile.png")
	DataResource guile();
	
	@Source("logo-large.png")
	DataResource logoLarge();
	
	@Source("right-arrow.png")
	DataResource rightArrow();
	
	@Source("noise.png")
	DataResource noise();
	
	
	
	
	@Source("heads.png")
	ImageResource heads();
	
	@Source("tails.png")
	ImageResource tails();
	
	//SwapViewContainer	
	@Source("product.png")
	ImageResource product();
		
	@Source("addedProduct.png")
	ImageResource addedProduct();
	
	@Source("purchaseCompleted.png")
	ImageResource purchaseCompleted();
}
