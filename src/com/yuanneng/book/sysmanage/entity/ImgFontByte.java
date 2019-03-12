/*
 * @(#)ImgFontByte.java
 */
package com.yuanneng.book.sysmanage.entity;

import java.io.ByteArrayInputStream;
import java.awt.*;

import com.yuanneng.book.common.entity.CommonBean;

/**
 * ImgFontByte.java
 * 
 * 功 能： 生成字体
 * 
 * <pre>
 * ver      修订日              作者            修订内容
 * -----------------------------------------------------
 * 1.0     2016.04.15         shanjixiang        新规做成
 * </pre>
 */
public class ImgFontByte extends CommonBean {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获得字体格式
     * 
     * @param fontHeight
     * @return
     */
    public Font getFont(int fontHeight) {
        try {
            Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new ByteArrayInputStream(
                    hex2byte(getFontByteStr())));
            return baseFont.deriveFont(Font.PLAIN, fontHeight);
        } catch (Exception e) {
            return new Font("Arial", Font.PLAIN, fontHeight);
        }
    }

    /**
     * 字体字节
     * 
     * @param str
     * @return
     */
    private byte[] hex2byte(String str) {
        if (str == null)
            return null;
        str = str.trim();
        int len = str.length();
        if (len == 0 || len % 2 == 1)
            return null;

        byte[] b = new byte[len / 2];
        try {
            for (int i = 0; i < str.length(); i += 2) {
                b[i / 2] = (byte) Integer.decode("0x" + str.substring(i, i + 2)).intValue();
            }
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ttf字体文件的十六进制字符串
     * 
     * @return
     */
    private String getFontByteStr() {
        StringBuffer strBuf = new StringBuffer();
        strBuf.append("0001000000100040000400c04f532f327d8175d4000087740000005650434c5461e3d9fb000087cc00000036636d61709cbc");
        strBuf.append("69ab00007a64000005e863767420bb32bf1600000f24000000326670676d8333c24f00000f1000000014676c7966302665d8");
        strBuf.append("00000fc40000663c68646d7806beef530000806c0000070868656164c6469a91000088040000003668686561068002f40000");
        strBuf.append("883c00000024686d7478e8bd09b4000077b0000001ac6b65726efffe00650000804c0000001e6c6f6361001a319600007600");
        strBuf.append("000001b06d617870013e049f00008860000000206e616d65a927f7000000010c00000e04706f737469df66ea0000795c0000");
        strBuf.append("010670726570eacfd8a800000f580000006b0000001f017a000000000000000001de00000000000000000001001c00520000");
        strBuf.append("000000000002000e01de0000000000000003003201ec0000000000000004001c005200000000000000050024021e00000000");
        strBuf.append("00000006001a02420000000000000007005c0052000100000000000000ef025c0001000000000001000e0285000100000000");
        strBuf.append("00020007034b0001000000000003001903520001000000000004000e028500010000000000050012036b0001000000000006");
        strBuf.append("000d037d0001000000000007002e0285000300010409000001de00000003000104090001001c00520003000104090002000e");
        strBuf.append("01de0003000104090003003201ec0003000104090004001c005200030001040900050024021e0003000104090006001a0242");
        strBuf.append("0003000104090007005c00520003000104090008002c038a000300010409000900180aa2000300010409000a01300b160003");
        strBuf.append("00010409000b004c0a12000300010409000c00440c46000300010409000d076003b6000300010409000e00600a1200680074");
        strBuf.append("00740070003a002f002f006d0065006d0062006500720073002e0061006f006c002e0063006f006d002f00760072006f006f");
        strBuf.append("006d0066006f006e00640065002f007400740066002f0020002d00200041006300740069006f006e0020004a00610063006b");
        strBuf.append("0073006f006e00200043006f007000790072006900670068007400200028004300290020003100390039003800200054006f");
        strBuf.append("006d0020004d00750072007000680079002000370020002d00200046007200650065002100200042007500740020006e006f");
        strBuf.append("007400200074006f0020006200650020007200650073006f006c006400200028006f006e00200043004400200066006f0072");
        strBuf.append("00200069006e007300740061006e00630065002100290020002d00200049006d0069006700680074006200650054004d0040");
        strBuf.append("0061006f006c002e0063006f006d0020002d00200033003300390020005300740069006c006c002000480069006c006c0020");
        strBuf.append("00520064002e0020002d002000480061006d00640065006e002000430054002000300036003500310038002e003100380033");
        strBuf.append("00300020002d00200045006c0069006d0069007400610074006500730020004f0064006f00720073002e0020004e006f0074");
        strBuf.append("0020004100200043006f007600650072002d0055007000210052006500670075006c0061007200460072006f0067003a0020");
        strBuf.append("00200041006300740069006f006e0020004a00610063006b0073006f006e00200031002e003000460072006f0067003a0020");
        strBuf.append("00200038002f00320033002f0039003800200031002e00300041006300740069006f006e004a00610063006b0073006f006e");
        strBuf.append("687474703a2f2f6d656d626572732e616f6c2e636f6d2f76726f6f6d666f6e64652f7474662f202d20416374696f6e204a61");
        strBuf.append("636b736f6e20436f7079726967687420284329203139393820546f6d204d75727068792037202d2046726565212042757420");
        strBuf.append("6e6f7420746f206265207265736f6c6420286f6e20434420666f7220696e7374616e63652129202d20496d69676874626554");
        strBuf.append("4d40616f6c2e636f6d202d20333339205374696c6c2048696c6c2052642e202d2048616d64656e2043542030363531382e31");
        strBuf.append("383330202d20456c696d697461746573204f646f72732e204e6f74204120436f7665722d557021526567756c617246726f67");
        strBuf.append("3a2020416374696f6e204a61636b736f6e20312e3046726f673a2020382f32332f393820312e30416374696f6e4a61636b73");
        strBuf.append("6f6e005b0044006900760069006400650020004200790020005a00650072006f005d00200046006f006e0074007300480065");
        strBuf.append("007200650020006900730020007400680065002000730075006d006d0061007200790020006f006600200074006800650020");
        strBuf.append("006c006900630065006e0073006500200066006f00720020007400680069007300200066006f006e0074002c002000770068");
        strBuf.append("0069006300680020006d006100790020006200650020006f00760065007200720069006400640065006e0020006200790020");
        strBuf.append("0028006d006f007300740020006c0069006b0065006c007900200076006500720079002000730069006d0069006c00610072");
        strBuf.append("00290020006e006500770020006c006900630065006e0073006500730020006100740020007400680065002000550052004c");
        strBuf.append("002000620065006c006f0077002e000d000a000d000a004e004f0020004d004f004e004500590020006d0075007300740020");
        strBuf.append("0065007600650072002000650078006300680061006e00670065002000680061006e0064007300200066006f007200200074");
        strBuf.append("00680069007300200066006f006e0074002000660069006c0065002c00200077006900740068006f00750074002000450058");
        strBuf.append("0050004c00490043004900540020005700520049005400540045004e0020005000450052004d0049005300530049004f004e");
        strBuf.append("002000660072006f006d0020007400680065002000640065007300690067006e00650072002e000d000a000d000a00540068");
        strBuf.append("006900730020006d00650061006e007300200079006f00750020004d004100590020004e004f0054002000530045004c004c");
        strBuf.append("0020005400480049005300200046004f004e00540020006f006e0020006100200066006f006e0074002d0063006f006c006c");
        strBuf.append("0065006300740069006f006e002000430044002c0020006e006f0072002000730069006e00670075006c00610072006c0079");
        strBuf.append("0020006e006f0072002000700061007200740020006f006600200061006e00790020006f0074006800650072002000740079");
        strBuf.append("007000650020007000610063006b006100670065002e000d000a000d000a0059006f00750020006d00610079002000640069");
        strBuf.append("007300740072006900620075007400650020007400680069007300200066006f006e0074002000660069006c006500200074");
        strBuf.append("006f00200061006e0079006f006e006500200079006f0075002000770061006e0074002c0020006100730020006c006f006e");
        strBuf.append("006700200061007300200079006f007500200064006f0020006e006f00740020006d006f0064006900660079002000690074");
        strBuf.append("00200061006e006400200064006f0020006e006f0074002000630068006100720067006500200061006e00790020006d006f");
        strBuf.append("006e006500790020006f0072002000730065007200760069006300650073002e000d000a000d000a0059006f007500200063");
        strBuf.append("0061006e00200075007300650020007400680069007300200066006f006e007400200069006e0020006e006f006e0063006f");
        strBuf.append("006d006d00650072006300690061006c0020006100700070006c00690063006100740069006f006e007300200061006e0064");
        strBuf.append("00200077006500620073006900740065007300200066007200650065006c007900200061006e006400200077006900740068");
        strBuf.append("006f007500740020007400680065002000640065007300690067006e00650072002700730020007000650072006d00690073");
        strBuf.append("00730069006f006e002e000d000a000d000a0059006f0075002000630061006e002000750073006500200074006800690073");
        strBuf.append("00200066006f006e007400200074006f002000630072006500610074006500200063006f006d006d00650072006300690061");
        strBuf.append("006c002000700072006f006400750063007400730020006f00720020007700650062002000730069007400650073002c0020");
        strBuf.append("0062007500740020007700680065006e00200061007000700072006f00700072006900610074006500200049002700640020");
        strBuf.append("006c006f0076006500200066006f007200200079006f007500200074006f002000730065006e00640020006d006500200061");
        strBuf.append("00200063006f006d0070006c0069006d0065006e007400610072007900200063006f007000790020006f0066002000740068");
        strBuf.append("00650020006900740065006d00200079006f0075002000750073006500200069007400200069006e002e000d000a000d000a");
        strBuf.append("0046006f00720020007400680065002000660075006c006c0020006c006900630065006e0073006500200061006e00640020");
        strBuf.append("0075007000640061007400650073003a000d000a000d000a0068007400740070003a002f002f006d0065006d006200650072");
        strBuf.append("0073002e0061006f006c002e0063006f006d002f00760072006f006f006d0066006f006e00640065002f007400740066002f");
        strBuf.append("006c006500670061006c002e00680074006d006c000d000a000d000a004d00610069006c0069006e00670020006100640064");
        strBuf.append("0072006500730073003a000d000a000d000a0054006f006d0020004d0075007200700068007900200037000d000a00330033");
        strBuf.append("00390020005300740069006c006c002000480069006c006c002000520064000d000a00480061006d00640065006e00200043");
        strBuf.append("0054002000300036003500310038002e0031003800330030000d000a005500530041000d000a004300720065006100740065");
        strBuf.append("006400200062007900200054006f006d0020004d0075007200700068007900200037002e000d000a000d000a005400680069");
        strBuf.append("007300200069007300200061006e00200075006e006500760065006e00200073006f007200740020006f0066002000330044");
        strBuf.append("00200061006300740069006f006e00200066006f006e0074002e0020004c006f006f006b002000610074002000690074002e");
        strBuf.append("000d000a000d000a005b0044006900760069006400650020004200790020005a00650072006f005d00200066006f006e0074");
        strBuf.append("0073003a000d000a0068007400740070003a002f002f006d0065006d0062006500720073002e0061006f006c002e00630061");
        strBuf.append("f006d002f00760072006f006f006d0066006f006e00640065002f007400740066002f000d000a0068007400740070003a002");
        strBuf.append("f002f006d0065006d0062006500720073002e0061006f006c002e0063006f006d002f0069006d00690067006800740062006");
        strBuf.append("50074006d002f4001002c764520b003254523616818236860442d000b030900210018001b0023001c009b003d0063012d016");
        strBuf.append("9011001d800b801b200de00f901d55a725a725a725a72000400060000401f1212111110100f0f0e0e0d0d0c0c0b0b0a0a090");
        strBuf.append("908080707060601010000018db801ff854568444568444568444568444568444568444568444568444568444568444568444");
        strBuf.append("56844456844456844456844b3030246002bb3050446002bb10202456844b10404456844000002003f000001b603200003000");
        strBuf.append("7005640200108084009020704020100060502030205040500070605010201030000010046762f3718003f3c2f3c10fd3c10f");
        strBuf.append("d3c012f3cfd3c2f3cfd3c003130014968b900000008496861b0405258381137b90008ffc0385933112111253311233f0177f");
        strBuf.append("ec7fafa0320fce03f02a300060024001000fd03060028003500480055005e006900914044016a6a406b295d5a3d3a5c56095");
        strBuf.append("303175f3b3a021b0029022f65032f3603034642403f3d05450304034a4902070b05495549050d68052c4f04233204612c002");
        strBuf.append("301011746762f3718003f3f2ffd10fd10fd2ffd3c10fd012ffd3c2f3cfd173c10fd2ffd10fd3c2ffd3c3c2ffd2e2e2e002e2");
        strBuf.append("e2e2e3130014968b90017006a496861b0405258381137b9006affc038591314061d011406071607060706232227262726272");
        strBuf.append("62726351437363534373637363736333217161716131406232226353436333217160334272627111633143d01343534263d0");
        strBuf.append("13436031134262726270607061514131736272635160717362734232207061514163332fb0705010401050c34330d02180a0");
        strBuf.append("103050f0c01010d072d0e2620030412190d0102361a1e3a30222818161c020310090802062b04010103234a03258a01070a0");
        strBuf.append("3090a0c202218131526122a02a203640289012a0a3e66060705010f15041e43958401072a2729180603030103020a0d2802f");
        strBuf.append("d961e2d392022301f1b021d19070e1afe000506254412291440015e0366fe5101db031d04010204041f373cfe988e15070a0");
        strBuf.append("1320c07121a390e1119122400ffff001001aa026b03550027000ffffd024f0007000f0140024c0006002e0045021f02a7002");
        strBuf.append("500e500e900ef00f901020130408101fdf1f0eae9e7e6e3d3d0cbc9c3bfb8b4afacaaa89b997c6e6a5d5b57504d3a3930241");
        strBuf.append("d18110efffaf0eceae8e6d5cecbc6c4bdb9b1afa593898682807674717066655f322a26221b1a090807001f030514020305f");
        strBuf.append("502903a029059029035022d530290dc053e0b05552a2804ee553e04f6f54704d74a4404ded77a9e7e019346762f3718002f2");
        strBuf.append("f2fb901000004fdb801013c2f3cfd3c10fd2f3cfd2f3cfd3c10fd10fd012ffd2ffd10fd10fdb801003c10fd2f3cfd10fd2e2");
        strBuf.append("e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e002e2e2e2e2e2e2e2e2e2e2e2");
        strBuf.append("e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e313001b9010400264968b900930103496861b0405258b90");
        strBuf.append("103004038b801031137b90103ffc038590114060736151407171514232226232206232226353437363332170716173635342");
        strBuf.append("63534371637142322271e01151406232235343635342e0127231407062322272627262322062322262322062322262322061");
        strBuf.append("514173633321514232235061514171617161d011617161736373633321715062207161514070623222706172635343726272");
        strBuf.append("6273e0135342627262726372e01353437363736373233323633321716171e011514062322270623222623161514062322272");
        strBuf.append("627071617161514232227262707161514062322271416151423222623220716333236373633321736373e013332162f01071");
        strBuf.append("f01060716333227230607061733363736132e012322071533320213100101140706173f030d370e040b39261f05051315290");
        strBuf.append("f041c030c440a0b010f340a0d2b1302062c16102a270a0104010105110405100404090302260b040a180a080f12030210030");
        strBuf.append("d090b5235290d1a12120827062413091813170f0b0d0713061a4b3f22031c0a0713033105081026231a0f0a03190a2a0a2d3");
        strBuf.append("f471e090f0b04050b060808110f150b040218031a0a08090d1407150d0e0e200b040229050e06111d431c5925030d02111c3");
        strBuf.append("31014270618112e1b560704082c062b100409980d0216100110020e144c020c04040f0c060127021102031b140f040802260");
        strBuf.append("b0a050e080501130b1716070410050d14029830010724030a2d10091d040322092d250c091d0d170104040d190e040d0a0e0");
        strBuf.append("f0f02050a433a0a150e180303110c0f030422110f04141101140a081213130c130a0909100d111c02110f0d0714801927081");
        strBuf.append("00d1a3732150d02070e0f1406260d050a0b0b250e0f040b17030d0208090d030f17101002120b050a1b030e03152543160e0");
        strBuf.append("10a190106021613620f010e630434052b05110d0f0b0f17fea80109071200ffff002e0045021f02a7000600060000ffff002");
        strBuf.append("e0045021f02a7000600060000ffff002e0045021f02a7000600060000ffff0013019c012b03440007000f0000023e0002001");
        strBuf.append("8ffdc010f030200220030004a40190131314032002923292318001e02272d020c0b031401010b46762f3718003f2f012f3cf");
        strBuf.append("d2ffd2e2e2e2e002e2e3130014968b9000b0031496861b0405258381137b90031ffc0385925140623222726272627263d011");
        strBuf.append("4373637363736371617161514070607061514171e010726272635343706070615141716010f290c04253a1e141914070c1e2");
        strBuf.append("83c08100d0c130e1302112f02215b29101944371f1b171e20063e1926382455442f60053a5a49631a060809090d061b384a0");
        strBuf.append("a6059a3780638037e42695e899c2f695858754c6200020013fff900f303150018002600494019012727402800211d211d120");
        strBuf.append("a1902001f030c14010800010a46762f3718003f3f012ffd2ffd2e2e2e2e002e2e3130014968b9000a0027496861b04052583");
        strBuf.append("81137b90027ffc0385913140706070607062322273635342726272635343716171e010734272627161514073637363736f30");
        strBuf.append("809072956241010054a1a0212100b05184666411d2035363c101a22171501ad1c5155147f431c10b981ae970d3a360506050");
        strBuf.append("11236c8535156612da1f483a10d1c3574650000010029023000e102e4002f006140260130304031002b201f1d23201704000");
        strBuf.append("e271b0e1f1402061f022a272d05090d05252511011b46762f3718002f2f10fd2ffd012f3cfd2ffd10fd10fd2e2e2e2e002e2");
        strBuf.append("e2e2e3130014968b9001b0030496861b0405258381137b90030ffc0385913140706071615140623222726270607062322263");
        strBuf.append("5343637262726353433321733342635343332151406151736333216e1120d0d260d0a09130d0c08080c08081614031312161");
        strBuf.append("110250606101f02041b08051902920a04020125050b17140e0e0f0f1717080a140b030205131f13082108121804130506132");
        strBuf.append("50005001800dc0210030c00300038005e00690072009b404401737340740070665a5150494740351f076e6a625c5b4b47454");
        strBuf.append("43e3b39312b291817090700555402354e03695f6261051c57050c383105046a040c54046c0c2301011746762f3718003f2f2");
        strBuf.append("ffd10fd2ffd3c10fd2ffd3c012f3cfd2ffd3c2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e2e002e2e2e2e2e2e2e2e2e2e2");
        strBuf.append("e3130014968b900170073496861b0405258381137b90073ffc03859011407062322262316070e012322272627263506272e0");
        strBuf.append("13d0134373633321633363736333216171e01151407161716171607262726271e01333726353436352627060706271706073");
        strBuf.append("63332151406151417333236333534333216333735343605262b011617163337363517262322071617323602100c0f0d13491");
        strBuf.append("30101042b3e380a2505021d36072c1809111042110207050d0a89030c250d272810082741032c232218212e0990112952040");
        strBuf.append("8068b0403010e3943050412103f10191552150206fed71f341716040c1c2602b0191e0453070e145101e21a3943134b081d1");
        strBuf.append("306341908500208033e07512c050105535c0a1a0309370c1d3c0809040e4477200906062510af1c12196118060d525a0a040");
        strBuf.append("40a4d022d124412100907641f1501150f3d4d081d030801060eb925070b16030000030013ff5e012b0106001d00360046006");
        strBuf.append("7402901474740481a37313d312f25230a042928020f1e02383733023b43021a3f0500232205131300010f46762f3718002f2");
        strBuf.append("f10fd3c10fd012ffd2ffd2f3cfd2ffd3c2e2e2e2e2e2e2e002e2e3130014968b9000f0047496861b0405258381137b90047f");
        strBuf.append("fc03859172227302736373637363726272e01353437363332171e01171615140706132627262b01161514061d01161716171");
        strBuf.append("61514073635342726371514161514071633323736353427268511171e010b0808120c14220d230c061d7724054102062d310");
        strBuf.append("3070509661f02050e161b08232e6a04041f098612023a27230601a21f2d080d0a09191d010a0a481176100a170374071c324");
        strBuf.append("a3b4001244a0b0f0406041004580602040209312e40295b0e161b10070c2f0c73351536323c2413020003003c0109021d01e");
        strBuf.append("100200038004f007a403401505040511f48443f3e4e432c3821021f2d0210323105072e2d050c04054b2505183836053b4b0");
        strBuf.append("40722212a0418141b0c011046762f3718002f2f3c2ffd3c3c2ffd2ffd3c10fd10fd10fd3c10fd3c012ffd2ffd3c2e2e2e002");
        strBuf.append("e2e2e2e3130014968b900100050496861b0405258381137b90050ffc03859002322062322262322072206232227263534373");
        strBuf.append("617321716333236333217161514272322062322262326232207173332363b0132373637361f01262322062b0122070623173");
        strBuf.append("637363332163332363326020e2e0d350d1144112b590513051631070b21942c44410c071e071c100c440e081e080b26092d2");
        strBuf.append("c6649062a030c037e1120250e104a041123185e1682070c0f041a08123052114512103d0f060112030405054952210b040d0");
        strBuf.append("10201041e171d67970808020a5204050601010123030c02021c03030404040b0000030012000500f200c50012001a0027005");
        strBuf.append("1401e0128284029001715171b020013030021020a2505051e040d0d0500010a46762f3718003f2f10fd10fd012ffd2ffd10f");
        strBuf.append("d2e002e2e3130014968b9000a0028496861b0405258381137b90028ffc038593714070e01232226272635343633321716171");
        strBuf.append("6073427160736373627342623220615141716333236f21e043a06134d0b132f2323350e190f1a160c150c0b082e261b161d1");
        strBuf.append("1131f151c5e321a030a2b0e171d23301f0716151d200c1e270303042517291c161a1519260003002b0051015d02dc001b002");
        strBuf.append("300320058401e0133334034002d25222b24201c1200292b06141212141e0419190f011246762f3718002f2f10fd01872e0ec");
        strBuf.append("40efc0ec4012e2e2e2e2e2e002e2e2e3130014968b900120033496861b0405258381137b90033ffc03859011407060706070");
        strBuf.append("607060716070e0123222635341336373e013332162726233207163332072706070607060716173637363736015d0c0c011b1");
        strBuf.append("b1e0e0c0d010503350e1044551e39052a0c103b1d1410031923030a1e1f1a1e0e181d3c0f1f2c1c072c1f02a901181b03484");
        strBuf.append("8553e337014270a16230e15011f68910c212503130d150a0f3a5e214366ca070fc35616765600000600060012023c0303001");
        strBuf.append("b0025003d004d005c006700794035016868406900645e241e66645d231e5702484f4e023e1c030034020c2602206202483a0");
        strBuf.append("50853054c2e041259044412010800010c46762f3718003f3f2ffd10fd2ffd10fd012ffd2ffd2ffd2ffd2ffd3c10fd2e2e2e2");
        strBuf.append("e2e002e2e2e2e3130014968b9000c0068496861b0405258381137b90068ffc03859011407060706070623222726353437363");
        strBuf.append("7363332171617161716171607342716151406151736273427262726272623220706070615141716171633323736271407060");
        strBuf.append("706232227263534373633320335342726232207061514333237362f01060706151417263534023c0508010e3a3e54a05b532");
        strBuf.append("8336b250279450d192f1113070b1a39220818073e050701073c3f51ad1d010b09192623344f833324470d1114193850261c1");
        strBuf.append("b2341962a120e0836241b5425141093101e08031802012a0f162005553a3f746aa57f59701d093c0f1d36222743624ce54e8");
        strBuf.append("969124713022b5d1b29380c534044d70d221d1278395926376447b731556513196e4e634b3f52fea3a70f490b6a524689302");
        strBuf.append("5f0020c1f0d33452e18165f00000400290006020f030c00450059008a0093009340420194944095008e716d645e5c59513e2");
        strBuf.append("11f917e6b4f4e47463c170f260e1a00025a79031a75031d4b03385a038e8f6003586203544005049183050b2f010b00010f4");
        strBuf.append("6762f3718003f3f10fd3c2ffd012ffd2ffd2f3cfd2ffd2ffd2ffd10fd10fd2e2e2e2e2e2e2e2e2e2e002e2e2e2e2e2e2e2e2");
        strBuf.append("e2e2e3130014968b9000f0094496861b0405258381137b90094ffc0385925140706232206070607060722272635343736373");
        strBuf.append("63336353426353436353427060726272e01353437363736373e0133321716171615141615140706171617363332171617162");
        strBuf.append("7351427263534263d0134271406151417161f022627062322270237262322060706070607161736373633301716151407060");
        strBuf.append("7160f010607161732163332373637363736373426270714173426020f140a24081e05204033830842190b043c380e0403090");
        strBuf.append("3040d12240f3a252c02080e08920f0e1815040802020201010631051108240903970202071802050504115d04042b3d17020");
        strBuf.append("c011209115e0a1515191712261011180b0a0c0405010203086321070e030d0421334b092e2d364e10020117044a1c0804070");
        strBuf.append("10206070549431f0e0c03070703110b2b0319651a11110808081308490e073b46031114020d252211275d196f19102620131");
        strBuf.append("c1905061e2e13600d09211c59208b1f5903220e3d0f4f745e5f0a7a22420735011bc7040c0524252b1a182e101118020a821");
        strBuf.append("a2a370d2546060c011e3b020609010203043c080f034b10140e3b000500210022024702f60040004a00870092009b00ae405");
        strBuf.append("4019c9c409d009b918c6c49209377694b46368802715802001a027199030f8e032441037160032f850205030744056e1c056");
        strBuf.append("e830509807e7c037b050c3d054b4b043a38363a0497545250044e63042c2c09012446762f3718002f2f10fd2f173cfd3c3c1");
        strBuf.append("0fd10fd2ffd173c10fd2ffd10fd012f3c3cfd2ffd2ffd2ffd2ffd10fd2ffd10fd2e2e2e2e2e2e002e2e2e2e2e2e313001496");
        strBuf.append("8b90024009c496861b0405258381137b9009cffc038592514061514151615142322242322263534373637363736373e01353");
        strBuf.append("4232207060734272635343e01373637363332161514060706070607323316333236333217160334262322073216073613220");
        strBuf.append("623222326232223262322353437363736373635342623220706070615161f013633321615140706070607141716173332173");
        strBuf.append("233321633323f01360134272627061514161736132627262706353017024708012d46feec4509321c072d1329233c05102a2");
        strBuf.append("0343b17282008060c27544a44596c2f2612232e0a111f220e1042110d151be418090611111a0310c51556150b16160b0a121");
        strBuf.append("20a19394006291c165d4e373c19313a0f210b7f29202d841b251e1e080c020c1527271520802026230501fe471110070a220");
        strBuf.append("60a120305060b1525fb0c320b070e0d07670487121f22082a162a17370628081414160401372d050122210d2c1b18725a296");
        strBuf.append("233171b250a0108060801120911121c1016fee90501010f072f35062f48370f4f620f06181b0e1c38043a2f203e6214251f1");
        strBuf.append("e1c2c3b0c0106014615015906201d09200604360814fe460912264b2f016e00040010000501ed0313003f0048007b0085009");
        strBuf.append("9404601868640873c807c6f5b5a4340277e716458574d423a2d1d0951023678023c13026223026a6247023684023c6667056");
        strBuf.append("d0d050073050025055e10056d55042f2f010000012d46762f3718003f3f10fd2ffd2ffd10fd10fd10fd3c012ffd2ffd2f3cf");
        strBuf.append("d10fd10fd10fd2e2e2e2e2e2e2e2e2e2e2e002e2e2e2e2e2e2e2e3130014968b9002d0086496861b0405258381137b90086f");
        strBuf.append("fc03859372227262726272e01273637363332163332363534272627262726272635343736373635342322072627262726273");
        strBuf.append("6333216171617161514070607161514070613060717363736353407262726353437363534272623220715341733323633321");
        strBuf.append("71615140716173736161514062332270607163332373e013534272617060716333237363534b02208130e060f09110111101");
        strBuf.append("d0d0b2c0b1321341608030b010604131c1c262a1e4e0b1a1904050f56693276221612151917236a6b527a045412191e1c651");
        strBuf.append("11015125d4337435b420d0410401032222e76050a1320343b2501400f1d2e1c5e37284c191c5306370414110d0b050105120");
        strBuf.append("8150c190d2324380e110f1f032b1c0d3e05130e0a07090c0b141218200325220d12592b2b21151e23192b302c1f578375362");
        strBuf.append("802796d4905013d371f11bf0102040f0212584e3c231c1a0802440f11152f5024244901012f21243a0c1d3d141811702b2a2");
        strBuf.append("a2fa2234e192922161200000500160013022a030b00400049007b008a009400974043019595409600908b857c7a715f53514");
        strBuf.append("841342e03908b857c6f635b4a462d2b18150057023d69021c4102394d4c033d5003390d040f2a04267605052601100f00011");
        strBuf.append("c46762f3718003f3c3f2ffd10fd10fd012ffd2ffd3c10fd2ffd10fd2e2e2e2e2e2e2e2e2e2e2e2e2e2e002e2e2e2e2e2e2e2");
        strBuf.append("e2e2e2e2e2e2e3130014968b9001c0095496861b0405258381137b90095ffc03859011406072623220706070607060706072");
        strBuf.append("306272e01373e013726272635343736373637363736373217161f01060717363736373631321617161514070607161716270");
        strBuf.append("6070e01151617361726273534363727062322262235343736372627262306070607161716171615140706070607163336373");
        strBuf.append("e01333217163336010e010706310607060736373637361306070e01073e013736022a300c0a300506060c020204200710141");
        strBuf.append("8383f1401043203383756121b0209090f0b172f111a151603101e40071603211e0a6803060e1202171722bf0b100513070a0");
        strBuf.append("eb818311c015c27100156321216040518110b0d1b1120205149260c0d0f0209205a19051f0307100e161f040bfe8f130d030");
        strBuf.append("50a120d14080c0723219a1720092e010e1e081801b61c6e02042f2a441d1d1916070d01090a120f25d2150b0c151924334d0");
        strBuf.append("828273d0811220806060c41820c2840060e0d1103060a1f2f3e0e0b0a11c1030c084c0a020627830b19051e6d190c9c1e0f2");
        strBuf.append("3424f17010504305f31620a0e0c0f050c072c3306407f0c35c6102305081c014b0f1814201c372c4c040a087c75feb50b160");
        strBuf.append("dd917050b0a7100050018000d02510300003b0049007c0088009800974044019999409a00908b8783817b5f4f443c291f049");
        strBuf.append("089817461534a3c1b08002c02574424025769020e7d035778050606044795041485042622045b65048e32011400011b46762");
        strBuf.append("f3718003f3f2ffd2ffd2ffd10fd2ffd10fd012ffd2ffd10fd3c10fd2e2e2e2e2e2e2e2e2e2e2e002e2e2e2e2e2e2e2e2e2e2");
        strBuf.append("e2e2e3130014968b9001b0099496861b0405258381137b90099ffc0385901140e0107262706071617161716151406070e012");
        strBuf.append("3222726272e013534373637321633323534232206232226353436373637131617161716171617160734272627262726271e0");
        strBuf.append("13332163726272e012706070615161716151407062322272627060716171633323736353426352627262726272635343e013");
        strBuf.append("33216333603342726271617363332173617262322062322271e0117163332373602511f0e10438f070319313c272227301c6");
        strBuf.append("a2227464e160916111106077d233a600a24090d320801030954376c16a2161e0405054509072c1e1d264d0a16160f8542363");
        strBuf.append("53e6163052a26652e55242025222d2726100b51081c4364414a111a241c3a191a281d06092baf2c09da4d136501113c04541");
        strBuf.append("c035a06060368215d6f05164f461e23334002520e680d041e20171b050c0f463e433c4b2415230f1214083f0f07302d0b2c1");
        strBuf.append("d3407570f041903172f010f020a0328040d052c2778141b070704040c18111f39c30f0f100a08377b6f46010f1a4c2217140");
        strBuf.append("c0c0c13302603082d34600f27082b120d0602020409088f0a3826feb03614050b05240a4a08a112292f1d1a0f0e0f1300000");
        strBuf.append("7001800170214030e00260030004e005900680074007f00ad40510180804081257a75746f6e6c5a5440332d7e6f6e5854352");
        strBuf.append("f2d2c1e13023d4b022578025d46020a74693d026528026572050461054f28270510560404181a042f311e04204f044848045");
        strBuf.append("210010400010a46762f3718003f3f2ffd10fd2ffd3c2ffd3c10fd10fd3c10fd10fd012ffd10fd3c3c2ffd2ffd2ffd10fd2e2");
        strBuf.append("e2e2e2e2e2e2e2e2e002e2e2e2e2e2e2e2e2e2e2e3130014968b9000a0080496861b0405258381137b90080ffc0385925060");
        strBuf.append("7062322272627263534373637363332161514070e0123262322070607363332171e01151403232207061d013637260722072");
        strBuf.append("6353437363736373635342f01060706070615143332363534272603220623222716333237262722263534373633321716151");
        strBuf.append("40706373426232207313236333217072206071633323736353401ea1c36392c57494423142921585c691623080309070a029");
        strBuf.append("12106074f2d3a212b40910e1526293f3b063756651510151c4c6d0204071512b14121f04566191c48081d07453541440c361");
        strBuf.append("46f23433e33392a1e213a2d4322143015071d07341c522839051716292835812720233a36543155358267464932175a10070");
        strBuf.append("3027113251d0a0c5c2e6d01cc111210031f010ed44c022314374e20590e210210180307031ed2692ef76c46501e21fea7051");
        strBuf.append("129120b4e3d2334211b15182a4120188913171b0517042b25160d101d2c000005000c0012023102ec002c00390044006b007");
        strBuf.append("20093403c0173734074006f6c665b56554b49413a362f19156f6d6c645e533e3a36312f1f151166680806040406666808070");
        strBuf.append("606074502004d0425250b00011f46762f3718003f2f10fd012ffd872e0ec40efc0ec4872e0ec40efc0ec4012e2e2e2e2e2e2");
        strBuf.append("e2e2e2e2e2e2e2e002e2e2e2e2e2e2e2e2e2e2e2e2e2e3130014968b9001f0073496861b0405258381137b90073ffc038590");
        strBuf.append("114070607060f0106070607262726272635343736372207060726272e023534373637363332171e021716271637362726353");
        strBuf.append("4262716171607060706071e013332373637342726272607062322070607060716073332373e0133321615140706070607161");
        strBuf.append("73637363736013534271417160231201a1a3425540d1c0513054b340604524b19253a401920081d0509060abcae2e380e062");
        strBuf.append("20803041f0a020202030c0c020601d3314d720d05200509b806cc0706060d16190a23170d94613f0d01082fb006220707101");
        strBuf.append("f1c0929651b3d407f181826feed68012502561f37282958459f1c36080703251a0928120e9f922a0c0d021a061a0f7e0d0a0");
        strBuf.append("5080f0d0603250d2925060a04030f1104171a08102610410a070b0206191f034a151e1a19010102020109060a482e19010a0");
        strBuf.append("e06073e3a1045d1132871e52c2c45fdd0090f3c081112000a0003000c0214031600190021002c00500060006f007b0088009");

        return strBuf.toString();
    }
}