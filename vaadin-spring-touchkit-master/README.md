# An example to use Vaadin TouchKit with Vaadin Spring

Integration to TouchKit is rather similar as with other add-ons, but for advanced stuff you'll need extra steps. Solution is pretty much as follows when applying on a simple hello world style Spring Boot + Vaadin app, generated e.g. using start.spring.io service:

 * REQUIRED (enough for basic component usage)
   * dependency to Vaadin TouchKit, see [pom.xml](https://github.com/mstahv/vaadin-spring-touchkit/blob/master/pom.xml#L57-L68)
   * Widgetset with TouchKit components (and theme)
       * Simple option using cdn.virit.in:
           * Add plugin to [pom.xml](https://github.com/mstahv/vaadin-spring-touchkit/blob/master/pom.xml#L90-L102)
           * Add generated servlet filter to your configuration https://github.com/mstahv/vaadin-spring-touchkit/blob/master/src/main/java/org/vaadin/tkspring/Application.java#L20-L25
       * Standard solution:
           * Add [vaadin-maven-plugn to pom.xml](https://github.com/mstahv/vaadin-spring-touchkit/blob/master/pom.xml#L103-L128)
           * Add @Widgetset annotation to your [UI class](https://github.com/mstahv/vaadin-spring-touchkit/blob/master/src/main/java/org/vaadin/tkspring/MainUI.java#L18-L20)
 * OPTIONAL/SUGGESTED TUNING (all features, automatic viewport settings and no warnings)
    * Use dummy ["touchkit" theme](https://github.com/mstahv/vaadin-spring-touchkit/blob/master/src/main/java/org/vaadin/tkspring/MainUI.java#L16) (empty theme, TouhcKit default them comes from GWT module, saves quite a lot of bytes). vaadin-themes can be removed.
    * Use a specialized version of VaadinSpringServlet that has VaadinTouchKitServlet feature build into it. This will make many features like home screen icons, "full screen mode", offline mode etc. possible.
        * Define [the special servlet](https://github.com/mstahv/vaadin-spring-touchkit/blob/master/src/main/java/org/vaadin/tkspring/SpringAwareTouchKitServlet.java) (feel free to copy paste this example)
        * Configure your application to use it instead of default SpringVaadinServlet. In Boot app e.g. with [this](https://github.com/mstahv/vaadin-spring-touchkit/blob/master/src/main/java/org/vaadin/tkspring/Application.java#L15-L18) will do the trick.

This example uses Spring Boot, but the setup logically the same with basic Spring project.
