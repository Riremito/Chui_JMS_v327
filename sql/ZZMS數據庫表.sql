/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2015-09-23 12:13:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `accounts`
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(13) NOT NULL DEFAULT '',
  `password` varchar(128) NOT NULL DEFAULT '',
  `salt` varchar(32) DEFAULT NULL,
  `2ndpassword` varchar(134) DEFAULT NULL,
  `salt2` varchar(32) DEFAULT NULL,
  `loggedin` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `lastlogin` timestamp NULL DEFAULT NULL,
  `lastlogon` timestamp NULL DEFAULT NULL,
  `createdat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `birthday` date NOT NULL DEFAULT '0000-00-00',
  `banned` tinyint(1) NOT NULL DEFAULT '0',
  `banreason` mediumtext,
  `gm` tinyint(1) NOT NULL DEFAULT '0',
  `email` text,
  `IM` text,
  `phone` text,
  `macs` text,
  `tempban` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `greason` tinyint(4) unsigned DEFAULT NULL,
  `BeanfunGash` int(11) NOT NULL DEFAULT '0',
  `mPoints` int(11) NOT NULL DEFAULT '0',
  `Mileage` int(11) NOT NULL DEFAULT '0',
  `gender` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `SessionIP` varchar(64) DEFAULT NULL,
  `lastWorld` tinyint(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `ranking1` (`id`,`banned`,`gm`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of accounts
-- ----------------------------

-- ----------------------------
-- Table structure for `adminlog`
-- ----------------------------
DROP TABLE IF EXISTS `adminlog`;
CREATE TABLE `adminlog` (
  `logid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL DEFAULT '0',
  `command` mediumtext NOT NULL,
  `mapid` int(11) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of adminlog
-- ----------------------------

