package com.xetosphere.arcane.configuration;

public class ConfigurationSettings {

    /*
     * Version check related settings
     */
    public static boolean DISPLAY_VERSION_RESULT;
    public static final String DISPLAY_VERSION_RESULT_CONFIGNAME = "version_check.display_results";
    public static final boolean DISPLAY_VERSION_RESULT_DEFAULT = true;

    public static String LAST_DISCOVERED_VERSION;
    public static final String LAST_DISCOVERED_VERSION_CONFIGNAME = "version_check.last_discovered_version";
    public static final String LAST_DISCOVERED_VERSION_DEFAULT = "";

    public static String LAST_DISCOVERED_VERSION_TYPE;
    public static final String LAST_DISCOVERED_VERSION_TYPE_CONFIGNAME = "version_check.last_discovered_version_type";
    public static final String LAST_DISCOVERED_VERSION_TYPE_DEFAULT = "";

	public static final boolean DEFAULT_GENERATION = true;
	public static final boolean DEFAULT_CRAFTING = true;

	public static boolean enableCustomGeneration;
	public static boolean enableRecipeAlcTab;

}
