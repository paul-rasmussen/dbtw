package com.dbtw.widgets;

import java.util.Vector;

public class CountryCodeISSOWidget {
	//Static variables
	public static final int AFGHANISTAN = 0;
	public static final int ALBANIA = 1;
	public static final int ALGERIA = 2;
	public static final int ANDORRA = 3;
	public static final int ANGOLA = 4;
	public static final int ANGUILLA = 5;
	public static final int ANTARCTICA = 6;
	public static final int ANTIGUA_AND_BARBUDA = 7;
	public static final int ARGENTINA = 8;
	public static final int AMERICAN_SAMOA = 9;
	public static final int ARMENIA = 10;
	public static final int ARUBA = 11;
	public static final int AUSTRALIA = 12;
	public static final int AUSTRIA = 13;
	public static final int ALAND_ISLANDS = 14;
	public static final int AZERBAIJAN = 15;
	public static final int BAHAMAS = 16;
	public static final int BAHRAIN = 17;
	public static final int BANGLADESH = 18;
	public static final int BARBADOS = 19;
	public static final int BELARUS = 20;
	public static final int BELGIUM = 21;
	public static final int BELIZE = 22;
	public static final int BENIN = 23;
	public static final int BERMUDA = 24;
	public static final int BHUTAN = 25;
	public static final int BOLIVIA = 26;
	public static final int BONAIRE_SINT_EUSTATUIS_SABA = 27;
	public static final int BOSNIA_HERZEGOVIAN = 28;
	public static final int BOTSWANA = 29;
	public static final int BOUVET_ISLAND = 30;
	public static final int BRAZIL = 31;
	public static final int BRITISH_INDIAN_OCEAN_TERRITORY = 32;
	public static final int BRITISH_VIRGIN_ISLANDS = 33;
	public static final int BRUNEI_DARUSSALAM = 34;
	public static final int BULGARIA = 35;
	public static final int BURKINA_FASO = 36;
	public static final int BURUNDI = 37;
	public static final int CAMAROON = 38;
	public static final int CAMBODIA = 39;
	public static final int CANADA = 40;
	public static final int CAPE_VERDE = 41;
	public static final int CAYMAN_ISLANDS = 42;
	public static final int CENTRAL_AFRICAN_REPUBLIC = 43;
	public static final int CHAD = 44;
	public static final int CHILE = 45;
	public static final int CHINA = 46;
	public static final int CHRISTMAS_ISLAND = 47;
	public static final int COCOS_ISLANDS = 46;
	public static final int COLOMBIA = 47;
	public static final int COMOROS = 48;
	public static final int CONGO = 49;
	public static final int COOK_ISLANDS = 50;
	public static final int COSTA_RICA = 51;
	public static final int CROATIA = 52;
	public static final int CUBA = 53;
	public static final int CURACAO = 54;
	public static final int CYPRUS = 55;
	public static final int CZECH_REPUBLIC = 56;
	public static final int DEMOCRATIC_REPUBLIC_OF_CONGO = 57;
	public static final int DENMARK = 58;
	public static final int DOMINICA = 59;
	public static final int DOMINICAN_REPUBLIC = 60;
	public static final int DJIBOUTI = 61;
	public static final int ECUADOR = 62;
	public static final int EGYPT = 63;
	public static final int EL_SALVADOR = 64;
	public static final int EQUATORIAL_GUINEA = 65;
	public static final int ERITREA = 66;
	public static final int ESTONIA = 67;
	public static final int ETHIOPIA = 68;
	public static final int FALKLAND_ISLANDS = 69;
	public static final int FAROE_ISLANDS = 70;
	public static final int FIJI = 71;
	public static final int FINLAND = 72;
	public static final int FRANCE = 73;
	public static final int FRENCH_GUIANA = 74;
	public static final int FRENCH_POLYNESIA = 75;
	public static final int FRENCH_SOUTHERN_TERRITORIES = 76;
	public static final int GABON = 77;
	public static final int GAMBIA = 78;
	public static final int GEORGIA = 79;
	public static final int GERMANY = 80;
	public static final int GHANA = 81;
	public static final int GIBRALTAR = 82;
	public static final int GREECE = 83;
	public static final int GREENLAND = 84;
	public static final int GRENADA = 85;
	public static final int GUADELOUPE = 86;
	public static final int GUAM = 87;
	public static final int GUATEMALA = 88;
	public static final int GUERNSEY = 89;
	public static final int GUINEA = 90;
	public static final int GUINEA_BISSAU = 91;
	public static final int GUYANA = 92;
	public static final int HAITI = 93;
	public static final int HEARD_ISLAND_AND_MCDONALD_ISLAND = 94;
	public static final int HONDURAS = 95;
	public static final int HONG_KONG = 96;
	public static final int HUNGARY = 97;
	public static final int ICELAND = 98;
	public static final int INDIA = 99;
	public static final int INDONESIA = 100;
	public static final int IRAN = 101;
	public static final int IRAQ = 102;
	public static final int IRELAND = 103;
	public static final int ISLE_OF_MAN = 104;
	public static final int ISRAEL = 105;
	public static final int ITALY = 106;
	public static final int IVORY_COAST = 107;
	public static final int JERSEY = 108;
	public static final int JAMAICA = 109;
	public static final int JORDAN = 110;
	public static final int JAPAN = 111;
	public static final int KAZAKHSTAN = 112;
	public static final int KENYA = 113;
	public static final int KIRIBATI = 114;
	public static final int KYRGYZSTAN = 115;
	public static final int KUWAIT = 116;
	public static final int LAOS = 117;
	public static final int LATVIA = 118;
	public static final int LEBANON = 119;
	public static final int LESOTHO = 120;
	public static final int LIBERIA = 121;
	public static final int LIBYA = 122;
	public static final int LIECHTENSTEIN = 123;
	public static final int LITHUANIA = 124;
	public static final int LUXEMBOURG = 125;
	public static final int MACAO = 126;
	public static final int MACEDONIA = 127;
	public static final int MADAGASCAR = 128;
	public static final int MALAWI = 129;
	public static final int MALAYSIA = 130;
	public static final int MALDIVES = 131;
	public static final int MALI = 132;
	public static final int MALTA = 133;
	public static final int MARSHALL_ISLANDS = 134;
	public static final int MARTINIQUE = 135;
	public static final int MAURITANIA = 136;
	public static final int MAURITIUS = 137;
	public static final int MAYOTTE = 138;
	public static final int MEXICO = 139;
	public static final int MICRONESIA = 140;
	public static final int MOLDOVA = 141;
	public static final int MONACO = 142;
	public static final int MONGOLIA = 143;
	public static final int MONTENEGRO = 144;
	public static final int MONTSERRAT = 145;
	public static final int MOROCCO = 146;
	public static final int MOZAMBIQUE = 147;
	public static final int MYANMAR = 148;
	public static final int NAMIBIA = 149;
	public static final int NAURU = 150;
	public static final int NEPAL = 151;
	public static final int NETHERLANDS = 152;
	public static final int NEW_CALEDONIA = 153;
	public static final int NEW_ZEALAND = 154;
	public static final int NICARAGUA = 155;
	public static final int NIGER = 156;
	public static final int NIGERIA = 157;
	public static final int NIUE = 158;
	public static final int NORFOLK_ISLAND = 159;
	public static final int NORTH_KOREA = 160;
	public static final int NORTHERN_MARIANA_ISLANDS = 161;
	public static final int NORWAY = 162;
	public static final int OMAN = 163;
	public static final int PAKISTAN = 164;
	public static final int PALAU = 165;
	public static final int PALESTINE = 166;
	public static final int PANAMA = 167;
	public static final int PAPUA_NEW_GUINEA = 168;
	public static final int PARAGUAY = 169;
	public static final int PERU = 170;
	public static final int PHILIPPINES = 171;
	public static final int PITCAIRN = 172;
	public static final int POLAND = 173;
	public static final int PORTUGAL = 174;
	public static final int PUERTO_RICO = 175;
	public static final int QATAR = 176;
	public static final int REUNION = 177;
	public static final int ROMANIA = 178;
	public static final int RUSSIA = 179;
	public static final int RWANDA = 180;
	public static final int SAINT_BARTHELEMY = 181;
	public static final int SAINT_LUCIA = 182;
	public static final int SAINT_MARTIN_DUTCH = 183;
	public static final int SAINT_MARTIN_FRENCH = 184;
	public static final int SAINT_PIERRE_AND_MIQUELON = 185;
	public static final int SAMOA = 186;
	public static final int SAN_MARINO = 187;
	public static final int SAO_TOME_AND_PRINCIPE = 188;
	public static final int SAUDI_ARABIA = 189;
	public static final int SENEGAL = 190;
	public static final int SERBIA = 191;
	public static final int SEYCHELLES = 192;
	public static final int SIERRA_LEONE = 193;
	public static final int SINGAPORE = 194;
	public static final int SLOVAKIA = 195;
	public static final int SLOVENIA = 196;
	public static final int SOLOMON_ISLANDS = 197;
	public static final int SOMALIA = 198;
	public static final int SOUTH_AFRICA = 199;
	public static final int SOUTH_GEORGIA_AND_SANDWICH_ISLANDS = 200;
	public static final int SOUTH_KOREA = 201;
	public static final int SOUTH_SUDAN = 202;
	public static final int SPAIN = 203;
	public static final int SRI_LANKA = 204;
	public static final int ST_HELENA_ASCENSION_TRISTAN_DA_CUNHA = 205;
	public static final int ST_KITTS_AND_NEVIS = 206;
	public static final int ST_VINCENT_AND_GRENADINES = 207;
	public static final int SUDAN = 208;
	public static final int SURINAME = 209;
	public static final int SVALBARD_AND_JAN_MAYEN = 210;
	public static final int SWAZILAND = 211;
	public static final int SWEDEN = 212;
	public static final int SWITZERLAND = 213;
	public static final int SYRIA = 214;
	public static final int TAIWAN = 215;
	public static final int TAJIKISTAN = 216;
	public static final int TANZANIA = 217;
	public static final int THAILAND = 218;
	public static final int TIMOR_LESTE = 219;
	public static final int TOGO = 220;
	public static final int TOKELAU = 221;
	public static final int TONGA = 222;
	public static final int TRINIDAD_AND_TOBAGO = 223;
	public static final int TUNISIA = 224;
	public static final int TURKEY = 225;
	public static final int TURKMENISTAN = 226;
	public static final int TURKS_AND_CAICOS_ISLANDS = 227;
	public static final int TUVALU = 228;
	public static final int UGANDA = 229;
	public static final int UKRAINE = 230;
	public static final int UNITED_ARAB_EMIRATES = 231;
	public static final int UNITED_KINGDOM = 232;
	public static final int UNITED_STATES = 233;
	public static final int UNITED_STATES_MINOR_OUTLYING_ISLANDS = 234;
	public static final int URUGUAY = 235;
	public static final int US_VIRGIN_ISLANDS = 236;
	public static final int UZBEKISTAN = 237;
	public static final int WALLLIS_AND_FUTANA = 238;
	public static final int WESTERN_SAHARA = 239;
	public static final int VANUATU = 240;
	public static final int VATICAN = 241;
	public static final int VENEZUELA = 242;
	public static final int VIETNAM = 243;
	public static final int YEMEN = 244;
	public static final int ZAMBIA = 245;
	public static final int ZIMBABWE = 246;
	public static final int ISSO2 = 0;
	public static final int ISSO3 = 1;
	//Constants
	//Private variables
	private Vector<Vector<String>> codes = new Vector<Vector<String>>();
	//Public variables

