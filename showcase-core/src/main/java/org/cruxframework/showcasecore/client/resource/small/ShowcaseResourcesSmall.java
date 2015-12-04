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
package org.cruxframework.showcasecore.client.resource.small;

import org.cruxframework.crux.core.client.resources.Resource;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive.Device;
import org.cruxframework.showcasecore.client.resource.common.ShowcaseResourcesCommon;

import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * @author Gesse Dafe
 *
 */
@Resource(value="showcaseCoreResources", supportedDevices={Device.smallDisplayArrows, Device.smallDisplayTouch})
public interface ShowcaseResourcesSmall extends ShowcaseResourcesCommon
{
	@Source({"org/cruxframework/showcasecore/client/resource/common/cssShowcaseCommon.css", "cssShowcaseSmall.css"})
	CssShowcaseSmall css();
	
	@Source("icon-layout.png")
	DataResource layoutSectionIcon();
	
	@Source("svg-icon-house.svg")
	DataResource svgIconHouse();
	
	@Source("svg-icon-code.svg")
	DataResource svgIconCode();
	
	@Source("svg-icon-arrow.svg")
	DataResource svgIconArrow();
	
	@Source("svg-icon-menu.svg")
	DataResource svgIconMenu();
	
	@Source("crux.png")
	ImageResource crux();
	
	@Source("logo-small.png")
	DataResource logoSmall();
	
	@Source("right-arrow.png")
	DataResource rightArrow();
	
	@Source("noise.png")
	DataResource noise();
	
	@Source("mundi.jpg")
	DataResource mundi();
}
