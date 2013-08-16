package net.blazecoding.magicpowders.core.util;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 
 * Magic Powders
 * 
 * LocalizationUtil
 * 
 * @author BlazeCoding
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class LocalizationUtil {

	/**
	 * Checks if the file is a xml file.
	 * 
	 * @param fileName
	 *            String representing the file name of the file in question
	 * 
	 * @return True if the file name represents a XML file, false otherwise
	 */
	public static boolean isXMLLanguageFile(String fileName) {
		return fileName.endsWith(".xml");
	}

	/***
	 * Returns the locale from file name
	 * 
	 * @param fileName
	 *            String representing the file name of the file in question
	 * 
	 * @return String representation of the locale snipped from the file name
	 */
	public static String getLocaleFromFileName(String fileName) {
		return fileName.substring(fileName.lastIndexOf('/') + 1, fileName.lastIndexOf('.'));
	}

	public static String getLocalizedString(String key) {
		return LanguageRegistry.instance().getStringLocalization(key);
	}

}
