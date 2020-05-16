/*
SQLyog Community v12.08 (32 bit)
MySQL - 5.7.15-log : Database - apnishop_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`apnishop_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `apnishop_db`;

/*Table structure for table `activitylog` */

DROP TABLE IF EXISTS `activitylog`;

CREATE TABLE `activitylog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activitylogtypeid` int(11) NOT NULL,
  `entityid` int(11) DEFAULT NULL,
  `entityname` varchar(400) DEFAULT NULL,
  `customerid` int(11) NOT NULL,
  `comment` longtext NOT NULL,
  `createdonutc` datetime NOT NULL,
  `ipaddress` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_activitylog_activitylogtypeid` (`activitylogtypeid`),
  KEY `ix_activitylog_customerid` (`customerid`),
  KEY `ix_activitylog_createdonutc` (`createdonutc`),
  CONSTRAINT `fk_activitylog_customer_customerid` FOREIGN KEY (`customerid`) REFERENCES `user` (`Id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `activitylog` */

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` longtext,
  `lastname` longtext,
  `email` longtext,
  `company` longtext,
  `countryid` int(11) DEFAULT NULL,
  `stateprovinceid` int(11) DEFAULT NULL,
  `county` longtext,
  `city` longtext,
  `address1` longtext,
  `address2` longtext,
  `zippostalcode` longtext,
  `phonenumber` longtext,
  `faxnumber` longtext,
  `landmark` longtext,
  `createdonutc` datetime NOT NULL,
  `gpslong` decimal(18,4) DEFAULT NULL,
  `gpslat` decimal(18,4) DEFAULT NULL,
  `gpsarea` longtext,
  `gpsradius` decimal(18,4) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `addresstype` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_address_countryid` (`countryid`),
  KEY `ix_address_stateprovinceid` (`stateprovinceid`),
  CONSTRAINT `fk_address_country_countryid` FOREIGN KEY (`countryid`) REFERENCES `country` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_address_stateprovince_stateprovinceid` FOREIGN KEY (`stateprovinceid`) REFERENCES `stateprovince` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `address` */

insert  into `address`(`id`,`firstname`,`lastname`,`email`,`company`,`countryid`,`stateprovinceid`,`county`,`city`,`address1`,`address2`,`zippostalcode`,`phonenumber`,`faxnumber`,`landmark`,`createdonutc`,`gpslong`,`gpslat`,`gpsarea`,`gpsradius`,`userid`,`addresstype`) values (2,NULL,NULL,NULL,NULL,1,1,NULL,'gurgaon','address1',NULL,'1564767',NULL,NULL,'near Axis Bank','2020-05-16 01:56:51','0.0000','0.0000',NULL,'0.0000',0,'delivery address');

/*Table structure for table `campaign` */

DROP TABLE IF EXISTS `campaign`;

CREATE TABLE `campaign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` longtext NOT NULL,
  `subject` longtext NOT NULL,
  `body` longtext NOT NULL,
  `storeid` int(11) NOT NULL,
  `customerroleid` int(11) NOT NULL,
  `createdonutc` datetime NOT NULL,
  `dontsendbeforedateutc` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `campaign` */

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) NOT NULL,
  `description` longtext,
  `metakeywords` varchar(400) DEFAULT NULL,
  `metadescription` longtext,
  `metatitle` varchar(400) DEFAULT NULL,
  `pictureid` int(11) NOT NULL,
  `priceranges` varchar(400) DEFAULT NULL,
  `showonhomepage` tinyint(1) NOT NULL,
  `includeintopmenu` tinyint(1) NOT NULL,
  `published` tinyint(1) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  `createdonutc` datetime NOT NULL,
  `updatedonutc` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_category_displayorder` (`displayorder`),
  KEY `ix_category_deleted_extended` (`deleted`,`id`,`name`(255),`published`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `category` */

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `allowsbilling` tinyint(1) DEFAULT NULL,
  `allowsshipping` tinyint(1) DEFAULT NULL,
  `twoletterisocode` varchar(2) DEFAULT NULL,
  `threeletterisocode` varchar(3) DEFAULT NULL,
  `numericisocode` int(11) NOT NULL,
  `published` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_country_displayorder` (`displayorder`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `country` */

insert  into `country`(`id`,`name`,`allowsbilling`,`allowsshipping`,`twoletterisocode`,`threeletterisocode`,`numericisocode`,`published`,`displayorder`) values (1,'India',1,1,NULL,NULL,0,0,0),(2,'Srilanka',1,0,NULL,NULL,0,0,0);

/*Table structure for table `currency` */

DROP TABLE IF EXISTS `currency`;

CREATE TABLE `currency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `currencycode` varchar(5) NOT NULL,
  `rate` decimal(18,4) NOT NULL,
  `displaylocale` varchar(50) DEFAULT NULL,
  `customformatting` varchar(50) DEFAULT NULL,
  `limitedtostores` tinyint(1) NOT NULL,
  `published` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  `createdonutc` datetime NOT NULL,
  `updatedonutc` datetime NOT NULL,
  `roundingtypeid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_currency_displayorder` (`displayorder`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `currency` */

/*Table structure for table `discount` */

DROP TABLE IF EXISTS `discount`;

CREATE TABLE `discount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `usepercentage` tinyint(1) NOT NULL,
  `discountpercentage` decimal(18,4) NOT NULL,
  `discountamount` decimal(18,4) NOT NULL,
  `maximumdiscountamount` decimal(18,4) DEFAULT NULL,
  `startdateutc` datetime DEFAULT NULL,
  `enddateutc` datetime DEFAULT NULL,
  `requirescouponcode` tinyint(1) NOT NULL,
  `couponcode` varchar(100) DEFAULT NULL,
  `iscumulative` tinyint(1) NOT NULL,
  `discountlimitationid` int(11) NOT NULL,
  `limitationtimes` int(11) NOT NULL,
  `maximumdiscountedquantity` int(11) DEFAULT NULL,
  `appliedtosubcategories` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `discount` */

/*Table structure for table `emailaccount` */

DROP TABLE IF EXISTS `emailaccount`;

CREATE TABLE `emailaccount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `displayname` varchar(255) DEFAULT NULL,
  `host` varchar(255) NOT NULL,
  `port` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enablessl` tinyint(1) NOT NULL,
  `usedefaultcredentials` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `emailaccount` */

/*Table structure for table `gdprconsent` */

DROP TABLE IF EXISTS `gdprconsent`;

CREATE TABLE `gdprconsent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` longtext NOT NULL,
  `isrequired` tinyint(1) NOT NULL,
  `requiredmessage` longtext,
  `displayduringregistration` tinyint(1) NOT NULL,
  `displayoncustomerinfopage` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `gdprconsent` */

/*Table structure for table `gdprlog` */

DROP TABLE IF EXISTS `gdprlog`;

CREATE TABLE `gdprlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `consentid` int(11) NOT NULL,
  `customerinfo` longtext,
  `requesttypeid` int(11) NOT NULL,
  `requestdetails` longtext,
  `createdonutc` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `gdprlog` */

/*Table structure for table `language` */

DROP TABLE IF EXISTS `language`;

CREATE TABLE `language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `languageculture` varchar(20) NOT NULL,
  `uniqueseocode` varchar(2) DEFAULT NULL,
  `flagimagefilename` varchar(50) DEFAULT NULL,
  `rtl` tinyint(1) NOT NULL,
  `limitedtostores` tinyint(1) NOT NULL,
  `defaultcurrencyid` int(11) NOT NULL,
  `published` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_language_displayorder` (`displayorder`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=latin1;

/*Data for the table `language` */

insert  into `language`(`id`,`name`,`languageculture`,`uniqueseocode`,`flagimagefilename`,`rtl`,`limitedtostores`,`defaultcurrencyid`,`published`,`displayorder`) values (101,'English','',NULL,NULL,0,0,0,0,0),(102,'Hindi','',NULL,NULL,0,0,0,0,0);

/*Table structure for table `localestringresource` */

DROP TABLE IF EXISTS `localestringresource`;

CREATE TABLE `localestringresource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `languageid` int(11) NOT NULL,
  `resourcename` varchar(200) NOT NULL,
  `resourcevalue` longtext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_localestringresource_languageid` (`languageid`),
  KEY `ix_localestringresource` (`resourcename`,`languageid`),
  CONSTRAINT `fk_localestringresource_language_languageid` FOREIGN KEY (`languageid`) REFERENCES `language` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `localestringresource` */

/*Table structure for table `localizedproperty` */

DROP TABLE IF EXISTS `localizedproperty`;

CREATE TABLE `localizedproperty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `entityid` int(11) NOT NULL,
  `languageid` int(11) NOT NULL,
  `localekeygroup` varchar(400) NOT NULL,
  `localekey` varchar(400) NOT NULL,
  `localevalue` longtext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_localizedproperty_languageid` (`languageid`),
  CONSTRAINT `fk_localizedproperty_language_languageid` FOREIGN KEY (`languageid`) REFERENCES `language` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `localizedproperty` */

/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loglevelid` int(11) NOT NULL,
  `shortmessage` longtext NOT NULL,
  `fullmessage` longtext,
  `ipaddress` varchar(200) DEFAULT NULL,
  `customerid` int(11) DEFAULT NULL,
  `pageurl` longtext,
  `referrerurl` longtext,
  `createdonutc` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_log_customerid` (`customerid`),
  KEY `ix_log_createdonutc` (`createdonutc`),
  CONSTRAINT `fk_log_customer_customerid` FOREIGN KEY (`customerid`) REFERENCES `user` (`Id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `log` */

/*Table structure for table `manufacturer` */

DROP TABLE IF EXISTS `manufacturer`;

CREATE TABLE `manufacturer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) NOT NULL,
  `description` longtext,
  `metakeywords` varchar(400) DEFAULT NULL,
  `metadescription` longtext,
  `metatitle` varchar(400) DEFAULT NULL,
  `pictureid` int(11) DEFAULT NULL,
  `priceranges` varchar(400) DEFAULT NULL,
  `published` tinyint(1) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  `createdonutc` datetime NOT NULL,
  `updatedonutc` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_manufacturer_displayorder` (`displayorder`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `manufacturer` */

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderguid` varchar(64) NOT NULL,
  `retailerid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `billingaddressid` int(11) NOT NULL,
  `shippingaddressid` int(11) DEFAULT NULL,
  `pickupaddressid` int(11) DEFAULT NULL,
  `pickupinstore` tinyint(1) DEFAULT NULL,
  `orderstatusid` int(11) NOT NULL,
  `shippingstatusid` int(11) NOT NULL,
  `paymentstatusid` int(11) NOT NULL,
  `paymentmethodsystemname` longtext,
  `customercurrencycode` longtext,
  `currencyrate` decimal(18,8) NOT NULL,
  `customertaxdisplaytypeid` int(11) NOT NULL,
  `ordersubtotalincltax` decimal(18,4) NOT NULL,
  `ordersubtotalexcltax` decimal(18,4) NOT NULL,
  `ordersubtotaldiscountincltax` decimal(18,4) NOT NULL,
  `ordersubtotaldiscountexcltax` decimal(18,4) NOT NULL,
  `ordershippingincltax` decimal(18,4) NOT NULL,
  `ordershippingexcltax` decimal(18,4) NOT NULL,
  `paymentmethodadditionalfeeincltax` decimal(18,4) NOT NULL,
  `paymentmethodadditionalfeeexcltax` decimal(18,4) NOT NULL,
  `taxrates` longtext,
  `ordertax` decimal(18,4) NOT NULL,
  `orderdiscount` decimal(18,4) NOT NULL,
  `ordertotal` decimal(18,4) NOT NULL,
  `refundedamount` decimal(18,4) NOT NULL,
  `rewardpointshistoryentryid` int(11) DEFAULT NULL,
  `customerlanguageid` int(11) NOT NULL,
  `affiliateid` int(11) NOT NULL,
  `customerip` longtext,
  `allowstoringcreditcardnumber` tinyint(1) DEFAULT NULL,
  `cardtype` longtext,
  `cardname` longtext,
  `cardnumber` longtext,
  `maskedcreditcardnumber` longtext,
  `cardcvv2` longtext,
  `cardexpirationmonth` longtext,
  `cardexpirationyear` longtext,
  `authorizationtransactionid` longtext,
  `authorizationtransactioncode` longtext,
  `authorizationtransactionresult` longtext,
  `capturetransactionid` longtext,
  `capturetransactionresult` longtext,
  `subscriptiontransactionid` longtext,
  `paiddateutc` datetime DEFAULT NULL,
  `shippingmethod` longtext,
  `shippingratecomputationmethodsystemname` longtext,
  `deleted` tinyint(1) NOT NULL,
  `createdonutc` datetime NOT NULL,
  `customordernumber` longtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_order_rewardpointshistoryentryid` (`rewardpointshistoryentryid`),
  KEY `ix_order_billingaddressid` (`billingaddressid`),
  KEY `ix_order_customerid` (`customerid`),
  KEY `ix_order_pickupaddressid` (`pickupaddressid`),
  KEY `ix_order_shippingaddressid` (`shippingaddressid`),
  KEY `ix_order_createdonutc` (`createdonutc`),
  CONSTRAINT `fk_order_address_billingaddressid` FOREIGN KEY (`billingaddressid`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_address_pickupaddressid` FOREIGN KEY (`pickupaddressid`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_address_shippingaddressid` FOREIGN KEY (`shippingaddressid`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_customer_customerid` FOREIGN KEY (`customerid`) REFERENCES `user` (`Id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_rewardpointshistory_rewardpointshistoryentryid` FOREIGN KEY (`rewardpointshistoryentryid`) REFERENCES `rewardpointshistory` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `order` */

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderitemguid` varchar(64) NOT NULL,
  `orderid` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unitpriceincltax` decimal(18,4) NOT NULL,
  `unitpriceexcltax` decimal(18,4) NOT NULL,
  `priceincltax` decimal(18,4) NOT NULL,
  `priceexcltax` decimal(18,4) NOT NULL,
  `discountamountincltax` decimal(18,4) NOT NULL,
  `discountamountexcltax` decimal(18,4) NOT NULL,
  `originalproductcost` decimal(18,4) NOT NULL,
  `itemweight` decimal(18,4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_orderitem_orderid` (`orderid`),
  KEY `ix_orderitem_productid` (`productid`),
  CONSTRAINT `fk_orderitem_order_orderid` FOREIGN KEY (`orderid`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderitem_product_productid` FOREIGN KEY (`productid`) REFERENCES `product` (`Id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `orderitem` */

/*Table structure for table `ordernote` */

DROP TABLE IF EXISTS `ordernote`;

CREATE TABLE `ordernote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` int(11) NOT NULL,
  `note` longtext NOT NULL,
  `downloadid` int(11) NOT NULL,
  `displaytocustomer` tinyint(1) NOT NULL,
  `createdonutc` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_ordernote_orderid` (`orderid`),
  CONSTRAINT `fk_ordernote_order_orderid` FOREIGN KEY (`orderid`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ordernote` */

/*Table structure for table `picture` */

DROP TABLE IF EXISTS `picture`;

CREATE TABLE `picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mimetype` varchar(40) NOT NULL,
  `seofilename` varchar(300) DEFAULT NULL,
  `altattribute` longtext,
  `titleattribute` longtext,
  `isnew` tinyint(1) NOT NULL,
  `virtualpath` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `picture` */

/*Table structure for table `picturebinary` */

DROP TABLE IF EXISTS `picturebinary`;

CREATE TABLE `picturebinary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `binarydata` longblob,
  `pictureid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_picturebinary_pictureid` (`pictureid`),
  CONSTRAINT `fk_picturebinary_picture_pictureid` FOREIGN KEY (`pictureid`) REFERENCES `picture` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `picturebinary` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product name` varchar(400) NOT NULL,
  `shortdescription` longtext,
  `fulldescription` longtext,
  `retailerid` int(11) DEFAULT NULL,
  `admincomment` longtext,
  `showonhomepage` tinyint(1) DEFAULT NULL,
  `metakeywords` varchar(400) DEFAULT NULL,
  `metadescription` longtext,
  `metatitle` varchar(400) DEFAULT NULL,
  `sku` varchar(400) DEFAULT NULL,
  `manufacturerpartnumber` varchar(400) DEFAULT NULL,
  `gtin` varchar(400) DEFAULT NULL,
  `isshipenabled` tinyint(1) DEFAULT NULL,
  `isfreeshipping` tinyint(1) DEFAULT NULL,
  `shipseparately` tinyint(1) DEFAULT NULL,
  `additionalshippingcharge` decimal(18,4) DEFAULT NULL,
  `istaxexempt` tinyint(1) DEFAULT NULL,
  `taxcategoryid` int(11) DEFAULT NULL,
  `isservices` tinyint(1) DEFAULT NULL,
  `stockquantity` int(11) NOT NULL,
  `displaystockavailability` tinyint(1) DEFAULT NULL,
  `displaystockquantity` tinyint(1) DEFAULT NULL,
  `minstockquantity` int(11) DEFAULT NULL,
  `lowstockactivityid` int(11) DEFAULT NULL,
  `orderminimumquantity` int(11) DEFAULT NULL,
  `ordermaximumquantity` int(11) DEFAULT NULL,
  `allowedquantities` varchar(1000) DEFAULT NULL,
  `notreturnable` tinyint(1) DEFAULT NULL,
  `disablebuybutton` tinyint(1) DEFAULT NULL,
  `disablewishlistbutton` tinyint(1) DEFAULT NULL,
  `availableforpreorder` tinyint(1) DEFAULT NULL,
  `preorderavailabilitystartdatetimeutc` datetime DEFAULT NULL,
  `callforprice` tinyint(1) DEFAULT NULL,
  `price` decimal(18,4) NOT NULL,
  `oldprice` decimal(18,4) NOT NULL,
  `productcost` decimal(18,4) NOT NULL,
  `mrp` decimal(18,4) NOT NULL,
  `oldmrp` decimal(18,4) NOT NULL,
  `markasnew` tinyint(1) DEFAULT NULL,
  `markasnewstartdatetimeutc` datetime DEFAULT NULL,
  `markasnewenddatetimeutc` datetime DEFAULT NULL,
  `hasdiscountsapplied` tinyint(1) DEFAULT NULL,
  `weight` decimal(18,4) NOT NULL,
  `length` decimal(18,4) NOT NULL,
  `width` decimal(18,4) NOT NULL,
  `height` decimal(18,4) NOT NULL,
  `availablestartdatetimeutc` datetime DEFAULT NULL,
  `availableenddatetimeutc` datetime DEFAULT NULL,
  `displayorder` int(11) NOT NULL,
  `published` tinyint(1) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `createdonutc` datetime NOT NULL,
  `updatedonutc` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_product_pricedatesetc` (`price`,`availablestartdatetimeutc`,`availableenddatetimeutc`,`published`,`deleted`),
  KEY `ix_product_deleted_and_published` (`published`,`deleted`),
  KEY `ix_product_published` (`published`),
  KEY `ix_product_showonhomepage` (`showonhomepage`),
  KEY `ix_product_delete_id` (`deleted`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product` */

/*Table structure for table `product_category_mapping` */

DROP TABLE IF EXISTS `product_category_mapping`;

CREATE TABLE `product_category_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) NOT NULL,
  `categoryid` int(11) NOT NULL,
  `isfeaturedproduct` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_product_category_mapping_categoryid` (`categoryid`),
  KEY `ix_product_category_mapping_productid` (`productid`),
  KEY `ix_pcm_product_and_category` (`categoryid`,`productid`),
  KEY `ix_pcm_productid_extended` (`productid`,`isfeaturedproduct`,`categoryid`),
  KEY `ix_product_category_mapping_isfeaturedproduct` (`isfeaturedproduct`),
  CONSTRAINT `fk_product_category_mapping_category_categoryid` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_category_mapping_product_productid` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product_category_mapping` */

/*Table structure for table `product_manufacturer_mapping` */

DROP TABLE IF EXISTS `product_manufacturer_mapping`;

CREATE TABLE `product_manufacturer_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) NOT NULL,
  `manufacturerid` int(11) NOT NULL,
  `isfeaturedproduct` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_product_manufacturer_mapping_manufacturerid` (`manufacturerid`),
  KEY `ix_product_manufacturer_mapping_productid` (`productid`),
  KEY `ix_pmm_product_and_manufacturer` (`manufacturerid`,`productid`),
  KEY `ix_pmm_productid_extended` (`productid`,`isfeaturedproduct`,`manufacturerid`),
  KEY `ix_product_manufacturer_mapping_isfeaturedproduct` (`isfeaturedproduct`),
  CONSTRAINT `fk_product_manufacturer_mapping_manufacturer_manufacturerid` FOREIGN KEY (`manufacturerid`) REFERENCES `manufacturer` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_manufacturer_mapping_product_productid` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product_manufacturer_mapping` */

/*Table structure for table `product_picture_mapping` */

DROP TABLE IF EXISTS `product_picture_mapping`;

CREATE TABLE `product_picture_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) NOT NULL,
  `pictureid` int(11) NOT NULL,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_product_picture_mapping_pictureid` (`pictureid`),
  KEY `ix_product_picture_mapping_productid` (`productid`),
  CONSTRAINT `fk_product_picture_mapping_picture_pictureid` FOREIGN KEY (`pictureid`) REFERENCES `picture` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_picture_mapping_product_productid` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product_picture_mapping` */

/*Table structure for table `product_retailer_mapping` */

DROP TABLE IF EXISTS `product_retailer_mapping`;

CREATE TABLE `product_retailer_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) NOT NULL,
  `retailerid` int(11) NOT NULL,
  `retailerprice` decimal(18,4) NOT NULL,
  `retailerdiscountamount` decimal(18,4) DEFAULT NULL,
  `retailerdiscountpercentage` decimal(18,4) DEFAULT NULL,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_product_retailer_mapping_retailerid` (`retailerid`),
  KEY `ix_product_retailer_mapping_productid` (`productid`),
  CONSTRAINT `fk_product_retailer_mapping_product_productid` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_retailer_mapping_retailer_retailerid` FOREIGN KEY (`retailerid`) REFERENCES `retailer` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product_retailer_mapping` */

/*Table structure for table `product_subcategory_mapping` */

DROP TABLE IF EXISTS `product_subcategory_mapping`;

CREATE TABLE `product_subcategory_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) NOT NULL,
  `subcategoryid` int(11) NOT NULL,
  `isfeaturedproduct` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_product_subcategory_mapping_subcategoryid` (`subcategoryid`),
  KEY `ix_product_subcategory_mapping_productid` (`productid`),
  KEY `ix_pcm_product_and_subcategory` (`subcategoryid`,`productid`),
  KEY `ix_pcm_productid_subextended` (`productid`,`isfeaturedproduct`,`subcategoryid`),
  KEY `ix_product_subcategory_mapping_isfeaturedproduct` (`isfeaturedproduct`),
  CONSTRAINT `fk_product_subcategory_mapping_product_productid` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_subcategory_mapping_subcategory_subcategoryid` FOREIGN KEY (`subcategoryid`) REFERENCES `subcategory` (`Id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product_subcategory_mapping` */

/*Table structure for table `productattributevalue` */

DROP TABLE IF EXISTS `productattributevalue`;

CREATE TABLE `productattributevalue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productattributemappingid` int(11) NOT NULL,
  `attributevaluetypeid` int(11) NOT NULL,
  `associatedproductid` int(11) NOT NULL,
  `name` varchar(400) NOT NULL,
  `colorsquaresrgb` varchar(100) DEFAULT NULL,
  `imagesquarespictureid` int(11) NOT NULL,
  `priceadjustment` decimal(18,4) NOT NULL,
  `priceadjustmentusepercentage` tinyint(1) NOT NULL,
  `weightadjustment` decimal(18,4) NOT NULL,
  `cost` decimal(18,4) NOT NULL,
  `customerentersqty` tinyint(1) NOT NULL,
  `quantity` int(11) NOT NULL,
  `ispreselected` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  `pictureid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_productattributevalue_productattributemappingid` (`productattributemappingid`),
  KEY `ix_productattributevalue_productattributemappingid_displayorder` (`productattributemappingid`,`displayorder`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `productattributevalue` */

/*Table structure for table `productreview` */

DROP TABLE IF EXISTS `productreview`;

CREATE TABLE `productreview` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `storeid` int(11) NOT NULL,
  `isapproved` tinyint(1) NOT NULL,
  `title` longtext,
  `reviewtext` longtext,
  `replytext` longtext,
  `customernotifiedofreply` tinyint(1) NOT NULL,
  `rating` int(11) NOT NULL,
  `helpfulyestotal` int(11) NOT NULL,
  `helpfulnototal` int(11) NOT NULL,
  `createdonutc` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_productreview_customerid` (`customerid`),
  KEY `ix_productreview_productid` (`productid`),
  CONSTRAINT `fk_productreview_customer_customerid` FOREIGN KEY (`customerid`) REFERENCES `user` (`Id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_productreview_product_productid` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `productreview` */

/*Table structure for table `productreviewhelpfulness` */

DROP TABLE IF EXISTS `productreviewhelpfulness`;

CREATE TABLE `productreviewhelpfulness` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productreviewid` int(11) NOT NULL,
  `washelpful` tinyint(1) NOT NULL,
  `customerid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_productreviewhelpfulness_productreviewid` (`productreviewid`),
  CONSTRAINT `fk_productreviewhelpfulness_productreview_productreviewid` FOREIGN KEY (`productreviewid`) REFERENCES `productreview` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `productreviewhelpfulness` */

/*Table structure for table `producttag` */

DROP TABLE IF EXISTS `producttag`;

CREATE TABLE `producttag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_producttag_name` (`name`(255))
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `producttag` */

/*Table structure for table `retailer` */

DROP TABLE IF EXISTS `retailer`;

CREATE TABLE `retailer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storename` varchar(400) NOT NULL,
  `storeid` varchar(100) DEFAULT NULL,
  `description` longtext,
  `pictureid` int(11) NOT NULL,
  `admincomment` longtext,
  `active` tinyint(1) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  `metakeywords` varchar(400) DEFAULT NULL,
  `metadescription` longtext,
  `metatitle` varchar(400) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200005 DEFAULT CHARSET=latin1;

/*Data for the table `retailer` */

insert  into `retailer`(`id`,`storename`,`storeid`,`description`,`pictureid`,`admincomment`,`active`,`deleted`,`displayorder`,`metakeywords`,`metadescription`,`metatitle`,`userid`) values (20001,'RIL',NULL,NULL,0,NULL,0,0,1,NULL,NULL,NULL,0),(200002,'Acorp','398013',NULL,0,NULL,0,0,0,NULL,NULL,NULL,0),(200003,'AcorpLtd','510214',NULL,0,NULL,0,0,0,NULL,NULL,NULL,0),(200004,'OScorp Ltd','405118',NULL,0,NULL,0,0,0,NULL,NULL,NULL,0);

/*Table structure for table `returnrequest` */

DROP TABLE IF EXISTS `returnrequest`;

CREATE TABLE `returnrequest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customnumber` longtext,
  `storeid` int(11) NOT NULL,
  `orderitemid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `reasonforreturn` longtext NOT NULL,
  `requestedaction` longtext NOT NULL,
  `customercomments` longtext,
  `uploadedfileid` int(11) NOT NULL,
  `staffnotes` longtext,
  `returnrequeststatusid` int(11) NOT NULL,
  `createdonutc` datetime NOT NULL,
  `updatedonutc` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_returnrequest_customerid` (`customerid`),
  CONSTRAINT `fk_returnrequest_customer_customerid` FOREIGN KEY (`customerid`) REFERENCES `user` (`Id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `returnrequest` */

/*Table structure for table `returnrequestaction` */

DROP TABLE IF EXISTS `returnrequestaction`;

CREATE TABLE `returnrequestaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) NOT NULL,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `returnrequestaction` */

/*Table structure for table `returnrequestreason` */

DROP TABLE IF EXISTS `returnrequestreason`;

CREATE TABLE `returnrequestreason` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) NOT NULL,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `returnrequestreason` */

/*Table structure for table `rewardpointshistory` */

DROP TABLE IF EXISTS `rewardpointshistory`;

CREATE TABLE `rewardpointshistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `storeid` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `pointsbalance` int(11) DEFAULT NULL,
  `usedamount` decimal(18,4) NOT NULL,
  `message` longtext,
  `createdonutc` datetime NOT NULL,
  `enddateutc` datetime DEFAULT NULL,
  `validpoints` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_rewardpointshistory_customerid` (`customerid`),
  CONSTRAINT `fk_rewardpointshistory_customer_customerid` FOREIGN KEY (`customerid`) REFERENCES `user` (`Id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rewardpointshistory` */

/*Table structure for table `scheduletask` */

DROP TABLE IF EXISTS `scheduletask`;

CREATE TABLE `scheduletask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` longtext NOT NULL,
  `seconds` int(11) NOT NULL,
  `type` longtext NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `stoponerror` tinyint(1) NOT NULL,
  `laststartutc` datetime DEFAULT NULL,
  `lastendutc` datetime DEFAULT NULL,
  `lastsuccessutc` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `scheduletask` */

/*Table structure for table `searchterm` */

DROP TABLE IF EXISTS `searchterm`;

CREATE TABLE `searchterm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyword` longtext,
  `storeid` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `searchterm` */

/*Table structure for table `setting` */

DROP TABLE IF EXISTS `setting`;

CREATE TABLE `setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `value` longtext NOT NULL,
  `storeid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `setting` */

/*Table structure for table `shipment` */

DROP TABLE IF EXISTS `shipment`;

CREATE TABLE `shipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` int(11) NOT NULL,
  `trackingnumber` longtext,
  `totalweight` decimal(18,4) DEFAULT NULL,
  `shippeddateutc` datetime DEFAULT NULL,
  `deliverydateutc` datetime DEFAULT NULL,
  `admincomment` longtext,
  `createdonutc` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_shipment_orderid` (`orderid`),
  CONSTRAINT `fk_shipment_order_orderid` FOREIGN KEY (`orderid`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `shipment` */

/*Table structure for table `shippingmethod` */

DROP TABLE IF EXISTS `shippingmethod`;

CREATE TABLE `shippingmethod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) NOT NULL,
  `description` longtext,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `shippingmethod` */

/*Table structure for table `shoppingcartitem` */

DROP TABLE IF EXISTS `shoppingcartitem`;

CREATE TABLE `shoppingcartitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `retailerid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `attributesxml` longtext,
  `customerenteredprice` decimal(18,4) NOT NULL,
  `quantity` int(11) NOT NULL,
  `createdonutc` datetime NOT NULL,
  `updatedonutc` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_shoppingcartitem_customerid` (`customerid`),
  KEY `ix_shoppingcartitem_productid` (`productid`),
  KEY `ix_shoppingcartitem_shoppingcarttypeid_customerid` (`customerid`),
  CONSTRAINT `fk_shoppingcartitem_customer_customerid` FOREIGN KEY (`customerid`) REFERENCES `user` (`Id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_shoppingcartitem_product_productid` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `shoppingcartitem` */

/*Table structure for table `stateprovince` */

DROP TABLE IF EXISTS `stateprovince`;

CREATE TABLE `stateprovince` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryid` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `abbreviation` varchar(100) DEFAULT NULL,
  `published` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_stateprovince_countryid` (`countryid`),
  CONSTRAINT `fk_stateprovince_country_countryid` FOREIGN KEY (`countryid`) REFERENCES `country` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `stateprovince` */

insert  into `stateprovince`(`id`,`countryid`,`name`,`abbreviation`,`published`,`displayorder`) values (1,1,'Delhi','DEL',0,0),(2,1,'Punjab','PUN',0,0),(3,1,'Kerala','KER',0,0);

/*Table structure for table `subcategory` */

DROP TABLE IF EXISTS `subcategory`;

CREATE TABLE `subcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) NOT NULL,
  `description` longtext,
  `metakeywords` varchar(400) DEFAULT NULL,
  `metadescription` longtext,
  `metatitle` varchar(400) DEFAULT NULL,
  `pictureid` int(11) NOT NULL,
  `priceranges` varchar(400) DEFAULT NULL,
  `showonhomepage` tinyint(1) NOT NULL,
  `includeintopmenu` tinyint(1) NOT NULL,
  `published` tinyint(1) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `displayorder` int(11) NOT NULL,
  `createdonutc` datetime NOT NULL,
  `updatedonutc` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_subcategory_displayorder` (`displayorder`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `subcategory` */

/*Table structure for table `taxcategory` */

DROP TABLE IF EXISTS `taxcategory`;

CREATE TABLE `taxcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) NOT NULL,
  `displayorder` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `taxcategory` */

/*Table structure for table `taxrate` */

DROP TABLE IF EXISTS `taxrate`;

CREATE TABLE `taxrate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storeid` int(11) NOT NULL,
  `taxcategoryid` int(11) NOT NULL,
  `countryid` int(11) NOT NULL,
  `stateprovinceid` int(11) NOT NULL,
  `zip` longtext,
  `percentage` decimal(18,4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `taxrate` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userguid` varchar(64) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `usermobileno` varchar(1000) NOT NULL,
  `userrole` varchar(100) DEFAULT NULL,
  `usertype` varchar(100) DEFAULT NULL,
  `languageid` int(11) DEFAULT NULL,
  `email` varchar(1000) DEFAULT NULL,
  `emailtorevalidate` varchar(1000) DEFAULT NULL,
  `admincomment` longtext,
  `istaxexempt` tinyint(1) NOT NULL,
  `affiliateid` int(11) NOT NULL,
  `hasshoppingcartitems` tinyint(1) NOT NULL,
  `requirerelogin` tinyint(1) NOT NULL,
  `failedloginattempts` int(11) NOT NULL,
  `cannotloginuntildateutc` datetime DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  `issystemaccount` tinyint(1) NOT NULL,
  `systemname` varchar(400) DEFAULT NULL,
  `lastipaddress` longtext,
  `createdonutc` datetime NOT NULL,
  `lastlogindateutc` datetime DEFAULT NULL,
  `lastactivitydateutc` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_customer_email` (`email`(255)),
  KEY `ix_customer_username` (`usermobileno`(255)),
  KEY `ix_customer_customerguid` (`userguid`),
  KEY `ix_customer_systemname` (`systemname`(255)),
  KEY `ix_customer_createdonutc` (`createdonutc`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`userguid`,`username`,`usermobileno`,`userrole`,`usertype`,`languageid`,`email`,`emailtorevalidate`,`admincomment`,`istaxexempt`,`affiliateid`,`hasshoppingcartitems`,`requirerelogin`,`failedloginattempts`,`cannotloginuntildateutc`,`active`,`deleted`,`issystemaccount`,`systemname`,`lastipaddress`,`createdonutc`,`lastlogindateutc`,`lastactivitydateutc`) values (10001,'xx01','Ankit','98909878','retailer','Lead',101,'i@gmail.com',NULL,NULL,0,0,0,0,0,NULL,0,0,0,NULL,NULL,'2020-05-12 17:20:28',NULL,'2020-05-12 17:20:28');

/*Table structure for table `user_retailer_mapping` */

DROP TABLE IF EXISTS `user_retailer_mapping`;

CREATE TABLE `user_retailer_mapping` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  `RetailerId` int(11) NOT NULL,
  `DisplayOrder` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `IX_User_Retailer_Mapping_RetailerId` (`RetailerId`),
  KEY `IX_User_Retailer_Mapping_UserId` (`UserId`),
  CONSTRAINT `FK_User_Retailer_Mapping_Retailer_RetailerId` FOREIGN KEY (`RetailerId`) REFERENCES `retailer` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_User_Retailer_Mapping_User_UserId` FOREIGN KEY (`UserId`) REFERENCES `user` (`Id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `user_retailer_mapping` */

insert  into `user_retailer_mapping`(`Id`,`UserId`,`RetailerId`,`DisplayOrder`) values (1,10001,20001,12);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
