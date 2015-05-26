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
package org.cruxframework.showcasecore.client.resource.common;

import org.cruxframework.crux.core.client.resources.Resource;
import org.cruxframework.crux.core.client.screen.DeviceAdaptive.Device;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

/**
 * @author @author Samuel Almeida Cardoso (samuel@cruxframework.org)
 *
 */
@Resource(value="showcaseCoreResourcesCommon", supportedDevices={Device.all})
public interface ShowcaseResourcesCommon extends ClientBundle
{
	@Source("cssShowcaseCommon.css")
	CssResource cssShowcaseCommon();
	
	@Source("prism.js")
	TextResource jsPrism();
	
	@Source("prism.css")
	CssResource cssPrism();
	
	@Source("countries/algeria.jpg")
	ImageResource algeria();
	
	@Source("countries/argentina.jpg")
	ImageResource argentina();
	
	@Source("countries/australia.jpg")
	ImageResource australia();
	
	@Source("countries/brazil.jpg")
	ImageResource brazil();
	
	@Source("countries/canada.jpg")
	ImageResource canada();
	
	@Source("countries/chile.jpg")
	ImageResource chile();
	
	@Source("countries/china.jpg")
	ImageResource china();
	
	@Source("countries/costaRica.jpg")
	ImageResource costaRica();
	
	@Source("countries/france.jpg")
	ImageResource france();
	
	@Source("countries/germany.jpg")
	ImageResource germany();
	
	@Source("countries/italy.jpg")
	ImageResource italy();
	
	@Source("countries/japan.jpg")
	ImageResource japan();
	
	@Source("countries/mexico.jpg")
	ImageResource mexico();
	
	@Source("countries/morocco.jpg")
	ImageResource morocco();
	
	@Source("countries/southAfrica.jpg")
	ImageResource southAfrica();
	
	@Source("countries/southKorea.jpg")
	ImageResource southKorea();
	
	@Source("countries/usa.jpg")
	ImageResource spain();
	
	@Source("countries/usa.jpg")
	ImageResource usa();
}
