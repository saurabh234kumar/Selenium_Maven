package com.suadeo.WEB.Locators;

import org.openqa.selenium.By;

public class SuadeoLocators {
	
	//-----------------------------------My Account login--------------------------------------------------//
	public static final String LoginAuthentication_Xpath = "//input[@placeholder='Authentification']";
	public static final String LoginUsername_Xpath = "//input[@id='tb_username']";
	public static final String LoginPassword_ID = "tb_pwd";
	public static final String LoginButton_ID = "btn_login";
	public static final String LoginAuthenticationDropDownButton_ID = "SUADEO.NET";
	public static final String LogoutButton_Xpath = "//span[@class='user-name display-name']";
	public static final String DisconnectButton_ID = "logout";
	
	//-----------------------------------HomePage--------------------------------------------------//
	
	
	public static final String HomePageLogo_Xpath = "//div[@class='vertical-menu']//a[@class='logo logo-light suadeo-home-logo']//span[@class='logo-lg']//img[@class='logo en']";
	public static final String HomeMenu_Xpath = "//button[@class='btn header-item noti-icon']//*[name()='svg']";
	public static final String MMenuCataloguesXpath = "	/html[1]/body[1]/form[1]/div[3]/header[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/img[1]";

	

	public static final String HomeLang_ID = "header-lang-img";
	public static final String HomeLang_Eng_Xpath = "//span[normalize-space()='English']";
	public static final String HomeCalender_Xpath = "/html[1]/body[1]/form[1]/div[3]/header[1]/div[1]/div[2]/div[5]/a[1]/*[name()='svg'][1]";
	public static final String HomeMessage_Xpath = "/html[1]/body[1]/form[1]/div[3]/header[1]/div[1]/div[2]/div[4]/a[1]/*[name()='svg'][1]";
	public static final String HomeSearch_Xpath = "//div[@id='topbar-search']//button[@type='button']//*[name()='svg']";
	public static final String HomeSearchinput_Xpath = "//input[@id='globalSearchTxtBox']";
	public static final String CataloguesXpath = "//span[@class='menu-item'][normalize-space()='Catalogues']";
	
	//-----------------------------------Catalogs--------------------------------------------------//
	
	
	public static final String CataloguesNewButtonXpath = "//i[@class='far fa-plus-square']"; 
	public static final String CataloguesNameXpath = "//div[@id='manage-catalog-name']//input[@role='textbox']";
	public static final String CataloguesMessageXpath = "/html/body/form/div[3]/div[2]/div/div/div[1]/div/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div/textarea";
	public static final String ModelsNameXpath = "//div[@id='model-name']//input[@role='textbox']";

	public static final String ModelsMessageXpath = "	/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[8]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/textarea[1]";
	public static final String CataloguesSaveXpath = "//button[@class='btn suadeo-button-primary text-white btn-sm text-uppercase manage-catalog-save ms-2 manage-catalog-create-action-buttons']";
	public static final String ModelsSaveXpath = "//button[@class='bg-suadeo-base-color btn next-step']";

	
	//-----------------------------------User Data--------------------------------------------------//
	public static final String ModelsXpath = "/html[1]/body[1]/form[1]/div[3]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]/span[1]"; 
	
	
	
	
	//-----------------------------------Page--------------------------------------------------//


	
	//-----------------------------------Page--------------------------------------------------//


	

	
	//-----------------------------------Page--------------------------------------------------//

	
	

}
