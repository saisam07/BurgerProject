# BurgerStop E-commerce site

Burger-Stop is a very popular roadside restaurant chain mainly focused on creating the best and Exotic Burgers for all burger loving foodies. 
Burger-stop have its own delivery services and has 300 branches in different cities. 
Burger-stop is also one of the major tourist attractions of many major cities. 

Burger-stop follows the old traditional methods to showcase their menu like in Pamphlets and in some billboard advertisements and delivery services are manually executed. In this Digital era, as everything is available online, Burger-stop wants to make their mark online and are excited to attract more foodies from all around the world. This project is focused on create a software solution to remove the old traditional methods of showcasing menus and manual delivery services.  

An Ecommerce website will be a perfect solution for Burger-Stop. This will not only cover all the required requirements of the restaurant, but will also increase sales and brand value digitally and physically. Ecommerce provides an easy way to sell products to a large customer base. 

Creating an Ecommerce website using web technologies has its drawbacks like content management, so to get the perfection and a professional ecommerce website Adobe Experience Manage tool will be used to get the desired results. Adobe Experience Manager (AEM), is a comprehensive content management solution for building websites, mobile apps and forms. And it makes it easy to manage your marketing content and assets.  




## Modules

The main parts of the project are:

* **core**: Java bundle containing all core functionality like OSGi services, listeners or schedulers, as well as component-related Java code such as servlets or request filters.
* **ui.apps**: contains the /apps (and /etc) parts of the project, ie JS & CSS clientlibs, components, templates, runmode specific configs as well as Hobbes-tests
* **ui.content**: contains mutable content (not /apps) that is integral to the running of the BurgerStop site. This include template types, templates, policies and base-line organization page and asset structures.
* **it.tests**: Java bundle containing JUnit tests that are executed server-side. This bundle is not to be deployed onto production.
* **it.launcher**: contains glue code that deploys the it.tests bundle (and dependent bundles) to the server and triggers the remote JUnit execution


## How to build

To build all the modules run in the project root directory the following command with Maven 3:

    mvn clean install

To build all the modules and deploy the `all` package to a local instance of AEM, run in the project root directory the following command:

    mvn clean install -PautoInstallSinglePackage

Or to deploy it to a publish instance, run

    mvn clean install -PautoInstallSinglePackagePublish

Or alternatively

    mvn clean install -PautoInstallSinglePackage -Daem.port=4503

Or to deploy only the bundle to the author, run

    mvn clean install -PautoInstallBundle

Or to deploy only a single content package, run in the sub-module directory (i.e `ui.apps`)

    mvn clean install -PautoInstallPackage

## Testing

There are three levels of testing contained in the project:

* unit test in core: this show-cases classic unit testing of the code contained in the bundle. To test, execute:

    ```
    mvn clean test
    ```

* server-side integration tests: this allows to run unit-like tests in the AEM-environment, ie on the AEM server. To test, execute:

    ```
    mvn clean verify -PintegrationTests
    ```

* client-side Hobbes.js tests: JavaScript-based browser-side tests that verify browser-side behavior. To test, go in the browser, open the page in 'Developer mode', open the left panel and switch to the 'Tests' tab and find the generated 'MyName Tests' and run them.