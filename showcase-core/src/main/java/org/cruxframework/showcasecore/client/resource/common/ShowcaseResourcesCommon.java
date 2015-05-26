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

import com.google.gwt.i18n.client.Messages.Optional;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author @author Samuel Almeida Cardoso (samuel@cruxframework.org)
 *
 */
public interface ShowcaseResourcesCommon extends ClientBundle
{
	@Source("cssShowcaseCommon.css")
	CssResource cssShowcaseCommon();
	
	@Source("prism.js")
	TextResource jsPrism();
	
	@Source("prism.css")
	CssResource cssPrism();
	
	
//	Browsers
	@Source("browsers/ie.png")
	@ImageOptions(repeatStyle=RepeatStyle.Both)
	ImageResource ie9();
	
	@Source("browsers/chrome.png")
	@ImageOptions(repeatStyle=RepeatStyle.Both)
	ImageResource chrome();
	
	@Source("browsers/safari.png")
	@ImageOptions(repeatStyle=RepeatStyle.Both)
	ImageResource safari();
	
	@Source("browsers/firefox.png")
	@ImageOptions(repeatStyle=RepeatStyle.Both)
	ImageResource firefox();
	
	
//	RandomPager
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
	
//	Menu
	@Source("logos/audi.png")
	ImageResource audi();
	
	@Source("logos/bmw.png")
	ImageResource bmw();
	
	@Source("logos/chevrolet.png")
	ImageResource chevrolet();
	
	@Source("logos/ford.png")
	ImageResource ford();
	
	@Source("logos/gmc.png")
	ImageResource gmc();
	
	@Source("logos/hondaCar.png")
	ImageResource hondaCar();
	
	@Source("logos/hyundai.png")
	ImageResource hyundai();
	
	@Source("logos/mercedes.png")
	ImageResource mercedes();
	
	@Source("logos/peterbilt.png")
	ImageResource peterbilt();
	
	@Source("logos/scania.png")
	ImageResource scania();
	
	@Source("logos/volkswagen.png")
	ImageResource volkswagen();
	
	@Source("logos/volvo.png")
	ImageResource volvo();
	
	@Source("logos/yamaha.png")
	ImageResource yamaha();
	
	@Source("logos/honda.png")
	ImageResource honda();
	
	@Source("logos/mitsubishi.png")
	ImageResource mitsubishi();
	

//	Image RollingPanel
	@Source("sports/baseball.jpg")
	ImageResource baseball();	
	
	@Source("sports/basketball.jpg")
	ImageResource basketball();	
	
	@Source("sports/canoeing.jpg")
	ImageResource canoeing();	
	
	@Source("sports/football.jpg")
	ImageResource football();	
	
	@Source("sports/motocross.jpg")
	ImageResource motocross();
	
	@Source("sports/running.jpg")
	ImageResource running();
	
	@Source("sports/snowboard.jpg")
	ImageResource snowboard();
	
	@Source("sports/soccerball.jpg")
	ImageResource soccerball();
	
	@Source("sports/swimming.jpg")
	ImageResource swimming();
	
	@Source("sports/volleyball.jpg")
	ImageResource volleyball();
	
	
//	RollingPanel custom component
	@Source("sports/backpack.png")
	ImageResource backpack();

	@Source("sports/baseballbats.png")
	ImageResource baseballbats();
	
	@Source("sports/basketballshoes.png")
	ImageResource basketballshoes();
	
	@Source("sports/footballboots.png")
	ImageResource footballboots();
	
	@Source("sports/gloves.png")
	ImageResource gloves();
	
	@Source("sports/pinkball.png")
	ImageResource pinkball();
	
	@Source("sports/swimshorts.png")
	ImageResource swimshorts();
	
	//Disposals
	@Source("mammals.jpg")
	ImageResource mammals();
	
	@Source("reptiles.jpg")
	ImageResource reptiles();
	
	@Source("birds.jpg")
	ImageResource birds();
	
	@Source("amphibians.jpg")
	ImageResource amphibians();	
	
	@Source("animals.png")
	ImageResource animals();	
	
//	Disposal-mobile
	@Source("topMenuDisposal.png")
	ImageResource topMenuDisposal();
	
	@Source("sideMenuDisposal.png")
	ImageResource sideMenuDisposal();
	
	//SwapViewContainer
	@Source("shopping.png")
	@ImageOptions(repeatStyle=RepeatStyle.Vertical)
	ImageResource shopping();
	
//	SwapPanel
	@Source("crux.png")
	ImageResource crux();
	
//	SequentialPager
	@Source("cd.jpg")
	ImageResource cd();
}
