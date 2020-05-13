# aXe-chrome-accessibility #

aXe-chrome-accessibility is used for automating the accessibility audit of your web site with the help of selenium and Java. This repo is built with on popular accessibility scanners [aXe-core][1] and [GoogleChrome accessibility-developer-tools][2]. 

There are three methods available in <i>ProcessResponse</i> class for page scanning. 
1. aXescanner() - This method just scans without any rules by using aXe-core and returns the response as string
2. aXescannerWithRules() - This method scans the a11y violations with the given rules by using aXe-core and returns the response as                                string. To know more about these aXe rules click [here][3]
3. googleChromeScanner() - This method scans the page by using GoogleChrome accessibility-developer-tools and returns the response as                              string.
 
Once you call these methods, the tool also creates a Time stamped PDF file with all the violations listed under "Accessibility Results" folder. So, each time when you call this method, it generates a PDF with the violations.

## Better Practice ##

If you are looking for just meaningful PDF report, then call these methods once per page.

## To use the aXe-chrome-accessibility library in your own tests ##

As this library is not available in maven repo, you would need to clone this project and deploy locally by running `mvn clean install`.

Once the library is available in your local/internal maven repository, please add dependency like below to project.

```
<dependency>
   <groupId>com.accessibility</groupId>
   <artifactId>aXe-chrome-accessibility</artifactId>
   <version>1.1.0-SNAPSHOT</version>
</dependency>
```

In this project, you can find one example testcase of how to use this library using TestNG and Selenium under `src/test/java/com/accessibility/examples/test/WebDrivera11yTest.java`. Test is written to run in chrome browser. Since WebDriverManager dependency is added, you don't have to include driver .exe files for running.  

## Reference ##

I have used the below repos as reference for this tool. Thanks to Nilesh and Dian Fay.

https://github.com/nikulkarni/webdriver-accessibility

https://github.com/dequelabs/axe-selenium-java

## Contributing ##

Fork the project and submit pull request if you like to add a feature/fix bugs etc.
	
## Disclaimer ##

I am not a accessibility expert. I am open for suggestions.

## Known Issues ##
1. Working on creating a maven dependency of this project.
2. Need to solve the duplicate violations on the same page. 

## Contact ##

Email Id: illi.nainappa@gmail.com

Blog Link: https://seleniumocean.blogspot.com/


[1]: https://github.com/dequelabs/axe-core/tree/master "aXe-core"
[2]: https://github.com/GoogleChrome/accessibility-developer-tools "GoogleChrome accessibility-developer-tools"
[3]: https://dequeuniversity.com/rules/axe/3.1
