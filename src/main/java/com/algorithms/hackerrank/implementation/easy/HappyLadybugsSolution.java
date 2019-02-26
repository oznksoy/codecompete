package com.algorithms.hackerrank.implementation.easy;

public class HappyLadybugsSolution {

	/**
	 * Complete the happyLadybugs function in the editor below. It should return an
	 * array of strings, either 'YES' or 'NO', one for each test string.
	 * <p>
	 * 1 <= g, n <= 100
	 * </p>
	 * 
	 * @param b:an array of strings that represents the initial positions and colors
	 *        of the ladybugs b[i] includes { '_' , ascii[A-Z]}
	 * @return
	 */
	static String happyLadybugs(String b) {

		// If there are no _ chars, it is not possible to swap characters.
		// It is not necessary to know how many swaps occur.
		// there should be (count % 2 == 0) chars of each, except _
		// full _ inputs are valid.

		char empty = '_';

		String x = String.valueOf(b);
		for (int i = 0; i < x.length() - 1; i++) {
			char compared = x.charAt(i);
			boolean isUnpaired = true;
			for (int j = i + 1; j < x.length(); j++) {
				char toCompare = x.charAt(j);
				if (compared != empty && compared == toCompare) {
					isUnpaired = false;
					x = x.replaceAll(String.valueOf(compared), String.valueOf(empty));
					break;
				}
			}
			if (compared != empty && isUnpaired) {
				return "NO";
			}
		}
		if (x.codePointAt(x.length() - 1) != empty) {
			return "NO";
		}

		boolean isEmptyCharExists = false;
		for (int i = 0; i < b.length(); i++) {
			char toCompare = b.charAt(i);
			if (toCompare == empty) {
				isEmptyCharExists = true;
				break;
			}
		}
		if (isEmptyCharExists) {
			return "YES";
		}

		// else if (!isEmptyCharExists && !isUnpairedExists)
		// Does isUnhappyExits ? "NO" : "YES";

		if (b.length() < 2) {
			return "NO";
		} else if (b.charAt(0) != b.charAt(1)) {
			return "NO";
		} else if (b.charAt(b.length() - 2) != b.charAt(b.length() - 1)) {
			return "NO";
		} else {
			for (int i = 1; i < b.length() - 1; i++) {
				char toCompare = b.charAt(i);
				char comparedLeft = b.charAt(i - 1);
				char comparedRight = b.charAt(i + 1);
				if (comparedLeft != toCompare && comparedRight != toCompare) {
					return "NO";
				}
			}
		}

		return "YES";

	}// End of Method

