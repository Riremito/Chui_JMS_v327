package client;

import constants.GameConstants;
import handling.Buffstat;
import java.io.Serializable;

public enum MapleBuffStat implements Serializable, Buffstat {

    //==========================Mask[0] - 1 - IDA[0xE]
 
    // 0    
    TEST_BUFF0(888, true),
    //提升最大爆擊                      [完成-182]
    INDIE_CR(888, true),
    // 2
    TEST_BUFF2(888, true),
    // 16
    TEST_BUFF16(888, true),
    // 19
    TEST_BUFF19(888, true),
    // 20
    TEST_BUFF20(888, true),
    // 21
    TEST_BUFF21(888, true),
    // 22
    TEST_BUFF22(888, true),
    // 23 
    STACKING_ATK(888, true),
    // 24
    TEST_BUFF24(888, true),
    // 30
    TEST_BUFF30(888, true),
    // 31
    TEST_BUFF31(888, true),
    
    //==========================Mask[1] - 2 - IDA[0xD]
    
    //傷害最大值
    INDIE_MAX_DAMAGE_OVER(231, true),
    //傷害最大值 %
    INDIE_MAX_DAMAGE_OVER_R(254, true),
    //物理傷害減少百分比(重生的輪行蹤)   [完成-182]
    INDIE_ASR_R(260, true), //indieAsrR
    //魔法傷害減少百分比(重生的輪行蹤)   [完成-182]
    INDIE_TER_R(261, true), //indieTerR
    //爆擊率提升                        [完成-182]
    INDIE_CR_R(274, true),
    //提升最大爆擊                      [完成-182]
    INDIE_MAX_CR(108, true),    
    //提升格檔                          [完成-182]
    INDIE_STANCE_R(23, true),
    // 42
    TEST_BUFF42(888, true),
    // 提升最大爆擊％
    INDIE_MAX_CR_R(888, true),
    //提升所有迴避值％                  [完成-182]
    INDIE_EVA_R(888, true),
    //提升魔法防禦力％                  [完成-182]
    INDIE_MDD_R(888, true),

    //物理攻擊力                        [IDA找的-186]
    WATK(0),
    //物理防御力                        [IDA找的-186]
    WDEF(1),
    //魔法攻擊力                        [IDA找的-186]
    MATK(2),
    //魔法防御力                        [IDA找的-186]
    MDEF(3),
    //命中率                            [IDA找的-186]
    ACC(4),
    //迴避率                            [IDA找的-186]
    AVOID(5),
    //手技                              [IDA找的-186]
    HANDS(6),
    //移動速度                          [IDA找的-186]
    SPEED(7),
    //跳躍力                            [IDA找的-186]
    JUMP(8),
    //魔心防禦                          [IDA找的-186]
    MAGIC_GUARD(9),
    //隱藏術                            [IDA找的-186]
    DARKSIGHT(10),
    //攻擊加速                          [IDA找的-186]
    BOOSTER(11),
    //傷害反擊                          [IDA找的-186]
    POWERGUARD(12),
    //神聖之火_最大MP                   [IDA找的-186]
    MAXMP(13),
    
    //==========================Mask[2] - 3 - IDA[0xC]
    
