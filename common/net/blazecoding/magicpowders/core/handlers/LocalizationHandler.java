package net.blazecoding.magicpowders.core.handlers;

import net.blazecoding.magicpowders.core.util.LocalizationUtil;
import net.blazecoding.magicpowders.lib.Localizations;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 
 * Magic Powders
 * 
 * LocalizationHandler
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
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
