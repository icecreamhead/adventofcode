package com.icecreamhead.adventofcode.seven;

import junit.framework.TestCase;

import org.assertj.core.api.Assertions;

import java.util.regex.Matcher;

import static com.icecreamhead.adventofcode.seven.TowerResolver.READER;
import static org.assertj.core.api.Assertions.assertThat;

public class TowerTest {

  private final TowerResolver resolver = new TowerResolver();

  private static final String TEST_INPUT =
      "pbga (66)\n" +
          "xhth (57)\n" +
          "ebii (61)\n" +
          "havc (66)\n" +
          "ktlj (57)\n" +
          "fwft (72) -> ktlj, cntj, xhth\n" +
          "qoyq (66)\n" +
          "padx (45) -> pbga, havc, qoyq\n" +
          "tknk (41) -> ugml, padx, fwft\n" +
          "jptl (61)\n" +
          "ugml (68) -> gyxo, ebii, jptl\n" +
          "gyxo (61)\n" +
          "cntj (57)";

  public void testLongPattern() throws Exception {
    Matcher matcher = READER.matcher("ugml (68) -> gyxo, ebii, jptl");

    assertThat(matcher.matches()).isTrue();
    for (int i = 1; i < matcher.groupCount(); i++) {
      System.out.println(matcher.group(i));
    }
    assertThat(matcher.groupCount()).isEqualTo(4);
    assertThat(matcher.group(1)).isEqualTo("ugml");
    assertThat(matcher.group(2)).isEqualTo("68");
    assertThat(matcher.group(3)).isEqualTo("gyxo, ebii, jptl");
  }

  public void testShortPattern() throws Exception {
    Matcher matcher = READER.matcher("pbga (66)");

    assertThat(matcher.matches()).isTrue();
    for (int i = 1; i < matcher.groupCount(); i++) {
      System.out.println(matcher.group(i));
    }
    assertThat(matcher.groupCount()).isEqualTo(4);
    assertThat(matcher.group(1)).isEqualTo("pbga");
    assertThat(matcher.group(2)).isEqualTo("66");
    assertThat(matcher.group(3)).isEqualTo(null);
  }

  public void testPart1() throws Exception {
    assertThat(resolver.findRoot(TEST_INPUT)).isEqualTo("tknk");
  }

  public void testPart2() throws Exception {
    assertThat(resolver.findIncorrectWeight(TEST_INPUT)).isEqualTo("10");
  }

  public void testPart1Solution() throws Exception {
    System.out.println(resolver.findRoot(PUZZLE_INPUT));
  }

  public void testPart2Solution() throws Exception {
    System.out.println(resolver.findIncorrectWeight(PUZZLE_INPUT));
  }