-- ----------------------------
-- Table structure for `alliances`
-- ----------------------------
DROP TABLE IF EXISTS `alliances`;
CREATE TABLE `alliances` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(13) NOT NULL,
  `leaderid` int(11) NOT NULL,
  `guild1` int(11) NOT NULL,
  `guild2` int(11) NOT NULL,
  `guild3` int(11) NOT NULL DEFAULT '0',
  `guild4` int(11) NOT NULL DEFAULT '0',
  `guild5` int(11) NOT NULL DEFAULT '0',
  `rank1` varchar(13) NOT NULL DEFAULT 'Master',
  `rank2` varchar(13) NOT NULL DEFAULT 'Jr.Master',
  `rank3` varchar(13) NOT NULL DEFAULT 'Member',
  `rank4` varchar(13) NOT NULL DEFAULT 'Member',
  `rank5` varchar(13) NOT NULL DEFAULT 'Member',
  `capacity` int(11) NOT NULL DEFAULT '2',
  `notice` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `id` (`id`),
  KEY `leaderid` (`leaderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of alliances
-- ----------------------------

-- ----------------------------
-- Table structure for `androids`
-- ----------------------------
DROP TABLE IF EXISTS `androids`;
CREATE TABLE `androids` (
  `uniqueid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(3) NOT NULL DEFAULT '機器人',
  `type` int(11) NOT NULL DEFAULT '-1',
  `gender` int(11) NOT NULL DEFAULT '0',
  `skin` int(11) NOT NULL DEFAULT '0',
  `hair` int(11) NOT NULL DEFAULT '0',
  `face` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uniqueid`),
  KEY `uniqueid` (`uniqueid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of androids
-- ----------------------------

-- ----------------------------
-- Table structure for `battlelog`
-- ----------------------------
DROP TABLE IF EXISTS `battlelog`;
CREATE TABLE `battlelog` (
  `battlelogid` int(11) NOT NULL AUTO_INCREMENT,
  `accid` int(11) NOT NULL DEFAULT '0',
  `accid_to` int(11) NOT NULL DEFAULT '0',
  `when` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`battlelogid`),
  KEY `accid` (`accid`),
  CONSTRAINT `battlelog_ibfk_1` FOREIGN KEY (`accid`) REFERENCES `accounts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of battlelog
-- ----------------------------

-- ----------------------------
-- Table structure for `bbs_replies`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_replies`;
CREATE TABLE `bbs_replies` (
  `replyid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `threadid` int(10) unsigned NOT NULL,
  `postercid` int(10) unsigned NOT NULL,
  `timestamp` bigint(20) unsigned NOT NULL,
  `content` varchar(26) NOT NULL DEFAULT '',
  `guildid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`replyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bbs_replies
-- ----------------------------

-- ----------------------------
-- Table structure for `bbs_threads`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_threads`;
CREATE TABLE `bbs_threads` (
  `threadid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `postercid` int(10) unsigned NOT NULL,
  `name` varchar(26) NOT NULL DEFAULT '',
  `timestamp` bigint(20) unsigned NOT NULL,
  `icon` smallint(5) unsigned NOT NULL,
  `startpost` mediumtext NOT NULL,
  `guildid` int(10) unsigned NOT NULL,
  `localthreadid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`threadid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bbs_threads
-- ----------------------------

-- ----------------------------
-- Table structure for `buddies`
-- ----------------------------
DROP TABLE IF EXISTS `buddies`;
CREATE TABLE `buddies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `characterid` int(11) NOT NULL,
  `buddyid` int(11) NOT NULL,
  `pending` tinyint(4) NOT NULL DEFAULT '0',
  `groupname` varchar(16) NOT NULL DEFAULT 'ETC',
  PRIMARY KEY (`id`),
  KEY `buddies_ibfk_1` (`characterid`),
  KEY `buddyid` (`buddyid`),
  KEY `id` (`id`),
  CONSTRAINT `buddies_ibfk_1` FOREIGN KEY (`characterid`) REFERENCES `characters` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of buddies
-- ----------------------------

-- ----------------------------
-- Table structure for `cashshop_categories`
-- ----------------------------
DROP TABLE IF EXISTS `cashshop_categories`;
CREATE TABLE `cashshop_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `parent` int(11) NOT NULL,
  `flag` int(11) NOT NULL,
  `sold` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cashshop_categories
-- ----------------------------

-- ----------------------------
-- Table structure for `cashshop_items`
-- ----------------------------
DROP TABLE IF EXISTS `cashshop_items`;
CREATE TABLE `cashshop_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` int(11) NOT NULL,
  `subcategory` int(11) NOT NULL,
  `parent` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `sn` int(11) NOT NULL,
  `itemid` int(11) NOT NULL,
  `flag` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `discountPrice` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `expire` int(11) NOT NULL,
  `gender` tinyint(1) NOT NULL DEFAULT '2',
  `likes` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cashshop_items
-- ----------------------------

-- ----------------------------
-- Table structure for `cashshop_limit_sell`
-- ----------------------------
DROP TABLE IF EXISTS `cashshop_limit_sell`;
CREATE TABLE `cashshop_limit_sell` (
  `serial` int(11) NOT NULL,
  `amount` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`serial`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cashshop_limit_sell
-- ----------------------------

-- ----------------------------
-- Table structure for `cashshop_menuitems`
-- ----------------------------
DROP TABLE IF EXISTS `cashshop_menuitems`;
CREATE TABLE `cashshop_menuitems` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` int(11) NOT NULL,
  `subcategory` int(11) NOT NULL,
  `parent` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `sn` int(11) NOT NULL,
  `itemid` int(11) NOT NULL,
  `flag` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `discountPrice` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `expire` int(11) NOT NULL,
  `gender` tinyint(1) NOT NULL DEFAULT '2',
  `likes` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cashshop_menuitems
-- ----------------------------

-- ----------------------------
-- Table structure for `cashshop_modified_items`
-- ----------------------------
DROP TABLE IF EXISTS `cashshop_modified_items`;
CREATE TABLE `cashshop_modified_items` (
  `serial` int(11) NOT NULL,
  `discount_price` int(11) NOT NULL DEFAULT '-1',
  `mark` tinyint(1) NOT NULL DEFAULT '-1',
  `showup` tinyint(1) NOT NULL DEFAULT '0',
  `itemid` int(11) NOT NULL DEFAULT '0',
  `priority` tinyint(3) NOT NULL DEFAULT '0',
  `package` tinyint(1) NOT NULL DEFAULT '0',
  `period` tinyint(3) NOT NULL DEFAULT '0',
  `gender` tinyint(1) NOT NULL DEFAULT '0',
  `count` tinyint(3) NOT NULL DEFAULT '0',
  `meso` int(11) NOT NULL DEFAULT '0',
  `unk_1` tinyint(1) NOT NULL DEFAULT '0',
  `unk_2` tinyint(1) NOT NULL DEFAULT '0',
  `unk_3` tinyint(1) NOT NULL DEFAULT '0',
  `extra_flags` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`serial`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cashshop_modified_items
-- ----------------------------

-- ----------------------------
-- Table structure for `characters`
-- ----------------------------
DROP TABLE IF EXISTS `characters`;
CREATE TABLE `characters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountid` int(11) NOT NULL DEFAULT '0',
  `world` tinyint(1) NOT NULL DEFAULT '0',
  `position` tinyint(2) NOT NULL DEFAULT '0',
  `name` varchar(13) NOT NULL DEFAULT '',
  `level` int(3) NOT NULL DEFAULT '0',
  `exp` bigint(11) NOT NULL DEFAULT '0',
  `str` int(5) NOT NULL DEFAULT '0',
  `dex` int(5) NOT NULL DEFAULT '0',
  `luk` int(5) NOT NULL DEFAULT '0',
  `int` int(5) NOT NULL DEFAULT '0',
  `hp` int(5) NOT NULL DEFAULT '0',
  `mp` int(5) NOT NULL DEFAULT '0',
  `maxhp` int(5) NOT NULL DEFAULT '0',
  `maxmp` int(5) NOT NULL DEFAULT '0',
  `meso` bigint(20) DEFAULT NULL,
  `hpApUsed` int(5) NOT NULL DEFAULT '0',
  `job` int(5) NOT NULL DEFAULT '0',
  `skincolor` tinyint(1) NOT NULL DEFAULT '0',
  `gender` tinyint(1) NOT NULL DEFAULT '0',
  `fame` int(5) NOT NULL DEFAULT '0',
  `hair` int(11) NOT NULL DEFAULT '0',
  `face` int(11) unsigned NOT NULL DEFAULT '0',
  `faceMarking` int(11) NOT NULL DEFAULT '0',
  `tail` int(11) NOT NULL DEFAULT '0',
  `ears` int(11) NOT NULL DEFAULT '0',
  `ap` int(11) NOT NULL DEFAULT '0',
  `weaponPoint` int(11) NOT NULL DEFAULT '0',
  `map` int(11) NOT NULL DEFAULT '0',
  `spawnpoint` int(3) NOT NULL DEFAULT '0',
  `gm` int(3) NOT NULL DEFAULT '0',
  `party` int(11) NOT NULL DEFAULT '0',
  `buddyCapacity` int(11) NOT NULL DEFAULT '25',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `guildid` int(10) unsigned NOT NULL DEFAULT '0',
  `guildrank` tinyint(1) unsigned NOT NULL DEFAULT '5',
  `allianceRank` tinyint(1) unsigned NOT NULL DEFAULT '5',
  `guildContribution` int(11) NOT NULL DEFAULT '0',
  `pets` varchar(13) NOT NULL DEFAULT '-1,-1,-1',
  `sp` varchar(255) NOT NULL DEFAULT '0,0,0,0,0,0,0,0,0,0',
  `hsp` varchar(255) NOT NULL DEFAULT '0,0,0',
  `subcategory` int(11) NOT NULL DEFAULT '0',
  `rank` int(11) NOT NULL DEFAULT '1',
  `rankMove` int(11) NOT NULL DEFAULT '0',
  `jobRank` int(11) NOT NULL DEFAULT '1',
  `jobRankMove` int(11) NOT NULL DEFAULT '0',
  `marriageId` int(11) NOT NULL DEFAULT '0',
  `gachexp` int(11) NOT NULL DEFAULT '0',
  `fatigue` tinyint(4) NOT NULL DEFAULT '0',
  `charm` mediumint(7) NOT NULL DEFAULT '0',
  `craft` mediumint(7) NOT NULL DEFAULT '0',
  `charisma` mediumint(7) NOT NULL DEFAULT '0',
  `will` mediumint(7) NOT NULL DEFAULT '0',
  `sense` mediumint(7) NOT NULL DEFAULT '0',
  `insight` mediumint(7) NOT NULL DEFAULT '0',
  `pvpExp` int(11) NOT NULL DEFAULT '0',
  `pvpPoints` int(11) NOT NULL DEFAULT '0',
  `honourExp` int(11) NOT NULL DEFAULT '0',
  `honourLevel` int(11) NOT NULL DEFAULT '0',
  `friendshippoints` varchar(255) NOT NULL DEFAULT '0,0,0,0',
  `friendshiptoadd` int(11) NOT NULL DEFAULT '0',
  `chatcolour` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `accountid` (`accountid`),
  KEY `id` (`id`),
  KEY `guildid` (`guildid`),
  KEY `marriageId` (`marriageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of characters
-- ----------------------------

-- ----------------------------
-- Table structure for `character_cards`
-- ----------------------------
DROP TABLE IF EXISTS `character_cards`;
CREATE TABLE `character_cards` (
  `accid` int(10) NOT NULL,
  `worldid` int(11) NOT NULL,
  `characterid` int(11) NOT NULL,
  `position` int(11) NOT NULL,
  PRIMARY KEY (`characterid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of character_cards
-- ----------------------------

-- ----------------------------
-- Table structure for `character_slots`
-- ----------------------------
DROP TABLE IF EXISTS `character_slots`;
CREATE TABLE `character_slots` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accid` int(11) NOT NULL DEFAULT '0',
  `worldid` int(11) NOT NULL DEFAULT '0',
  `charslots` int(11) NOT NULL DEFAULT '6',
  PRIMARY KEY (`id`),
  KEY `accid` (`accid`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of character_slots
-- ----------------------------

-- ----------------------------
-- Table structure for `cheatlog`
-- ----------------------------
DROP TABLE IF EXISTS `cheatlog`;
CREATE TABLE `cheatlog` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `characterid` int(11) unsigned NOT NULL DEFAULT '0',
  `offense` text NOT NULL,
  `count` int(11) unsigned NOT NULL DEFAULT '0',
  `lastoffensetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `param` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`characterid`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of cheatlog
-- ----------------------------

-- ----------------------------
-- Table structure for `coreauras`
-- ----------------------------
DROP TABLE IF EXISTS `coreauras`;
CREATE TABLE `coreauras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `str` int(11) NOT NULL DEFAULT '0',
  `dex` int(11) NOT NULL DEFAULT '0',
  `int` int(11) NOT NULL DEFAULT '0',
  `luk` int(11) NOT NULL DEFAULT '0',
  `att` int(11) NOT NULL DEFAULT '0',
  `magic` int(11) NOT NULL DEFAULT '0',
  `total` int(11) NOT NULL DEFAULT '0',
  `expire` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of coreauras
-- ----------------------------

-- ----------------------------
-- Table structure for `dojorankings`
-- ----------------------------
DROP TABLE IF EXISTS `dojorankings`;
CREATE TABLE `dojorankings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rank` int(11) NOT NULL,
  `name` varchar(13) NOT NULL,
  `time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dojorankings
-- ----------------------------

-- ----------------------------
-- Table structure for `drop_data`
-- ----------------------------
DROP TABLE IF EXISTS `drop_data`;
CREATE TABLE `drop_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dropperid` int(11) NOT NULL,
  `itemid` int(11) NOT NULL DEFAULT '0',
  `minimum_quantity` tinyint(3) NOT NULL DEFAULT '1',
  `maximum_quantity` tinyint(3) NOT NULL DEFAULT '1',
  `questid` int(11) NOT NULL DEFAULT '0',
  `chance` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `mobid` (`dropperid`)
) ENGINE=MyISAM AUTO_INCREMENT=78511 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drop_data
-- ----------------------------

-- ----------------------------
-- Table structure for `drop_data_global`
-- ----------------------------
DROP TABLE IF EXISTS `drop_data_global`;
CREATE TABLE `drop_data_global` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `continent` int(11) NOT NULL,
  `dropType` tinyint(1) NOT NULL DEFAULT '0',
  `itemid` int(11) NOT NULL DEFAULT '0',
  `minimum_quantity` int(11) NOT NULL DEFAULT '1',
  `maximum_quantity` int(11) NOT NULL DEFAULT '1',
  `questid` int(11) NOT NULL DEFAULT '0',
  `chance` int(11) unsigned NOT NULL DEFAULT '0',
  `comments` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobid` (`continent`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of drop_data_global
-- ----------------------------

-- ----------------------------
-- Table structure for `dueypackages`
-- ----------------------------
DROP TABLE IF EXISTS `dueypackages`;
CREATE TABLE `dueypackages` (
  `PackageId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `RecieverId` int(10) NOT NULL,
  `SenderName` varchar(13) NOT NULL,
  `Mesos` bigint(20) unsigned DEFAULT '0',
  `TimeStamp` bigint(20) unsigned DEFAULT NULL,
  `Checked` tinyint(1) unsigned DEFAULT '1',
  `Type` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`PackageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of dueypackages
-- ----------------------------

-- ----------------------------
-- Table structure for `effectswitch`
-- ----------------------------
DROP TABLE IF EXISTS `effectswitch`;
CREATE TABLE `effectswitch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `characterid` int(11) NOT NULL,
  `pos` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of effectswitch
-- ----------------------------

-- ----------------------------
-- Table structure for `extendedslots`
-- ----------------------------
DROP TABLE IF EXISTS `extendedslots`;
CREATE TABLE `extendedslots` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `characterid` int(11) NOT NULL DEFAULT '0',
  `itemId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of extendedslots
-- ----------------------------

-- ----------------------------
-- Table structure for `famelog`
-- ----------------------------
DROP TABLE IF EXISTS `famelog`;
CREATE TABLE `famelog` (
  `famelogid` int(11) NOT NULL AUTO_INCREMENT,
  `characterid` int(11) NOT NULL DEFAULT '0',
  `characterid_to` int(11) NOT NULL DEFAULT '0',
  `when` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`famelogid`),
  KEY `characterid` (`characterid`),
  CONSTRAINT `famelog_ibfk_1` FOREIGN KEY (`characterid`) REFERENCES `characters` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of famelog
-- ----------------------------

-- ----------------------------
-- Table structure for `familiars`
-- ----------------------------
DROP TABLE IF EXISTS `familiars`;
CREATE TABLE `familiars` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `characterid` int(11) NOT NULL DEFAULT '0',
  `familiar` int(11) NOT NULL DEFAULT '0',
  `name` varchar(40) NOT NULL DEFAULT '',
  `fatigue` int(11) NOT NULL DEFAULT '0',
  `expiry` bigint(20) NOT NULL DEFAULT '0',
  `vitality` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of familiars
-- ----------------------------

-- ----------------------------
-- Table structure for `gifts`
-- ----------------------------
DROP TABLE IF EXISTS `gifts`;
CREATE TABLE `gifts` (
  `giftid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `recipient` int(11) NOT NULL DEFAULT '0',
  `from` varchar(13) NOT NULL DEFAULT '',
  `message` varchar(255) NOT NULL DEFAULT '',
  `sn` int(11) NOT NULL DEFAULT '0',
  `uniqueid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`giftid`),
  KEY `recipient` (`recipient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gifts
-- ----------------------------

-- ----------------------------
-- Table structure for `gmlog`
-- ----------------------------
DROP TABLE IF EXISTS `gmlog`;
CREATE TABLE `gmlog` (
  `gmlogid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL DEFAULT '0',
  `command` mediumtext NOT NULL,
  `mapid` int(11) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`gmlogid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gmlog
-- ----------------------------

-- ----------------------------
-- Table structure for `guilds`
-- ----------------------------
DROP TABLE IF EXISTS `guilds`;
CREATE TABLE `guilds` (
  `guildid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `leader` int(10) unsigned NOT NULL DEFAULT '0',
  `GP` int(11) NOT NULL DEFAULT '0',
  `logo` int(10) unsigned DEFAULT NULL,
  `logoColor` smallint(5) unsigned NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL,
  `rank1title` varchar(45) NOT NULL DEFAULT 'Master',
  `rank2title` varchar(45) NOT NULL DEFAULT 'Jr. Master',
  `rank3title` varchar(45) NOT NULL DEFAULT 'Member',
  `rank4title` varchar(45) NOT NULL DEFAULT 'Member',
  `rank5title` varchar(45) NOT NULL DEFAULT 'Member',
  `capacity` int(10) unsigned NOT NULL DEFAULT '10',
  `logoBG` int(10) unsigned DEFAULT NULL,
  `logoBGColor` smallint(5) unsigned NOT NULL DEFAULT '0',
  `notice` varchar(101) DEFAULT NULL,
  `signature` int(11) NOT NULL DEFAULT '0',
  `alliance` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`guildid`),
  UNIQUE KEY `name` (`name`),
  KEY `guildid` (`guildid`),
  KEY `leader` (`leader`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of guilds
-- ----------------------------

-- ----------------------------
-- Table structure for `guildskills`
-- ----------------------------
DROP TABLE IF EXISTS `guildskills`;
CREATE TABLE `guildskills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guildid` int(11) NOT NULL DEFAULT '0',
  `skillid` int(11) NOT NULL DEFAULT '0',
  `level` smallint(3) NOT NULL DEFAULT '1',
  `timestamp` bigint(20) NOT NULL DEFAULT '0',
  `purchaser` varchar(13) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of guildskills
-- ----------------------------

-- ----------------------------
-- Table structure for `hacker`
-- ----------------------------
DROP TABLE IF EXISTS `hacker`;
CREATE TABLE `hacker` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `md5` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of hacker
-- ----------------------------

-- ----------------------------
-- Table structure for `hiredmerch`
-- ----------------------------
DROP TABLE IF EXISTS `hiredmerch`;
CREATE TABLE `hiredmerch` (
  `PackageId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `characterid` int(10) unsigned DEFAULT '0',
  `accountid` int(10) unsigned DEFAULT NULL,
  `Mesos` bigint(20) unsigned DEFAULT '0',
  `time` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`PackageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hiredmerch
-- ----------------------------

-- ----------------------------
-- Table structure for `hyperrocklocations`
-- ----------------------------
DROP TABLE IF EXISTS `hyperrocklocations`;
CREATE TABLE `hyperrocklocations` (
  `trockid` int(11) NOT NULL AUTO_INCREMENT,
  `characterid` int(11) DEFAULT NULL,
  `mapid` int(11) DEFAULT NULL,
  PRIMARY KEY (`trockid`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hyperrocklocations
-- ----------------------------

-- ----------------------------
-- Table structure for `imps`
-- ----------------------------
DROP TABLE IF EXISTS `imps`;
CREATE TABLE `imps` (
  `impid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `characterid` int(11) NOT NULL DEFAULT '0',
  `itemid` int(11) NOT NULL DEFAULT '0',
  `level` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `state` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `closeness` mediumint(6) unsigned NOT NULL DEFAULT '0',
  `fullness` mediumint(6) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`impid`),
  KEY `impid` (`impid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of imps
-- ----------------------------

-- ----------------------------
-- Table structure for `inner_ability_skills`
-- ----------------------------
DROP TABLE IF EXISTS `inner_ability_skills`;
CREATE TABLE `inner_ability_skills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `player_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `skill_level` int(3) NOT NULL,
  `max_level` int(3) NOT NULL,
  `rank` int(3) NOT NULL,
  `locked` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inner_ability_skills
-- ----------------------------

-- ----------------------------
-- Table structure for `internlog`
-- ----------------------------
DROP TABLE IF EXISTS `internlog`;
CREATE TABLE `internlog` (
  `gmlogid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL DEFAULT '0',
  `command` text NOT NULL,
  `mapid` int(11) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`gmlogid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of internlog
-- ----------------------------

-- ----------------------------
-- Table structure for `inventoryequipment`
-- ----------------------------
DROP TABLE IF EXISTS `inventoryequipment`;
CREATE TABLE `inventoryequipment` (
  `inventoryequipmentid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `inventoryitemid` bigint(20) unsigned NOT NULL DEFAULT '0',
  `PlatinumHammer` tinyint(2) NOT NULL DEFAULT '0',
  `upgradeslots` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `level` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `str` int(6) NOT NULL DEFAULT '0',
  `dex` int(6) NOT NULL DEFAULT '0',
  `int` int(6) NOT NULL DEFAULT '0',
  `luk` int(6) NOT NULL DEFAULT '0',
  `hp` int(6) NOT NULL DEFAULT '0',
  `mp` int(6) NOT NULL DEFAULT '0',
  `watk` int(6) NOT NULL DEFAULT '0',
  `matk` int(6) NOT NULL DEFAULT '0',
  `wdef` int(6) NOT NULL DEFAULT '0',
  `mdef` int(6) NOT NULL DEFAULT '0',
  `acc` int(6) NOT NULL DEFAULT '0',
  `avoid` int(6) NOT NULL DEFAULT '0',
  `hands` int(6) NOT NULL DEFAULT '0',
  `speed` int(6) NOT NULL DEFAULT '0',
  `jump` int(6) NOT NULL DEFAULT '0',
  `ViciousHammer` tinyint(2) NOT NULL DEFAULT '0',
  `itemEXP` int(11) NOT NULL DEFAULT '0',
  `durability` mediumint(9) NOT NULL DEFAULT '-1',
  `enhance` tinyint(3) NOT NULL DEFAULT '0',
  `state` tinyint(3) NOT NULL,
  `potential1` int(5) NOT NULL DEFAULT '0',
  `potential2` int(5) NOT NULL DEFAULT '0',
  `potential3` int(5) NOT NULL DEFAULT '0',
  `bonusState` tinyint(3) NOT NULL,
  `potential4` int(5) NOT NULL DEFAULT '0',
  `potential5` int(5) NOT NULL DEFAULT '0',
  `potential6` int(5) NOT NULL DEFAULT '0',
  `fusionAnvil` int(11) NOT NULL DEFAULT '0',
  `socket1` int(5) NOT NULL DEFAULT '-1',
  `socket2` int(5) NOT NULL DEFAULT '-1',
  `socket3` int(5) NOT NULL DEFAULT '-1',
  `incSkill` int(11) NOT NULL DEFAULT '-1',
  `charmEXP` int(6) NOT NULL DEFAULT '-1',
  `pvpDamage` int(6) NOT NULL DEFAULT '0',
  `enhanctBuff` int(3) NOT NULL DEFAULT '0',
  `reqLevel` int(3) NOT NULL DEFAULT '0',
  `yggdrasilWisdom` tinyint(2) NOT NULL DEFAULT '0',
  `finalStrike` tinyint(2) NOT NULL DEFAULT '0',
  `bossDamage` int(3) NOT NULL DEFAULT '0',
  `ignorePDR` int(3) NOT NULL DEFAULT '0',
  `totalDamage` int(3) NOT NULL DEFAULT '0',
  `allStat` int(3) NOT NULL DEFAULT '0',
  `karmaCount` int(3) NOT NULL DEFAULT '-1',
  `starforce` int(3) NOT NULL DEFAULT '0',
  `soulname` int(6) NOT NULL DEFAULT '0',
  `soulenchanter` int(6) NOT NULL DEFAULT '0',
  `soulpotential` int(6) NOT NULL DEFAULT '0',
  `soulskill` int(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`inventoryequipmentid`),
  KEY `inventoryitemid` (`inventoryitemid`),
  CONSTRAINT `inventoryequipment_ibfk_1` FOREIGN KEY (`inventoryitemid`) REFERENCES `inventoryitems` (`inventoryitemid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of inventoryequipment
-- ----------------------------

-- ----------------------------
-- Table structure for `inventoryitems`
-- ----------------------------
DROP TABLE IF EXISTS `inventoryitems`;
CREATE TABLE `inventoryitems` (
  `inventoryitemid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `characterid` int(11) DEFAULT NULL,
  `accountid` int(10) DEFAULT NULL,
  `itemid` int(11) NOT NULL DEFAULT '0',
  `inventorytype` int(11) NOT NULL DEFAULT '0',
  `position` int(11) NOT NULL DEFAULT '0',
  `quantity` int(11) NOT NULL DEFAULT '0',
  `owner` text,
  `GM_Log` text,
  `uniqueid` int(11) NOT NULL DEFAULT '-1',
  `flag` int(2) NOT NULL DEFAULT '0',
  `expiredate` bigint(20) NOT NULL DEFAULT '-1',
  `type` tinyint(1) NOT NULL DEFAULT '0',
  `sender` varchar(13) NOT NULL DEFAULT '',
  PRIMARY KEY (`inventoryitemid`),
  KEY `inventorytype` (`inventorytype`),
  KEY `accountid` (`accountid`),
  KEY `characterid_2` (`characterid`,`inventorytype`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of inventoryitems
-- ----------------------------

-- ----------------------------
-- Table structure for `inventorylog`
-- ----------------------------
DROP TABLE IF EXISTS `inventorylog`;
CREATE TABLE `inventorylog` (
  `inventorylogid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `inventoryitemid` int(10) unsigned NOT NULL DEFAULT '0',
  `msg` text NOT NULL,
  PRIMARY KEY (`inventorylogid`),
  KEY `inventoryitemid` (`inventoryitemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inventorylog
-- ----------------------------

-- ----------------------------
-- Table structure for `inventoryslot`
-- ----------------------------
DROP TABLE IF EXISTS `inventoryslot`;
CREATE TABLE `inventoryslot` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `characterid` int(10) unsigned DEFAULT NULL,
  `equip` tinyint(3) unsigned DEFAULT NULL,
  `use` tinyint(3) unsigned DEFAULT NULL,
  `setup` tinyint(3) unsigned DEFAULT NULL,
  `etc` tinyint(3) unsigned DEFAULT NULL,
  `cash` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `characterid` (`characterid`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of inventoryslot
-- ----------------------------

-- ----------------------------
-- Table structure for `ipbans`
-- ----------------------------
DROP TABLE IF EXISTS `ipbans`;
CREATE TABLE `ipbans` (
  `ipbanid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ip` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`ipbanid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of ipbans
-- ----------------------------

-- ----------------------------
-- Table structure for `iplog`
-- ----------------------------
DROP TABLE IF EXISTS `iplog`;
CREATE TABLE `iplog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accid` int(11) NOT NULL,
  `ip` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of iplog
-- ----------------------------

-- ----------------------------
-- Table structure for `keymap`
-- ----------------------------
DROP TABLE IF EXISTS `keymap`;
CREATE TABLE `keymap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `characterid` int(11) NOT NULL DEFAULT '0',
  `key` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `type` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `action` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `keymap_ibfk_1` (`characterid`),
  CONSTRAINT `keymap_ibfk_1` FOREIGN KEY (`characterid`) REFERENCES `characters` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of keymap
-- ----------------------------

-- ----------------------------
-- Table structure for `macbans`
-- ----------------------------
DROP TABLE IF EXISTS `macbans`;
CREATE TABLE `macbans` (
  `macbanid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mac` varchar(30) NOT NULL,
  PRIMARY KEY (`macbanid`),
  UNIQUE KEY `mac_2` (`mac`)
) ENGINE=MEMORY DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of macbans
-- ----------------------------

-- ----------------------------
-- Table structure for `macfilters`
-- ----------------------------
DROP TABLE IF EXISTS `macfilters`;
CREATE TABLE `macfilters` (
  `macfilterid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `filter` varchar(30) NOT NULL,
  PRIMARY KEY (`macfilterid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of macfilters
-- ----------------------------

-- ----------------------------
-- Table structure for `marriages`
-- ----------------------------
DROP TABLE IF EXISTS `marriages`;
CREATE TABLE `marriages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `husbandId` int(11) NOT NULL,
  `wifeId` int(11) NOT NULL DEFAULT '0',
  `ring` int(11) NOT NULL DEFAULT '0',
  `husbandName` varchar(15) NOT NULL DEFAULT '0',
  `WifeName` varchar(15) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of marriages
-- ----------------------------

-- ----------------------------
-- Table structure for `monsterbook`
-- ----------------------------
DROP TABLE IF EXISTS `monsterbook`;
CREATE TABLE `monsterbook` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `charid` int(10) unsigned NOT NULL DEFAULT '0',
  `cardid` int(10) unsigned NOT NULL DEFAULT '0',
  `level` tinyint(2) unsigned DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `charid` (`charid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of monsterbook
-- ----------------------------

-- ----------------------------
-- Table structure for `mountdata`
-- ----------------------------
DROP TABLE IF EXISTS `mountdata`;
CREATE TABLE `mountdata` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `characterid` int(10) unsigned DEFAULT NULL,
  `Level` int(3) unsigned NOT NULL DEFAULT '0',
  `Exp` int(10) unsigned NOT NULL DEFAULT '0',
  `Fatigue` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `characterid` (`characterid`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mountdata
-- ----------------------------

-- ----------------------------
-- Table structure for `notes`
-- ----------------------------
DROP TABLE IF EXISTS `notes`;
CREATE TABLE `notes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `to` varchar(13) NOT NULL DEFAULT '',
  `from` varchar(13) NOT NULL DEFAULT '',
  `message` mediumtext NOT NULL,
  `timestamp` bigint(20) unsigned NOT NULL,
  `gift` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `to` (`to`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of notes
-- ----------------------------

-- ----------------------------
-- Table structure for `nxcode`
-- ----------------------------
DROP TABLE IF EXISTS `nxcode`;
CREATE TABLE `nxcode` (
  `code` varchar(15) NOT NULL,
  `valid` int(11) NOT NULL DEFAULT '1',
  `user` varchar(13) DEFAULT NULL,
  `type` int(11) NOT NULL DEFAULT '0',
  `item` int(11) NOT NULL DEFAULT '10000',
  PRIMARY KEY (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nxcode
-- ----------------------------

-- ----------------------------
-- Table structure for `parttime`
-- ----------------------------
DROP TABLE IF EXISTS `parttime`;
CREATE TABLE `parttime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `job` tinyint(1) NOT NULL DEFAULT '0',
  `time` bigint(20) NOT NULL DEFAULT '0',
  `reward` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of parttime
-- ----------------------------

-- ----------------------------
-- Table structure for `pets`
-- ----------------------------
DROP TABLE IF EXISTS `pets`;
CREATE TABLE `pets` (
  `petid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(13) DEFAULT NULL,
  `level` int(3) unsigned NOT NULL,
  `closeness` int(6) unsigned NOT NULL,
  `fullness` int(3) unsigned NOT NULL,
  `seconds` int(11) NOT NULL DEFAULT '0',
  `flags` smallint(5) NOT NULL DEFAULT '0',
  `skillid` int(11) NOT NULL DEFAULT '0',
  `excluded` varchar(255) NOT NULL DEFAULT '0,0,0,0,0,0,0,0,0,0',
  PRIMARY KEY (`petid`),
  KEY `petid` (`petid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pets
-- ----------------------------

-- ----------------------------
-- Table structure for `playernpcs`
-- ----------------------------
DROP TABLE IF EXISTS `playernpcs`;
CREATE TABLE `playernpcs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(13) NOT NULL,
  `hair` int(11) NOT NULL,
  `face` int(11) NOT NULL,
  `skin` int(11) NOT NULL,
  `x` int(11) NOT NULL DEFAULT '0',
  `y` int(11) NOT NULL DEFAULT '0',
  `map` int(11) NOT NULL,
  `charid` int(11) NOT NULL,
  `scriptid` int(11) NOT NULL,
  `foothold` int(11) NOT NULL,
  `dir` tinyint(1) NOT NULL DEFAULT '0',
  `gender` tinyint(1) NOT NULL DEFAULT '0',
  `pets` varchar(25) DEFAULT '0,0,0',
  `job` int(5) NOT NULL,
  `elf` int(11) NOT NULL,
  `demonmarking` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `scriptid` (`scriptid`),
  KEY `playernpcs_ibfk_1` (`charid`),
  CONSTRAINT `playernpcs_ibfk_1` FOREIGN KEY (`charid`) REFERENCES `characters` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of playernpcs
-- ----------------------------

-- ----------------------------
-- Table structure for `playernpcs_equip`
-- ----------------------------
DROP TABLE IF EXISTS `playernpcs_equip`;
CREATE TABLE `playernpcs_equip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `npcid` int(11) NOT NULL,
  `equipid` int(11) NOT NULL,
  `equippos` int(11) NOT NULL,
  `charid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `playernpcs_equip_ibfk_1` (`charid`),
  KEY `playernpcs_equip_ibfk_2` (`npcid`),
  CONSTRAINT `playernpcs_equip_ibfk_1` FOREIGN KEY (`charid`) REFERENCES `characters` (`id`) ON DELETE CASCADE,
  CONSTRAINT `playernpcs_equip_ibfk_2` FOREIGN KEY (`npcid`) REFERENCES `playernpcs` (`scriptid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of playernpcs_equip
-- ----------------------------

-- ----------------------------
-- Table structure for `pqlog`
-- ----------------------------
DROP TABLE IF EXISTS `pqlog`;
CREATE TABLE `pqlog` (
  `pqid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `characterid` int(10) unsigned NOT NULL,
  `pqname` varchar(20) NOT NULL,
  `count` int(10) NOT NULL DEFAULT '0',
  `type` int(10) NOT NULL DEFAULT '0',
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pqid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of pqlog
-- ----------------------------

-- ----------------------------
-- Table structure for `questinfo`
-- ----------------------------
DROP TABLE IF EXISTS `questinfo`;
CREATE TABLE `questinfo` (
  `questinfoid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `characterid` int(11) NOT NULL DEFAULT '0',
  `quest` int(6) NOT NULL DEFAULT '0',
  `customData` varchar(555) DEFAULT NULL,
  PRIMARY KEY (`questinfoid`),
  KEY `characterid` (`characterid`),
  CONSTRAINT `questsinfo_ibfk_1` FOREIGN KEY (`characterid`) REFERENCES `characters` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of questinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `queststatus`
-- ----------------------------
DROP TABLE IF EXISTS `queststatus`;
CREATE TABLE `queststatus` (
  `queststatusid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `characterid` int(11) NOT NULL DEFAULT '0',
  `quest` int(6) NOT NULL DEFAULT '0',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `time` int(11) NOT NULL DEFAULT '0',
  `forfeited` int(11) NOT NULL DEFAULT '0',
  `customData` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`queststatusid`),
  KEY `characterid` (`characterid`),
  KEY `queststatusid` (`queststatusid`),
  CONSTRAINT `queststatus_ibfk_1` FOREIGN KEY (`characterid`) REFERENCES `characters` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of queststatus
-- ----------------------------

-- ----------------------------
-- Table structure for `queststatusmobs`
-- ----------------------------
DROP TABLE IF EXISTS `queststatusmobs`;
CREATE TABLE `queststatusmobs` (
  `queststatusmobid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `queststatusid` int(10) unsigned NOT NULL DEFAULT '0',
  `mob` int(11) NOT NULL DEFAULT '0',
  `count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`queststatusmobid`),
  KEY `queststatusid` (`queststatusid`),
  CONSTRAINT `queststatusmobs_ibfk_1` FOREIGN KEY (`queststatusid`) REFERENCES `queststatus` (`queststatusid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of queststatusmobs
-- ----------------------------

-- ----------------------------
-- Table structure for `reactordrops`
-- ----------------------------
DROP TABLE IF EXISTS `reactordrops`;
CREATE TABLE `reactordrops` (
  `reactordropid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `reactorid` int(11) NOT NULL,
  `itemid` int(11) NOT NULL,
  `chance` int(11) NOT NULL,
  `questid` int(5) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`reactordropid`),
  KEY `reactorid` (`reactorid`)
) ENGINE=MyISAM AUTO_INCREMENT=844 DEFAULT CHARSET=utf8 PACK_KEYS=1;

-- ----------------------------
-- Records of reactordrops
-- ----------------------------

-- ----------------------------
-- Table structure for `regrocklocations`
-- ----------------------------
DROP TABLE IF EXISTS `regrocklocations`;
CREATE TABLE `regrocklocations` (
  `trockid` int(11) NOT NULL AUTO_INCREMENT,
  `characterid` int(11) DEFAULT NULL,
  `mapid` int(11) DEFAULT NULL,
  PRIMARY KEY (`trockid`),
  KEY `characterid` (`characterid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of regrocklocations
-- ----------------------------

-- ----------------------------
-- Table structure for `reports`
-- ----------------------------
DROP TABLE IF EXISTS `reports`;
CREATE TABLE `reports` (
  `reportid` int(9) NOT NULL AUTO_INCREMENT,
  `characterid` int(11) NOT NULL DEFAULT '0',
  `type` tinyint(2) NOT NULL DEFAULT '0',
  `count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`reportid`,`characterid`),
  KEY `characterid` (`characterid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reports
-- ----------------------------

-- ----------------------------
-- Table structure for `rewards`
-- ----------------------------
DROP TABLE IF EXISTS `rewards`;
CREATE TABLE `rewards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `start` bigint(20) NOT NULL DEFAULT '-1',
  `end` bigint(20) NOT NULL DEFAULT '-1',
  `type` int(11) NOT NULL DEFAULT '0',
  `itemId` int(11) NOT NULL DEFAULT '0',
  `mp` int(11) NOT NULL DEFAULT '0',
  `meso` int(11) NOT NULL DEFAULT '0',
  `exp` int(11) NOT NULL DEFAULT '0',
  `desc` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of rewards
-- ----------------------------

-- ----------------------------
-- Table structure for `rings`
-- ----------------------------
DROP TABLE IF EXISTS `rings`;
CREATE TABLE `rings` (
  `ringid` int(11) NOT NULL AUTO_INCREMENT,
  `partnerRingId` int(11) NOT NULL DEFAULT '0',
  `partnerChrId` int(11) NOT NULL DEFAULT '0',
  `itemid` int(11) NOT NULL DEFAULT '0',
  `partnername` varchar(255) NOT NULL,
  PRIMARY KEY (`ringid`),
  KEY `ringid` (`ringid`),
  KEY `partnerChrId` (`partnerChrId`),
  KEY `partnerRingId` (`partnerRingId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of rings
-- ----------------------------

-- ----------------------------
-- Table structure for `savedlocations`
-- ----------------------------
DROP TABLE IF EXISTS `savedlocations`;
CREATE TABLE `savedlocations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `characterid` int(11) NOT NULL,
  `locationtype` int(11) NOT NULL DEFAULT '0',
  `map` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `savedlocations_ibfk_1` (`characterid`),
  CONSTRAINT `savedlocations_ibfk_1` FOREIGN KEY (`characterid`) REFERENCES `characters` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of savedlocations
-- ----------------------------

-- ----------------------------
-- Table structure for `scroll_log`
-- ----------------------------
DROP TABLE IF EXISTS `scroll_log`;
CREATE TABLE `scroll_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accId` int(11) NOT NULL DEFAULT '0',
  `chrId` int(11) NOT NULL DEFAULT '0',
  `scrollId` int(11) NOT NULL DEFAULT '0',
  `itemId` int(11) NOT NULL DEFAULT '0',
  `oldSlots` tinyint(4) NOT NULL DEFAULT '0',
  `newSlots` tinyint(4) NOT NULL DEFAULT '0',
  `hammer` tinyint(4) NOT NULL DEFAULT '0',
  `result` varchar(13) NOT NULL DEFAULT '',
  `whiteScroll` tinyint(1) NOT NULL DEFAULT '0',
  `legendarySpirit` tinyint(1) NOT NULL DEFAULT '0',
  `vegaId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of scroll_log
-- ----------------------------

-- ----------------------------
-- Table structure for `shopitems`
-- ----------------------------
DROP TABLE IF EXISTS `shopitems`;
CREATE TABLE `shopitems` (
  `shopitemid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shopid` int(10) unsigned NOT NULL DEFAULT '0',
  `itemid` int(11) NOT NULL DEFAULT '0',
  `price` int(11) NOT NULL DEFAULT '0',
  `position` int(11) NOT NULL DEFAULT '0',
  `reqitem` int(11) NOT NULL DEFAULT '0',
  `reqitemq` int(11) NOT NULL DEFAULT '0',
  `rank` tinyint(3) NOT NULL DEFAULT '0',
  `quantity` int(11) NOT NULL DEFAULT '0',
  `buyable` int(11) NOT NULL DEFAULT '0',
  `category` tinyint(3) NOT NULL DEFAULT '0',
  `minLevel` int(11) NOT NULL DEFAULT '0',
  `expiration` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`shopitemid`),
  KEY `shopid` (`shopid`)
) ENGINE=MyISAM AUTO_INCREMENT=6522 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopitems
-- ----------------------------

-- ----------------------------
-- Table structure for `shopranks`
-- ----------------------------
DROP TABLE IF EXISTS `shopranks`;
CREATE TABLE `shopranks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopid` int(11) NOT NULL DEFAULT '0',
  `rank` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL DEFAULT '',
  `itemid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of shopranks
-- ----------------------------

-- ----------------------------
-- Table structure for `shops`
-- ----------------------------
DROP TABLE IF EXISTS `shops`;
CREATE TABLE `shops` (
  `shopid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `npcid` int(11) DEFAULT '0',
  PRIMARY KEY (`shopid`)
) ENGINE=MyISAM AUTO_INCREMENT=9270066 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of shops
-- ----------------------------

-- ----------------------------
-- Table structure for `skillmacros`
-- ----------------------------
DROP TABLE IF EXISTS `skillmacros`;
CREATE TABLE `skillmacros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `characterid` int(11) NOT NULL DEFAULT '0',
  `position` tinyint(1) NOT NULL DEFAULT '0',
  `skill1` int(11) NOT NULL DEFAULT '0',
  `skill2` int(11) NOT NULL DEFAULT '0',
  `skill3` int(11) NOT NULL DEFAULT '0',
  `name` varchar(30) DEFAULT NULL,
  `shout` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `characterid` (`characterid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of skillmacros
-- ----------------------------

-- ----------------------------
-- Table structure for `skills`
-- ----------------------------
DROP TABLE IF EXISTS `skills`;
CREATE TABLE `skills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `skillid` int(11) NOT NULL DEFAULT '0',
  `characterid` int(11) NOT NULL DEFAULT '0',
  `skilllevel` int(11) NOT NULL DEFAULT '0',
  `masterlevel` tinyint(4) NOT NULL DEFAULT '0',
  `expiration` bigint(20) NOT NULL DEFAULT '-1',
  `victimid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `skills_ibfk_1` (`characterid`),
  CONSTRAINT `skills_ibfk_1` FOREIGN KEY (`characterid`) REFERENCES `characters` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of skills
-- ----------------------------

-- ----------------------------
-- Table structure for `skills_cooldowns`
-- ----------------------------
DROP TABLE IF EXISTS `skills_cooldowns`;
CREATE TABLE `skills_cooldowns` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `charid` int(11) NOT NULL,
  `SkillID` int(11) NOT NULL,
  `length` bigint(20) NOT NULL,
  `StartTime` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `charid` (`charid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of skills_cooldowns
-- ----------------------------

-- ----------------------------
-- Table structure for `speedruns`
-- ----------------------------
DROP TABLE IF EXISTS `speedruns`;
CREATE TABLE `speedruns` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(13) NOT NULL,
  `leader` varchar(13) NOT NULL,
  `timestring` varchar(1024) NOT NULL,
  `time` bigint(20) NOT NULL DEFAULT '0',
  `members` varchar(1024) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of speedruns
-- ----------------------------

-- ----------------------------
-- Table structure for `stolen`
-- ----------------------------
DROP TABLE IF EXISTS `stolen`;
CREATE TABLE `stolen` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `characterid` varchar(45) NOT NULL,
  `skillid` varchar(45) NOT NULL,
  `chosen` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stolen
-- ----------------------------

-- ----------------------------
-- Table structure for `storages`
-- ----------------------------
DROP TABLE IF EXISTS `storages`;
CREATE TABLE `storages` (
  `storageid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `accountid` int(11) NOT NULL DEFAULT '0',
  `slots` int(11) NOT NULL DEFAULT '0',
  `meso` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`storageid`),
  KEY `accountid` (`accountid`),
  CONSTRAINT `storages_ibfk_1` FOREIGN KEY (`accountid`) REFERENCES `accounts` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of storages
-- ----------------------------

-- ----------------------------
-- Table structure for `trocklocations`
-- ----------------------------
DROP TABLE IF EXISTS `trocklocations`;
CREATE TABLE `trocklocations` (
  `trockid` int(11) NOT NULL AUTO_INCREMENT,
  `characterid` int(11) DEFAULT NULL,
  `mapid` int(11) DEFAULT NULL,
  PRIMARY KEY (`trockid`),
  KEY `characterid` (`characterid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trocklocations
-- ----------------------------

-- ----------------------------
-- Table structure for `wishlist`
-- ----------------------------
DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE `wishlist` (
  `characterid` int(11) NOT NULL,
  `sn` int(11) NOT NULL,
  KEY `characterid` (`characterid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of wishlist
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_customlife`
-- ----------------------------
DROP TABLE IF EXISTS `wz_customlife`;
CREATE TABLE `wz_customlife` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataid` int(11) NOT NULL,
  `f` int(11) NOT NULL,
  `hide` tinyint(1) NOT NULL DEFAULT '0',
  `fh` int(11) NOT NULL,
  `type` varchar(1) NOT NULL,
  `cy` int(11) NOT NULL,
  `rx0` int(11) NOT NULL,
  `rx1` int(11) NOT NULL,
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL,
  `mobtime` int(11) DEFAULT '1000',
  `mid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wz_customlife
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_itemadddata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_itemadddata`;
CREATE TABLE `wz_itemadddata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemid` int(11) NOT NULL,
  `key` varchar(30) NOT NULL,
  `subKey` varchar(30) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6238 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of wz_itemadddata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_itemdata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_itemdata`;
CREATE TABLE `wz_itemdata` (
  `itemid` int(11) NOT NULL,
  `name` tinytext,
  `msg` varchar(4096) DEFAULT NULL,
  `desc` varchar(4096) DEFAULT NULL,
  `slotMax` smallint(5) NOT NULL DEFAULT '1',
  `price` varchar(255) NOT NULL DEFAULT '-1.0',
  `wholePrice` int(11) NOT NULL DEFAULT '-1',
  `stateChange` int(11) NOT NULL DEFAULT '0',
  `flags` smallint(4) NOT NULL DEFAULT '0',
  `karma` tinyint(1) NOT NULL DEFAULT '0',
  `meso` int(11) NOT NULL DEFAULT '0',
  `monsterBook` int(11) NOT NULL DEFAULT '0',
  `itemMakeLevel` smallint(6) NOT NULL DEFAULT '0',
  `questId` int(11) NOT NULL DEFAULT '0',
  `scrollReqs` varchar(4096) DEFAULT NULL,
  `consumeItem` tinytext,
  `totalprob` int(11) NOT NULL DEFAULT '0',
  `incSkill` varchar(255) NOT NULL DEFAULT '',
  `replaceid` int(11) NOT NULL DEFAULT '0',
  `replacemsg` varchar(255) NOT NULL DEFAULT '',
  `create` int(11) NOT NULL DEFAULT '0',
  `afterImage` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`itemid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of wz_itemdata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_itemequipdata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_itemequipdata`;
CREATE TABLE `wz_itemequipdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemid` int(11) NOT NULL,
  `itemLevel` int(11) NOT NULL DEFAULT '-1',
  `key` varchar(30) NOT NULL,
  `value` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=560145 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of wz_itemequipdata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_itemrewarddata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_itemrewarddata`;
CREATE TABLE `wz_itemrewarddata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemid` int(11) NOT NULL,
  `item` int(11) NOT NULL,
  `prob` int(11) NOT NULL DEFAULT '0',
  `quantity` smallint(5) NOT NULL DEFAULT '0',
  `period` int(11) NOT NULL DEFAULT '-1',
  `worldMsg` varchar(255) NOT NULL DEFAULT '',
  `effect` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=43582 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of wz_itemrewarddata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_mobskilldata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_mobskilldata`;
CREATE TABLE `wz_mobskilldata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `skillid` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `hp` int(11) NOT NULL DEFAULT '100',
  `mpcon` int(11) NOT NULL DEFAULT '0',
  `x` int(11) NOT NULL DEFAULT '1',
  `y` int(11) NOT NULL DEFAULT '1',
  `time` int(11) NOT NULL DEFAULT '0',
  `prop` int(11) NOT NULL DEFAULT '100',
  `limit` int(11) NOT NULL DEFAULT '0',
  `spawneffect` int(11) NOT NULL DEFAULT '0',
  `interval` int(11) NOT NULL DEFAULT '0',
  `summons` varchar(1024) NOT NULL DEFAULT '',
  `ltx` int(11) NOT NULL DEFAULT '0',
  `lty` int(11) NOT NULL DEFAULT '0',
  `rbx` int(11) NOT NULL DEFAULT '0',
  `rby` int(11) NOT NULL DEFAULT '0',
  `once` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3422 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wz_mobskilldata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_npcnamedata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_npcnamedata`;
CREATE TABLE `wz_npcnamedata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `npc` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3848 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of wz_npcnamedata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_oxdata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_oxdata`;
CREATE TABLE `wz_oxdata` (
  `questionset` smallint(6) NOT NULL DEFAULT '0',
  `questionid` smallint(6) NOT NULL DEFAULT '0',
  `question` varchar(200) NOT NULL DEFAULT '',
  `display` varchar(200) NOT NULL DEFAULT '',
  `answer` enum('o','x') NOT NULL,
  PRIMARY KEY (`questionset`,`questionid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wz_oxdata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_questactdata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_questactdata`;
CREATE TABLE `wz_questactdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(127) NOT NULL DEFAULT '',
  `type` tinyint(1) NOT NULL DEFAULT '0',
  `intStore` int(11) NOT NULL DEFAULT '0',
  `applicableJobs` varchar(1024) NOT NULL DEFAULT '',
  `uniqueid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `quests_ibfk_2` (`questid`)
) ENGINE=MyISAM AUTO_INCREMENT=29516 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of wz_questactdata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_questactitemdata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_questactitemdata`;
CREATE TABLE `wz_questactitemdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemid` int(11) NOT NULL DEFAULT '0',
  `count` smallint(5) NOT NULL DEFAULT '0',
  `period` int(11) NOT NULL DEFAULT '0',
  `gender` tinyint(1) NOT NULL DEFAULT '2',
  `job` int(11) NOT NULL DEFAULT '-1',
  `jobEx` int(11) NOT NULL DEFAULT '-1',
  `prop` int(11) NOT NULL DEFAULT '-1',
  `uniqueid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=35609 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of wz_questactitemdata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_questactquestdata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_questactquestdata`;
CREATE TABLE `wz_questactquestdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quest` int(11) NOT NULL DEFAULT '0',
  `state` tinyint(1) NOT NULL DEFAULT '2',
  `uniqueid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of wz_questactquestdata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_questactskilldata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_questactskilldata`;
CREATE TABLE `wz_questactskilldata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `skillid` int(11) NOT NULL DEFAULT '0',
  `skillLevel` int(11) NOT NULL DEFAULT '-1',
  `masterLevel` int(11) NOT NULL DEFAULT '-1',
  `uniqueid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=537 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of wz_questactskilldata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_questdata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_questdata`;
CREATE TABLE `wz_questdata` (
  `questid` int(11) NOT NULL,
  `name` varchar(1024) NOT NULL DEFAULT '',
  `autoStart` tinyint(1) NOT NULL DEFAULT '0',
  `autoPreComplete` tinyint(1) NOT NULL DEFAULT '0',
  `viewMedalItem` int(11) NOT NULL DEFAULT '0',
  `selectedSkillID` int(11) NOT NULL DEFAULT '0',
  `blocked` tinyint(1) NOT NULL DEFAULT '0',
  `autoAccept` tinyint(1) NOT NULL DEFAULT '0',
  `autoComplete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`questid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of wz_questdata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_questpartydata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_questpartydata`;
CREATE TABLE `wz_questpartydata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questid` int(11) NOT NULL DEFAULT '0',
  `rank` varchar(1) NOT NULL DEFAULT '',
  `mode` varchar(13) NOT NULL DEFAULT '',
  `property` varchar(255) NOT NULL DEFAULT '',
  `value` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `quests_ibfk_7` (`questid`)
) ENGINE=MyISAM AUTO_INCREMENT=161 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of wz_questpartydata
-- ----------------------------

-- ----------------------------
-- Table structure for `wz_questreqdata`
-- ----------------------------
DROP TABLE IF EXISTS `wz_questreqdata`;
CREATE TABLE `wz_questreqdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(128) NOT NULL DEFAULT '',
  `type` tinyint(1) NOT NULL DEFAULT '0',
  `intStore` int(11) NOT NULL DEFAULT '-1',
  `stringStore` varchar(1024) NOT NULL DEFAULT '',
  `intStoresFirst` varchar(1024) NOT NULL DEFAULT '',
  `intStoresSecond` varchar(4096) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `quests_ibfk_1` (`questid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of wz_questreqdata
-- ----------------------------

-- ----------------------------
-- View structure for `readable_cheatlog`
-- ----------------------------
DROP VIEW IF EXISTS `readable_cheatlog`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `readable_cheatlog` AS select `a`.`name` AS `accountname`,`a`.`id` AS `accountid`,`c`.`name` AS `name`,`c`.`id` AS `characterid`,`cl`.`offense` AS `offense`,`cl`.`count` AS `count`,`cl`.`lastoffensetime` AS `lastoffensetime`,`cl`.`param` AS `param` from ((`cheatlog` `cl` join `characters` `c`) join `accounts` `a`) where ((`cl`.`id` = `c`.`id`) and (`a`.`id` = `c`.`accountid`) and (`a`.`banned` = 0)) ;

-- ----------------------------
-- View structure for `readable_last_hour_cheatlog`
-- ----------------------------
DROP VIEW IF EXISTS `readable_last_hour_cheatlog`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `readable_last_hour_cheatlog` AS select `a`.`name` AS `accountname`,`a`.`id` AS `accountid`,`c`.`name` AS `name`,`c`.`id` AS `characterid`,sum(`cl`.`count`) AS `numrepos` from ((`cheatlog` `cl` join `characters` `c`) join `accounts` `a`) where ((`cl`.`id` = `c`.`id`) and (`a`.`id` = `c`.`accountid`) and (timestampdiff(HOUR,`cl`.`lastoffensetime`,now()) < 1) and (`a`.`banned` = 0)) group by `cl`.`id` order by sum(`cl`.`count`) desc ;

-- ----------------------------
-- Procedure structure for `doWipe`
-- ----------------------------
DROP PROCEDURE IF EXISTS `doWipe`;
DELIMITER ;;
CREATE DEFINER=`Emy77182x3`@`%` PROCEDURE `doWipe`(iid INT, lower INT, upper INT, leave_amount INT)
BEGIN

  DECLARE done INT DEFAULT 0;

  DECLARE CharID INT;

  DECLARE NumWipe INT;

  DECLARE curs1 CURSOR FOR

    SELECT characterid, c FROM (

      SELECT characterid, COUNT(*) c

      FROM inventoryitems

      WHERE itemid = iid

      GROUP BY characterid

      ORDER BY c DESC

    ) t WHERE c >= lower && c <= upper;

  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;



  OPEN curs1;



  character_loop: LOOP

    IF done THEN

      LEAVE character_loop;

    END IF;



    Fetch curs1 INTO CharID, NumWipe;

    IF leave_amount < NumWipe THEN

      PREPARE STMT FROM

        "DELETE FROM `inventoryitems` WHERE characterid = ? && itemid = ? LIMIT ?";

      SET @CharID = CharID;

      SET @iid = iid;

      SET @NumWipe = NumWipe - leave_amount;

      EXECUTE STMT USING @CharID, @iid, @NumWipe;

    END IF;

  END LOOP;



  CLOSE curs1;

END
;;
DELIMITER ;