    //神聖之火_最大HP                   [IDA找的-186]
    MAXHP(14),    
    //神聖之光                          [IDA找的-186]
    INVICIBLE(15),
    //無形之箭                          [IDA找的-186]
    SOULARROW(16),
    //昏迷                              [IDA找的-186]
    STUN(17),
    //中毒                              [IDA找的-186]
    POISON(18),
    //封印                              [IDA找的-186]
    SEAL(19),
    //黑暗                              [IDA找的-186]
    DARKNESS(20),
    //鬥氣集中                          [IDA找的-186]
    COMBO(21),
    //召喚獸                            [IDA找的-186]
    SUMMON(21),
    //屬性攻擊                          [IDA找的-186]
    WK_CHARGE(22),
    //龍之力量                          [IDA找的-186]
    DRAGONBLOOD(23),
    //神聖祈禱                          [IDA找的-186]
    HOLY_SYMBOL(24),
    //(CMS_聚財術)                      [IDA找的-186]
    MESOUP(25),
    //影分身                            [IDA找的-186]
    SHADOWPARTNER(26),
    //勇者掠奪術                        [IDA找的-186]
    PICKPOCKET(27),
    //替身術                            [IDA找的-186]
    PUPPET(27),
    //楓幣護盾                          [IDA找的-186]
    MESOGUARD(28),
    //                                 [IDA找的-186]
    HP_LOSS_GUARD(29),
    //虛弱                              [IDA找的-186]
    WEAKEN(30),
    //詛咒                              [IDA找的-186]
    CURSE(31),
    //緩慢                              [IDA找的-186]
    SLOW(32),
    //變身                              [IDA找的-186]
    MORPH(33),
    //恢復                              [IDA找的-186]
    RECOVERY(34),
    //楓葉祝福                          [IDA找的-186]
    MAPLE_WARRIOR(35),
    //格擋(穩如泰山)                    [IDA找的-186]
    STANCE(36),
    //銳利之眼                          [IDA找的-186]
    SHARP_EYES(37),
    //魔法反擊                          [IDA找的-186]
    MANA_REFLECTION(38),
    //誘惑                              [IDA找的-186]
    SEDUCE(39),
    //精神投擲                          [IDA找的-186]
    SPIRIT_CLAW(40),
    //時空門                            [IDA找的-186]
    MYSTIC_DOOR(40),
    //魔力無限                          [IDA找的-186]
    INFINITY(41),
    //進階祝福                          [IDA找的-186]
    HOLY_SHIELD(42),
    //敏捷提升                          [IDA找的-186]
    HAMSTRING(43),
    //命中率增加                        [IDA找的-186]
    BLIND(44),
    //集中精力                          [IDA找的-186]
    CONCENTRATE(45),
    //不死化                            [IDA找的-186]
    ZOMBIFY(46),
    //英雄的回響                        [IDA找的-186]
    ECHO_OF_HERO(47),
    //==========================Mask[3] - 4 - IDA[0xB]
    //楓幣獲得率                        [IDA找的-186]
    MESO_RATE(48),
    //鬼魂變身                          [IDA找的-186]
    GHOST_MORPH(49),
    //混亂                              [IDA找的-186]
    REVERSE_DIRECTION(50),
    //掉寶幾率                          [IDA找的-186]
    DROP_RATE(51),
    //經驗倍率                          [IDA找的-186]
    EXPRATE(52),
    //樂豆倍率                          [IDA找的-186]
    ACASH_RATE(53),
    //                                  [IDA找的-186]
    ILLUSION(54),
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF8(55),
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF9(56),
    //狂暴戰魂                          [IDA找的-186]
    BERSERK_FURY(57),
    //金剛霸體                          [IDA找的-186]
    DIVINE_BODY(58),
    //(CMS_闪光击)                      [IDA找的-186]
    SPARK(59),
    //(CMS_终极弓剑)                    [IDA找的-186]
    FINALATTACK(60),
    //隱藏刀                            [IDA找的-186]
    BLADE_CLONE(61),
    //自然力重置                        [IDA找的-186]
    ELEMENT_RESET(62),
    //(CMS_风影漫步)                    [IDA找的-186]
    WIND_WALK(63),
    //組合無限                          [IDA找的-186]
    UNLIMITED_COMBO(64),
    //矛之鬥氣                          [IDA找的-186]
    ARAN_COMBO(66),
    //嗜血連擊                          [IDA找的-186]
    COMBO_DRAIN(67),
    //宙斯之盾                          [IDA找的-186]
    COMBO_BARRIER(68),
    //強化連擊(CMS_戰神抗壓)            [IDA找的-186]
    BODY_PRESSURE(69),
    //釘錘(CMS_戰神威勢)                [IDA找的-186]
    SMART_KNOCKBACK(70),
    //(CMS_天使狀態)                    [IDA找的-186]
    PYRAMID_PQ(71),
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF10(72),
    //無法使用藥水                      [IDA找的-186]
    POTION_CURSE(73),
    //影子                              [IDA找的-186]
    SHADOW(74),
    //致盲                              [IDA找的-186]
    BLINDNESS(75),
    //緩慢術                            [IDA找的-186]
    SLOWNESS(76),
    //守護之力(CMS_魔法屏障)             [IDA找的-186]
    MAGIC_SHIELD(77),
    //魔法抵抗．改                      [IDA找的-186]
    MAGIC_RESISTANCE(78),
    //靈魂之石                          [IDA找的-186]
    SOUL_STONE(79),
    
    //==========================Mask[4] - 5 - IDA[0xA]
    
