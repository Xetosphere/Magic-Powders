package com.webs.blazecoding.core.handlers;

import com.webs.blazecoding.core.util.LocalizationUtil;
import com.webs.blazecoding.lib.Localizations;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 
 * Magic Powders
 * 
 * LocalizationHandler
 * 
 * @author BlazeCoding
 * @license Lesser Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class LocalizationHandler {

	/**
	 * Loads in all the localization files from the Localizations library class.
	 */
	public static void loadLanguages() {

		for (String localizationFile : Localizations.localeFiles) {
			LanguageRegistry.instance().loadLocalization(localizationFile, LocalizationUtil.getLocaleFromFileName(localizationFile), LocalizationUtil.isXMLLanguageFile(localizationFile));
		}

	}

}