	public static void main(String[] args) {

		testHappyLadybugs("RBY_YBR", "YES");
		testHappyLadybugs("X_Y__X", "NO");
		testHappyLadybugs("__", "YES");
		testHappyLadybugs("B_RRBR", "YES");

		testHappyLadybugs("AABBC", "NO");
		testHappyLadybugs("AABBC_C", "YES");
		testHappyLadybugs("_", "YES");
		testHappyLadybugs("DD__FQ_QQF", "YES");
		testHappyLadybugs("AABCBC", "NO");

		testHappyLadybugs("_ABC", "NO");
		testHappyLadybugs("___A_B_C__", "NO");
		testHappyLadybugs("___AA_AB_BC__C", "YES");
		testHappyLadybugs("AAABBCC", "YES");
		testHappyLadybugs("AAABBCCXVYXV", "NO");
		testHappyLadybugs("R", "NO");

		testHappyLadybugs("GNC_OGTQCW_R__QLKQ_NG_GOWCNWKWCNGR____OQ__OW_TOGC_", "NO");
		testHappyLadybugs(
				"_ZUICLOO__CF_L_WC__ELH_GMANSTUYSZUEUOOF_FAWLFZILCLZ_WSSIIGSFMCHYH_SHI_CCGAEUSSUE___H_GF_L_USCCSCL",
				"NO");
		testHappyLadybugs("DEBGBVLKKWWEXHBEG_IMQKEAEE_NYBVEXHWAAMEHGLEKEKKBENBEWEKVENDEAAVLEBMWAEEDBKLBEEQBKXNHGUUE",
				"NO");
		testHappyLadybugs("VVJ_FW_FNNICOM_WLLRKYSN_HB_L_FBYY_NKLNNWH_LVRMHV__WWYNJ_WCFYO_HWULN_WNWF_F__YWLLC_LWLKL",
				"NO");
		testHappyLadybugs("IRMH_ILBSJDXBBMGRVMYROPVVMU_XXXRHUMRRMBJJMRIMSMPIGUBBBXSBDIVBLHBMXSVOXIGMLMRHMXPIO", "NO");
		testHappyLadybugs("GPWUY_WUPLGLULWUUGPP", "NO");
		testHappyLadybugs("UHNHEOOPAGWICFTWYXEOQWYWIEF_GWYOYOHHFEPWIFGYIWCXWOTUEGIEYUCUFIWOIPOOWYOAEHF_IWEHGTYYYO",
				"NO");
		testHappyLadybugs(
				"IHHC_CGTR__AEW_U_W_LGZTBXX_IFOXZK_CG_B__UW_RAHWWGCEXWHB_ZH_C_TCTTHWIIHRXWLIHR_WXLOZZZA__ZR__GA_UT_L",
				"NO");
		testHappyLadybugs("YJWHTS_AQIDUZAHJUT_ADUQY_ASTSIIDUZDAW_A_UAA", "YES");
		testHappyLadybugs("QMXLUAMH_WFS__DBAE_BUHDXALEBL_AAD_XB_AAMH_SQFQ__LFMDSAE_WE", "YES");
		testHappyLadybugs("ORROOORX", "NO");
		testHappyLadybugs("QR_UY_VWATNK_QKU_TU_VTUW__WURVQ_YNTTW", "NO");
		testHappyLadybugs("NZRRL__GBWUL_IYFFRJLYLZLFFYYYFRLYLILFRNYNBGWRBLJJ_GLFJN_RL", "NO");
		testHappyLadybugs("LLLZ", "NO");
		testHappyLadybugs("DXSOSDLXDLXXD", "NO");
		testHappyLadybugs("NJIQ_ASQTTQHCRNU_VZY_JZRD_H_A_THQDNY_I__R__SJIN__ITIQRQ_TAUNRVUA__CQQDARQTZZRD_DQXZDVRUHVNU",
				"NO");
		testHappyLadybugs("RWWSDFXJEKCRCCCCRKFCWXXFCFCEEWDJJEDFR", "NO");
		testHappyLadybugs(
				"_SRGKOJUBKZCNSK_OPZ_DZ_E_V_NMHGVN_ZOOGD__GMZSGZNVSVVHE__GOZSOD_S_ZUKGVB_O__GG____SOEGKH_ZJ_B_OKK",
				"NO");
		testHappyLadybugs("T__U_KG_JJXR_DQ__EAGJRTXOTDHLTTTGHDODDJHD____QXDKXO_HJ__R_UEAGR_DG_JDTT_DDOLHOKG_JXHUJ_G",
				"YES");
		testHappyLadybugs("NRBI__SARKUWPXAMSAWTMRSB_A_SIARUWRWRRKP_MS__IWRXXURRA_MU_A_WWAAX", "NO");
		testHappyLadybugs("OIRBIIORBOIIIOIB_", "YES");
		testHappyLadybugs("_XA_B_ABAA", "NO");
		testHappyLadybugs("__", "YES");
		testHappyLadybugs("EPZ_ASUVN_GHDTNODBPATDZUVRCONENTRRVHGBPDRDVNUVUGTVAUTVTPTZOHVUGUDR_UDOZBUTHGNRE_PHH", "NO");
		testHappyLadybugs("NP_OOQAEHPO_Q_ONAPHQQEQHQHOQAOOOOEO", "YES");
		testHappyLadybugs("E_C_AFNEFTAJQAV___E_QQDQJ_A_QFAC_FVFECD_QAACQEFAFD", "NO");
		testHappyLadybugs("KVD_R___YVTPJFQVCJVIWH__I_ATVFWI_J_J_PQPVJIVFF_LCD_TVJIK_TV__QFVVH_QL_RH_DLIKTWV_AV_PA",
				"NO");
		testHappyLadybugs(
				"UAHS_PF_GCIVJVPUW__ZCB_O_MBJLNZJZV_VOHUNAU_ZABZVMV_VVVPNOBBSVS_VPSZZB_AWBULI_BVUBVMJ_V_AGJONMB", "NO");
		testHappyLadybugs("DL_CIWWA_D_DCWCIC__CCLDCACWI", "YES");
		testHappyLadybugs("RGCVYFNRYHH_NAYGWYGRAVFYHYYNHHNGF_RCCAGYWRAFYYNC", "YES");
		testHappyLadybugs("R_EOVZ__N_PH_AQPPQRGVIDXVHP__PGP_GEOPRDQD_XGI_RN_HVN_NPVPO__DA_VHO_Q_PV___", "NO");
		testHappyLadybugs("YYBY_VUHN_K_AGZEE_J_R_H_PQZJGEZY_R_Z_J_Z_GN_JH___VJJ__HHEEY___PHE_ZUBNNZV_E_KB___E", "NO");
		testHappyLadybugs("FINOSXKGYJ_KKXZ_DL_XNDIJKKYJLKKXXGJYYNK_XLZKDKJNXXXSGK", "NO");
		testHappyLadybugs("_OB_AWS_IZ__KZIOIHELSA_KZ__K_H_S__IIAZAIBEOK_ZILLEO_AI__SS_O__HIIWHO", "YES");
		testHappyLadybugs("XMHCBS_DXDIDSBHMHXXDHSM_SH", "NO");
		testHappyLadybugs("PQXSOQSPOPQPPOSQP", "NO");
		testHappyLadybugs("XNWO_PTWCIHDZRFKVNYUKPJTRQTUTUQFVYZTWDODJKTKZNURTXNKKKTQHNCVPDICXWQKKZJWJVNU_KCR", "YES");
		testHappyLadybugs("MU_T_PJGELNJ_PJUGGEMJ_UENMTJD_UMD", "NO");
		testHappyLadybugs("C_HQB_BQ_QQHJHB_BH_Q", "NO");
		testHappyLadybugs("FKG_I_N_U__K__GIIN__FN____KF__", "NO");
		testHappyLadybugs("Y_EOYRTYOREOTYREY_YRYYO", "YES");
		testHappyLadybugs("GGG_UK_KM_GMU__AXJ__GJAKG__MKXGK_UJ_G___KGKGUM_GUK__X_GGU", "YES");
		testHappyLadybugs("QRRTXMGJLVL__VN_____XRVJ_LLXXLTXR__JNJXX_G_GNMN_V","NO");
		testHappyLadybugs("LS_FNQQINWRZOWBWBNIORI_ZLNNSZISIWNFOFSFFLOWIBZRWFX", "NO");
		testHappyLadybugs("SOA_KHEW_KOA_KAS_W_AWWSSOWAO_", "NO");
		testHappyLadybugs("_ZC_BOXWELEFANBFI_CCLSZTKQWUC_CILEZCBZWNWZEECO__EWCLLXCFNWELQFBFSNFONCIE_QCZBCTEQXBTTBBXB",
				"NO");
		testHappyLadybugs("MFSYBHHYMYBBMXHXFYYM", "NO");
		testHappyLadybugs("NWSJRWUIEIUNWSIRJNIWNLRLIIS", "NO");
		testHappyLadybugs("YITUSDK_STDESSKKUYI_ITYKT_", "NO");
		testHappyLadybugs("FYNGP_JPO_JVLWUCTGHA_W_KP_VO_WHGGP_OGJJ_FAHNT_JWWYPPCQGNYPP_P_UC_TOA_GJWJHP", "NO");
		testHappyLadybugs("T_EVWGWNUPEBM_DDZVUEETWUVVEEAWVE_NAGEEDATBBVN_DPTVUPDVEGBE", "NO");
		testHappyLadybugs("_ESSVSVV_S", "NO");
		testHappyLadybugs("PL_TDYNIIRDVXEPZRDIVIN_LXRILPVTPTEVRZNILEVVDVYEREYD", "YES");
		testHappyLadybugs("ZQMD__CLNCRMMSGNCMMZR_DSMQ_SMQMSS_LCNM_QLDMMZ", "NO");
		testHappyLadybugs("YPUSQYYUPSSQPYUQRSPUPYQUPUSSUSYY", "NO");
		testHappyLadybugs("DBPCSTIOW_SVKAAOXMSPOMOOSSXSXDOTCVAOWUCBMVCXD_DDVSKITU", "YES");
		testHappyLadybugs("_K_VZBK__G_VZ_VGK_____V_VZK_ZKG__", "NO");
		testHappyLadybugs("MQXP_K__LFQQ__Q__XQ____XQ__LM_F_", "NO");
		testHappyLadybugs("WJOVRHVXSR_JLMJVG_BEBR_HVYUCTBYHJ_UY__C_BVXUG_VCRG_VRVJGTREUUBBN_OVXBUTJXMUYCVBHCUJWTURJJ",
				"NO");

	}// End of Main

	static void testHappyLadybugs(String b, String expected) {
		String result = happyLadybugs(b);
		System.out.println("Result : " + result);
		assert expected.equals(result);
	}// End of Test

}// End of Class