    //飛天騎乘                          [IDA找的-186]
    SOARING(80),    
    //冰凍                              [IDA找的-186]
    FREEZE(81),
    //雷鳴之劍
    LIGHTNING_CHARGE(82),
    //鬥氣爆發                          [IDA找的-186]
    ENRAGE(83),
    //障礙                              [IDA找的-186]
    BACKSTEP(84),
    //無敵(隱‧鎖鏈地獄、自由精神等)     [IDA找的-186]
    INVINCIBILITY(85),
    //絕殺刃                            [IDA找的-186]
    FINAL_CUT(86),
    //咆哮                              [IDA找的-186]
    DAMAGE_BUFF(87),
    //狂獸附體                          [IDA找的-186]
    ATTACK_BUFF(88), 
    //地雷                              [IDA找的-186]
    RAINING_MINES(89),
    //增強_MaxHP                        [IDA找的-186]
    ENHANCED_MAXHP(90),
    //增強_MaxMP                        [IDA找的-186]
    ENHANCED_MAXMP(91),
    //增強_物理攻擊力                   [IDA找的-186]
    ENHANCED_WATK(92),
    //增強_魔法攻擊力                   [IDA找的-186]
    ENHANCED_MATK(93),
    //增強_物理防禦力                   [IDA找的-186]
    ENHANCED_WDEF(94),
    //增強_魔法防禦力                   [IDA找的-186]
    ENHANCED_MDEF(95),
    //全備型盔甲                        [IDA找的-186]
    PERFECT_ARMOR(96),
    //終極賽特拉特_PROC                 [IDA找的-186]
    SATELLITESAFE_PROC(97),
    //終極賽特拉特_吸收                 [IDA找的-186]
    SATELLITESAFE_ABSORB(98),                   
    //颶風                              [IDA找的-186]
    TORNADO(99),
    //咆哮_會心一擊機率增加              [IDA找的-186]
    CRITICAL_RATE_BUFF(100),
    //咆哮_MaxMP 增加                   [IDA找的-186]
    MP_BUFF(101),
    //咆哮_傷害減少                     [IDA找的-186]
    DAMAGE_TAKEN_BUFF(102),
    //咆哮_迴避機率                     [IDA找的-186]
    DODGE_CHANGE_BUFF(103),
    //                                 [IDA找的-186]
    CONVERSION(104),
    //甦醒                              [IDA找的-186]
    REAPER(105),
    //迷你啾出動                        [IDA找的-186]
    MINI_PINK_BEAN_SUMMON(888),
    //潛入                             [IDA找的-186]
    INFILTRATE(106),
    //合金盔甲                         [IDA找的-186]                  
    MECH_CHANGE(107),    
    
    //==========================Mask[5] - 6 - IDA[0x9]
    // 繩索
    AURA(108),
    //黑色繩索                      
    DARK_AURA_OLD(109),
    //藍色繩索                      
    BLUE_AURA_OLD(110),
    //黃色繩索                      
    YELLOW_AURA_OLD(111),
    //超級體
    BODY_BOOST(112),
    //暴走形态                          [IDA找的-186]
    FELINE_BERSERK(113),
    //幸运骰子                          [IDA找的-186]
    DICE_ROLL(114),
    //祝福护甲                          [IDA找的-186]
    DIVINE_SHIELD(115),
    //攻擊增加百分比                    [IDA找的-186]
    DAMAGE_RATE(116),
    //瞬間移動精通                      [IDA找的-186]
    TELEPORT_MASTERY(117),
    //戰鬥命令                          [IDA找的-186]
    COMBAT_ORDERS(118),
    //追隨者                            [IDA找的-186]
    BEHOLDER(119),    
    //裝備潛能無效化                    [IDA找的-186]
    DISABLE_POTENTIAL(120),    
    // 巨人藥水                                [IDA找的-186]
    GIANT_POTION(121),
    //玛瑙的保佑                        [IDA找的-186]
    ONYX_SHROUD(122),
    //玛瑙的意志                        [IDA找的-186]
    ONYX_WILL(123),
    //龍捲風                            [IDA找的-186]
    TORNADO_CURSE(124),
    //天使祝福                          [IDA找的-186]
    BLESS(125),    
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF4(126),
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF6(127),
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF7(128),
    //压制术                            [IDA找的-186]
    THREATEN_PVP(129),
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF5(130),
    //冰骑士                            [IDA找的-186]
    ICE_KNIGHT(131),    
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF15(888),    
    //力量                              [IDA找的-186]
    STR(132),
    //智力                              [IDA找的-186]
    INT(133),
    //敏捷                              [IDA找的-186]
    DEX(134),
    //運氣                              [IDA找的-186]
    LUK(135),
    //未知(未確定)                      [IDA找的-186]
    ATTACK(136),    
    //未知(未確定)                      [IDA找的-186]
    STACK_ALLSTATS(137),
    // 堆疊物攻
    INDIE_PAD(138, true),
    // 堆疊魔攻
    INDIE_MAD(139, true),
    //最大體力                          [完成-182]
    INDIE_MAX_HP(140, true), //indieMaxHp, indieMhp
    //最大魔法                          [完成-182]
    INDIE_MAX_MP(141, true),//indieMaxMp
    //命中值增加                        [完成-182]
    INDIE_ACC(142, true),//indieAcc
    //提升迴避值                        [完成-182]
    INDIE_EVA(143, true),
    //疾速之輪行蹤
    INDIE_JUMP(144, true),
    //疾速之輪行蹤                      [完成-182]
    INDIE_SPEED(145, true),
    //所有能力提升
    INDIE_ALL_STATE(146, true), //indieAllStat 
    //未知(未確定)                      [IDA找的-186]
    PVP_DAMAGE(147),
    //IDA移動Buff                       [IDA找的-186]
    IDA_MOVE_BUFF7(888),    
    // 更新BUFF用                       [IDA找的-186]
    IDA_BUFF_183(888),
    // 更新BUFF用                       [IDA找的-186]
    IDA_BUFF_184(888),
    // 更新BUFF用                       [IDA找的-186]
    IDA_BUFF_185(888),    
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF2(888),
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF1(888),
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF12(888),
    //未知(未確定)
    PVP_ATTACK(148),    
    // 更新BUFF用                       [IDA找的-186]
    IDA_BUFF_189(149),    
    //隱藏潛能(未確定)                  [IDA找的-186]
    HIDDEN_POTENTIAL(150),
    //未知(未確定)                      [IDA找的-186]
    ELEMENT_WEAKEN(151),
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF3(152),
    //未知(未確定)(90002000)            [IDA找的-186]
    SNATCH(153),     
    //凍結                              [IDA找的-186]
    FROZEN(154),    
    // 更新BUFF用                       [IDA找的-186]
    IDA_BUFF_193(155),
    // 更新BUFF用                       [IDA找的-186]
    IDA_BUFF_194(156),
    // 更新BUFF用                       [IDA找的-186]
    IDA_BUFF_195(157),

