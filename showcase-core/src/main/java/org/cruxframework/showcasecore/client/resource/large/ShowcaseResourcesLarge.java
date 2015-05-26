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

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * @author Gesse Dafe
 *
 */
@Resource(value="showcaseCoreResources", supportedDevices={Device.all})
public interface ShowcaseResourcesLarge extends ClientBundle
{
	@Source("cssShowcaseLarge.css")
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
	
	@Source("coliseu.jpg")
	DataResource image1Image();
	
	@Source("eiffel.jpg")
	DataResource image2Image();
	
	@Source("liberty.jpg")
	DataResource image3Image();
	
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
}
