package handling;

import constants.ServerConfig;
import tools.EncodingDetect;
import tools.FileoutputUtil;
import tools.StringUtil;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public enum SendPacketOpcode implements WritableIntValueHolder {

    //================================
    // CLogin::OnPacket 開始(185-完成)
    //================================ 
    // 密碼驗證
    LOGIN_STATUS(0x00),
    // 伺服器選單
    SERVERLIST(0x03),
    // CLogin::OnLatestConnectedWorld
    ENABLE_RECOMMENDED(0x15),
    // CLogin::OnRecommendWorldMessage
    SEND_RECOMMENDED(0x16),
    
    // 0x04 [Long] * 8

    // 選擇伺服器 [Int(伺服器編號)]
    CHANNEL_SELECTED(),
    // 角色選單
    CHARLIST(0x04),
    // 伺服器IP
    SERVER_IP(0x05),
    // 帳號信息
    ACCOUNT_INFO(0x01),
    
    // 0x09 [Byte]

    // 檢查角色名稱
    CHAR_NAME_RESPONSE(0x06),
    // 建立角色
    ADD_NEW_CHAR_ENTRY(0x07),
    // 刪除角色
    DELETE_CHAR_RESPONSE(0x08),
    
    // 0x0D 【刪除新星世界角色】[Int][Boolean] false => [Long][Long]
    // 0x0E 【登入新星世界伺服器(未確認)】[Int][Byte]
    // 0x0A 【變更角色名稱】[Int][String][Short]
    // 0x10 [Int]

    // 變更頻道
    CHANGE_CHANNEL(0x0B),
    // Ping
    PING(0x0C),
    // 購物商城
    CS_USE(0x0D),
    
    // 0x15 
    // 0x16
    // 0x17
    // 0x18
    // 0x19
    
    // 建立角色驗證回覆
    CREATE_CHAR_AUTH_RESPONSE(),
    
    // 0x1C
    // 0x1D
    // 0x1E

    // 打工系統
    PART_TIME(),
    
    // 0x20 [-]
    // 0x21 [-]
    // 0x22 [Int][Int]
    // 0x23 【購買道具】[Int][Int][Int][Byte][Byte][Byte]

    // 選擇性別 + 設置第二組密碼
    CHOOSE_GENDER(),
    // 選擇性別 + 設置第二組密碼回覆
    GENDER_SET(),
    // 外掛偵測
    HACKSHIELD_REQUEST(),
    // 強制變更角色名稱 [-]
    FORCED_CHANGE_CHAR_NAME(),
    // 強制變更角色名稱訊息 [Byte]
    FORCED_CHANGE_CHAR_NAME_NOTICE(),
    // 伺服器狀態
    SERVERSTATUS(),
    // 測試
    TEST(),
    // 背景驗證
    LOGIN_AUTH(0x1B),
    
    // 0x2B
    // 0x2C
    // 0x2D [Byte][Byte][Int]
    // 0x2E 【新星世界按鈕 + 刪除角色按鈕】[Int]

    // 顯示視窗
    MAPLESTORY_AUTH(),
    // 變更名稱申請成功
    NAME_CHANGE_SUCCESS(),
    // 第二組密碼錯誤
    SECONDPW_ERROR(),
    
    // 0x37
    // 0x38
    // 0x39
    // 0x3A
    // 0x3B
    // 0x3C
    // 0x3D
    // 0x3E
    // 0x3F
    // 0x40

    //================================
    // CWvsContext::OnPacket 開始(186-完成)
    //================================    
    // 道具操作[完成]
    INVENTORY_OPERATION(0x1E),
    // 擴充道具欄位[完成]
    INVENTORY_GROW(0x1F),
    // 更新能力值[完成]
    UPDATE_STATS(0x20),
    // 獲得輔助效果[完成]
    GIVE_BUFF(0x21),
    // 取消輔助效果[完成]
    CANCEL_BUFF(0x22),
    // 臨時能力值開始[完成]
    TEMP_STATS(0x23),
    // 重置臨時能力值[完成]
    TEMP_STATS_RESET(0x24),
    // 更新技能[完成]
    UPDATE_SKILLS(0x25),
    // 幻影俠盜複製技能成功
    UPDATE_STOLEN_SKILLS(0x26),
    // 幻影俠盜竊取技能時顯示 
    TARGET_SKILL(0x27),

    // 0x28

    // 偷竊技能檢查(Done)
    STEEL_SKILL_CHECK(0x29),
    // 惡魔追蹤發送
    CONVEY_TO(0x2A),
    // 名聲回覆[完成]
    FAME_RESPONSE(0x2B),
    // 顯示角色狀態信息[完成]
    SHOW_STATUS_INFO(0x2C),
    // 訊息[完成]
    SHOW_NOTES(0x2D),
    // 瞬移之石[完成]
    TROCK_LOCATIONS(0x2E),
    // 測謊機[完成]
    LIE_DETECTOR(0x2F),

    // 0x30

    // 炸彈測謊機[完成]
    BOMB_LIE_DETECTOR(0x31),
    // 設置舉報[完成]
    REPORT_RESPONSE(0x32),
    // 舉報時間[完成]
    REPORT_TIME(0x33),
    // 舉報狀態[完成]
    REPORT_STATUS(0x34),
    // 更新騎寵[完成]
    UPDATE_MOUNT(0x35),
    // 任務完成[完成]
    SHOW_QUEST_COMPLETION(0x36),
    // 精靈商人[完成]
    SEND_TITLE_BOX(0x37),
    // 使用技能書[完成]
    USE_SKILL_BOOK(0x38),
    // 重置SP[完成]
    SP_RESET(0x39),
    // 重置AP[完成]
    AP_RESET(0x3A),
    // 經驗瓶[完成]
    EXP_POTION(0x3B),
    // 散佈道具[完成] [Byte][Int][Byte]
    DISTRIBUTE_ITEM(0x3C),
    // 擴充角色欄位[完成]
    EXPAND_CHARACTER_SLOTS(0x3D),
    // 申請變更角色名稱[完成]
    APPLY_NAME_CHANGE(0x3E),
    // 向上整理[完成]
    FINISH_SORT(0x3F),
    // 種類排序[完成]
    FINISH_GATHER(0x40),

    // 0x41 (null)
    // 0x42 (null)
    // 0x43
    // 0x44

    // 角色信息[完成]
    CHAR_INFO(0x45),
    
    // 0x46

    // 隊伍操作[完成]
    PARTY_OPERATION(0x47),
    // 尋找隊員
    MEMBER_SEARCH(0x48),
    // 隊伍搜尋
    PARTY_SEARCH(0x49),

    // 0x4A
    // 0x4B
    // 0x4C

    // 遠征隊操作
    EXPEDITION_OPERATION(0x4D),
    // 好友列表[完成]
    BUDDYLIST(0x4E),
    // 請求回覆[完成]
    GUILD_REQUEST(0x4F),
    // 公會操作[完成]
    GUILD_OPERATION(0x50),
    // 公會聯盟操作[完成]
    ALLIANCE_OPERATION(0x51),
    // 時空門[完成]
    SPAWN_PORTAL(0x52),
    // 開放通道[完成]
    MECH_PORTAL(0x53),
    // 伺服器訊息[完成]
    SERVERMESSAGE(0x54),
    // 阿斯旺海防戰訊息[完成]
    AZWAN_MSG(0x55),
    // 花生機獎勵[完成]
    PIGMI_REWARD(0x56),
    // 獲得道具[完成]
    ITEM_OBTAIN(0x57),
    // 智慧貓頭鷹[完成]
    OWL_OF_MINERVA(0x58),
    // 智慧貓頭鷹回覆
    OWL_RESULT(0x59),
    // 戒指操作請求[完成]
    ENGAGE_REQUEST(0x5A),
    // 戒指操作返回[完成]
    ENGAGE_RESULT(0x5B),
    // 結婚禮物[完成]
    WEDDING_GIFT(0x5C),
    // 結婚地圖變更[完成] [Int][Int]
    WEDDING_MAP_TRANSFER(0x5D),
    // 使用寵物飼料[完成]
    USE_CASH_PET_FOOD(0x5E),
    // 使用寵物技能[完成]
    USE_CASH_PET_SKILL(0x5F),

    // 0x61 [-]

    // 神秘的鐵砧[完成]
    FUSION_ANVIL(),
    
    // 0x5C [Byte][Long]
    // 0x61 屬性之石
    // 0x64 小鋼珠
    // 餽贈認證
    MAPLE_FEED_AUTHEN(0x65),
    // 速配指數
    QUICK_PAIR_RESULT(0x66),
    UPDATE_CODEX(0x67),
    CARD_DROPS(0x67),
    FAMILIAR_INFO(0x68),

    // 黃色公告[完成]
    YELLOW_CHAT(),
    // 商店優惠[完成]
    SHOP_DISCOUNT(),
    // 捕捉怪物[完成]
    CATCH_MOB(0x74),
    // 玩家Npc[完成]
    PLAYER_NPC(0x75),

    // 0x76

    // 隱藏Npc[完成]
    DISABLE_NPC(0x77),
    // 獲得卡片[完成]
    GET_CARD(0x78),
    // 卡片設置[完成] [Int]
    CARD_SET(0x79),
    BOOK_STATS(0x7A),

    // 情景喇叭
    AVATAR_MEGA(0x7C),

    // 0x7d

    // 變更小時[完成]
    CHANGE_HOUR(0x7E),
    // 重置小地圖[完成]
    RESET_MINIMAP(0x7F),
    // 教師更新[完成]
    CONSULT_UPDATE(0x80),
    // 班級更新[完成]
    CLASS_UPDATE(0x81),
    // 網頁瀏覽更新[完成]
    WEB_BOARD_UPDATE(0x82),
    // 擊殺數量[完成]
    SESSION_VALUE(0x83),
    // 組隊數值[完成]
    PARTY_VALUE(0x84),
    // 地圖數值[完成]
    MAP_VALUE(0x85),

    // 0x86 [String][String]

    // 精靈墜飾[完成]
    EXP_BONUS(0x87),
    // 家族系統[已關閉][完成]
    SEND_PEDIGREE(0x88),
    OPEN_FAMILY(0x89),
    FAMILY_MESSAGE(0x8A),
    FAMILY_INVITE(0x8B),
    FAMILY_JUNIOR(0x8C),
    SENIOR_MESSAGE(0x8D),
    FAMILY(0x8E),
    REP_INCREASE(0x8F),
    FAMILY_LOGGEDIN(0x90),
    FAMILY_BUFF(0x91),
    FAMILY_USE_REQUEST(0x92),
    // (公會成員)升級訊息[完成]
    LEVEL_UPDATE(0x93),
    // 结婚訊息[完成]
    MARRIAGE_UPDATE(0x94),
    // 轉職訊息[完成]
    JOB_UPDATE(0x95),
    // 項鍊擴充[完成]
    SLOT_UPDATE(0x96),
    // 請求跟隨提示[完成]
    FOLLOW_REQUEST(0x97),
    // 新頂部訊息[完成]
    TOP_MSG2(0x98),
    // 頂部訊息[完成]
    TOP_MSG(0x99),
    // 新頂部訊息[完成]
    NEW_TOP_MSG(0x9A),
    // 中間訊息[完成]
    MID_MSG(0x9B),
    // 清理中間的訊息[完成]
    CLEAR_MID_MSG(0x9C),
    // 特殊訊息[完成]
    SPECIAL_MSG(0x9D),
    // 182新增的訊息[完成]
    MAPLE182_ADD_MSG(),
    // 楓之谷提示訊息[完成]
    MAPLE_TIP_MSG(0x9E),
    // 楓之谷管理員訊息[完成]
    MAPLE_ADMIN_MSG(0x9F),
    // 檢查道具欄位[完成]
    INVENTORY_FULL(0xA0),

    // 0xA1

    // 更新美洲豹[完成]
    UPDATE_JAGUAR(0xA2),
    // 神之子能力值
    ZERO_STATS(0xA3),
    // 神之子更新
    ZERO_UPDATE(0xA4),

    // 0xA5

    // 終極冒險家[完成]
    ULTIMATE_EXPLORER(0xA6),

    // 0xA7

    // 能力值信息[完成][hyper]
    SPECIAL_STAT(0xA8),
    // 更新培養皿時間[完成]
    UPDATE_IMP_TIME(0xA9),
    // 使用培養皿[完成]
    ITEM_POT(0xAA),

    // 0xAB
    // 0xAC

    // 武陵道場訊息
    MULUNG_MESSAGE(0xAD),
    // 傳授角色技能
    GIVE_CHARACTER_SKILL(0xAE),

    // 0xAF
    // 0xB0
    // 0xB1
    // 0xB2

    // 武陵排行[完成] // 要重抓
    MULUNG_DOJO_RANKING(0xB3),

    // 0xB4
    // 0xB5

    // 更新潛在能力值
    UPDATE_INNER_ABILITY(0xB6),

    // 0xB7

    // 使用/刪除技能[完成]
    REPLACE_SKILLS(0xB8),
    // 內在能力值訊息[完成]
    INNER_ABILITY_MSG(0xB9),
    // 地圖指引[完成] [Int]
    MINIMAP_ARROW(0xBA),

    // 0xBB

    // 角色潛在能力設定[完成]
    ENABLE_INNER_ABILITY(0xBB),
    // 角色潛在能力重置
    DISABLE_INNER_ABILITY(0xBC),
    // 獲得名聲值[完成]
    UPDATE_HONOUR(0xBD),
    // 阿斯旺未知[未知]
    AZWAN_UNKNOWN(0xBE),
    // 阿斯旺結果[完成] [Int][Int][Int][Int][Int][Int][Int][Int][Boolean]
    AZWAN_RESULT(0xBF),
    // 阿斯旺擊殺[完成]
    AZWAN_KILLED(0xC0),

    // 0xC1 【point】
    // 0xC2 阿斯旺復活[String(玩家名稱)][Int](復活時間)

    // 能力傳播者
    CIRCULATOR_ON_LEVEL(),
    // 十字獵人訊息
    SILENT_CRUSADE_MSG(),
    // 十字獵人商店
    SILENT_CRUSADE_SHOP(),
    
    // 0xE3 幸運怪物【UI/UIWindow2.img/mapleMuseum】【UI/UIWindow2.img/mapleMuseum2)(UI/UIWindow2.img/luckyMonstery】
    // 0xE4
    // 0xE5 幸運怪物【UI/UIWindow2.img/mapleMuseum】【UI/UIWindow2.img/mapleMuseum2)(UI/UIWindow2.img/luckyMonstery】
    // 0xE6 【state】
    // 0xE8 【state】
    // 0xE9
    
    // 自動飛行 [Int]
    AUTO_FLYING(),
    // 禁止完成任務
    DISALLOW_DELIVERY_QUEST(),
    // 0xEB 【彈跳視窗】
    // 0xEC 【賓果活動?】 [Byte] 【deck】【bingo】
    // 0xED 【賓果活動?】 [Byte] 【deck】【bingo】
    // 0xEE
    // 0xEF 【獲取物品?】【---】

    // 楓葉點數(完成)
    MAPLE_POINT(0xD2),
    // 0xD3 [Long]
    // 0xD4 【方塊洗洗樂?】
    // 0xD5 【重置神聖SP】 [Byte][Int][Byte]
    // 0xD6 【Debug信息?】 [Short](年)[Short](月)[Short](日)[Short](點)[Short](分)[Int]((DWORD)%u, (LONG)%d)【(DWORD)%u, (LONG)%d】
    // 0xD7 【Debug信息?】 [Int][Long]
    // 0xD8
    // 0xD9
    // 0xDA
    // 0xDB 這個道具不能在再設定潛在能力
    // 0xDC 這個道具不能再設定潛在能力
    // 0xDD

    //
    DRESSUP_INFO(0xDE),
    // 解鎖充電技能
    UNLOCK_CHARGE_SKILL(0xDF),
    // 上鎖充電技能
    LOCK_CHARGE_SKILL(0xE0),
    // 自動登入
    AUTO_LOGIN(0xE1),
    
    // 0xE2 【寵物名牌戒指?】【[BP:%02d] %d】【///////////////////////////////】

    // 進化系統
    EVOLVING_ACTION(0xE3),
    // BossPvP技能【Recv => 0x16D】
    BOSSPVP_SKILL_UI(0xE4),
    // CANDY RANKING
    CANDY_RANKING(0xE7),
    // 公會搜索
    GUILD_SEARCH(),
    // 請求進程列表
    SYSTEM_PROCESS_LIST(),
    // 情景喇叭訊息
    AVATAR_MEGA_RESULT(),
    // 移除情景喇叭
    AVATAR_MEGA_REMOVE(),
    // 活動清單
    EVENT_LIST(),
    // 楓之谷聊天室
    MESSENGER_OPEN(),
    // 王冠活動
    EVENT_CROWN(),
    // 自由轉職
    FREE_CHANGE_JOB(0xF8),

    // 0xF9 TIME_EVENT

    // 開啟墜飾欄(175+)
    UPDATE_PENDANT_SLOT(),
    // 魔王競技場配對成功
    BOSSPVP_FOUND(),
    // 魔王競技場配對失敗
    BOSSPVP_FAIL(),
    // 參加魔王競技場配對
    BOSSPVP_SEARCH(),
    // 菁英王訊息
    ELITE_BOSS_NOTICE(),
    //隨機傳送點出現在[地圖]快去看看吧 【00 00 00 00 00 00 00 00 00】
    RANDOM_PORTAL_NOTICE(),
    // 咒文的痕跡
    EQUIPMENT_ENCHANT(),
    // The Seed 排行
    TOWER_OF_OZ_RANKING(),
    // The Seed 好友排行
    TOWER_OF_OZ_FRIEND_RANKING(),
    // The Seed 獎勵 [Int](樓層)[Int](時間)[Int](The Seed點數)[Int](獲得經驗值)[Int][Int]
    TOWER_OF_OZ_REWARD(),
    // 離開遊戲
    EXIT_GAME(),
    
    // 0x14A BACK_TO_CHARLIST
    
    // 火步行[未知]
    FIRE_STEP(),

    // 0x14C
    // 0x14D
    // 0x14E 【臉部情緒?】【Unlock request Failed】
    // 0x14F  UPDATE_CORE_AURA【Recv => [Byte][Int][String][Byte]】
    // 0x150 【Item/Cash/0501.img/%08d/effect】
    // 0x151
    // 0x152
    // 0x153
    // 0x154
    // 0x155
    // 0x156 【彈跳視窗】
    
    // 申請變更角色名稱
    NAME_CHANGE(),
    // 雪橇活動【UI/Sboating.img/Basic/backgrnd】
    SELECT_SLEIGH(),
    // 潘姆音樂
    PAM_SONG(0xD0),

    // 0x15C
    // 0x15D
    // 0x15E
    
    // 贈送小鋼珠
    GIFTS_BALL(),
    // 九龍珠
    DRAGON_BALL(),
    // 開啟寶箱
    TREASURE_BOX(), //[Int] [0:金、1:銀、5:神秘開罐器、6:幻想開罐器]

    // 0x162
    // 0x163 【釣魚系統】
    // 0x164
    // 0x165 【周圍沒有攻擊的怪物。】、【無法連續使用.】

    // 管理員警告[完成] [GMKiKi][HACK]
    GM_POLICE(),    
    // 新年賀卡[完成]
    NEW_YEAR_CARD(),
    // 隨機變身藥水[完成]
    RANDOM_MORPH(),
    // 個性文字[完成](5480000)
    DISPOSITION_TEXT(),
    // 經驗值椅子[完成]
    CHAIR_EXP_MSG(),

    // 0x16B    
    // 0x16C

    // 變更頻道 + 訊息[完成]
    AUTO_CC_MSG(),

    // 0x16E
    // 0x16F
    // 0x170
    // 0x171 [Int][Int]
    // 0x172
    // 0x173
    // 0x174

    // 獲得獎勵[完成]
    REWARD(),

    // 0x176
    // 0x177

    // 閃炫方塊回覆
    SHIMMER_CUBE_RESPONSE(),
    
    // 0x179
    // 0x101 【任務抵達】
    // 0x17C 【購物商城 => [B0 1A 25 00 00 00 00 00 00 80 59 DA 6B 2E CE 01 80 29 A5 02 EC 33 CE 01 18 00 00 00 98 A3 98 00 99 A3 98 00 9A A3 98 00 9B A3 98 00 24 52 A6 00 25 52 A6 00 76 6F 40 01 77 6F 40 01 78 6F 40 01 79 6F 40 01 20 4A CB 01 22 4A CB 01 2E 4A CB 01 2F 4A CB 01 30 4A CB 01 4E 4A CB 01 4F 4A CB 01 50 4A CB 01 55 4A CB 01 6C 4A CB 01 6D 4A CB 01 6E 4A CB 01 6F 4A CB 01 70 4A CB 01]
    // 0x17D 【[BlackListLoadDone] [BlackSize:%d] [sTargetIGNs:%s]】
    // 0x17E 【神奇剪刀】
    // 0x17F
    // 0x180 【組隊任務?】
    // 0x181 
    // 0x182 【輸入觀戰板內容】【Recv => 0x95】

    // 咒文的痕跡(FOREVER_TIME)
    FEVER_TIME(),

    // 0x1A1
    // 0x1A2
    // 0x1A3
    // 0x1A4
    // 0x1AE
    // 0x1AF
    // 0x1B0
    // 0x1B1
    // 0x1B2 您因不當言行 而遭到遊戲管理員禁止發言
    // 0x1BA
    // 0x1BB
    // 0x1BC
    // 0x1BD
    
    // 技能組合[完成]
    SKILL_MACRO(0x13A),

    //================================
    // CStage::OnPacket 開始(186-完成)
    //================================ 

    // 地圖傳送[完成]
    WARP_TO_MAP(0x13B),
    // 農場[關閉]
    FARM_OPEN(),
    // 拍賣系統[完成]
    MTS_OPEN(0x13C),
    // 購物商城[完成]
    CS_OPEN(0x13D),
    // 購物商城信息[完成]
    CS_INFO(),
    CASH_SHOP(),
    //================================
    // CField::OnPacket 開始(186-完成)
    //================================ 

    //================================
    // CMapLoadable::OnPacket 開始(186-完成)
    //================================ 

    // 移除背景層
    REMOVE_BG_LAYER(0x13E),
    // 變更背景
    CHANGE_BACKGROUND(0x13F),
    // 設置物件狀態
    SET_MAP_OBJECT_VISIBLE(0x140),
    
    // 0x141

    // 重置畫面
    RESET_SCREEN(0x142),

    // 地圖阻擋[完成]
    MAP_BLOCKED(0x143),
    // 伺服器阻擋[完成]
    SERVER_BLOCKED(0x144),
    // 隊伍阻擋[完成]
    PARTY_BLOCKED(0x145),
    // 裝備效果[完成]
    SHOW_EQUIP_EFFECT(0x146),
    // 組隊公會聊天
    MULTICHAT(0x147),
    // 世界聊天模式1[完成]
    WORLD_MULTICHAT(0x148),
    // 悄悄話
    WHISPER(0x149),
    // 夫妻聊天
    SPOUSE_CHAT(0x14A),
    // Boss血條[完成]
    BOSS_ENV(0x14B),
    
    MOVE_ENV(0x14C),
    UPDATE_ENV(0x14D),
    // 0x14E

    // 地圖效果[完成]
    MAP_EFFECT(0x14F),
    // 祝賀音樂(5100000)[完成]
    CASH_SONG(0x150),
    // GM效果[完成]
    GM_EFFECT(),
    // GM日誌[完成]
    GM_LOG(0x151),
    // 選邊站[完成]
    OX_QUIZ(0x152),
    // GM活動說明[完成]
    GMEVENT_INSTRUCTIONS(0x153),
    // 計時器[完成]
    CLOCK(0x154),
    //================================
    // CField_ContiMove::OnPacket 開始(186-完成)
    //================================ 

    // 船隻移動[完成]
    BOAT_MOVE(0x155),
    // 船隻狀態[完成]
    BOAT_STATE(0x156),
    //================================
    // CField_ContiMove::OnPacket 結束
    //================================ 

    // 0x157
    // 0x158
    // 0x159

    // 停止計時[完成]
    STOP_CLOCK(0x15A),
    //================================
    //CField_AriantArena::OnPacket（CField_AriantArena::OnShowResult） 開始(186-完成)
    //================================ 
    // 納希競技大會分數[完成]
    ARIANT_SCOREBOARD(0x15B),
    //================================
    // CField_AriantArena::OnPacket（CField_AriantArena::OnShowResult） 結束
    //================================ 
    // 金字塔更新[完成]
    PYRAMID_UPDATE(0x15C),
    //================================
    // CField_KillCount::OnPacket 開始(186-完成)
    //================================ 
    // 金字塔擊殺數量[完成]
    PYRAMID_KILL_COUNT(0x15D),
    //================================
    // CField_KillCount::OnPacket 結束
    //================================ 
    // 金字塔分數[完成]
    PYRAMID_RESULT(0x15E),
    // 快速按鍵[完成]
    QUICK_SLOT(0x15F),
    // 移動平臺[完成]
    MOVE_PLATFORM(0x160),

    // 0x161
    // 0x162
    SMART_MOB_NOTICE(0x163),
    // 0x164
    // 0x165
    // 0x166

    // PvP信息[完成]
    PVP_INFO(0x167),
    // 角色站立方向狀態[完成]
    DIRECTION_STATUS(0x168),
    // 惡魔之力[完成]
    GAIN_FORCE(0x169),
    // 組隊任務達成率[完成]
    ACHIEVEMENT_RATIO(0x16A),
    // 快速移動[完成]
    QUICK_MOVE(0x16B),
    
    CHANGE_ASWAN_SIEGE_WEAPON_GAUGE(0x16C),

    // 招喚障礙物[完成]
    SPAWN_OBTACLE(0x16D),
    // 清理
    CLEAR_OBTACLE(0x16E),
    Box2D_FOOTHOLD_CREATE(0x16F),
    // 0x170
    // 0x171
    DEBUFF_OBJ_ON(0x172), // Effect/DebuffObjEff.img/%s/start
    FIELD_CREATE_FALLING_CATCHER(0x173),
    // 0x174
    // 0x175
    // 0x176
    // 0x177
    // 0x178
    // 0x179
    // 0x17A
    // 0x17B
    // 0x1A9

    //================================
    // CUserPool::OnPacket 開始(186-完成)
    //================================ 

    // 召喚玩家[完成]
    SPAWN_PLAYER(0x17C),
    // 移除玩家[完成]
    REMOVE_PLAYER_FROM_MAP(0x17D),
    //================================
    // CUserPool::OnUserCommonPacket 開始(186-完成)
    //================================ 

    // 普通聊天[完成]
    CHATTEXT(0x17E),
    // CWKPQ
    CHATTEXT_1(0x17F),

    // 黑板[完成]
    CHALKBOARD(0x180),

    // 0x181

    // 更新玩家[完成]
    UPDATE_CHAR_BOX(0x182),

    // 0x183

    // 消費效果[未知]
    SHOW_CONSUME_EFFECT(),
    // 使用卷軸效果[完成]
    SHOW_SCROLL_EFFECT(0x184),

    // 0x185
  
    // 咒文的痕跡[完成]
    SHOW_ENCHANTER_EFFECT(0x186),
    // 使用魂之珠[完成]
    SHOW_SOULSCROLL_EFFECT(0x187),
    // 放大鏡效果[完成]
    SHOW_MAGNIFYING_EFFECT(0x188),

    // 0x189
    // 0x18A 暗號解謎成功
    // 0x18B 印章使用成功
    // 0x18C
    // 0x18D familar的潛在能力開放了
    // 0x18E
    // 0x18F

    // 重新設置潛能效果
    SHOW_POTENTIAL_RESET(0x18D),
    // 重新設置附加潛能效果
    SHOW_BONUS_POTENTIAL_RESET(0x18E),
    // 擴充潛能欄位
    SHOW_POTENTIAL_EXPANSION(0x18F),
    // 顯示煙花效果
    SHOW_FIREWORKS_EFFECT(), // ?
    // 顯示星岩效果
    SHOW_NEBULITE_EFFECT(),
    // 顯示合成效果
    SHOW_FUSION_EFFECT(),

    // 0x193
 
    // PvP攻擊
    PVP_ATTACK(0x194),
    // PvP煙霧[完成] find:[ invenom ]
    PVP_MIST(0x195),

    // 0x196

    // PvP冷卻時間
    PVP_COOL(0x197),
    // 磁場技能
    TESLA_TRIANGLE(0x198),
    
    // 0x199

    // 跟隨效果
    FOLLOW_EFFECT(0x19A),
    // 顯示組隊任務獎勵[完成]
    SHOW_PQ_REWARD(0x19B),
    // 工藝效果
    CRAFT_EFFECT(0x19C),
    // 工藝完成
    CRAFT_COMPLETE(0x19D),
    // 採集結束特效
    HARVESTED_EFFECT(0x19E),
    // 採集結束
    HARVESTED(0x19F),
    //
    PLAYER_EXPLODE(0x1A0),
    // 玩家傷害
    PLAYER_DAMAGED(0x1A1),
    // 奈特的金字塔
    NETT_PYRAMID(0x1A2),
    // 設定特效
    MIXER_RESULT(0x1A3),
    //
    WAIT_QUERE_RESPONSE(0x1A4),
    // 
    CATEGORY_EVENT_NAMETAG(0x1A5),

    // 攻擊Skin[完成]
    SHOW_DAMAGE_SKIN(0x1A6),
    // 0x1A7
    // 0x1A8
    // 0x1A9
    // 0x1AA
    // 0x1AB

    // 潘姆音樂
    PAMS_SONG(0x1AC),

    性向稱號獲得(0x1AD),

    // 裝備特效開關
    EFFECT_SWITCH(),

    // 0x1B4 釣魚

    //================================
    // CUserPool::OnUserPetPacket 開始(186-完成)
    //================================ 

    // 召喚寵物[完成]
    SPAWN_PET(0x1B5),
    
    // 0x1B6 null?

    // 顯示寵物[完成]
    SHOW_PET(0x1B7),
    // 寵物移動[完成]
    MOVE_PET(0x1B8),
    // 寵物說話[完成]
    PET_CHAT(0x1B9),
    // 變更寵物名稱
    PET_NAMECHANGE(0x1BA),
    // 寵物例外清單[完成]
    PET_EXCEPTION_LIST(0x1BB),
    // 寵物顏色[完成]
    PET_COLOR(0x1BC),
    // 寵物大小[完成]
    PET_SIZE(0x1BD),
    // 寵物指令[完成]
    PET_COMMAND(0x1BE),
    //================================
    // CUserPool::OnUserDragonPacket 開始(186-完成)
    //================================ 

    // 召喚寶貝龍[完成] 
    DRAGON_SPAWN(0x1BF),
    // 寶貝龍移動[完成]
    DRAGON_MOVE(0x1C0),
    // 移除寶貝龍[完成]
    DRAGON_REMOVE(0x1C1),
    
    //================================
    // CUserPool::OnUserAndroidPacket 開始(186-完成)
    //================================ 

    // 召喚機器人[完成]
    ANDROID_SPAWN(0x1C2),
    // 機器人移動[完成]
    ANDROID_MOVE(0x1C3),
    // 機器人情緒[完成]
    ANDROID_EMOTION(0x1C4),
    // 更新機器人外觀[完成]
    ANDROID_UPDATE(0x1C5),
    // 移除機器人[完成]
    ANDROID_DEACTIVATED(0x1C6),

    //================================
    // CUserPool::OnUserHakuPacket1 開始(186-完成)
    //================================ 

    // 變更花弧
    HAKU_CHANGE_1(0x1C7),
    
    // 0x1C8

    // 花狐使用技能後發的(Done)
    HAKU_USE_BUFF(0x1C9),
    // 變更花弧
    HAKU_CHANGE_0(0x1CA),
    
    // 0x1CB

    // 花弧未知
    HAKU_UNK(0x1CC),

    //================================
    // CUserPool::OnFamilarPacket 開始(186-完成)
    //================================ 

    SPAWN_FAMILIAR(0x1CD),
    MOVE_FAMILIAR(0x1CE),
    TOUCH_FAMILIAR(0x1CF),
    ATTACK_FAMILIAR(0x1D0),
    RENAME_FAMILIAR(0x1D1),
    SPAWN_FAMILIAR_2(0x1D2),
    UPDATE_FAMILIAR(0x1D3),

    //================================
    // CUserPool::OnUserHakuPacket2 開始(186-完成)
    //================================ 

    // 0x1D4

    //花狐移動
    HAKU_MOVE(0x1D5),
    //花狐更新
    HAKU_UPDATE(0x1D6),
    //變更花狐
    HAKU_CHANGE(0x1D7),
    
    // 0x1D8[null]
    // 0x1D9[null]

    //召喚花狐[完成]
    SPAWN_HAKU(0x1DA),
    
    // 0x1DB
    // 0x1DC

    //================================
    // CUserPool::OnUserRemotePacket 開始(186-完成)
    //================================ 

    // 玩家移動[完成]
    MOVE_PLAYER(0x1DD),
    
    // 0x1DE [null]

    // 近距離攻擊[完成]
    CLOSE_RANGE_ATTACK(0x1DF),
    // 遠距離攻擊[完成]
    RANGED_ATTACK(0x1E0),
    // 魔法攻擊[完成]
    MAGIC_ATTACK(0x1E1),
    // 被動攻擊[完成]
    PASSIVE_ATTACK(0x1E2),
    //技能效果[完成][用主教的创世之破抓到包]
    SKILL_EFFECT(0x1E3),
    //移動攻擊[完成][33121214 - 狂野機關砲]
    MOVE_ATTACK(0x1E4),
    //取消技能效果[完成]
    CANCEL_SKILL_EFFECT(0x1E5),
    //玩家受到傷害[完成]
    DAMAGE_PLAYER(0x1E6),
    //玩家面部表情[完成]
    FACIAL_EXPRESSION(0x1E7),
    
    // 0x1E8

    //顯示物品效果
    SHOW_EFFECT(0x1E9),

    // 0x1EA

    //顯示頭上稱號
    SHOW_TITLE(0x1EB),
    //天使破壞者變更
    ANGELIC_CHANGE(0x1EC),

    // 0x1EC
    // 0x1ED
    // 0x1EE

    //顯示椅子效果[完成]
    SHOW_CHAIR(0x1EF),
    //更新玩家外觀[完成]
    UPDATE_CHAR_LOOK(0x1F0),
    //玩家外觀效果[完成]
    SHOW_FOREIGN_EFFECT(0x1F1),

    // 0x1F2

    //獲得異常狀態[完成]
    GIVE_FOREIGN_BUFF(0x1F3),
    //取消異常狀態
    CANCEL_FOREIGN_BUFF(0x1F4),
    //更新隊員血量
    UPDATE_PARTYMEMBER_HP(0x1F5),
    //讀取公會名稱[完成]
    LOAD_GUILD_NAME(0x1F6),
    //讀取公會標誌[完成]
    LOAD_GUILD_ICON(0x1F7),
    //讀取隊伍(Done)
    LOAD_TEAM(0x1F8),
    //採集
    SHOW_HARVEST(0x1F9),
    //PvP血量
    PVP_HP(0x1FA),

    // 0x1FB
    // 0x1FC
    // 0x1FD
    KAISER_COLOR_CHANGE(0x1FE),
    // 0x1FE
    // 0x1FF
    // 0x200 SHOW_SPECIAL_EFFECT
    // 0x201
    // 0x202
    // 0x203
    // 0x204
    // 0x205
    // 0x206
    // 0x207
    // 0x208
    // 0x209
    // 0x20A
    // 0x20B
    // 0x20C
    //神之子狀態
    ZERO_MUITTAG(),
    SHOW_SPECIAL_ATTACK(0x20C),

    //================================
    // CUserPool::OnUserLocalPacket 開始(186-完成)
    //================================ 

    SHOW_SKILL_SKIN(0x1B1),

    // 取消椅子
    CANCEL_CHAIR(0x20D),
    // 動畫表情[完成]
    DIRECTION_FACIAL_EXPRESSION(0x20E),
    // 畫面移動
    MOVE_SCREEN(0x20F),
    // 顯示物品效果[完成]
    SHOW_SPECIAL_EFFECT(0x210),
    // 角色地圖瞬移
    CURRENT_MAP_WARP(0x211),

    // 0x212
    // 0x213
    // 0x214
    // 0x215
    // 0x216
    // 0x217

    // 使用福包成功(5200000)[完成]
    MESOBAG_SUCCESS(0x218),
    // 使用福包失敗(5200000)[完成]
    MESOBAG_FAILURE(0x219),
    // 更新任務信息
    UPDATE_QUEST_INFO(0x21A),
    // 血量減少
    HP_DECREASE(0x21B),
    // 變更寵物技能[完成]
    PET_FLAG_CHANGE(0x21C),
    // 玩家提示[完成]
    PLAYER_HINT(0x21D),
    // 播放事件音效
    PLAY_EVENT_SOUND(0x21E),
    // 播放迷你遊戲音效
    PLAY_MINIGAME_SOUND(0x21F),
    // 生產用技能
    MAKER_SKILL(0x220),

    // 0x221
    // 0x222 學園對抗戰

    // 開啟介面[完成]
    OPEN_UI(0x223),

    // 0x224

    // 開啟選項介面[完成]
    OPEN_UI_OPTION(0x225),
    // 鎖定玩家按鍵動作[完成]
    LOCK_KEY(0x226),
    // 劇情鎖定介面[完成]
    LOCK_UI(0x227),
    // 不顯示其他玩家[完成]
    DISABLE_OTHERS(0x228),
    // 召喚初心者幫手[完成]
    SUMMON_HINT(0x229),
    // 初心者幫手訊息[完成]
    SUMMON_HINT_MSG(0x22A),
    // 狂狼勇士連擊[完成]
    ARAN_COMBO(0x22B),
    // 狂狼勇士鬥氣重生[完成]
    ARAN_COMBO_RECHARGE(0x22C),

    // 0x22D 小鋼珠
    // 0x22E 小鋼珠
    // 0x22F FP 農場點數
    // 0x230 FP 農場點數
    // 0x231
    // 0x232
    // 0x233
    // 0x234 狂狼勇士技能教學

    // 公告提示[完成]
    GAME_MSG(0x235),
    // 遊戲訊息[完成]
    GAME_MESSAGE(0x236),
    
    // 0x237 [String][Int]

    //
    BUFF_ZONE_EFFECT(0x238),
    //
    DAMAGE_METER(0x239),
    // 炸彈攻擊
    TIME_BOMB_ATTACK(0x23A),
    // 跟隨移動
    FOLLOW_MOVE(0x23B),
    // 跟隨訊息
    FOLLOW_MSG(0x23C),

    //　0x23D

    // 建立終極冒險家
    CREATE_ULTIMATE(0x23E),
    // 採集訊息
    HARVEST_MESSAGE(0x23F),
    // 符文介面
    RUNE_ACTION(),
    // 礦物背包
    OPEN_BAG(0x240),
    // 龍之氣息
    DRAGON_BLINK(0x241),
    // PvP冰騎士
    PVP_ICEGAGE(0x242),
    // 位置信息[完成]
    DIRECTION_INFO(0x243),
    // 重新獲得勳章
    REISSUE_MEDAL(0x244),

    // 0x245
    // 0x246 [Int]

    // 動畫播放[完成]
    PLAY_MOVIE(0x247),
    // 蛋糕 vs 派餅 活動
    CAKE_VS_PIE_MSG(0x248),
    // 幻影俠盜卡片[完成]
    PHANTOM_CARD(0x249),
    
    // 0x24A [Int]
    // 0x24B [Int][Byte]

    // 夜光連擊
    LUMINOUS_COMBO(0x24C),

    // 0x24D

    // Aggressive排名[完成]
    AGGRESSIVE_RANKING(0x24E),
    // 剩餘死亡次數 打王用的
    DEATH_COUNT(0x24F),
    // 個人剩餘死亡次數
    DEATH_COUNT_1(0x250),
    // 變成天使破壞者 UserSetDressUpState
    CHANGE_ANGELIC(0x251),

    // 0x252 UserSeverAckMobZoneStateChange
    // 0x253 SummonEventRank
    // 0x254 SummonEventReward
    // 0x255 角色臉紅 身上發電
    // 0x256 UserFlipTheCoinEnabled
    // 0x257
    // 0x258

    // 死亡視窗
    DEATH_TIP(),
    // 時間膠囊[完成] (3010587)
    TIME_CAPSULE(),
    // 神之子衝擊波[完成] (101000102)
    ZERO_SHOCKWAVE(0x242),
    // 設定槍的名稱[完成]
    SET_GUN_NAME(0x243),
    // 設定槍彈[完成]
    SET_GUN_AMMO(0x244),
    // 建立槍[完成]
    CREATE_GUN(0x245),
    // 清除槍[完成]
    CLEAR_GUN(0x246),
    // 戰鬥回復[完成] (101110205)
    ZERO_BATTLE_HEAL(0x24A),
    // 神之子參數(Done)
    ZERO_OPTION(0x24B),
    // 翻轉硬幣(Done)
    FLIP_THE_COIN(),
    //幽靈水彩特效(Done) (skill == 80001408)
    GHOST_WATERCOLOR_EFFECT(),
    //符文特效(Done) (80001429)
    RUNE_EFFECT(),
    // Setp GiftID[完成]
    SETP_GIFT_ID(),
    // Step Coin[完成]
    SETP_COIN(0x259),
    //凱撒快速鍵[完成]
    KAISER_QUICK_KEY(0x25A),
    //閃耀方塊反饋 (CField頂端內容有/12的用xRef回找)
    FLASH_CUBE_RESPONSE(),
    // 寒冰迅移[完成]
    SPAWN_SPECIAL(0x298),
    
    // 0x299

    // 技能冷卻[完成]
    COOLDOWN(0x29A),

    // 0x29B

    //================================
    // CUser::OnSummonedPacket 開始(186-完成)
    //================================ 

    // 召喚召喚獸[完成]
    SPAWN_SUMMON(0x29C),
    // 移除召喚獸[完成]
    REMOVE_SUMMON(0x29D),
    // 召喚獸移動[完成]
    MOVE_SUMMON(0x29E),
    // 召喚獸攻擊[完成]
    SUMMON_ATTACK(0x29F),
    // PvP召喚獸
    PVP_SUMMON(0x2A0),
    // 召喚獸技能
    SUMMON_SKILL_2(0x2A1),
    // 召喚獸技能
    SUMMON_SKILL(0x2A2),
    // 召喚獸延遲
    SUMMON_DELAY(0x2A3),
    // 召喚獸受傷
    DAMAGE_SUMMON(0x2A4),

    // 0x2A5
    // 0x2A6
    // 0x2A7

    //================================
    // CMobPool::OnMobPacket 開始(186-完成)
    //================================ 

    // 怪物召喚[完成]
    SPAWN_MONSTER(0x2A8),
    // 殺除怪物[完成]
    KILL_MONSTER(0x2A9),
    // 控制召喚怪物[完成]
    SPAWN_MONSTER_CONTROL(0x2AA),

    // 0x2AB

    // 怪物移動[完成]
    MOVE_MONSTER(0x2AC),
    // 怪物移動回覆[完成]
    MOVE_MONSTER_RESPONSE(0x2AD),
    
    // 0x2AE

    // 添加怪物狀態[完成]
    APPLY_MONSTER_STATUS(0x2AF),
    // 取消怪物狀態[完成]
    CANCEL_MONSTER_STATUS(0x2B0),
    // 怪物暫停重置[完成]
    MONSTER_SUSPEND_RESET(0x2B1),
    // 影響怪物[完成]
    MONSTER_AFFECTED(0x2B2),
    // 怪物受到傷害
    DAMAGE_MONSTER(0x2B3),
    // 怪物技能特效[完成]
    SKILL_EFFECT_MOB(0x2B4),

    // 0x2B5

    // 怪物CRC[完成] 接收=> 0x156
    MONSTER_CRC_CHANGE(0x2B6),
    // 顯示怪物HP[完成]
    SHOW_MONSTER_HP(0x2B7),
    // 捕捉怪物[完成]
    CATCH_MONSTER(0x2B8),
    // 怪物物品特效[完成]
    ITEM_EFFECT_MOB(0x2B9),
    
    // 0x2BA
    // 0x2BB

    // 傳送怪物?
    TELEPORT_MONSTER(0x2BC),
    //
    MOB_SKILL_DELAY(0x2BD),
    //
    MONSTER_PROPERTIES(0x2BE),
    
    // 0x2BF

    // 怪物說話[完成]
    TALK_MONSTER(0x2C0),
    // 移除怪物說話
    REMOVE_TALK_MONSTER(),
    // 怪物技能延遲[完成]
    MONSTER_SKILL_DELAY(0x2C1),
    // 怪物護送全部路徑[完成]
    MONSTER_ESCORT_FULL_PATH(),
    // 怪物護送暫停/停止允許[完成]
    MONSTER_ESCORT_STOP_END_PERMISSION(),
    // 怪物護送暫停/停止允許[完成]
    MONSTER_ESCORT_STOP_END_PERMISSION2(),
    // 怪物護送暫停說話[完成]
    MONSTER_ESCORT_STOP_SAY(),
    // 怪物護送返回前[完成]
    MONSTER_ESCORT_RETURN_BEFORE(),
    // 怪物下個攻擊[完成]
    MONSTER_NEXT_ATTACK(0x2C2),

    // 0x2C3

    // 怪物強迫行動
    MONSTER_FORCED_ACTION(0x2C4),
    // 時間重置
    MONSTER_TIME_RESIST(0x2C5),
    //
    MONSTER_ONE_KILL_DAMAGE(0x2C6),
    //
    MOB_ATTACK_BLOCK(0x2C7),

    // 0x2C8
    // 0x2C9
    // 0x2CA
    // 0x2CB
    // 0x2CC
    // 0x2CD
    // 0X2CE

    // 怪物攻擊怪物[完成]
    MOB_TO_MOB_DAMAGE(0x2CF),
    
    // 0X2D0

    //================================
    // CMobPool::OnAzwanMobPacket 開始(186-完成)
    //================================ 
    
    // 阿斯旺怪物攻擊怪物[完成]
    AZWAN_MOB_TO_MOB_DAMAGE(0x2D1),
    // 阿斯旺怪物召喚[完成]
    AZWAN_SPAWN_MONSTER(0x2D2),
    // 阿斯旺怪物死亡[完成]
    AZWAN_KILL_MONSTER(0x2D3),
    // 阿斯旺控制召喚怪物[完成]
    AZWAN_SPAWN_MONSTER_CONTROL(0x2D4),

    //================================
    // CNpcPool::OnPacket 開始(186-完成)
    //================================ 

    // 召喚Npc[完成]
    SPAWN_NPC(0x2D5),
    // 移除Npc[完成]
    REMOVE_NPC(0x2D6),

    // 0x2D7

    // 控制召喚Npc[完成]
    SPAWN_NPC_REQUEST_CONTROLLER(0x2D8),
    // Npc動作[完成]
    NPC_ACTION(0x2D9),
    INITIAL_QUIZ(0x2DC),
    // 更新Npc狀態信息
    NPC_UPDATE_LIMITED_INFO(0x2DD),
    // 重置Npc動作
    RESET_NPC(0x2DB),
    // Npc特殊事件[完成]
    NPC_SET_SPECIAL_ACTION(0x2E1),
    // 設置Npc腳本[完成]
    NPC_SCRIPTABLE(0x2E2),

    RED_LEAF_HIGH(0x2E3),

    //================================
    // CEmployeePool::OnPacket 開始(186-完成)
    //================================ 

    // 召喚精靈商人
    SPAWN_HIRED_MERCHANT(0x2E4),
    // 移除精靈商人
    DESTROY_HIRED_MERCHANT(0x2E5),

    // 0x2E6

    // 精靈商人更新
    UPDATE_HIRED_MERCHANT(0x2E7),
    //================================
    // CDropPool::OnPacket 開始(186-完成)
    //================================ 

    // 物品掉落[完成]
    DROP_ITEM_FROM_MAPOBJECT(0x2E8),

    // 0x2E9 (null)

    // 物品消失[完成]
    REMOVE_ITEM_FROM_MAP(0x2EA),
    //================================
    // CMessageBoxPool::OnPacket 開始(186-完成)
    //================================ 

    // 召喚風箏錯誤[完成]
    SPAWN_KITE_ERROR(0x2EB),
    // 召喚風箏[完成]
    SPAWN_KITE(0x2EC),
    // 移除風箏[完成]
    DESTROY_KITE(0x2ED),
    //================================
    // CAffectedAreaPool::OnPacket 開始(186-完成)
    //================================ 

    // 召喚煙霧[完成]
    SPAWN_MIST(0x2EE),
    // 煙霧未知[完成]
    MIST_UNK(),
    // 移除煙霧[完成]
    REMOVE_MIST(0x2EF),
    //================================
    // CTownPortalPool::OnPacket 開始(186-完成)
    //================================ 

    // 時空門[完成]
    SPAWN_DOOR(0x2F0),
    // 移除時空門[完成]
    REMOVE_DOOR(0x2F1),

    //================================
    // COpenGatePool::OnPacket 開始(186-完成)
    //================================ 

    // 召喚開放通道[完成]
    MECH_DOOR_SPAWN(0x2F2),
    // 移除開放通道[完成]
    MECH_DOOR_REMOVE(0x2F3),

    //================================
    // COpenGatePool::OnPacket 結束(186-完成)
    //================================ 

    // 0x2F4
    // 0x2F5
    // 0x2F6

    //================================
    // CReactorPool::OnPacket 開始(186-完成)
    //================================ 

    // 攻擊箱子[完成]
    REACTOR_HIT(0x2F7),
    // 箱子移動[完成]
    REACTOR_MOVE(0x2F8),
    // 召喚箱子[完成]
    REACTOR_SPAWN(0x2F9),
    // 箱子未知[完成]
    REACTOR_UNK(0x2FA),
    // 箱子未知2[完成]
    REACTOR_UNK2(),
    // 箱子消失(隱藏?)[Int - oid][完成]
    REACTOR_UNK3(),
    // 重置箱子[完成]
    REACTOR_DESTROY(0x2FB),
    //================================
    // CReactorPool::OnExtractorPacket 開始(185-完成)
    //================================ 

    // 召喚分解機[完成]
    SPAWN_EXTRACTOR(0x2FC),
    // 移除分解機[完成]
    REMOVE_EXTRACTOR(0x2FD),
    //================================
    // CEventsPool::OnPacket 開始(185-完成)「CField_SnowBall::OnPacket」
    //================================ 

    //滾動雪球
    ROLL_SNOWBALL(0x2FE),
    //攻擊雪球
    HIT_SNOWBALL(0x2FF),
    //雪球訊息
    SNOWBALL_MESSAGE(0x300),
    //向左擊飛
    LEFT_KNOCK_BACK(0x301),
    //================================
    // CField_Coconut::OnPacket 開始(185-完成)
    //================================ 

    //攻擊椰子
    HIT_COCONUT(0x302),
    //椰子活動分數
    COCONUT_SCORE(0x303),
    //================================
    // CField_GuildBoss::OnPacket 開始(185-完成)
    //================================ 

    // CField_GuildBoss::OnHealerMove[完成]
    MOVE_HEALER(0x304),
    // CField_GuildBoss::OnPulleyStateChange[完成]
    PULLEY_STATE(0x305),

    //================================
    // CField_MonsterCarnival::OnPacket 開始(183-完成)
    //================================ 
    // 怪物擂台賽開始[完成]
    MONSTER_CARNIVAL_START(0x306),
    // 怪物擂台賽獲得CP[完成]
    MONSTER_CARNIVAL_OBTAINED_CP(0x307),
    // 怪物擂台賽狀態[完成]
    MONSTER_CARNIVAL_STATS(0x308),

    // 0x309 [Int] * 4

    // 怪物擂台賽召喚[完成]
    MONSTER_CARNIVAL_SUMMON(0x30A),
    // 怪物擂台賽訊息[完成]
    MONSTER_CARNIVAL_MESSAGE(0x30B),
    // 怪物擂台賽死亡[完成]
    MONSTER_CARNIVAL_DIED(0x30C),
    // 怪物擂台賽離開[完成]
    MONSTER_CARNIVAL_LEAVE(0x30D),
    // 怪物擂台賽分數[完成]
    MONSTER_CARNIVAL_RESULT(0x30E),
    // 怪物擂台賽排名[完成]
    MONSTER_CARNIVAL_RANKING(0x30F),
    //================================
    // CField_AriantArena::OnPacket 開始(183-完成)
    //================================ 

    // 更新納希競技大會分數[完成]
    ARIANT_SCORE_UPDATE(0x310),
    //================================
    // CField_AriantArena::OnPacket 結束
    //================================ 

    // 0x311

    // 開心牧場資訊
    SHEEP_RANCH_INFO(0x312),
    // 開心牧場衣服
    SHEEP_RANCH_CLOTHES(0x313),
    // 魔女之塔
    WITCH_TOWER(0x314),
    // 遠征隊挑戰[完成]
    EXPEDITION_CHALLENGE(0x315),
    // 炎魔祭壇[完成]
    ZAKUM_SHRINE(0x316),
    // 炎魔祭壇[完成]
    ZAKUM_SHRINE2(0x317),
    // PvP類型[完成]
    PVP_TYPE(0x318),
    // PvP轉移[完成]
    PVP_TRANSFORM(0x319),
    // PvP[完成]
    PVP_DETAILS(0x31A),
    // PvP開始[完成]
    PVP_ENABLED(0x31B),
    // PvP分數[完成]
    PVP_SCORE(0x31C),
    // PvP結果[完成]
    PVP_RESULT(0x31D),
    // PvP隊伍[完成]
    PVP_TEAM(0x31E),
    // PvP計分板[完成]
    PVP_SCOREBOARD(0x31F),

    // 0x320 [Int][Byte]

    // PvP點數[完成]
    PVP_POINTS(0x321),
    // PvP擊殺數[完成]
    PVP_KILLED(0x322),
    // PvP模式[完成]
    PVP_MODE(0x323),
    // PvP冰騎士[完成]
    PVP_ICEKNIGHT(0x324),
    // 召喚符文[完成-183]
    SPAWN_RUNE(),
    // 移除符文[完成-183]
    REMOVE_RUNE(),
    // 重新召喚符文[完成-183]
    RESPAWN_RUNE(),
    // 混沌炎魔祭壇[完成]
    CHAOS_ZAKUM_SHRINE(),
    // 0x511
    // 闇黑龍王祭壇[完成]【未確認】
    HORNTAIL_SHRINE(),
    // 購物商城更新楓幣
    CS_MESO_UPDATE(),
    // 0x514
    // 0x515
    // 商城搭配
    CS_COLLOCATTON(),

    // sub_67C061 { 【怪物擂台賽】
    // 0x408
    // 0x409
    // 0x40A [-]
    // 0x40B [-]
    // 0x40C
    // 0x40D
    // 0x40E
    // 0x40F
    // 0x410
    // 0x411
    // 0x412
    // }

    // sub_680FAC { 【蛋糕 Vs 派餅 活動】
    // 0x415
    // 0x416 【%s 陣營的Boss已經被召喚。】
    // 0x417 【更新Boss血條】
    // 0x418 【攻擊效果】[Byte(00:Miss、01:Cool)]
    // 0x41C
    // 0x41F
    // }

    // PvP(奪旗模式)
    CAPTURE_FLAGS(),
    CAPTURE_POSITION(),
    CAPTURE_RESET(),
    // 粉紅色炎魔祭壇[完成]
    PINK_ZAKUM_SHRINE(0x37E),
    //================================
    // CScriptMan::OnPacket 開始(186-完成)
    //================================ 

    // Npc交談[完成]
    NPC_TALK(0x37F),
    //================================
    // CShopDlg::OnPacket 開始(186-完成)
    //================================ 

    // Npc商店[完成]
    OPEN_NPC_SHOP(0x380),
    // 購買Npc商店道具[完成]
    CONFIRM_SHOP_TRANSACTION(0x381),
    //================================
    // CAdminShopDlg::OnPacket 開始(186-完成)
    //================================ 
    // 管理員商店[完成]
    ADMIN_SHOP_RESULT(0x382),
    // 管理員商店-商品[完成]
    ADMIN_SHOP_COMMODITY(0x383),

    // 0x384
    // 0x385
    // 0x386
    // 0x387
    // 0x388

    //================================
    // CField_SoulDungeon_OnPacket 開始(186-完成)
    //================================ 

    // 0x389
    // 0x38A
    // 0x38B 【靈魂陷阱】
    // 0x38C
    // 0x38D
    // 0x38E
    // 0x38F
    // 0x390 【姆勒姆勒地城地圖】、【姆勒姆勒的炸彈】
    // 0x391

    //================================
    // CField_SoulDungeon_OnPacket 結束
    //================================ 

    // 倉庫[完成]
    OPEN_STORAGE(0x392),

    Coordination_RunWay_Avata(0x393),
    CoordinationEnd(0x394),

    //================================
    // CStoreBankDlg::OnPacket 開始(186-完成)
    //================================
    // 富蘭德里訊息
    MERCH_ITEM_MSG(0x395),
    // 富蘭德里倉庫
    MERCH_ITEM_STORE(0x396),
    //================================
    // CStoreBankDlg::OnPacket 結束(186-完成)
    //================================

    // 猜拳遊戲[完成]
    RPS_GAME(0x397),

    // 0x398

    // 聊天室[完成]
    MESSENGER(0x399),
    // 玩家互動[完成]
    PLAYER_INTERACTION(0x39A),

    // 0x39B
    // 0x39C

    //================================
    // CField_Tournament::OnPacket 開始(186-完成)
    //================================

    // CField_Tournament::OnTournament[完成]
    TOURNAMENT(),
    // CField_Tournament::OnTournamentMatchTable[完成]
    TOURNAMENT_MATCH_TABLE(),
    // CField_Tournament::OnTournamentSetPrize[完成]
    TOURNAMENT_SET_PRIZE(),
    // CField_Tournament::OnTournamentUEW[完成]
    TOURNAMENT_UEW(),
    // CField_Tournament::OnTournamentAvatarInfo[完成]
    TOURNAMENT_CHARACTERS(),
    // CField_Wedding::OnWeddingProgress[完成]
    WEDDING_PROGRESS(),
    // CField_Wedding::OnWeddingCeremonyEnd[完成]
    WEDDING_CEREMONY_END(),

    // 小鋼珠 {
    // 0x39D
    // 0x39E
    // 0x39F
    // 0x3A0
    // 0x3A1
    // }

    // 宅配操作(完成)
    PACKAGE_OPERATION(0x3A2),

    // 0x3A3

    //================================
    // CCashShop::OnPacket 開始(186-完成)
    //================================

    // 0x3AB
    // 0x3AC

    // 購物商城更新[完成]
    CS_UPDATE(0x3AD),
    // 購物商城操作[完成]
    CS_OPERATION(0x3AE),
    // CCashShop::OnPurchaseExpChanged[完成]
    CS_EXP_PURCHASE(),

    // 0x5B9
    // 0x5BA 【00 00 04 00 00 00 00 00 84 11 06 00 00 00 00 00 FF 00 00】
    // 0x5BB
    // 0x5BC

    // 購物商城未知[完成]
    CASH_USE4(),
    
    // 0x5BE
    // 0x5BF
    // 0x5C0
    // 0x5C1
    // 0x5C2
    // 0x5C3
    // 0x5C4
    // 0x5C5
    // 0x5C6
    // 0x5C7

    // 購物商城帳號[完成]
    CS_ACCOUNT(),
    // 購物商城未知[完成]
    CASH_USE3(),
    // 購物商城未知[完成]
    CASH_USE(),
    
    // 0x5CB
    // 0x5CC
    // 0x5CD
    // 0x5CE
    // 0x5CF

    // 購物商城未知[完成]
    CASH_USE2(),

    //==================================
    // CFuncKeyMappedMan::OnPacket 開始(186-完成)
    //==================================

    // 鍵盤設置[完成]
    KEYMAP(0x3DD),
    // 寵物技能(HP)[完成]
    PET_AUTO_HP(0x3DE),
    // 寵物技能(MP)[完成]
    PET_AUTO_MP(0x3DF),
    // 寵物技能(Buff)[完成]
    PET_AUTO_CURE(0x3E0),

    // 0x3E1

    //================================
    // CLogin::OnPacket 開始(186-完成)
    //================================ 

    // 創建角色第二組密碼驗證[完成]【獲得驗證碼 + 第二組密碼錯誤回應 + 獲得可建立職業】
    CREATE_CHAR_RESPONSE(),
    
    // 0x619

    //==================================
    // CField::OnGoldHammerRes 開始(186-完成)
    //==================================

    // 0x3E2
    // 0x3E3
    // 0x3E4
    // 0x3E5

    // 黃金鐵鎚使用完成[完成]
    VICIOUS_HAMMER(0x3E6),

    // 0x3E7

    //==================================
    // CField::OnPlatinumHammerRes 開始(186-完成)
    //==================================

    // 0x3E8

    // 白金槌子
    PLATINUM_HAMMER(0x3E9),

    // 0x3EA 

    //==================================
    // CField::OnZeroScroll 開始(186-完成)
    //==================================

    EgoEquip_s(0x3EB),

    // 神之子使用卷軸[完成]
    ZERO_SCROLL_START(0x3EC),
    // 神之子武器介面[完成]
    ZERO_RESULT(0x3ED),
    // 神之子卷軸[完成]
    ZERO_SCROLL(0x3EE),

    EgoEquipItemUpgradeEffect(0x3EF),
    EgoEquip_e(0x3F0),

    //==================================
    // CField::OnZeroWeapon 開始(186-完成)
    //==================================

    // 武器資訊
    ZERO_WEAPONINFO(0x3F1),
    // 武器成長[完成]
    ZERO_UPGRADE(0x3F2),

    InheritanceComplete(0x3F3),
    Inheritance_e(0x3F4),

    //==================================
    // CField::OnMIRROR_READING 開始
    //==================================

    MirrorReading_s(0x3F5),
    MirrorReadingSelectBookResult(0x3F6),
    MirrorReading_e(0x3F7),

    //==================================
    // CField::OnArrowBlaster 開始(186-完成) Etc/FieldAttackObjInfo.img
    //==================================

    // 召喚箭座[完成]
    ATTACKOBJ_CREATE(0x3F8),

    ATTACKOBJ_REMOVE_BYSINGLEKEY(0x3F9),

    // 取消箭座[完成]
    ATTACKOBJ_REMOVE_BYLIST(0x3FA),

    ATTACKOBJ_REMOVE_ALL(0x3FB),

    ATTACKOBJ_S(0x3FC),

    // 箭座控制[完成]
    ATTACKOBJ_SETATTACK(0x3FD),

    ATTACKOBJ_SETOWNER(0x3FE),
    ATTACKOBJ_RESETOWNER(0x3FF), //【破除封印】
    ATTACKOBJ_PUSHACT(0x400),
    ATTACKOBJ_E(0x401),
    ATTACKOBJ_SENDALL(0x402),

    //==================================
    // CField::OnArrowBlaster 結束
    //==================================

    // sub_50630B {
    // 0x439
    // 0x63D
    // 0x63E
    // 0x63F
    // 0x640
    // }

    // 潛能方塊[完成-186]
    STRENGTHEN_UI(),

    // 0x68F
    // 0x690

    // 階段介面[完成-186]
    LEVEL_UI(),
    // sub_6921D9 {
    // 0x54B
    // 0x54C
    // }

    // sub_63AD6C {
    // 0x54D [Byte]
    // }

    // 每日免費強化任意門[完成-186]
    DAY_OF_CHRONOSPHERE(),
    // 強化任意門錯誤[完成-186]
    ERROR_CHRONOSPHERE(),
    // sub_6DF4C6 {
    // 0x6B0
    // 0x5B1
    // 0x5B2
    // 0x5B3
    // 0x5B4
    // }

    // General

    UNKNOWN,
    AUTH_RESPONSE,
    GUEST_ID_LOGIN,
    // Login

    SEND_LINK,
    PIN_OPERATION,
    PIN_ASSIGNED,
    ALL_CHARLIST,
    RELOG_RESPONSE,
    REGISTER_PIC_RESPONSE,
    EXTRA_CHAR_INFO,
    SPECIAL_CREATION,
    // Channel

    FULL_CLIENT_DOWNLOAD,
    BOOK_INFO,
    REPORT_RESULT,
    TRADE_LIMIT,
    UPDATE_GENDER,
    BBS_OPERATION,
    CODEX_INFO_RESPONSE,
    ECHO_MESSAGE,
    POTION_BONUS,
    MAPLE_TV_MSG,
    LUCKY_LUCKY_MONSTORY,
    POPUP2,
    CANCEL_NAME_CHANGE,
    CANCEL_WORLD_TRANSFER,
    CLOSE_HIRED_MERCHANT,
    CANCEL_NAME_CHANGE_2,
    GM_STORY_BOARD,
    FIND_FRIEND,
    VISITOR,
    PINKBEAN_CHOCO,
    EQUIP_STOLEN_SKILL,
    INNER_ABILITY_RESET_MSG,
    CASSANDRAS_COLLECTION,
    SET_OBJECT_STATE,
    POPUP,
    YOUR_INFORMATION,
    ATTENDANCE,
    RANDOM_RESPONSE,
    MAGIC_WHEEL,
    SPAWN_PET_2,
    R_MESOBAG_SUCCESS,
    R_MESOBAG_FAILURE,
    MAP_FADE,
    MAP_FADE_FORCE,
    RANDOM_EMOTION,
    RADIO_SCHEDULE,
    OPEN_SKILL_GUIDE,
    AP_SP_EVENT,
    QUEST_GUIDE_NPC,
    REGISTER_FAMILIAR,
    FAMILIAR_MESSAGE,
    SHOW_MAP_NAME,
    CAKE_VS_PIE,
    MOVE_SCREEN_X,
    MOVE_SCREEN_DOWN,
    CAKE_PIE_INSTRUMENTS,
    SEALED_BOX,
    //
    CYGNUS_ATTACK,
    SHOW_MAGNET,
    NPC_TOGGLE_VISIBLE,
    LOGOUT_GIFT,
    CS_CHARGE_CASH,
    GIFT_RESULT,
    CHANGE_NAME_CHECK,
    CHANGE_NAME_RESPONSE,
    //0x314 int itemid int sn

    CASH_SHOP_UPDATE,
    GACHAPON_STAMPS,
    FREE_CASH_ITEM,
    CS_SURPRISE,
    XMAS_SURPRISE,
    ONE_A_DAY,
    NX_SPEND_GIFT,
    RECEIVE_GIFT,
    RANDOM_CHECK,
    START_TV,
    REMOVE_TV,
    ENABLE_TV,
    GM_ERROR,
    ALIEN_SOCKET_CREATOR,
    BATTLE_RECORD_DAMAGE_INFO,
    CALCULATE_REQUEST_RESULT,
    BOOSTER_PACK,
    BOOSTER_FAMILIAR,
    BLOCK_PORTAL,
    NPC_CONFIRM,
    RSA_KEY,
    BUFF_BAR,
    GAME_POLL_REPLY,
    GAME_POLL_QUESTION,
    ENGLISH_QUIZ,
    FISHING_BOARD_UPDATE,
    BOAT_EFFECT,
    FISHING_CAUGHT,
    SIDEKICK_OPERATION,
    FARM_PACKET1,
    FARM_ITEM_PURCHASED,
    FARM_ITEM_GAIN,
    HARVEST_WARU,
    FARM_MONSTER_GAIN,
    FARM_INFO,
    FARM_MONSTER_INFO,
    FARM_QUEST_DATA,
    FARM_QUEST_INFO,
    FARM_MESSAGE,
    UPDATE_MONSTER,
    AESTHETIC_POINT,
    UPDATE_WARU,
    FARM_EXP,
    FARM_PACKET4,
    QUEST_ALERT,
    FARM_PACKET8,
    FARM_FRIENDS_BUDDY_REQUEST,
    FARM_FRIENDS,
    FARM_USER_INFO,
    FARM_AVATAR,
    FRIEND_INFO,
    FARM_RANKING,
    SPAWN_FARM_MONSTER1,
    SPAWN_FARM_MONSTER2,
    RENAME_MONSTER,
    //Unplaced:
    REDIRECTOR_COMMAND;

    private short code = -2;
    public static boolean record = false;

    private SendPacketOpcode() {
        this.code = 0x7FFE;
    }

    private SendPacketOpcode(int code) {
        this.code = (short) code;
    }

    public void setValue(int code) {
        this.code = (short) code;
    }
    
    @Override
    public void setValue(short newval) {
        this.code = newval;
    }

    @Override
    public short getValue() {
        return getValue(true);
    }

    public short getValue(boolean show) {
        if (show && ServerConfig.LOG_PACKETS) {
            if (isRecordHeader(this)) {
                record = true;
                String tab = "";
                for (int i = 4; i > name().length() / 8; i--) {
                    tab += "\t";
                }
                FileoutputUtil.log(FileoutputUtil.Packet_Record, "[發送]\t" + name() + tab + "\t包頭:0x" + StringUtil.getLeftPaddedStr(String.valueOf(code), '0', 4) + "\r\n");
            } else {
                record = false;
            }
        }
        return code;
    }

    public String getType(short code) {
        String type = null;
        if (code >= 0 && code < 0xE || code >= 0x17 && code < 0x21) {
            type = "CLogin";
        } else if (code >= 0xE && code < 0x17) {
            type = "LoginSecure";
        } else if (code >= 0x21 && code < 0xCB) {
            type = "CWvsContext";
        } else if (code >= 0xD2) {
            type = "CField";
        }
        return type;
    }

    public static String nameOf(int value) {
        for (SendPacketOpcode opcode : SendPacketOpcode.values()) {
            if (opcode.getValue(false) == value) {
                return opcode.name();
            }
        }
        return "UNKNOWN";
    }

    public static boolean isRecordHeader(SendPacketOpcode opcode) {
        switch (opcode.name()) {
//            case "WARP_TO_MAP":
//            case "GUILD_OPERATION":
//            case "PARTY_OPERATION":
//            case "GIVE_BUFF":
//            case "SPAWN_PLAYER":
//            case "DROP_ITEM_FROM_MAPOBJECT":
//            case "INVENTORY_OPERATION":
//            case "SPAWN_MONSTER":
            case "UNKNOWN":
                return true;
            default:
                return false;
        }
    }

    public static boolean isSpamHeader(SendPacketOpcode opcode) {
        switch (opcode.name()) {
            case "CHARLIST":
            case "WARP_TO_MAP":
            case "CS_OPEN":
            case "CS_INFO":
            case "PING":
            case "NPC_ACTION":
//            case "AUTH_RESPONSE":
//            case "SERVERLIST":
            case "UPDATE_STATS":
            case "MOVE_PLAYER":
            case "SPAWN_NPC":
            case "SPAWN_NPC_REQUEST_CONTROLLER":
            case "REMOVE_NPC":
            case "MOVE_MONSTER":
            case "MOVE_MONSTER_RESPONSE":
            case "SPAWN_MONSTER":
            case "SPAWN_MONSTER_CONTROL":
            case "HAKU_MOVE":
            case "MOVE_SUMMON":
//            case "MOVE_FAMILIAR":
            case "ANDROID_MOVE":
            case "GAME_MESSAGE":
//            case "INVENTORY_OPERATION":
            case "MOVE_PET":
//            case "SHOW_SPECIAL_EFFECT":
//            case "DROP_ITEM_FROM_MAPOBJECT":
            case "REMOVE_ITEM_FROM_MAP":
//            case "UPDATE_PARTYMEMBER_HP":
//            case "DAMAGE_PLAYER":
//            case "SHOW_MONSTER_HP":
//            case "CLOSE_RANGE_ATTACK":
//            case "RANGED_ATTACK":
//            case "ARAN_COMBO":
//            case "REMOVE_BG_LAYER":
            case "SPECIAL_STAT":
            case "TOP_MSG":
//            case "ANGELIC_CHANGE":
//            case "UPDATE_CHAR_LOOK":
//            case "KILL_MONSTER":
            case "SYSTEM_PROCESS_LIST":
            case "SERVERMESSAGE":
            case "SPAWN_PLAYER":
                return true;
            default:
                return false;
        }
    }

    public static void loadValues() {
        Properties props = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("sendops.properties")) {
            props.load(new BufferedReader(new InputStreamReader(fileInputStream, EncodingDetect.getJavaEncode("sendops.properties"))));
        } catch (IOException ex) {
            InputStream in = SendPacketOpcode.class.getClassLoader().getResourceAsStream("sendops.properties");
            if (in == null) {
                System.out.println("未讀取 sendops.properties 檔案, 使用內建 SendPacketOpcode 列舉");
                return;
            }
            try {
                props.load(in);
            } catch (IOException e) {
                throw new RuntimeException("讀取 sendops.properties 檔案異常", e);
            }
        }
        ExternalCodeTableGetter.populateValues(props, values());
    }

    static {
        loadValues();
    }
}