    //==========================Mask[6] - 7 - IDA[0x8]
    
    //未知(未確定)                      [IDA找的-186]
    PVP_FLAG(158),    
    //無限力量[猜測]                    [IDA找的-186]
    BOUNDLESS_RAGE(159),
    //聖十字魔法盾                      [IDA找的-186]
    HOLY_MAGIC_SHELL(160),
    //核爆術                            [IDA找的-186]
    BIG_BANG(161),
    //神秘狙擊                         [IDA找的-186]
    MANY_USES(162),
    //大魔法師(已改成被動,無BUFF)       [IDA找的-186]
    BUFF_MASTERY(163),
    //異常抗性                         [IDA找的-186]
    ABNORMAL_STATUS_R(164),
    //屬性抗性                         [IDA找的-186]
    ELEMENTAL_STATUS_R(165),
    //水之盾                           [IDA找的-186]
    WATER_SHIELD(166),
    //變形                             [IDA找的-186]
    DARK_METAMORPHOSIS(167),
    //随机橡木桶                       [IDA找的-186]
    BARREL_ROLL(168),
    //精神连接[跟靈魂灌注是同個東西]    [IDA找的-186]
    SPIRIT_LINK(169),
    INDIE_IGNORE_DODGE_CRIT_TIME(170, true),
    //靈魂灌注_攻擊增加                [IDA找的-186]
    DAMAGE_R(169),
    //神圣拯救者的祝福                 [IDA找的-186]
    VIRTUE_EFFECT(170),
    //光明綠化                        [IDA找的-186]
    COSMIC_GREEN(171),    
    //靈魂灌注_爆擊率增加              [IDA找的-186]
    CRITICAL_RATE(175),
    //物理防禦力增加                    [完成-182]
    INDIE_PDD(173, true),//indiePdd
    //魔法防禦力增加                    [完成-182]
    INDIE_MDD(174, true),//indieMdd
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_209(177),
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_210(178),
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_211(179),
    //最大體力百分比                    [完成-182]
    INDIE_MHP_R(195, true), //indieMhpR
    //疾速之輪行蹤 & 重生的輪行蹤        [完成-182]
    INDIE_EXP(196, true), //indieExp
    //攻擊速度提升                      [完成-182]
    INDIE_BOOSTER(200, true), //indieBooster
    //提升攻擊％                        [完成-182]
    INDIE_PAD_R(202, true),
    //提升魔法攻擊％                     [完成-182]
    INDIE_MAD_R(203, true),
    INDIE_FIX_DAMAGE_R(206, true),
    //提高STR                          [完成-182] 
    INDIE_STR(213, true),
    //提高DEX                          [完成-182] 
    INDIE_DEX(214, true),
    //提高INT                          [完成-182] 
    INDIE_INT(215, true),
    //提高LUK                          [完成-182]  
    INDIE_LUK(216, true),    
    //提高技能攻擊力                    [完成-182]
    INDIE_DAM_R(229, true),//indieDamR
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_213(197),
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_214(198),    
    //未知(未確定)                    [IDA找的-186]
    NO_SLIP(199),
    //未知(未確定)                    [IDA找的-186]
    FAMILIAR_SHADOW(200),
    //吸血鬼之觸                      [IDA找的-186]
    ABSORB_DAMAGE_HP(201),
    //提高防禦力[猜測]                [IDA找的-186]
    DEFENCE_BOOST_R(202),
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_218(203),    
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_219(204),    
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_220(205),    
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_221(206), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_222(207),    
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_223(208),  
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_224(209),   
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_225(210),
    //最大魔法百分比                    [完成-182]
    INDIE_MMP_R(211, true), //indieMmpR
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_226(212), 

    //==========================Mask[7] - 8 - IDA[0x7]
    