	//Constructors

	//Static methods
	//Public methods
	public String getISSO2(int country) {
		return codes.elementAt(country).elementAt(1);
	}
	
	public String getISSO3(int country) {
		return codes.elementAt(country).elementAt(2);
	}
	//Private methods
	private void init() {
		loadISSO();
	}
	
	private void loadISSO () {
		for (int i = 0; i < 247; i++) {
			Vector<String> codes = new Vector<String>();
			switch (i) {
				case(0) :{
					codes.add("AF");
					break;
				}
				case(1) :{
					codes.add("AL");
					break;
				}
				case(2) :{
					codes.add("DZ");
					break;
				}
				case(3) :{
					codes.add("AD");
					break;
				}
				case(4) :{
					codes.add("AO");
					break;
				}
				case(5) :{
					codes.add("AI");
					break;
				}
				case(6) :{
					codes.add("AQ");
					break;
				}
				case(7) :{
					codes.add("AG");
					break;
				}
				case(8) :{
					codes.add("AR");
					break;
				}
				case(9) :{
					codes.add("AS");
					break;
				}
				case(10) :{
					codes.add("AM");
					break;
				}
				case(11) :{
					codes.add("AW");
					break;
				}
				case(12) :{
					codes.add("AU");
					break;
				}
				case(13) :{
					codes.add("AT");
					break;
				}
				case(14) :{
					codes.add("AX");
					break;
				}
				case(15) :{
					codes.add("AZ");
					break;
				}
				case(16) :{
					codes.add("BS");
					break;
				}
				case(17) :{
					codes.add("BH");
					break;
				}
				case(18) :{
					codes.add("BD");
					break;
				}
				case(19) :{
					codes.add("BB");
					break;
				}
				case(20) :{
					codes.add("BY");
					break;
				}
				case(21) :{
					codes.add("BE");
					break;
				}
				case(22) :{
					codes.add("BZ");
					break;
				}
				case(23) :{
					codes.add("BJ");
					break;
				}
				case(24) :{
					codes.add("BM");
					break;
				}
				case(25) :{
					codes.add("BT");
					break;
				}
				case(26) :{
					codes.add("BO");
					break;
				}
				case(27) :{
					codes.add("BQ");
					break;
				}
				case(28) :{
					codes.add("BA");
					break;
				}
				case(29) :{
					codes.add("BW");
					break;
				}
				case(30) :{
					codes.add("BV");
					break;
				}
				case(31) :{
					codes.add("BR");
					break;
				}
				case(32) :{
					codes.add("IO");
					break;
				}
				case(33) :{
					codes.add("VG");
					break;
				}
				case(34) :{
					codes.add("BN");
					break;
				}
				case(35) :{
					codes.add("BG");
					break;
				}
				case(36) :{
					codes.add("BF");
					break;
				}
				case(37) :{
					codes.add("BI");
					break;
				}
				case(38) :{
					codes.add("CM");
					break;
				}
				case(39) :{
					codes.add("KH");
					break;
				}
				case(40) :{
					codes.add("CA");
					break;
				}
				case(41) :{
					codes.add("CV");
					break;
				}
				case(42) :{
					codes.add("KY");
					break;
				}
				case(43) :{
					codes.add("CF");
					break;
				}
				case(44) :{
					codes.add("TD");
					break;
				}
				case(45) :{
					codes.add("CL");
					break;
				}
				case(46) :{
					codes.add("CN");
					break;
				}
				case(47) :{
					codes.add("CO");
					break;
				}
				case(48) :{
					codes.add("KM");
					break;
				}
				case(49) :{
					codes.add("CG");
					break;
				}
				case(50) :{
					codes.add("CK");
					break;
				}
				case(51) :{
					codes.add("CR");
					break;
				}
				case(52) :{
					codes.add("HR");
					break;
				}
				case(53) :{
					codes.add("CU");
					break;
				}
				case(54) :{
					codes.add("CW");
					break;
				}
				case(55) :{
					codes.add("CY");
					break;
				}
				case(56) :{
					codes.add("CZ");
					break;
				}
				case(57) :{
					codes.add("CD");
					break;
				}
				case(58) :{
					codes.add("DK");
					break;
				}
				case(59) :{
					codes.add("DM");
					break;
				}
				case(60) :{
					codes.add("DO");
					break;
				}
				case(61) :{
					codes.add("DJ");
					break;
				}
				case(62) :{
					codes.add("EC");
					break;
				}
				case(63) :{
					codes.add("EG");
					break;
				}
				case(64) :{
					codes.add("SV");
					break;
				}
				case(65) :{
					codes.add("GQ");
					break;
				}
				case(66) :{
					codes.add("ER");
					break;
				}
				case(67) :{
					codes.add("EE");
					break;
				}
				case(68) :{
					codes.add("ET");
					break;
				}
				case(69) :{
					codes.add("FK");
					break;
				}
				case(70) :{
					codes.add("FO");
					break;
				}
				case(71) :{
					codes.add("FJ");
					break;
				}
				case(72) :{
					codes.add("FI");
					break;
				}
				case(73) :{
					codes.add("FR");
					break;
				}
				case(74) :{
					codes.add("GF");
					break;
				}
				case(75) :{
					codes.add("PF");
					break;
				}
				case(76) :{
					codes.add("TF");
					break;
				}
				case(77) :{
					codes.add("GA");
					break;
				}
				case(78) :{
					codes.add("GM");
					break;
				}
				case(79) :{
					codes.add("GE");
					break;
				}
				case(80) :{
					codes.add("DE");
					break;
				}
				case(81) :{
					codes.add("GH");
					break;
				}
				case(82) :{
					codes.add("GI");
					break;
				}
				case(83) :{
					codes.add("GR");
					break;
				}
				case(84) :{
					codes.add("GL");
					break;
				}
				case(85) :{
					codes.add("GD");
					break;
				}
				case(86) :{
					codes.add("GP");
					break;
				}
				case(87) :{
					codes.add("GU");
					break;
				}
				case(88) :{
					codes.add("GT");
					break;
				}
				case(89) :{
					codes.add("GG");
					break;
				}
				case(90) :{
					codes.add("GN");
					break;
				}
				case(91) :{
					codes.add("GW");
					break;
				}
				case(92) :{
					codes.add("GY");
					break;
				}
				case(93) :{
					codes.add("HT");
					break;
				}
				case(94) :{
					codes.add("HM");
					break;
				}
				case(95) :{
					codes.add("HN");
					break;
				}
				case(96) :{
					codes.add("HK");
					break;
				}
				case(97) :{
					codes.add("HU");
					break;
				}
				case(98) :{
					codes.add("IS");
					break;
				}
				case(99) :{
					codes.add("IN");
					break;
				}
				case(100) :{
					codes.add("ID");
					break;
				}
				case(101) :{
					codes.add("IR");
					break;
				}
				case(102) :{
					codes.add("IQ");
					break;
				}
				case(103) :{
					codes.add("IE");
					break;
				}
				case(104) :{
					codes.add("IM");
					break;
				}
				case(105) :{
					codes.add("IL");
					break;
				}
				case(106) :{
					codes.add("IT");
					break;
				}
				case(107) :{
					codes.add("CI");
					break;
				}
				case(108) :{
					codes.add("JE");
					break;
				}
				case(109) :{
					codes.add("JM");
					break;
				}
				case(110) :{
					codes.add("JO");
					break;
				}
				case(111) :{
					codes.add("JP");
					break;
				}
				case(112) :{
					codes.add("KZ");
					break;
				}
				case(113) :{
					codes.add("KE");
					break;
				}
				case(114) :{
					codes.add("KI");
					break;
				}
				case(115) :{
					codes.add("KG");
					break;
				}
				case(116) :{
					codes.add("KW");
					break;
				}
				case(117) :{
					codes.add("LA");
					break;
				}
				case(118) :{
					codes.add("LV");
					break;
				}
				case(119) :{
					codes.add("LB");
					break;
				}
				case(120) :{
					codes.add("LS");
					break;
				}
				case(121) :{
					codes.add("LR");
					break;
				}
				case(122) :{
					codes.add("LY");
					break;
				}
				case(123) :{
					codes.add("LI");
					break;
				}
				case(124) :{
					codes.add("LT");
					break;
				}
				case(125) :{
					codes.add("LU");
					break;
				}
				case(126) :{
					codes.add("MO");
					break;
				}
				case(127) :{
					codes.add("MK");
					break;
				}
				case(128) :{
					codes.add("MG");
					break;
				}
				case(129) :{
					codes.add("MW");
					break;
				}
				case(130) :{
					codes.add("MY");
					break;
				}
				case(131) :{
					codes.add("MV");
					break;
				}
				case(132) :{
					codes.add("ML");
					break;
				}
				case(133) :{
					codes.add("MT");
					break;
				}
				case(134) :{
					codes.add("MH");
					break;
				}
				case(135) :{
					codes.add("MQ");
					break;
				}
				case(136) :{
					codes.add("MR");
					break;
				}
				case(137) :{
					codes.add("MU");
					break;
				}
				case(138) :{
					codes.add("YT");
					break;
				}
				case(139) :{
					codes.add("MX");
					break;
				}
				case(140) :{
					codes.add("FM");
					break;
				}
				case(141) :{
					codes.add("MD");
					break;
				}
				case(142) :{
					codes.add("MC");
					break;
				}
				case(143) :{
					codes.add("MN");
					break;
				}
				case(144) :{
					codes.add("ME");
					break;
				}
				case(145) :{
					codes.add("MS");
					break;
				}
				case(146) :{
					codes.add("MA");
					break;
				}
				case(147) :{
					codes.add("MZ");
					break;
				}
				case(148) :{
					codes.add("MM");
					break;
				}
				case(149) :{
					codes.add("NA");
					break;
				}
				case(150) :{
					codes.add("NR");
					break;
				}
				case(151) :{
					codes.add("NP");
					break;
				}
				case(152) :{
					codes.add("NL");
					break;
				}
				case(153) :{
					codes.add("NC");
					break;
				}
				case(154) :{
					codes.add("NZ");
					break;
				}
				case(155) :{
					codes.add("NI");
					break;
				}
				case(156) :{
					codes.add("NE");
					break;
				}
				case(157) :{
					codes.add("NG");
					break;
				}
				case(158) :{
					codes.add("NU");
					break;
				}
				case(159) :{
					codes.add("");
					break;
				}
				case(160) :{
					codes.add("");
					break;
				}
				case(161) :{
					codes.add("");
					break;
				}
				case(162) :{
					codes.add("");
					break;
				}
				case(163) :{
					codes.add("");
					break;
				}
				case(164) :{
					codes.add("");
					break;
				}
				case(165) :{
					codes.add("");
					break;
				}
				case(166) :{
					codes.add("");
					break;
				}
				case(167) :{
					codes.add("");
					break;
				}
				case(168) :{
					codes.add("");
					break;
				}
				case(169) :{
					codes.add("");
					break;
				}
				case(170) :{
					codes.add("");
					break;
				}
				case(171) :{
					codes.add("");
					break;
				}
				case(172) :{
					codes.add("");
					break;
				}
				case(173) :{
					codes.add("");
					break;
				}
				case(174) :{
					codes.add("");
					break;
				}
				case(175) :{
					codes.add("");
					break;
				}
				case(176) :{
					codes.add("");
					break;
				}
				case(177) :{
					codes.add("");
					break;
				}
				case(178) :{
					codes.add("");
					break;
				}
				case(179) :{
					codes.add("");
					break;
				}
				case(180) :{
					codes.add("");
					break;
				}
				case(181) :{
					codes.add("");
					break;
				}
				case(182) :{
					codes.add("");
					break;
				}
				case(183) :{
					codes.add("");
					break;
				}
				case(184) :{
					codes.add("");
					break;
				}
				case(185) :{
					codes.add("");
					break;
				}
				case(186) :{
					codes.add("");
					break;
				}
				case(187) :{
					codes.add("");
					break;
				}
				case(188) :{
					codes.add("");
					break;
				}
				case(189) :{
					codes.add("");
					break;
				}
				case(190) :{
					codes.add("");
					break;
				}
				case(191) :{
					codes.add("");
					break;
				}
				case(192) :{
					codes.add("");
					break;
				}
				case(193) :{
					codes.add("");
					break;
				}
				case(194) :{
					codes.add("");
					break;
				}
				case(195) :{
					codes.add("");
					break;
				}
				case(196) :{
					codes.add("");
					break;
				}
				case(197) :{
					codes.add("");
					break;
				}
				case(198) :{
					codes.add("");
					break;
				}
				case(199) :{
					codes.add("");
					break;
				}
				case(200) :{
					codes.add("");
					break;
				}
				case(201) :{
					codes.add("");
					break;
				}
				case(202) :{
					codes.add("");
					break;
				}
				case(203) :{
					codes.add("");
					break;
				}
				case(204) :{
					codes.add("");
					break;
				}
				case(205) :{
					codes.add("");
					break;
				}
				case(206) :{
					codes.add("");
					break;
				}
				case(207) :{
					codes.add("");
					break;
				}
				case(208) :{
					codes.add("");
					break;
				}
				case(209) :{
					codes.add("");
					break;
				}
				case(210) :{
					codes.add("");
					break;
				}
				case(211) :{
					codes.add("");
					break;
				}
				case(212) :{
					codes.add("");
					break;
				}
				case(213) :{
					codes.add("");
					break;
				}
				case(214) :{
					codes.add("");
					break;
				}
				case(215) :{
					codes.add("");
					break;
				}
				case(216) :{
					codes.add("");
					break;
				}
				case(217) :{
					codes.add("");
					break;
				}
				case(218) :{
					codes.add("");
					break;
				}
				case(219) :{
					codes.add("");
					break;
				}
				case(220) :{
					codes.add("");
					break;
				}
				case(221) :{
					codes.add("");
					break;
				}
				case(222) :{
					codes.add("");
					break;
				}
				case(223) :{
					codes.add("");
					break;
				}
				case(224) :{
					codes.add("");
					break;
				}
				case(225) :{
					codes.add("");
					break;
				}
				case(226) :{
					codes.add("");
					break;
				}
				case(227) :{
					codes.add("");
					break;
				}
				case(228) :{
					codes.add("");
					break;
				}
				case(229) :{
					codes.add("");
					break;
				}
				case(230) :{
					codes.add("");
					break;
				}
				case(231) :{
					codes.add("");
					break;
				}
				case(232) :{
					codes.add("");
					break;
				}
				case(233) :{
					codes.add("");
					break;
				}
				case(234) :{
					codes.add("");
					break;
				}
				case(235) :{
					codes.add("");
					break;
				}
				case(236) :{
					codes.add("");
					break;
				}
				case(237) :{
					codes.add("");
					break;
				}
				case(238) :{
					codes.add("");
					break;
				}
				case(239) :{
					codes.add("");
					break;
				}
				case(240) :{
					codes.add("");
					break;
				}
				case(241) :{
					codes.add("");
					break;
				}
				case(242) :{
					codes.add("");
					break;
				}
				case(243) :{
					codes.add("");
					break;
				}
				case(244) :{
					codes.add("");
					break;
				}
				case(245) :{
					codes.add("");
					break;
				}
				case(246) :{
					codes.add("");
					break;
				}
			}
		}
	}

}