  private static final String PUZZLE_INPUT = "hndzyx (28)\n" +
      "kdelzk (399)\n" +
      "uylvg (403) -> xrvcjq, hihltxf, junpjcj, onkvtu, cckdoyb, favay, xsygurk\n" +
      "jiyqd (842) -> vunjzqr, sfooljn, gsnlv\n" +
      "mxmzyac (67) -> pbwmrq, eiqjanp, dyanei, zmkuj, vkvvtm, ktlhztg\n" +
      "wspoq (19) -> chpxtc, mylibd, vmutmbz\n" +
      "obqyrh (55)\n" +
      "inzzz (94) -> ayevuhk, rstjsa\n" +
      "mgraypm (108) -> ivvcytp, iaabs\n" +
      "eiqvo (87)\n" +
      "kienpis (32)\n" +
      "ohjesb (115) -> piepj, tplrep, yprilie\n" +
      "vthvyt (28)\n" +
      "vmyqa (5)\n" +
      "whavaec (79)\n" +
      "kpkcku (169) -> wprvgb, ektvj\n" +
      "amtxnd (99)\n" +
      "yauplaz (5) -> gnstbtt, ivucxwy, htoep, crgver\n" +
      "saaggxs (399)\n" +
      "kddqkkz (348)\n" +
      "tgcmyr (63) -> setljkt, qpyiycr\n" +
      "fhjpe (52)\n" +
      "tlirtlm (47)\n" +
      "xvkdd (15)\n" +
      "ybneks (12594) -> immqut, csprk, eyjif, oykud, bazfmo, nbmup, bxabcu\n" +
      "nwuxy (44)\n" +
      "trepya (17)\n" +
      "ibzuz (11301) -> dcqdop, pzpltg, xqzsy\n" +
      "acwne (28) -> gliupmb, hcwly\n" +
      "fcmspin (11992) -> thblrfo, rcsthxt, bmbkh, gnqdxl\n" +
      "pbwmrq (286) -> rupwawl, snqbfd\n" +
      "ivucxwy (64)\n" +
      "abaox (123) -> znltrss, hvfbx\n" +
      "udpwvnp (64)\n" +
      "fddgtmo (13)\n" +
      "gcult (71)\n" +
      "bykobk (1224) -> oaonzl, giiie, pdwwc\n" +
      "xrzdoz (84)\n" +
      "wwtxe (9)\n" +
      "cafeffy (311) -> wjwqs, qezwnc\n" +
      "lqimnfv (58) -> hekghqb, csirnil, ndnmvz\n" +
      "jjdzuw (9)\n" +
      "nbmup (360) -> ziouqpy, ilyaln, vecsik\n" +
      "zmukql (24)\n" +
      "tdxsvy (20)\n" +
      "qxtttuu (80)\n" +
      "fufgis (196) -> cdewiot, zdekdn\n" +
      "tgken (84)\n" +
      "leymr (98) -> msxnc, xxgvcq\n" +
      "rwhbcy (171) -> wmhwmv, yjdmkg\n" +
      "lncyf (93)\n" +
      "yhzue (994) -> mofidvl, xjghf, detpnh\n" +
      "lkfjzec (22)\n" +
      "khydeiy (53)\n" +
      "laxksv (35)\n" +
      "cmgap (28)\n" +
      "risnzi (84)\n" +
      "xmnqwd (249) -> ovsqv, qbdrnwf\n" +
      "wvrvgio (22)\n" +
      "vycfxv (20)\n" +
      "hacbd (93)\n" +
      "evmfp (254) -> ezfoih, xnyma, ltalmp\n" +
      "hrxxih (50)\n" +
      "jybwslx (1227) -> nadjis, qomycms, dmswq\n" +
      "mnvip (79)\n" +
      "kfvzter (233) -> aiizew, piuudr\n" +
      "pmtkuu (71)\n" +
      "vlujgrg (72)\n" +
      "hweuik (213) -> zdlyf, omdnuon\n" +
      "hymjivf (28) -> xrdkdkq, tonljgn, vcitv, wcufjj, ykcmzu, pgefkd\n" +
      "hdpqb (115) -> ecrdh, wnxya\n" +
      "eqcmflu (73)\n" +
      "euhmwat (89) -> jishckj, datzi, wjrjt, evmfp, mpgkscw\n" +
      "ywdvft (333) -> bktgoug, fufgis, dbkhupp, lhcndy, nggfb, tdgeaw, kdsmtx\n" +
      "kcfqe (33) -> guyzk, osnpcl, pejys, xbvlp\n" +
      "csirnil (43)\n" +
      "zzlopja (2024) -> opgjd, cigdar, olxbw\n" +
      "sakrb (82)\n" +
      "vpfaa (79)\n" +
      "hlsoeh (2786) -> prgfkm, eoabav, agfxi\n" +
      "ggdcjbd (120) -> hzfgjnm, qihokeg\n" +
      "qpyiycr (49)\n" +
      "vhyiaf (96) -> ghhwci, eudtoy, ceofy, kbzfvrp, ibzuz, vgkvnu, vmjcif\n" +
      "ysmrs (24)\n" +
      "pdwwc (235) -> iagng, hndzyx\n" +
      "knmdxw (57)\n" +
      "jijjnbw (34) -> xtqrjc, jqfou\n" +
      "uynpswf (98)\n" +
      "gxxwgu (73)\n" +
      "fmufi (124) -> lhcegk, uypiw\n" +
      "tzyav (40)\n" +
      "ystegvn (33)\n" +
      "xfyybbx (56)\n" +
      "eyjif (84) -> jvvnvo, yenoyh, yjldllm, dzcyze, acwne, wycdpt\n" +
      "ojjnnko (572) -> zmaxz, pqiivg, xmnqwd\n" +
      "cscdc (171) -> ynpehry, fbbcf\n" +
      "nczrlw (2351) -> jvhvlo, vrypfpq, egtdt\n" +
      "srozv (47)\n" +
      "kinfgwy (84)\n" +
      "qlscb (37) -> jlbbmrc, iehag, endqfm, ohksn\n" +
      "zlgewg (80)\n" +
      "ibqev (78)\n" +
      "edkcs (33)\n" +
      "gneen (33) -> vkeqd, bmfkrnb\n" +
      "zmtzfbt (68)\n" +
      "wnxbu (295)\n" +
      "qbsvwcc (45)\n" +
      "lclup (94)\n" +
      "wycdpt (170) -> btlvmkx, denjcv, iutqxkf\n" +
      "wxjne (287) -> blvgj, fddgtmo\n" +
      "ibuzkf (18)\n" +
      "wqhxpu (63)\n" +
      "gpmfjj (113) -> ioypyd, srozv\n" +
      "sowli (43)\n" +
      "rtfmatr (6)\n" +
      "knxli (53) -> qdbendr, zbpsmm, djfnwv, dsuhkja\n" +
      "yhcsmfs (88)\n" +
      "sthzqgi (17)\n" +
      "jujtux (99)\n" +
      "rpagi (166) -> rjrlumz, utoyap\n" +
      "cqrqt (52)\n" +
      "jgtnj (15)\n" +
      "xrdkdkq (435) -> voytx, tfqvoz, cxieq, nzdcujt, efwflo\n" +
      "yfcnm (54)\n" +
      "wkdquda (78)\n" +
      "ogexy (85)\n" +
      "rodlg (77)\n" +
      "ohavz (100) -> zlgewg, gjjykjf\n" +
      "znwmy (50) -> mvwtr, rzopy, qcbtref, snbjccn\n" +
      "zyvdjl (25)\n" +
      "fkgjr (38)\n" +
      "qyyiyo (63)\n" +
      "lzgcs (98)\n" +
      "nfrnbw (460) -> pajjlng, ibwax\n" +
      "eujco (71)\n" +
      "ickkf (50)\n" +
      "ipwjrx (71)\n" +
      "ijynzc (271) -> hshja, odlobo\n" +
      "rnwcn (69)\n" +
      "ojijdav (19)\n" +
      "ivnla (143)\n" +
      "ensst (6)\n" +
      "yjldllm (128) -> ltcwt, zwfyefp\n" +
      "drqjijj (37)\n" +
      "efwflo (249) -> tbosn, qhxasm\n" +
      "cxrmuo (50)\n" +
      "tvoqmae (15)\n" +
      "jurdmpq (77)\n" +
      "mowtdty (53)\n" +
      "cteerd (85)\n" +
      "hqbad (404) -> rhgfl, eeofxt\n" +
      "pofvr (72)\n" +
      "ibixfz (28) -> firwwz, xxqyp\n" +
      "fdbyixt (167) -> rodlg, alwsn\n" +
      "wyovcqf (47)\n" +
      "hgaupyo (32)\n" +
      "xirit (25)\n" +
      "ahatk (13)\n" +
      "wtuse (163) -> qbsvwcc, auqjapr\n" +
      "mphoskw (1275) -> wpdrp, lqimnfv, uoghp, dztpfb, lufzptb\n" +
      "ehucp (25)\n" +
      "rzwqxgp (76)\n" +
      "dwlqul (44)\n" +
      "csprk (1148) -> nrzao, agcqog, ehucp, ljtub\n" +
      "hzpagsa (89)\n" +
      "uoghp (153) -> pwyqx, isfuod\n" +
      "pbtuupy (42)\n" +
      "ykcmzu (1370) -> mozwerl, ddooi, teufo, rakjhe\n" +
      "ucafi (51)\n" +
      "sqwioau (19)\n" +
      "ewbfx (10)\n" +
      "qnbyib (86)\n" +
      "wvcui (35)\n" +
      "lgjkmc (57) -> nvuiy, idvtm\n" +
      "junpjcj (96) -> eqcmflu, ujpttyx\n" +
      "zdlyf (70)\n" +
      "ksbrn (58)\n" +
      "jrrrwqw (19)\n" +
      "xtqrjc (14)\n" +
      "foyeln (45)\n" +
      "soyzhei (74)\n" +
      "crgver (64)\n" +
      "xsygurk (242)\n" +
      "ugrxr (151) -> kmtpsb, lwkbk\n" +
      "nzzzh (22)\n" +
      "iwovx (36)\n" +
      "tfqvoz (185) -> pvxzi, sxwegk\n" +
      "yiwyghj (1246) -> seipdcu, lsgmebq, agdmzu\n" +
      "tovve (94)\n" +
      "hcjoif (67) -> sqkra, dufuw\n" +
      "kzbgh (68)\n" +
      "osnpcl (94)\n" +
      "kpwgdrt (263) -> winyji, ipwjrx\n" +
      "cdewiot (28)\n" +
      "iglpkvv (353) -> bozvn, ensst, rtfmatr, gnukyxz\n" +
      "hgbgr (220) -> cqrwox, ntqdd\n" +
      "putdy (21)\n" +
      "bwdstyz (62)\n" +
      "yofqkfe (973) -> iabql, mgraypm, pllcvd\n" +
      "zevpw (72)\n" +
      "nsrsjtk (237) -> nwvbh, eqkno\n" +
      "vgxle (142) -> fkgjr, vjupomu, lerrsh, sbgsxdw\n" +
      "ubiagvr (191) -> pbncc, tykqh\n" +
      "jriph (1998) -> cqrqt, kibpy\n" +
      "pbkyjk (179) -> hfrgc, jtvvv\n" +
      "gqrjzf (158) -> hzpagsa, bvtsl, hqaxdqm\n" +
      "lwnpt (43)\n" +
      "ejucumc (6)\n" +
      "imzjzf (257) -> rzwqxgp, lwatsc\n" +
      "eypmjnl (82)\n" +
      "vzglbr (33)\n" +
      "mlslqa (162) -> siwcnqk, coenxv\n" +
      "piuudr (88)\n" +
      "rcsthxt (220) -> szcxg, btkth\n" +
      "kixinqo (62) -> dcjiu, rnwcn\n" +
      "prgfkm (85)\n" +
      "enlnjb (88)\n" +
      "dcrhafq (28)\n" +
      "qkhwa (2607) -> sgoseob, zbwfbgd\n" +
      "emxti (5)\n" +
      "dkhddzb (82)\n" +
      "ffvsvb (73) -> ubuuw, tntwm, yiimp\n" +
      "nlaym (178) -> iqwsxmt, qcmxoe\n" +
      "lgyab (295)\n" +
      "wprvgb (46)\n" +
      "sjsqaol (48)\n" +
      "uzifsnw (84)\n" +
      "voytx (172) -> scjek, knmdxw, qwuug\n" +
      "ruroup (53)\n" +
      "lssxhxw (8)\n" +
      "pheyymh (78) -> kiwylpo, taapm, ggcyyr\n" +
      "zagsm (70)\n" +
      "ivvcytp (63)\n" +
      "lhcndy (134) -> idjquuv, tvpovok\n" +
      "ijjri (6)\n" +
      "vzttnzk (117) -> mmyaot, ignsmt\n" +
      "xqzsy (464) -> qlucu, fdnxe, soyzhei\n" +
      "jkbuq (29619) -> oielzfu, ocyjmcy, ybneks\n" +
      "pvuno (58)\n" +
      "tpxvyjx (92)\n" +
      "alwsn (77)\n" +
      "ioypyd (47)\n" +
      "zgjhbp (79) -> wpboq, pcitx\n" +
      "dlfghsv (84) -> rxozjry, uejnd, fpkgx, chvari\n" +
      "zddmfy (60)\n" +
      "qcbtref (61)\n" +
      "gabpxsf (1503) -> pjbrh, hsbzn, hjroy\n" +
      "hfrgc (67)\n" +
      "ytxusu (1914) -> upapd, tgcmyr, zgjhbp, qahkfnd, abaox, gobzapu, wnmyhx\n" +
      "yvdidmd (21)\n" +
      "iutqxkf (8)\n" +
      "kutxof (22)\n" +
      "ziouqpy (142) -> zfqvkc, jpwhcjy\n" +
      "sxxod (88)\n" +
      "lohgt (98)\n" +
      "ewbngna (15)\n" +
      "ffuxvj (83) -> fbbeae, xtbhjq\n" +
      "ulqloyn (79)\n" +
      "bazfmo (492) -> vvcoce, vekxtb, pheyymh\n" +
      "qhaxz (21)\n" +
      "fsfdbgt (77)\n" +
      "agdmzu (41) -> xbaluf, ucafi\n" +
      "thblrfo (148) -> lxmtjx, lwnpt\n" +
      "becfiz (97) -> xywsyz, mznemqf, zbbyzr, hftcktd\n" +
      "tzuiasi (91)\n" +
      "scjek (57)\n" +
      "wrhfj (46)\n" +
      "dxllc (44)\n" +
      "msxnc (81)\n" +
      "lswznxp (24)\n" +
      "vojtq (60)\n" +
      "ecrdh (63)\n" +
      "fymxr (77)\n" +
      "mfvdags (72) -> uljtowd, jurdmpq, jgome, syvhbgb\n" +
      "wpmef (75)\n" +
      "qomycms (222) -> wxbsqif, cmgap, xilohyg\n" +
      "roedr (77)\n" +
      "vbhmz (73)\n" +
      "hmonryr (344) -> euhmwat, lpmsj, jjrto, scabkd\n" +
      "qdbendr (67)\n" +
      "seffc (98)\n" +
      "geqrhsr (76)\n" +
      "txxjkb (306) -> lmtisu, sovgznm\n" +
      "cozmd (33) -> wvkqb, yquoa, seffc, uynpswf\n" +
      "vikpkr (233) -> xznjrta, emxti, efyiyc, nemethx\n" +
      "tabwkx (91)\n" +
      "wlpnxme (72)\n" +
      "mhgzc (60)\n" +
      "sfeepek (28)\n" +
      "dcpgsg (58)\n" +
      "upapd (161)\n" +
      "kyukz (10)\n" +
      "hihltxf (44) -> kugzwm, skzmpao\n" +
      "jmypi (32)\n" +
      "mrfswq (99)\n" +
      "ltalmp (51)\n" +
      "szymk (28)\n" +
      "qhnifn (287) -> nosbdrs, hzjcwc\n" +
      "nggfb (200) -> moaabux, xcriywz\n" +
      "cjgtg (343) -> rnimplt, vthvyt\n" +
      "iqvnyzy (55)\n" +
      "wltxoge (318) -> ewbngna, xvkdd\n" +
      "uczyc (93)\n" +
      "elvjpjr (32)\n" +
      "agfzkj (329) -> sjsqaol, rafvktj\n" +
      "cmqglh (84)\n" +
      "rzopy (61)\n" +
      "sbocc (48)\n" +
      "ihjyjx (11)\n" +
      "jpwhcjy (77)\n" +
      "radwgcq (46)\n" +
      "fpkgx (88)\n" +
      "fpiatig (2611) -> inxpyl, jlmgl\n" +
      "jnlnsk (1966) -> vzttnzk, wpidtfu, wnggxc\n" +
      "qxqwvi (99)\n" +
      "wmyojtm (260)\n" +
      "bsbjxg (9)\n" +
      "adyogf (99)\n" +
      "upsbm (19)\n" +
      "ynpehry (46)\n" +
      "vjupomu (38)\n" +
      "pvxzi (79)\n" +
      "knxyay (22)\n" +
      "wtluvr (88)\n" +
      "nadjis (284) -> xeqol, ihjyjx\n" +
      "mozwqgu (24)\n" +
      "cufloa (7) -> exmpr, jzjgef, gotuw\n" +
      "zqbkt (905) -> yauplaz, hcjoif, rwhbcy, kpkcku, vehlv\n" +
      "xwudzc (284) -> gneipe, ityktpq, wyovcqf\n" +
      "npehrzk (77) -> xsdzkqs, mzpumh\n" +
      "tmakl (51)\n" +
      "ocyjmcy (43) -> hlsoeh, wsgab, zzlopja, nczrlw, ytxusu, hzmxo, lffnvze\n" +
      "jmtqh (191) -> hacbd, lncyf\n" +
      "chpxtc (71)\n" +
      "ujpttyx (73)\n" +
      "qywnr (253) -> rdkqd, nfrnbw, juykf\n" +
      "uvybtgx (344) -> ijjri, ejucumc, yscyxrt, esskfkp\n" +
      "cuvke (18)\n" +
      "svprq (85)\n" +
      "sgoseob (38)\n" +
      "ghhwci (9294) -> jiyqd, ojjnnko, aawaew\n" +
      "znltrss (19)\n" +
      "pbncc (81)\n" +
      "ioyibl (77)\n" +
      "lwkbk (56)\n" +
      "ktlhztg (328) -> tzyav, gkzimba\n" +
      "gavzkq (15)\n" +
      "jdpfhyl (13)\n" +
      "mpyhy (263)\n" +
      "auqjapr (45)\n" +
      "caufkxz (55)\n" +
      "sbgsxdw (38)\n" +
      "rtckpbz (67)\n" +
      "yqewlf (92)\n" +
      "loukhc (80) -> adyogf, mrfswq, qxqwvi\n" +
      "xrvcjq (212) -> xhqpkdq, pisrmb\n" +
      "zfqvkc (77)\n" +
      "tqpgecy (76)\n" +
      "xcrejqf (5)\n" +
      "rrvihye (36) -> dkhddzb, sakrb\n" +
      "rbast (28)\n" +
      "bcygph (10)\n" +
      "ubfljy (95)\n" +
      "omdnuon (70)\n" +
      "mmyaot (61)\n" +
      "jwcsw (367) -> ounhwx, flcxc\n" +
      "gnqdxl (66) -> xqbgo, cmqglh\n" +
      "qipkli (218) -> putdy, rfvtz\n" +
      "rakjhe (103) -> wrhfj, ssvgu\n" +
      "rzuig (90)\n" +
      "iewgymm (10)\n" +
      "pqiivg (191) -> hjuhoum, bwpbkb\n" +
      "sswszre (78)\n" +
      "vihkn (63)\n" +
      "efuzst (72)\n" +
      "nbtxoam (83)\n" +
      "lerrsh (38)\n" +
      "myvyjck (86)\n" +
      "daxxjtz (445) -> ewypdpk, jfaseqo, bqxwpf, hweuik, ubiagvr\n" +
      "wefmw (88)\n" +
      "qlezcmj (44)\n" +
      "jvhvlo (230)\n" +
      "tplrep (20)\n" +
      "asvbb (67)\n" +
      "diqon (862) -> mgonf, rnjxo, ykijrb\n" +
      "dmswq (75) -> fsfdbgt, roedr, oplfyg\n" +
      "ietond (42)\n" +
      "tjwtl (87)\n" +
      "kdsmtx (78) -> tjwtl, fdkkxk\n" +
      "tplgx (76)\n" +
      "kbzfvrp (2091) -> xltrwv, hcxpyq, gogfx, uoqkd\n" +
      "ljtub (25)\n" +
      "irupq (60) -> grstedk, hzyxurv\n" +
      "ubzly (253) -> gbrnge, tzuiasi\n" +
      "rjrlumz (72)\n" +
      "dyrpzor (78)\n" +
      "lmtisu (51)\n" +
      "cqrwox (80)\n" +
      "jhxsez (7)\n" +
      "uxzql (84)\n" +
      "upjapf (77)\n" +
      "watsby (84)\n" +
      "adetez (46)\n" +
      "wxpagp (19)\n" +
      "hzjcwc (17)\n" +
      "bmfkrnb (87)\n" +
      "qljvi (237) -> iatmk, sowli, auigtqr, ddeso\n" +
      "chvari (88)\n" +
      "qhxasm (47)\n" +
      "ektvj (46)\n" +
      "feywd (2062) -> nrgrjty, cjhrs, ytomrhu\n" +
      "fjcbsj (97)\n" +
      "hzfgjnm (56)\n" +
      "uidqcn (84)\n" +
      "oagdsv (235) -> ndnxy, kbmqdsc\n" +
      "vcitv (1040) -> xyzmpjv, nlaym, fqftj, zrtlh, lnozan\n" +
      "dbqwqo (13)\n" +
      "lnozan (166) -> yhtmfb, dcrhafq\n" +
      "lhcegk (85)\n" +
      "taapm (58)\n" +
      "tntwm (79)\n" +
      "ovozt (70)\n" +
      "meuoa (90)\n" +
      "wzrpo (28)\n" +
      "lzmldaf (71)\n" +
      "oaonzl (95) -> lzgcs, wblgb\n" +
      "stvho (6)\n" +
      "xcerg (19)\n" +
      "denjcv (8)\n" +
      "budzpo (22)\n" +
      "wpmoil (54)\n" +
      "vehlv (233) -> jhxsez, xavbkjb, jdhwx, beinhu\n" +
      "blvgj (13)\n" +
      "giiie (95) -> lohgt, ekezedh\n" +
      "onmidw (436)\n" +
      "lftsl (79)\n" +
      "ktgfxpm (55)\n" +
      "nwvbh (29)\n" +
      "vdywyof (10)\n" +
      "juykf (339) -> wbqyxc, qghexm, spqtfmy\n" +
      "dzcyze (6) -> tovve, jtugpxm\n" +
      "rxozjry (88)\n" +
      "htoep (64)\n" +
      "qbdrnwf (6)\n" +
      "wpidtfu (49) -> ubfljy, slbyad\n" +
      "agfxi (85)\n" +
      "mtaatz (266) -> gjegewd, cozma\n" +
      "mznemqf (78)\n" +
      "eoabav (85)\n" +
      "ewypdpk (21) -> fdxizm, sbfiowr, zpatw, nbtxoam\n" +
      "ntqdd (80)\n" +
      "fqoozik (14)\n" +
      "gobzapu (50) -> pturyym, drqjijj, yoxfi\n" +
      "ytomrhu (197) -> xcrejqf, zbfds\n" +
      "vgoayw (21) -> vvyuxd, ahcxyzi\n" +
      "gslkem (11)\n" +
      "pgefkd (2000) -> rxmaax, wpmef\n" +
      "dztpfb (187)\n" +
      "dsvthh (82)\n" +
      "nemethx (5)\n" +
      "yquoa (98)\n" +
      "opfgye (151) -> yuctaoj, hsxey\n" +
      "vqecsyp (84)\n" +
      "hlxhne (35)\n" +
      "jfaseqo (247) -> khydeiy, lvbgvb\n" +
      "qborl (299)\n" +
      "yzpfod (28)\n" +
      "spqtfmy (45)\n" +
      "ptwgg (21)\n" +
      "suxsxhs (72)\n" +
      "kchnqf (82)\n" +
      "qvaemxv (99)\n" +
      "rupwawl (61)\n" +
      "gsnlv (137) -> oopqw, wghzp\n" +
      "tsqmps (63) -> bykynh, xfyybbx\n" +
      "yiimp (79)\n" +
      "xalpz (49)\n" +
      "xcriywz (26)\n" +
      "uabcnf (78)\n" +
      "zmkuj (364) -> kutxof, knxyay\n" +
      "egkkx (405)\n" +
      "kfojlo (9)\n" +
      "xavbkjb (7)\n" +
      "uuepceb (52)\n" +
      "rfvtz (21)\n" +
      "vunjzqr (15) -> gtwif, uuepceb, rgthsm\n" +
      "fbbeae (40)\n" +
      "yuctaoj (6)\n" +
      "tllmans (2018) -> abvtv, sbocc, fyxrsks, camnbrn\n" +
      "wirio (33) -> ztgujur, ovozt, nhfaz, zagsm\n" +
      "mozwerl (37) -> vpfaa, ulqloyn\n" +
      "mydrx (165) -> hdpqb, lgjkmc, aikum, ohzbeco\n" +
      "qvzsob (88)\n" +
      "etksk (47)\n" +
      "oopqw (17)\n" +
      "fowke (51)\n" +
      "txlrdpc (1421) -> jmtqh, flbni, loukhc, iglpkvv\n" +
      "dbkhupp (117) -> bugid, fzftvzt, foyeln\n" +
      "aurik (2443) -> jriph, bykobk, uylvg, yxhntq, ywdvft\n" +
      "tqved (35)\n" +
      "btkth (7)\n" +
      "gjqasxb (33)\n" +
      "snqbfd (61)\n" +
      "qgyboht (10)\n" +
      "eqdugzw (51)\n" +
      "xeqol (11)\n" +
      "oynrsea (79)\n" +
      "ilfmw (68) -> rzahe, fbfawqa, hxtumb, wtuse, vikpkr\n" +
      "dphwkj (88)\n" +
      "utoyap (72)\n" +
      "opbyya (93)\n" +
      "flcxc (19)\n" +
      "jishckj (155) -> uzifsnw, vqecsyp, uidqcn\n" +
      "kvrrast (175)\n" +
      "teufo (99) -> jmypi, aegkypi, kienpis\n" +
      "rlghl (32)\n" +
      "bugid (45)\n" +
      "vkeqd (87)\n" +
      "osppg (72)\n" +
      "xxcsggt (97)\n" +
      "vpgtsem (354) -> aqgufrg, sthzqgi, kwemyhv\n" +
      "eqkno (29)\n" +
      "ieqrsbo (65)\n" +
      "syvhbgb (77)\n" +
      "vxcuhd (66) -> vhnoll, xphisb\n" +
      "kugzwm (99)\n" +
      "vekxtb (202) -> zyvdjl, xirit\n" +
      "andsm (60)\n" +
      "gjegewd (10)\n" +
      "wmril (38) -> lmkdc, yhnbyxd\n" +
      "awcgokk (71)\n" +
      "wynfir (95)\n" +
      "seavb (67)\n" +
      "ohksn (97)\n" +
      "bykynh (56)\n" +
      "bjcmqj (72)\n" +
      "fyxrsks (48)\n" +
      "qhzdnug (51)\n" +
      "vvyuxd (93)\n" +
      "lsgmebq (143)\n" +
      "tykqh (81)\n" +
      "cwkoak (74)\n" +
      "ozeuxvw (90)\n" +
      "lmkdc (81)\n" +
      "nrgrjty (33) -> vkrhnw, eiqvo\n" +
      "vqxoyl (13)\n" +
      "onkvtu (83) -> mowtdty, zivoem, ruroup\n" +
      "hzyxurv (70)\n" +
      "immqut (285) -> fdbyixt, qhnifn, knxli\n" +
      "pjrin (295)\n" +
      "qihokeg (56)\n" +
      "nalhjfn (2161) -> lwogeq, ayvoftj, vxcuhd\n" +
      "siwcnqk (74)\n" +
      "nwmgu (285) -> mndwt, jjbgnry\n" +
      "blwogji (19)\n" +
      "kibpy (52)\n" +
      "iabql (84) -> ickkf, jfkhs, ypdcyhe\n" +
      "exmpr (230) -> pofvr, osppg\n" +
      "xbvlp (94)\n" +
      "ovsqv (6)\n" +
      "ddooi (107) -> dxllc, nwuxy\n" +
      "iutebku (1047) -> kfvzter, awronb, imzjzf, becfiz\n" +
      "qahkfnd (123) -> xcerg, upsbm\n" +
      "skzmpao (99)\n" +
      "tonljgn (57) -> gpwroki, qborl, eskfcor, leecyuk, nwmgu, zqbje, zalfzf\n" +
      "xxqyp (91)\n" +
      "ssvgu (46)\n" +
      "vmjcif (9360) -> tyrncu, ilfmw, nntuwn\n" +
      "oplfyg (77)\n" +
      "cigdar (339)\n" +
      "ilyaln (76) -> caufkxz, ktgfxpm, obqyrh, iqvnyzy\n" +
      "ryxdad (84)\n" +
      "zgjcuz (53) -> wefmw, wtluvr, wgqlq, enlnjb\n" +
      "pdswch (67)\n" +
      "glbvimo (211) -> fjcbsj, ggoegus\n" +
      "eyxvb (60)\n" +
      "utghvik (24)\n" +
      "ymnotlu (88)\n" +
      "hekdhpe (13)\n" +
      "ukldjwr (335) -> fvhtci, elvjpjr\n" +
      "ayvoftj (98) -> fvdpch, mnvip\n" +
      "bkpjjg (51)\n" +
      "mndwt (7)\n" +
      "hxunt (72)\n" +
      "yprilie (20)\n" +
      "kspwjf (55) -> ietond, orjnuc\n" +
      "nvuiy (92)\n" +
      "lgvgz (9)\n" +
      "hdtndko (38)\n" +
      "djfnwv (67)\n" +
      "bktgoug (208) -> nzzzh, lkfjzec\n" +
      "xnyma (51)\n" +
      "jfkhs (50)\n" +
      "firwwz (91)\n" +
      "sfooljn (69) -> gaszn, qhzdnug\n" +
      "qddxuou (63)\n" +
      "xjghf (181)\n" +
      "lnzzwfi (24) -> blwogji, ojijdav\n" +
      "puvpxd (38) -> opbyya, uczyc\n" +
      "pgqdymw (88)\n" +
      "sovgznm (51)\n" +
      "wzcini (97)\n" +
      "mekcnd (38)\n" +
      "cakeb (67)\n" +
      "grstedk (70)\n" +
      "rfnnn (7)\n" +
      "zrtlh (68) -> upjapf, pqcxw\n" +
      "gtoij (184) -> lssxhxw, brirt\n" +
      "vxgbrvk (5)\n" +
      "bmbkh (168) -> gjqasxb, ystegvn\n" +
      "xltrwv (2388) -> htqkf, ivnla, jsrfoem\n" +
      "xmxvd (31) -> bjcmqj, zevpw\n" +
      "hcxpyq (24) -> ukldjwr, gyymhc, kdelzk, tqjtmnl, glfsclp, cjgtg, saaggxs\n" +
      "jsojra (78)\n" +
      "eijnbk (65)\n" +
      "slbyad (95)\n" +
      "nrzao (25)\n" +
      "wnggxc (217) -> gslkem, ojzyz\n" +
      "pejys (94)\n" +
      "wjrjt (407)\n" +
      "gotuw (86) -> vlujgrg, pkkpfqd, hxunt, efuzst\n" +
      "hfzsc (58)\n" +
      "jzjgef (234) -> hlxhne, laxksv, tqved, nnhhm\n" +
      "jtugpxm (94)\n" +
      "bxabcu (570) -> eztcv, cnvjej, jikwvk\n" +
      "aikum (205) -> lgvgz, kfojlo, jjdzuw, yvkbhqt\n" +
      "iaabs (63)\n" +
      "rnjxo (61) -> eypmjnl, ebudz\n" +
      "kbmqdsc (39)\n" +
      "hvfbx (19)\n" +
      "iqwsxmt (22)\n" +
      "usbgi (53)\n" +
      "petrvdq (61)\n" +
      "elpnrhu (39)\n" +
      "fdxizm (83)\n" +
      "eskfcor (263) -> xlsmzvh, cuvke\n" +
      "fpkcbpf (210) -> hrxxih, cxrmuo\n" +
      "ggoegus (97)\n" +
      "zwfyefp (33)\n" +
      "iehag (97)\n" +
      "hmxzzp (42)\n" +
      "wpdrp (41) -> gxxwgu, vbhmz\n" +
      "qlucu (74)\n" +
      "jnotktj (302) -> bxoslf, usbgi\n" +
      "sxwegk (79)\n" +
      "gogfx (2601) -> warwhgb, wlpnxme, suxsxhs\n" +
      "ybuocfy (1374) -> tzfii, safaxql, opfgye, johvj, ezjzcma, ffuxvj, ztubst\n" +
      "jfnojdk (212) -> lsqafn, xjzwjwo\n" +
      "ecqun (20)\n" +
      "wblgb (98)\n" +
      "pfohpw (43)\n" +
      "yhtmfb (28)\n" +
      "oedzmki (360) -> npehrzk, ugrxr, mcjpy, mpyhy, cscdc\n" +
      "detpnh (47) -> dqxjmn, seavb\n" +
      "fvhtci (32)\n" +
      "wpboq (41)\n" +
      "bwpbkb (35)\n" +
      "zbbyzr (78)\n" +
      "dwghva (53) -> nalhjfn, txlrdpc, sxplgr\n" +
      "jlbbmrc (97)\n" +
      "ehogp (84)\n" +
      "jdhwx (7)\n" +
      "leecyuk (173) -> qyyiyo, fqbwlo\n" +
      "xfafo (9)\n" +
      "miuaxx (380)\n" +
      "bqxwpf (251) -> vcweon, bkpjjg\n" +
      "mvwtr (61)\n" +
      "bvtsl (89)\n" +
      "zqbje (219) -> tdxsvy, vycfxv, ecqun, ketqren\n" +
      "lwogeq (102) -> fymxr, ioyibl\n" +
      "dmnohav (23)\n" +
      "hpqvzn (5383) -> mxmzyac, gtukrss, ybuocfy\n" +
      "moaabux (26)\n" +
      "quwnokw (19)\n" +
      "qfmbrpi (7) -> ryxdad, kinfgwy\n" +
      "wnmyhx (161)\n" +
      "rilyl (28969) -> aurik, fcmspin, hpqvzn, hymjivf, qgrkb\n" +
      "lelwex (210) -> gabonn, rfnnn\n" +
      "zbpsmm (67)\n" +
      "bafivi (408) -> kresb, fqoozik\n" +
      "mwvpdtt (188) -> udpwvnp, ollxzi, uhomjuv\n" +
      "czwhzbc (282) -> guggdb, xalpz\n" +
      "dufuw (97)\n" +
      "rnnbl (114) -> zctkn, pfohpw\n" +
      "sddwvuf (297) -> wpmoil, yfcnm\n" +
      "totce (96) -> wqhxpu, ibxac, vihkn, qddxuou\n" +
      "vecsik (50) -> dsvthh, kchnqf, uifjz\n" +
      "pllcvd (30) -> gcuxn, kzbgh, zmtzfbt\n" +
      "zpatw (83)\n" +
      "unexcu (58)\n" +
      "gjjykjf (80)\n" +
      "asorc (67)\n" +
      "akpehu (85)\n" +
      "pkkpfqd (72)\n" +
      "wvkqb (98)\n" +
      "rfguypo (216) -> tqpgecy, tplgx\n" +
      "elfenmu (99)\n" +
      "efyiyc (5)\n" +
      "wgqlq (88)\n" +
      "tbosn (47)\n" +
      "fdkkxk (87)\n" +
      "gneipe (47)\n" +
      "guyzk (94)\n" +
      "awronb (279) -> ieqrsbo, eijnbk\n" +
      "nosbdrs (17)\n" +
      "ztgujur (70)\n" +
      "vvqdsqo (19)\n" +
      "gcuxn (68)\n" +
      "zrfcjo (293) -> ajqgxy, gcult\n" +
      "mvhek (52)\n" +
      "emjyxt (17)\n" +
      "kvblxto (39) -> cafeffy, qljvi, viftnsh, kcfqe\n" +
      "pisrmb (15)\n" +
      "uhomjuv (64)\n" +
      "oykud (1210) -> quwnokw, vvqdsqo\n" +
      "hnmipv (48) -> qvzsob, dphwkj\n" +
      "setljkt (49)\n" +
      "pdvmaam (67089) -> dwghva, hmonryr, rjdmf\n" +
      "tsmekuh (216) -> budzpo, wvrvgio\n" +
      "lpmsj (1266) -> inzzz, pwibnc, mtaatz\n" +
      "xbaluf (51)\n" +
      "lsqafn (84)\n" +
      "ezfoih (51)\n" +
      "hekghqb (43)\n" +
      "htqkf (9) -> asvbb, rtckpbz\n" +
      "wsgab (66) -> qlscb, xwudzc, cozmd, agfzkj, yewec, hvdpvf, gqrjzf\n" +
      "kmhdfd (10)\n" +
      "kmtpsb (56)\n" +
      "kiwylpo (58)\n" +
      "wbqyxc (45)\n" +
      "bozvn (6)\n" +
      "viftnsh (315) -> tlirtlm, etksk\n" +
      "udisj (10)\n" +
      "cgtirrb (368) -> stvho, shwgbpx\n" +
      "jlmgl (36)\n" +
      "xxgvcq (81)\n" +
      "sbfiowr (83)\n" +
      "nhfaz (70)\n" +
      "johvj (163)\n" +
      "osckuj (58)\n" +
      "idswf (15)\n" +
      "tqjtmnl (115) -> eujco, amacxs, lzmldaf, awcgokk\n" +
      "pwibnc (22) -> pgqdymw, tjffc, mbzenl\n" +
      "jtvvv (67)\n" +
      "hshja (12)\n" +
      "qghexm (45)\n" +
      "uejnd (88)\n" +
      "qlgkl (94)\n" +
      "aqgufrg (17)\n" +
      "cjhrs (131) -> zrruyn, sqwioau, jrrrwqw, rupecqk\n" +
      "rywlizi (44)\n" +
      "xyzmpjv (28) -> xxcsggt, wzcini\n" +
      "xyarhf (80)\n" +
      "hztbvq (348)\n" +
      "piepj (20)\n" +
      "ojzyz (11)\n" +
      "uljtowd (77)\n" +
      "ceofy (3309) -> yofqkfe, iiyhw, yiwyghj, oedzmki, qywnr, kvblxto\n" +
      "fzftvzt (45)\n" +
      "hsvleq (2142) -> emjyxt, ymjcf, mxtxzdj, trepya\n" +
      "jikwvk (110) -> unexcu, ksbrn\n" +
      "wnxya (63)\n" +
      "tjffc (88)\n" +
      "hsxey (6)\n" +
      "qijgfwk (155) -> fbbzyxj, ewbfx\n" +
      "pxkcra (23)\n" +
      "isfuod (17)\n" +
      "lgdtj (24)\n" +
      "qszyv (15)\n" +
      "zbwfbgd (38)\n" +
      "bgjreum (62)\n" +
      "mxtxzdj (17)\n" +
      "xjzwjwo (84)\n" +
      "rxmaax (75)\n" +
      "pwyqx (17)\n" +
      "qezwnc (49)\n" +
      "wvjhjjn (2611) -> zmukql, lswznxp, rsujfpj\n" +
      "amacxs (71)\n" +
      "lwatsc (76)\n" +
      "hpohuv (128) -> fhjpe, mvhek\n" +
      "vhnoll (95)\n" +
      "uujpyn (84)\n" +
      "lqnym (99)\n" +
      "ollxzi (64)\n" +
      "itqiej (90)\n" +
      "vmutmbz (71)\n" +
      "hwcnp (67) -> bjsyz, znwmy, sdxxuml, vgxle, fmufi\n" +
      "gnukyxz (6)\n" +
      "wmhwmv (45)\n" +
      "hcwly (83)\n" +
      "qwuug (57)\n" +
      "ggcyyr (58)\n" +
      "ztubst (43) -> zddmfy, wdmkbxa\n" +
      "qduyad (78)\n" +
      "uifjz (82)\n" +
      "tpkmqc (30) -> hqbad, oatauv, dlfghsv, bafivi, onmidw\n" +
      "cozma (10)\n" +
      "yxqwz (75) -> rlghl, hgaupyo\n" +
      "ohzbeco (175) -> vzglbr, edkcs\n" +
      "fqbwlo (63)\n" +
      "pzpltg (56) -> tnnjkm, tfkbv, ibixfz\n" +
      "sdxxuml (246) -> lrqeps, utghvik\n" +
      "nntuwn (109) -> txxjkb, gihcxn, jnotktj\n" +
      "mylibd (71)\n" +
      "gbrnge (91)\n" +
      "gtwif (52)\n" +
      "hsbzn (32) -> gfnxtjy, tabwkx\n" +
      "zrruyn (19)\n" +
      "safaxql (107) -> rbast, yzpfod\n" +
      "eztcv (78) -> cwkoak, bcmhwm\n" +
      "hxbcz (10)\n" +
      "ozecapv (121) -> bsbjxg, cpbasst\n" +
      "lufzptb (63) -> bgjreum, cryabx\n" +
      "fgsxy (13)\n" +
      "zivoem (53)\n" +
      "ibwax (7)\n" +
      "taudz (71)\n" +
      "fbfawqa (197) -> mdledr, szymk\n" +
      "hzmxo (1301) -> tlkqqk, ubzly, zrfcjo, nlbjopb\n" +
      "wxbsqif (28)\n" +
      "nnhhm (35)\n" +
      "doevlp (67)\n" +
      "nzdcujt (280) -> yvdidmd, qhaxz, ptwgg\n" +
      "nkviw (61)\n" +
      "xqbgo (84)\n" +
      "mdledr (28)\n" +
      "bxoslf (53)\n" +
      "rqbqxy (80)\n" +
      "endqfm (97)\n" +
      "jlrfg (88)\n" +
      "idvtm (92)\n" +
      "yscyxrt (6)\n" +
      "pjbrh (214)\n" +
      "camnbrn (48)\n" +
      "dcqdop (500) -> jijjnbw, bwdstyz, lnzzwfi\n" +
      "yhnbyxd (81)\n" +
      "qfhptx (92)\n" +
      "qyucm (127) -> yjdfxn, ysmrs\n" +
      "jvvnvo (138) -> wzrpo, sfeepek\n" +
      "olxbw (99) -> rqbqxy, xyarhf, qxtttuu\n" +
      "fvdpch (79)\n" +
      "osgdles (76)\n" +
      "yvkbhqt (9)\n" +
      "khyzbb (78)\n" +
      "lrqeps (24)\n" +
      "fbbzyxj (10)\n" +
      "gabonn (7)\n" +
      "jsrfoem (143)\n" +
      "zbfds (5)\n" +
      "mwojc (18)\n" +
      "opgjd (217) -> nkviw, petrvdq\n" +
      "hftcktd (78)\n" +
      "cryabx (62)\n" +
      "ezjzcma (21) -> taudz, pmtkuu\n" +
      "gfgrl (36)\n" +
      "zelhlaj (44)\n" +
      "shwgbpx (6)\n" +
      "jjrto (1452) -> puvpxd, lelwex, hnmipv\n" +
      "vcweon (51)\n" +
      "fqftj (102) -> chyyj, uetfc\n" +
      "xilohyg (28)\n" +
      "zctkn (43)\n" +
      "ounhwx (19)\n" +
      "rgthsm (52)\n" +
      "uypiw (85)\n" +
      "gnstbtt (64)\n" +
      "tdgeaw (252)\n" +
      "ebudz (82)\n" +
      "hqtwr (56) -> dyrpzor, sswszre, jsojra, qduyad\n" +
      "wdmkbxa (60)\n" +
      "guggdb (49)\n" +
      "pturyym (37)\n" +
      "abvtv (48)\n" +
      "eudtoy (99) -> hsvleq, daxxjtz, tllmans, tpkmqc, mphoskw, zqbkt\n" +
      "warwhgb (72)\n" +
      "orjnuc (42)\n" +
      "tzfii (115) -> mozwqgu, lgdtj\n" +
      "yxhntq (9) -> bmgtktw, kddqkkz, hztbvq, omouek, totce, wltxoge\n" +
      "ykijrb (225)\n" +
      "fdnxe (74)\n" +
      "bcmhwm (74)\n" +
      "uoqkd (1565) -> oagdsv, pbkyjk, wirio, wxjne\n" +
      "iprxseg (99)\n" +
      "gaszn (51)\n" +
      "gihcxn (56) -> jlrfg, sxxod, ymnotlu, yhcsmfs\n" +
      "tvpovok (59)\n" +
      "pqcxw (77)\n" +
      "sddsn (84)\n" +
      "iagng (28)\n" +
      "mcjpy (129) -> cmgugdz, asorc\n" +
      "xlsmzvh (18)\n" +
      "gyymhc (353) -> pxkcra, dmnohav\n" +
      "oielzfu (2549) -> jnlnsk, qkhwa, iutebku, fpiatig, feywd, wvjhjjn, ffypved\n" +
      "eeofxt (16)\n" +
      "xtbhjq (40)\n" +
      "tfkbv (165) -> tvoqmae, idswf, fjlsk\n" +
      "hjuhoum (35)\n" +
      "brirt (8)\n" +
      "zvittjn (202) -> iwovx, wklcvl, gfgrl\n" +
      "kwemyhv (17)\n" +
      "auigtqr (43)\n" +
      "ndnxy (39)\n" +
      "pfwuaht (295)\n" +
      "mofidvl (13) -> tgken, sddsn\n" +
      "flbni (341) -> mwojc, ibuzkf\n" +
      "ekezedh (98)\n" +
      "coenxv (74)\n" +
      "esskfkp (6)\n" +
      "jjbgnry (7)\n" +
      "mumddr (79)\n" +
      "rzahe (73) -> rzuig, meuoa\n" +
      "xywsyz (78)\n" +
      "dsuhkja (67)\n" +
      "vkvvtm (92) -> whavaec, lftsl, oynrsea, mumddr\n" +
      "gkzimba (40)\n" +
      "rstjsa (96)\n" +
      "qrqxdk (43) -> xrzdoz, risnzi, ehogp\n" +
      "dqxjmn (67)\n" +
      "xytmux (48) -> osgdles, geqrhsr\n" +
      "vihqwqe (95)\n" +
      "hjroy (214)\n" +
      "gfnxtjy (91)\n" +
      "lhplxk (5)\n" +
      "yewec (425)\n" +
      "wapwp (35)\n" +
      "hlqnsbe (77) -> rilyl, vhyiaf, pdvmaam, jkbuq\n" +
      "wjwqs (49)\n" +
      "rhgfl (16)\n" +
      "omouek (256) -> adetez, radwgcq\n" +
      "fjlsk (15)\n" +
      "ubuuw (79)\n" +
      "beinhu (7)\n" +
      "mzpumh (93)\n" +
      "rjdmf (2692) -> uotis, hwcnp, yhzue, diqon\n" +
      "yoxfi (37)\n" +
      "szcxg (7)\n" +
      "hzuqtd (39)\n" +
      "lffnvze (2861) -> ozeuxvw, itqiej\n" +
      "idjquuv (59)\n" +
      "xhqpkdq (15)\n" +
      "favay (44) -> iprxseg, jujtux\n" +
      "bjsyz (276) -> xfafo, wwtxe\n" +
      "xphisb (95)\n" +
      "jgome (77)\n" +
      "scabkd (574) -> rpagi, ffvsvb, fpkcbpf, mlslqa, zvittjn\n" +
      "yjdmkg (45)\n" +
      "cckdoyb (172) -> wvcui, wapwp\n" +
      "uetfc (60)\n" +
      "vrypfpq (29) -> doevlp, pdswch, cakeb\n" +
      "vlgyos (10)\n" +
      "odlobo (12)\n" +
      "cxieq (91) -> uujpyn, uxzql, watsby\n" +
      "uotis (137) -> rnnbl, irupq, rrvihye, gtoij, xytmux, kixinqo, wmril\n" +
      "rupecqk (19)\n" +
      "zmaxz (89) -> qnbyib, myvyjck\n" +
      "ignsmt (61)\n" +
      "tnnjkm (165) -> gavzkq, qszyv, jgtnj\n" +
      "inxpyl (36)\n" +
      "glfsclp (87) -> ibqev, khyzbb, uabcnf, wkdquda\n" +
      "ajqgxy (71)\n" +
      "nlbjopb (309) -> pbtuupy, hmxzzp, arzxsdq\n" +
      "jqfou (14)\n" +
      "wghzp (17)\n" +
      "winyji (71)\n" +
      "qcmxoe (22)\n" +
      "pajjlng (7)\n" +
      "ibxac (63)\n" +
      "zdekdn (28)\n" +
      "slrxywr (38)\n" +
      "vgkvnu (6924) -> oaddogg, gabpxsf, jybwslx\n" +
      "chyyj (60)\n" +
      "cpbasst (9)\n" +
      "xznjrta (5)\n" +
      "pcitx (41)\n" +
      "arzxsdq (42)\n" +
      "aegkypi (32)\n" +
      "ffypved (23) -> jfnojdk, cgtirrb, czwhzbc, mfvdags, miuaxx, mwvpdtt, hgbgr\n" +
      "ymjcf (17)\n" +
      "onhpt (19)\n" +
      "lxmtjx (43)\n" +
      "mbzenl (88)\n" +
      "yenoyh (80) -> mekcnd, hdtndko, slrxywr\n" +
      "vvcoce (76) -> zelhlaj, qlezcmj, dwlqul, rywlizi\n" +
      "ayevuhk (96)\n" +
      "ityktpq (47)\n" +
      "ypdcyhe (50)\n" +
      "seipdcu (65) -> elpnrhu, hzuqtd\n" +
      "wcufjj (925) -> qijgfwk, kvrrast, xmxvd, qfmbrpi, tsqmps, ohjesb, qyucm\n" +
      "gliupmb (83)\n" +
      "bmgtktw (108) -> mhgzc, eyxvb, vojtq, andsm\n" +
      "kresb (14)\n" +
      "dyanei (378) -> kyukz, vdywyof, kmhdfd\n" +
      "eiqjanp (218) -> wynfir, vihqwqe\n" +
      "btlvmkx (8)\n" +
      "rdkqd (78) -> amtxnd, qvaemxv, elfenmu, lqnym\n" +
      "sxplgr (94) -> jwcsw, sddwvuf, vpgtsem, glbvimo, egkkx, kpwgdrt, zgjcuz\n" +
      "fbbcf (46)\n" +
      "hvdpvf (237) -> lclup, qlgkl\n" +
      "oaddogg (80) -> pfwuaht, wnxbu, ijynzc, lgyab, pjrin, nsrsjtk, qrqxdk\n" +
      "mpgkscw (355) -> hekdhpe, jdpfhyl, dbqwqo, vqxoyl\n" +
      "kuydvlr (92)\n" +
      "hxtumb (233) -> udisj, iewgymm\n" +
      "hqaxdqm (89)\n" +
      "cmgugdz (67)\n" +
      "aiizew (88)\n" +
      "ndnmvz (43)\n" +
      "rnimplt (28)\n" +
      "flstvi (25) -> hqtwr, uvybtgx, rfguypo\n" +
      "tyrncu (712) -> vgoayw, gpmfjj, gneen\n" +
      "ahcxyzi (93)\n" +
      "zalfzf (259) -> qgyboht, hxbcz, bcygph, vlgyos\n" +
      "ketqren (20)\n" +
      "qgrkb (9541) -> cufloa, flstvi, mydrx\n" +
      "egtdt (210) -> vxgbrvk, vmyqa, dpqznt, lhplxk\n" +
      "wklcvl (36)\n" +
      "gtukrss (1819) -> wspoq, ggdcjbd, hpohuv\n" +
      "gpwroki (95) -> tmakl, eqdugzw, fwtuv, fowke\n" +
      "rafvktj (48)\n" +
      "rsujfpj (24)\n" +
      "fwtuv (51)\n" +
      "iatmk (43)\n" +
      "ltcwt (33)\n" +
      "aawaew (55) -> ohavz, tsmekuh, qipkli, leymr, wmyojtm\n" +
      "datzi (67) -> svprq, cteerd, ogexy, akpehu\n" +
      "agcqog (25)\n" +
      "mgonf (199) -> ahatk, fgsxy\n" +
      "tlkqqk (67) -> kuydvlr, yqewlf, qfhptx, tpxvyjx\n" +
      "dcjiu (69)\n" +
      "dpqznt (5)\n" +
      "xsdzkqs (93)\n" +
      "iiyhw (1258) -> ozecapv, yxqwz, kspwjf\n" +
      "snbjccn (61)\n" +
      "yjdfxn (24)\n" +
      "cnvjej (188) -> onhpt, wxpagp\n" +
      "vkrhnw (87)\n" +
      "sqkra (97)\n" +
      "oatauv (204) -> hfzsc, pvuno, osckuj, dcpgsg\n" +
      "ddeso (43)\n" +
      "lvbgvb (53)";
}