    //IDA特殊Buff                     [IDA找的-186]
    IDA_SPECIAL_BUFF_1(198),
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_228(214), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_229(215),     
    //角設預設Buff                    [IDA找的-186]
    CHAR_BUFF(216),
    //角設預設Buff                    [IDA找的-186]
    MOUNT_MORPH(217),
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_232(215),    
    //使用技能中移動                   [IDA找的-186]
    USING_SKILL_MOVE(216),
    //無視防禦力                       [IDA找的-186]
    IGNORE_DEF(217),
    //幸運幻影                         [IDA找的-186]
    FINAL_FEINT(218),
    //幻影斗蓬                         [IDA找的-186]
    PHANTOM_MOVE(219),
    //爆擊機率增加                     [IDA找的-186]
    CRITICAL_RATE2(220),
    //最大爆擊傷害
    MAX_CRITICAL_DAMAGE(221),
    //最小爆擊傷害                     [IDA找的-186]
    MIN_CRITICAL_DAMAGE(222),
    INDIE_SCRIPT_BUFF(223), // CTS_IndieScriptBuff
    //審判                             [IDA找的-186]
    JUDGMENT_DRAW(888),
    //增加_物理攻擊                     [IDA找的-186]
    DAMAGE_UP(224),    
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_241(227),
    //IDA移動Buff                  [IDA找的-186]
    IDA_MOVE_BUFF2(228),
    //IDA移動Buff                  [IDA找的-186]
    IDA_MOVE_BUFF3(229),
    //IDA移動Buff                  [IDA找的-186]
    IDA_MOVE_BUFF4(230),
    //解多人Buff用的                [IDA找的-186]
    PLAYERS_BUFF14(231),    
    //黑暗之眼                     [IDA找的-186]
    PRESSURE_VOID(232),    
    //光蝕 & 暗蝕                  [IDA找的-186]
    LUMINOUS_GAUGE(233),
    //黑暗強化 & 全面防禦          [IDA找的-186]
    DARK_CRESCENDO(234),
    //黑暗祝福                     [IDA找的-186]
    BLACK_BLESSING(235),
    //抵禦致命異常狀態              [IDA找的-186]
    //(如 元素適應(火、毒), 元素適應(雷、冰), 聖靈守護)
    ABNORMAL_BUFF_RESISTANCES(236),
    //血之限界                     [IDA找的-186]
    LUNAR_TIDE(237),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_252(238),    
    //凱撒變型值                   [IDA找的-186]
    KAISER_COMBO(239),    
    
    //==========================Mask[8] - 9 - IDA[0x6]
    
    //堅韌護甲                     [IDA找的-186]
    GRAND_ARMOR(240),
    //凱撒模式切換                 [IDA找的-186]
    KAISER_MODE_CHANGE(241),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_256(242),    
    //IDA移動Buff                  [IDA找的-186]
    IDA_MOVE_BUFF5(243),
    //意志之劍                     [IDA找的-186]
    TEMPEST_BLADES(244),
    //會心一擊傷害                 [IDA找的-186]
    CRIT_DAMAGE(245),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_260(246),  
    //靈魂傳動                      [IDA找的-186]
    DAMAGE_ABSORBED(247),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_262(248),  
    //功能不知道                    [IDA找的-186]
    IDA_UNK_BUFF3(249),    
    //IDA特殊Buff                   [IDA找的-186]
    IDA_SPECIAL_BUFF_3(250),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_265(251),
    //功能不知道                    [IDA找的-186]
    IDA_UNK_BUFF5(252),     
    //IDA移動Buff                   [IDA找的-186]
    IDA_MOVE_BUFF6(253),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_268(254),  
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_269(255),  
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_270(256),  
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_271(257), 
    //繼承人                        [IDA找的-186]
    SOUL_BUSTER(258),
    //未知(未確定)                  [IDA找的-186]
    PRETTY_EXALTATION(259),
    //未知(未確定)                  [IDA找的-186]
    KAISER_MAJESTY3(260),
    //未知(未確定)                  [IDA找的-186]
    KAISER_MAJESTY4(261),     
    //靈魂深造                      [IDA找的-186]
    RECHARGE(262),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_276(888), 
    //隱‧鎖鏈地獄                  [IDA找的-186] 
    STATUS_RESIST_TWO(260),
    //終極審判[猜測]                [IDA找的-186]
    FINAL_JUDGMENT_DRAW(261),    
    //冰雪結界                      [IDA找的-186]
    ABSOLUTE_ZERO_AURA(262),
    //未知(未確定)                  [IDA找的-186]
    PARTY_STANCE(888),    
    //火靈結界[猜測]                [IDA找的-186]
    INFERNO_AURA(263),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_278(261), 
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_279(262), 
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_280(263), 
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_281(264), 
    //復仇天使                      [IDA找的-186]
    AVENGING_ANGEL(265),
    //天堂之門                      [IDA找的-186]
    HEAVEN_IS_DOOR(266),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_284(267), 
    //戰鬥準備                      [IDA找的-186]
    BOWMASTERHYPER(268),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_286(269),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_287(270),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_288(271),     
    //修羅                          [IDA找的-186]
    ASURA_IS_ANGER(272),
    //暴能續發                      [IDA找的-186]
    STIMULATING_CONVERSATION(273),
    //IDA特殊Buff                   [IDA找的-186]
    IDA_SPECIAL_BUFF_2(274),
    
