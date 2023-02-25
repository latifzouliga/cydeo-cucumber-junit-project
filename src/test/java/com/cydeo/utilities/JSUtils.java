package com.cydeo.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtils {




        /**
         * This static method accepts one argument as a webElement
         * This method uses javaScript executor to change the background color of a webElement, and also it will draw line over it
         * @param element
         */
        public static void drawBorder(WebElement element) {
            //casting webDriver to JavascriptExecutor interface
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].setAttribute('style','background:yellow;3px solid red')", element);
        }

        public static void flashElement(WebElement element) {

            String bgColor = element.getCssValue("background-color");

            for (int i = 0; i < 50; i++) {
                changeColor("#000000",element);
                changeColor(bgColor,element);
            }

        }

        public static void changeColor(String color, WebElement element){
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].setAttribute('style','background:"+color+"')",element);
            try {
                Thread.sleep(50);
            }catch (InterruptedException e){
                // do nothing
            }

        }

}













