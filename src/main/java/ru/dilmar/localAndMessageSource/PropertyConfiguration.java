package ru.dilmar.localAndMessageSource;

//@Configuration
public class PropertyConfiguration {
    /*@Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }*/


 /*   @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("property/messages", "property/test", "property/editpage","i18n/bundle");
        resourceBundleMessageSource.setDefaultEncoding("windows-1251");
       // resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }*/


   /* @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/property/messages", "classpath:/property/test", "classpath:/property/editpage","classpath:/i18n/bundle");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("windows-1251");
       // messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(5);
        return messageSource;
    }*/
}