    //==========================Mask[9] - 10 - IDA[0x5]
    
    //功能不知道                     [IDA找的-186]
    IDA_UNK_BUFF10(275),
    //BOSS傷害                      [IDA找的-186]
    BOSS_DAMAGE(276),
    //功能不知道                     [IDA找的-186]
    IDA_UNK_BUFF8(277),
    //全域代碼                       [IDA找的-186]
    OOPARTS_CODE(278),    
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_295(279),    
    //超越_攻擊                      [IDA找的-186]
    EXCEED_ATTACK(280),
    //急速療癒                       [IDA找的-186]
    DIABOLIC_RECOVERY(281),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_298(282),    
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_299(283),      
    //超越                          [IDA找的-186]
    EXCEED(284),
    //沉月-攻擊數量                  [IDA找的-186]
    ATTACK_COUNT(285),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_302(287),  
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_303(288),  
    //傑諾能量                      [IDA找的-186]
    SUPPLY_SURPLUS(289),
    //IDA特殊Buff                   [IDA找的-186]
    IDA_SPECIAL_BUFF_5(290),    
    //IDA BUFF列表更新用            [IDA找的-186]
    IDA_BUFF_306(291),    
    //傑諾飛行                      [IDA找的-186]
    XENON_FLY(292),
    //阿瑪蘭斯發電機                [IDA找的-186]
    AMARANTH_GENERATOR(293),
    //解多人Buff用的                [IDA找的-186]
    PLAYERS_BUFF13(294),
    //元素： 風暴                   [IDA找的-186]
    STORM_ELEMENTAL(295),
    //開天闢地[猜測]                [IDA找的-186]
    PRIMAL_BOLT(296),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_312(297),  
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_313(298),
    //風暴使者                      [IDA找的-186]
    STORM_BRINGER(299),
    //光之劍-命中提升                [IDA找的-186]
    ACCURACY_PERCENT(300),
    //迴避提升                      [IDA找的-186]
    AVOID_PERCENT(301),
    //阿爾法                        [IDA找的-186]
    ALBATROSS(302),
    //                              [IDA找的-186]
    SPEED_LEVEL(303),
    //雙重力量 : 沉月/旭日           [IDA找的-186]
    SOLUNA_EFFECT(304),    
    //光之劍                        [IDA找的-186]
    ADD_AVOIDABILITY(305),
    //元素： 靈魂                   [IDA找的-186]
    SOUL_ELEMENT(306),
    //雙重力量 : 沉月/旭日           [IDA找的-186]
    EQUINOX_STANCE(307),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_323(308),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_324(309),
    //靈魂球BUFF                    [IDA找的-186]
    SOUL_WEAPON(310),
    //靈魂BUFF                      [IDA找的-186]
    SOUL_WEAPON_HEAD(311),
    
    //==========================Mask[10] - 11 - IDA[0x4]
    
    //復原                          [IDA找的-186]
    HP_RECOVER(313),
    //功能不知道                    [IDA找的-186]
    IDA_UNK_BUFF4(314),
    
    // 314
    
    //十字深鎖鏈                    [IDA找的-186]
    CROSS_SURGE(315),
    //超衝擊防禦_防禦概率           [IDA找的-186]
    PARASHOCK_GUARD(316),
    // 轉生                   [IDA找的-186]
    Reincarnation(317),
    // 更新BUFF用                  [IDA找的-186]          
    KnightsAura(318),    
    //超衝擊防禦_防禦力                 [完成-182]
    INDIE_PDD_R(319, true),
    //寒冰迅移                     [IDA找的-186]
    CHILLING_STEP(320),
    //祝福福音                      [IDA找的-186]
    PASSIVE_BLESS(321),

    // 322

    // 更新BUFF用                   [IDA找的-186]
    ComboCostInc(323),    
    //功能不知道                    [IDA找的-186]
    ExtremeArchery(324),
    //
    NaviFlying(325),
    // 魔幻箭筒                      [IDA找的-186]
    QUIVER_KARTRIGE(326),        
    //IDA特殊Buff                   [IDA找的-186]
    IDA_SPECIAL_BUFF_6(327),
    //IDA移動Buff                   [IDA找的-186]
    AdvancedQuiver(328),
    // 不知道
    UserControlMob(329),
    //IDA特殊Buff                   [IDA找的-186]
    ImmuneBarrier(330),
    //功能不知道                    [IDA找的-186]
    ArmorPiercing(331),
    //時之威能                      [IDA找的-186]
    DIVINE_FORCE_AURA(332),
    //聖靈神速                      [IDA找的-186]
    DIVINE_SPEED_AURA(333),
    // 更新BUFF用                   [IDA找的-186]
    CriticalGrowing(334),
    // 更新BUFF用                   [IDA找的-186]
    QuickDraw(335), // 頭上兩把槍
    //提升BOSS攻擊力                 
    INDIE_BOSS(336, true), // CTS_IndieBDR
    // 31110007                   [IDA找的-186]
    BowMasterConcentration(337), // 角色周圍出現+的圈圈
    // 更新BUFF用                   [IDA找的-186]
    TimeFastABuff(338),
    // 更新BUFF用                   [IDA找的-186]
    TimeFastBBuff(339),
    //提升所有屬性                      [完成-182]
    INDIE_ALL_STATE_R(340, true), // CTS_IndieStatR
    // 大砲(95001002)               [IDA找的-186]
    CANNON(341),
    //提升無視防禦                      [完成-182]
    INDIE_IGNORE_MOB_PDP_R(342, true), //indieIgnoreMobpdpR
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_354(343),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_355(344),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_356(345),
    //==========================Mask[11] - 12 - IDA[0x3]
    
    //無視怪物傷害(重生的輪行蹤)       [IDA找的-186]
    IGNORE_MOB_DAM_R(888), //ignoreMobDamR
    //靈魂結界                        [IDA找的-186]
    SPIRIT_WARD(343),
    //死裡逃生                        [IDA找的-186]
    CLOSE_CALL(344),    
    //IDA特殊Buff                     [IDA找的-186]
    IDA_SPECIAL_BUFF_9(345),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_361(346),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_362(347),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_363(348),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_364(349),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_365(350),    
    //IDA移動Buff                   [IDA找的-186]
    IDA_MOVE_BUFF9(351),
    //元素 : 闇黑                   [IDA找的-186]
    DARK_ELEMENTAL(352),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_368(353),
    //燃燒                          [IDA找的-186]
    CONTROLLED_BURN(888),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_370(370),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_371(371),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_372(372),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_373(373),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_374(374),
    // 暗影僕從                     [IDA找的-186]
    DARK_SERVANT(375),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_376(376),    
    //功能不知道                     [IDA找的-186]
    IDA_UNK_BUFF16(377),
    //危機繩索                      [IDA找的-186]
    AURA_BOOST(378),
    //提升最小爆擊傷害 %                      [完成-182]
    INDIE_MIN_CRIT_DAMAGE_R(351, true),
    // 未知
    IDK_UNK_265(355),
    // 隱形?
    IDK_UNK_BUFF_266(356),
    // 未知
    IDK_UNK_357(357),
    //拔刀術                        [IDA找的-186]
    HAYATO(358),
    //拔刀術-新技體                  [IDA找的-186]
    BATTOUJUTSU_SOUL(359),
    //制敵之先                         [IDA找的-186]
    COUNTERATTACK(360),
    //柳身                           [IDA找的-186]
    WILLOW_DODGE(361),        
    //紫扇仰波                       [IDA找的-186]
    SHIKIGAMI(362),
    //武神招來                       [IDA找的-186]
    MILITARY_MIGHT(363),
    //武神招來                       [IDA找的-186]
    MILITARY_MIGHT1(364),
    //武神招來                    
    MILITARY_MIGHT2(365),
    //拔刀術                           [IDA找的-186]
    BATTOUJUTSU_STANCE(366),

    // 367
    
    //==========================Mask[12] - 13 - IDA[0x2]
 
    //迅速                             [IDA找的-186]
    JINSOKU(368),
    //一閃                             [IDA找的-186]
    HITOKIRI_STRIKE(369), 
    //花炎結界                         [IDA找的-186]
    FOX_FIRE(370),
    //影朋‧花狐                        [IDA找的-186]
    HAKU_REBORN(371),
    //花狐的祝福                        [IDA找的-186]
    HAKU_BLESS(372),
    // 結界破魔
    結界破魔(375),
    // 更新BUFF用                       [IDA找的-186]
    IDA_BUFF_394(373),
    //解多人Buff用的                    [IDA找的-186]
    PLAYERS_BUFF11(374),    
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_396(376),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_397(377),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_398(378),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_399(379),
    
    //精靈召喚模式                   [IDA找的-186]
    ANIMAL_SELECT(888),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_401(401),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_402(402),
    // 401
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_404(404),    
    //IDA特殊Buff                   [IDA找的-186]
    IDA_SPECIAL_BUFF_4(405),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_406(406),    
    //依古尼斯咆哮-迴避提升          [IDA找的-186]
    PROP(375),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_408(408), 
    //召喚美洲豹                    [IDA找的-186]
    SUMMON_JAGUAR(409),
    //自由精神                      [IDA找的-186]
    SPIRIT_OF_FREEDOM(410),    
    //功能不知道                    [IDA找的-186]
    IDA_UNK_BUFF1(411),
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_412(412), 
    //功能不知道                    [IDA找的-186]
    IDA_UNK_BUFF2(413),    
    //光環效果                      [IDA找的-186]
    NEW_AURA(888),
    //黑暗閃電                      [IDA找的-186]
    DARK_SHOCK(888),
    //戰鬥精通                      [IDA找的-186]
    BATTLE_MASTER(416),
    //死神契約                      [IDA找的-186]
    GRIM_CONTRACT(417), 
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_418(418), 
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_419(419), 
    
    //==========================Mask[13] - 14 - IDA[0x0]
    
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_420(420), 
    // 更新BUFF用                   [IDA找的-186]
    IDA_BUFF_421(421),    
    //神盾系統                        [IDA找的-186]
    AEGIS_SYSTEM(422),    
    //索魂精通                        [IDA找的-186]
    SOUL_SEEKER(423),
    //小狐仙                          [IDA找的-186]
    FOX_SPIRITS(424),
    //暗影蝙蝠                        [IDA找的-186]
    SHADOW_BAT(425),
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_426(426), 
    //燎原之火                        [IDA找的-186]
    IGNITE(427),    
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_429(429), 
    //預設Buff-3                       [IDA找的-186]
    DEFAULTBUFF3(430, true),
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_431(431), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_432(432), 
    //皮卡啾攻擊                       [IDA找的-186]
    PINK_BEAN_ATTACK(888),
    //皮卡啾未知                       [IDA找的-186]
    PINK_BEAN_UNK(888),
    //預設Buff-4                        [IDA找的-186]
    DEFAULTBUFF4(435),
    //烈焰溜溜球                       [IDA找的-186]
    PINK_BEAN_YOYO(888),    
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_437(437), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_438(438), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_439(439), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_440(440), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_441(441), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_442(442), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_443(443), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_444(444), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_445(445), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_446(446), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_447(447), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_448(448), 
    // ESP數量                        [IDA找的-186]
    ESP_COUNT(449), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_450(450), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_451(451), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_452(452), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_453(453), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_454(454), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_455(455), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_456(456), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_457(457), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_458(458), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_459(459), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_460(460), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_461(461), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_462(462), 
    // 更新BUFF用                     [IDA找的-186]
    IDA_BUFF_463(463), 
    
    // 408
    
    //預設Buff-5                        [IDA找的-186]
    DEFAULTBUFF5(888, true),
    //能量獲得                        [IDA找的-186]
    ENERGY_CHARGE(409, true),
    //衝鋒_速度                         [IDA找的-186]
    DASH_SPEED(410, true),    
    //衝鋒_跳躍                         [IDA找的-186]
    DASH_JUMP(411, true),
    //怪物騎乘                          [IDA找的-186]
    MONSTER_RIDING(412, true),
    //最終極速                          [IDA找的-186]
    SPEED_INFUSION(413, true),
    //指定攻擊(無盡追擊)                 [IDA找的-186]
    HOMING_BEACON(414, true),
    //預設Buff-1                        [IDA找的-186]
    DEFAULTBUFF1(415, true),
    //預設Buff-2                        [IDA找的-186]
    DEFAULTBUFF2(888, true),
    
    
    //-----------------[已停用的Buff]
    //貓頭鷹召喚
    OWL_SPIRIT(888),
    
    ;
    private static final long serialVersionUID = 0L;
    private final int buffstat;
    private final int first;
    private boolean stacked = false;

    private MapleBuffStat(int buffstat) {
        this.buffstat = 1 << (/*31 - */(buffstat % 32));
        this.first = (GameConstants.MAX_BUFFSTAT - 1) - (int) Math.floor(buffstat / 32);
    }

    private MapleBuffStat(int buffstat, boolean stacked) {
        this.buffstat = 1 << (/*31 - */(buffstat % 32));
        this.first = (GameConstants.MAX_BUFFSTAT - 1 ) - (int) Math.floor(buffstat / 32);
        this.stacked = stacked;
    }

    @Override
    public int getPosition() {
        return first;
    }

    @Override
    public int getValue() {
        return buffstat;
    }
    
    public static MapleBuffStat getMapleBuffStat(int buff) 
    {
        int buf = 1 << (/*31 - */(buff % 32));
        int fir = (GameConstants.MAX_BUFFSTAT - 1 ) - (int) Math.floor(buff / 32);
        for (MapleBuffStat bb : values()){
            if (bb.buffstat == buf && bb.first == fir) {
                return bb;
            }
        }
        return MapleBuffStat.TEST_BUFF0;
    }

    public final boolean canStack() {
        return stacked;
    }
}