package io.nimbus.leetcode.topinterviewquestionseasy.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
 */
public class FirstUniqueCharacter {

    // this implementation is a little extreme. The clarity goes but is the fastest I can think of. so not needing a
    // Map, we know the values are lowercase so 26, the getAlphabetPosition() implementation requires knowledge of a
    // char's int representation.
    public int firstUniqChar(String s) {
        int[] frequencies = new int[27];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int p = getAlphabetPosition(c);
            frequencies[p] = frequencies[p] + 1;
        }

        for (int i = 0; i < chars.length; i++) {
            int p = getAlphabetPosition(chars[i]);
            if (frequencies[p] == 1)
                return i;
        }

        return -1;
    }

    private int getAlphabetPosition(int c) {
        return c - 96;
    }

    public int firstUniqChar_optionB(String s) {

        Map<Character, Integer> frequencies = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int v = frequencies.getOrDefault(c, 0);
            if (v < 2)// avoiding more puts.
                frequencies.put(c, v + 1);
        }

        // used s.charAt() previously which was very inefficient.
        for (int i = 0; i < chars.length; i++) {
            if (frequencies.get(chars[i]) == 1)
                return i;
        }

        return -1;
    }


    public static void main(String[] args) {
        FirstUniqueCharacter rs = new FirstUniqueCharacter();

        System.out.println(rs.firstUniqChar("abc"));
        System.out.println(rs.firstUniqChar("loveleetcode"));
        System.out.println(rs.firstUniqChar("dbcxxxqfjsdauxegoblxtcupxhrjmsaqocwhdnmuxrcagirtdkvvjplqqvomtwadpwqhouxinpqkldhotlqqljmsgexhhsfrqwhhrtqbmsvwrqvromnxbppernlhjtwdxslputqpuckejqtldedslkmiaplfbmexmjfoxtolnbgfllkdlecbjcunmlgrpdogjdtgkuklhesphablolsusoxtfbuldaeamrigmfuirwmdfaqkmcutapdbdafmumggxtjpgxntuuokmkpavbxgjucroakcmhfwqqaxqcmkabisvhpfaxuvgodcnscobaicqbexkfbhvlauagprxerbguxebofruipiwvvxuafidcarnbqmqjjalpuitlecfwtsmnmavnxxjxqimfapewbtdoemacgadtspijqagjhlrswieukatsllxkxblllfpoxhtabahxverkelgodqmwooxlehtfdqcqxrfcabimscsqsqkknhassgdadppqhbcjehobecblvetlopibhwqvqrtsehqvhppifiokvkjkxmomsiikbtchwbgiqbwmbetodeuqelsjhjbsvdrweqwjpnntwdruhpmsfljiiucknevoaqvnxeotaniswpigibuvdovfrfkcjdcabpcgcwqmljpoienbfajwvdifqosuuxihsajsfawnpbkxncogevewutkalpbfvqxeldcibbgvnfamfauvhqeuhwkinqjanxowtjujgbjnuflwwixfgrtronscdjalsswwkqjusigumjjecjwwhbpncwibxcpowtptqbhchwxlnjdpitlkmgbhkdvsatgsbqrggfhsmtksiviorouofkrqociioempjlmhdcrfkpiqewcsdccfalpxhvdjcgtuqsxfhkedxcrorkpsiivuxtknudmfdxbsvpuilustfevdakqhigvgsbebvumfbrxibrjknpjwmgtiahnbknjbpntutxdrfcfhlqhqqnstlwfurpghwotnawqgmoriwmsgtuwvjnndknjquedkuxrdeglglqgtmfioknnhshcfjeauavlrfsuduulfffjrahfxolnoslqkrbcxvspfavtmpqskevddrrsacgptcbjciwwsmsxnvkipnkoopbmiplxctojwrjtebsoemhlcfajdwtqqghebtfeeddlwplxqbfqwvqdeogajlbqrkitodhjxbwxluieakwnhhvgclgtrdvwjcmagcrncfndpjgejlhfidwgvjxscwxjhhevkvlbwqbbqfwfwnpaaqdjecjpnfqkthwibonftjdhwqbrehwfihnaqfmajhwjwumbuupriabfktnwwbugawssqdqpomtoageckxkfvonndnumktjbpplrncvkoffbqlqkmaualswgsgunbgohwkjtoftcpbwspvhaboodkedphxpqcjrhufsjmjlgrqnqndjfsrrokfwjrhmuffdtksadpqlivdcmjonbhklrblwmjgdcuifjhjjboregkbmglffupawesjdqouesemnkuaxdsmxjkcnwuaqgttjodunubcolibmwbjaasskbkgummxwokmlbugukcxdxgftvneorhkxwuojhklxfnkolxgiiaelegkbhixigaufairuihdedunbfrvrplqmtbqftmugxoblowqgxsilqwfmherioudxehvrsgsaejatjfsvuubvuddpaqmtxlfuhxlufrkoeajmjvpsxngkomgksvwlqxhlukrgrdlqbeeggxhfhehlxjpntsfjtrqvshqhjufwjekjaddxwrngxrfaepltorqicxhxefaanrsvoiswkgpvwnqlvvqdsnigesgojgvpekvsbpuemanwmuapfushgahvixfuroljaqcqjpkhtcalrxwcotljuqnpgovrugshhcjhojtjbkgluobootdikottvqfvsvtccrkpampjmikwwibbodimbriqpffrcuvqjvgrwbpwnvjtxnxfgeumbcmakeotgkalenmdcqjsuqfuppkqvvoscaqkxopnmafblcuxkiimblvivtsmfpxftutwfdqfvwdufdplprruulshtmiaeswfofvuoccvjlstdrmjrnosesdchidldndcbewealmlphlovddpxrgwkiahsxtpcjwvvrpwupgrjemndcfhdakqwvjpucidrnimkdhcsgrovpiqfgbqtiirqaxknjlpakiaxlgbshmrmtuhkwxsabkxarrjudddohgcwqfjelhuwwkketxfkeqdwbhckqjhunlafltdpjlokqjjjucbqbbwbisopkulseglftjqmcwhckkecsxwuxvwsnrgtguaadxewrvglvdxmetdwuhmmhevbbmroxbuwshkhfrxulpgrfwhxdbtraorglmwpduqlcnmsonjpemvbftwtgflldmeqmipasmnadbuneholpjsuoqrdodmkxgnatitpfjbfemjbarfjfwocghbxduxvfklpjfkvumwkwftwckgrfukkfimpmhcvvsilontswmsprmcesdatqkmnerelceglgndejtqfurhdmbgkwtvxniwtsmqkumunqeeesmiifeuihfhcrkevfxwuriivlottnwtrlcurcmaudhncbaveaggaowleokkpklavbecjsrfaaaatowqvffuodfdhwblxstdgxklaotsefgivstgamncxanhotcfmlxnndvxvgdppdtfxciffxvhdmphamvxonwujfehkbqmtkpadrlodlntcqjlpjklfjrjmgabvitbgjbphmgsudfoeugtjucajhgveohgpstpjijmuobhofoqqxlapkmojwxgcmlhqaiuuihfsfkhsbhbibcaqorfxxuogrmlircbwrlmjjliairrkuseggqgbrdliuargocwrcoqadmupclaxntfpcjpivwhpojteopmlmiqqtdjrwfwopgjedurlceinwwaqlrrvopwbikbmvhmjhkkvbsemjwaafaqlsjxpbfjdlaljokawihwkdsjjstgrlwkvvoeqebjwtohisnmxqwxdkeotmdcapaqvuikkiegcrdfbqiwkxgdxfjfcqpmukgbfgaitnniwepfljeipghepviuwfnmhtbgdufgmceptntpqfiaqvrrlrbnouishtivagptvibtrmntwdeatlnslcvxeufgnbehudwrggnmiqxbgtjxkbdhpalbgwwijgeeottxpvxlhsbbhgnntwjagctnvrsrljqfqhvnxupwabsmlmlbxlrnkafsbwrxsmqqqhvmpmohbgcaafaffqkwrmkakvudpuvwhscsxntmdajwihoqxmutmlbxxfsoktgifrmihwwxoqipbvesthinsatprplwlrtvsttgpxagsgobtndukcfcvrxiacqnkfmmfjqnojilwrdgixjeunmdtgftepqkhqchadctnugvdjanhnjtbhlbnifonvdejkvvrqjjmpttciloxuqbirusdpaccvknbctobjwildopqdhqrhapldhavsvqvhuehqwspvixkaxaivjvvditqekbdkugusjrlvfivmhningorutetdixaexxuwgwipbevjbtrauepsercimvkvbblufrjhkwrfnfmljqnpftniirusnqljslaefhsmqqgfmermnihjvstptopcnvhaturdwrxgbsropjmlvdqxbjjwujdxmfdcmlecqxafeoijeunrsrxjdagolqijsgcowccqtrmajlmvgoeotdwwkhuxiufcardfbitoihfhrjntkfijaptohwbpmgdinovwtnheobreciclcklckxhtqvobousdjojkobnjwprexanuvwtlajkkimttwqkmnxhbrmwnxbmsvruxtxrjcpmomlxgnalkadpsuoljbquewditfpupbxmfwdmbsgegkbjnqxrfekhkrwrrsfgselthfcivfrxquiuleadijaonotxisqnvtcsfbcmjwjcxfkkmrxqdpljfwijjvckgpupxtriogooufojpvfpooribiwiumcnvwrkekbttuhkwumcfklbxxetcmweqoaottrvfgixbjwiwlumfahobjtjxlongmuvalugbqisqecgurgbiftwsuolruadnnoblashroqnxnufxxshwlfbdqmbxhlgojglfrtwutiixmcnpmahocxwlwhlkvgnaqeuooptteqtxkfwnqqbbiiwlngjsndjulireiwaglqoaonqrlcnohirsgrkgpbsjjlncobumpaqjbtskoolggwhraqioeiabtlpgjwwgjasdjfnbivcaomqpttbmsidrxbgrhxxlhqefafbwbnlvgjlfplofmrctpodkscpemaobgrohkiouovctnogexlxpdqwbcjgavjqmjdepcedgwjlimnlpvwqerbhavslaubbadrsmjlcdhlpvmjdgnsvldivvnxxeqrsftvcxqmksqugroaxcxpqeamcqjptdjcdkcokpwouusmpnbmhlmoigrhesksufqkuqhudftdqiteuqvdlidfmrfamtpantulvxcxeqikgpvctttxtcvonwexjcarvfvmooexpjtdoaqqfgcowqqptvpufhfvdslewflesxxgiukujiscvlwsgfupwepmilhfovbohdrlllnijcekicgnvxwiowfwmijgwwwndntkqealmdxgxwbsssspdiadxahhwhbrjmmlxpmmbmdgchwqlpsuwqwdrddafrctqbuxqwavbmqsqmfhjovhogsxrsmbvljbhdmukwufmuxclnphuglrfdjvjnlsmgpeadtlhkburlxojedhtxnirhfxxlgdlktvrasnviwkskjwdwjkacsglrftuvhekgfcsdpinqlxnjldigbfbxcjtsblpsgoilwnnmmwhtqtlhilskejxvgtbbrnstkppivnrsjvkjwgennphsbocnvsuhgtlqtafgsjfvmxajmrqsuiqpamkxhqwlqudirctugtkohlxdkkxxumfjsuokfengvacmnmbdhsinbbijrcilvnghomqoogsihhidwvpsaopctqdbasmxiblsvnwekgfivjvnmxucwpolecilxqlldkdrvabermvpqoquhjrltvwtmgoqxgfwrxhvitanmauepgcoicoewaqqduhphkjqpqpnvqviccqqkbtdpudwiqckkfjbpgjdpvtkfwgemcckbpdekwqixomtaxvgibdmiwlmpfvcriklvqsrdiflvaiiwtlnbdqwddoktuqsreacfvhbbcrgsxmmkrspkuqhhewmcnptmhdqbeeunefcmeseocdttetxmbrelpevlxuvkhxufwrwvnalkmhsvdixckqpgkosfgdixmroljvtfmphubuupbjxkpcqdouxscikivrfhtjjshgaghlqkgmwtjjftuxhdvlsgajxqfuxgqhhqqdgvkkfnglofkhphnmjihxugqpgrgqmikwhafsdbpbmsbtcwmspojmnrksvjbsgqpcldxojwvtxqbfoajgtqwiksvfnainwxgqrxbeouorojdltwuqvhwdsaxagnnrtgxacljnduelkvngsafqwlrfglslxbpnwussgxjbqvoikcjwduugwsxfflnfqlgdorpnuexamherpcvtvmrjmwqmqrhpstcjmowcmjfshdfoqnlnrpmsjgecomcjvruiabhshwsokidpgjktwfnbukdxqnvlqwcqjuckvmfongfmjajofpmggdvtgdauejviihpvvkqaqflmibsogerjxidnxwtoqsgcerxsiqkurwvrdnmdinnjgslwugohnclmwcaifgtudqlbmdpflqwqdhxxumcalqnhvkuafflpmuwfilldrhomhbvfihnjruflkkjspmsmnqumsvqohclwsppdxaqrapkpfjjgvuiunogiakwgqphvtctqcndkhqdffxsmuuvpugnxkrwdrqqltrtdbapkhhsdcnwlgucnuphsrlwnvfigceovljckhngsgreftuvvtqgjnghesmwhpmmgawgcarhsgodisfxrjequvusxaxcosqfojrbsjdflfrnnmgjppqxdsnvxqnttuiruocvrdtqmjurtqxjieojflpbukxdgveacghrigkqpsopuprbmroaljehwvurgencossnxrxfsjqxwbtasoolvluousuwfckxjscqomdxwgbjkvvfeciclcnnajxqjgehlfimnjeodaboqeqsiglfvwjwaaoqkjjcudtiewmcahieifkwhbimcopqvkiocdtbtvlesltmxfxucbgjjeopmsatpfndadcsbtabijicoavonpblwpfojmdhncwnlbnpwedfghtwoqsdsavmfjfbkbiejasnepugsrtjewmgxwprrdrepkhjoepsjhbulcprnsbnsgluqjdksbgluusextjbobmrqfgwhntshorxlkwfnkcbuewddwvjqusdsgkxhnlgmxoowjjjjvhohfmplwethalutnldoabkjiqdcfdaptvtvelwxtmnsgitbthkmpdxwkbvppurpltgfulspupidfaanqiurrtmlfqmvgembwrqqdnrlkffqxtcodvjehriiigimternthsojqfceessjbtwuhbpalvudkjlgtittgcpxmfftobqndkuneuivtsixuhlosrkgmklncjuwtamdqxxthkqnixmueselimdlujbkqrpgrrmlrlibflpbluqrtcogvjgclochrvgdkdrevmpfqiubljtpaaahbalfllwtkfamfwegudlhxhreqghvlkevnsbjtpvpnrpblckkgigakjmkstsmvkqbinkjmkpdjjrulpoiemoachwvsifefgvdkkusvelohfpsvnwxvfugophlpfaeliljmcqhofdivnqgjmmibfqlodhmkskniocwvdgopffcvcwwquwsrskgdknbjqnodcbqnxfqrfcehshsjvfwewrqultrgfppmtbqnfpuddkvbomlnhidcqxqjixfjlbcuqkfumksgiewvxnbkdrsuicxsacvqqlvkdmqsohmiebpllkdtxotqfdfilmingniglxiqcgxlqcpjulsnninrrcrkrepalguaqlouaxopcnojrpfcdhaedwujkebhrhjbcprbabhsmsvdshnqtlgtdjfewsxepqgarececwcovtunodrklmmvbrnlvxqgnjlwokjpguilugcjptkvnjvdopdwptvgtckkhrvjmmbpdvaguxilqthlqtignnoljtbefrxsnwmurgfnngcemccxqntknxsnhdquabwdxjcrwkcusciwqgxpwufkaxcmntitbstddhkxcqhglbltohgrlbophwvrllqioefdcwnvvstqbmdcnuwxnmfaqmedbtrlrhvbspddhwguscauwwibwvlvnbgdqtlnildpnklbqnbbxfbxpftnumxxfemxokvvnhgfroniaxmpjlonbjavbjcfhpojebqdpmorifcppegxgfiwekoruddxvqljlqdxotevjnkggtiaadxbixopnldowadvbxpkscaiuxuwlwbkfnsowcajdbkrkxihigmlcrkdjljwxlkgplbneblwinpirmpxpnjtikavxbrxttdlmeopevphdplltjllvdgrmtvoaqtpggtjojhdewotegflimjvubefmfpwerxipllbmcmrodncllwhiguutxtpbqwgrnojqecjgxwjrgxmaofitpcjcnkitmmnisataxbuuivenvkkehtekotdrkspcboebiengvhpoeicrbglfwantnrsaikfhwprujlpmovmuvpjxcmxmctdpsrwhnliqmugctekjsckwjltghehknuepwnagknshlqlrxievqhjejupgkfsffucjjvxvxpdklrwtnoiarmsxecgxjaixdtfhdjenljrtehjofhdcwiuveeojnesgoadidanmifgivdeehdhenmqxhsbfocxmamgttkelmijtanvecrlewpeggfxrurxqphgsrablqndddmwvqkxtdskijnhowsdrmqbmockceclapborpnuskeshqjrvvfkrppjbbprsqxjkdtghitrpugkjlbfesjehqvvjmaoclfgbbtvpklwtrquqjpmvcxctpsounmpjweqvpitrxgmhrbhdtbvoqgcflnssomwrjdrogdbvveccucmsbpablxovopulnhcrusjmwmfdneitbksftkofsrolopbpcgejpdhxxsbtpoxmjsrebjfbwvjadwdphblrsltirwvflewmfrspcwqhxcpchebrlxxjunnndhasrtvlkqdgqomofjisjqtonbirwxopwwcaqgubdgojbttgasvricsxwohrijnhsstrjduohulawnepxefffmfsgplkcmslxmutekekvsbdwuqbeaqiaterfdmkuawfnuuqreffopidtonmvfxabkitstlkvmqutjdwqropkmiwlwoilmrhpwipgohtgrqhtdbxiihqbacnhkagvmwumcehkvrtiohalepkscqrcmfbpdvufwxowmuseqhuiutwebngxwcahxbqlqmtbcdpgebiuglerlpbgnrnefuhokputbvesxsommsjeaufskqjionwuwouqvgmoarnigudhbincvtgkraoluqjocjjvhgifthilgkwjnkuqwhwsroqiatojimmmqxpikpmcalhaiqomlaxcccxvkmfocxhpccthwcahtqwnkclotxactnecjgpvvdbukglsogwaahuijjuqwljbfgfbnwsglhbmlmxqmonwochaqehqnmkrxodqqwxqmtjhldplfxfjojihndfqiktqklprqfhnaxqektljtdgiatqlbphggwfhwxhcntqtfugvremlwbafdafvtxddapgwssnlqrtdgjliqhaiwctgqqrnutdonnpugcxoigbfrxhwodakbvxewesldmororilujhcwsriwulxeavpkcehoskorbtslccbjhewsgkgpdvdjpvrxrtpxnxqnsektjdxikgdlbofjbokwhsnjtkdcsdpiqirgunfpuebcdeopiplkakwhpsfptvmskxponglguiawemropwholhtbfetnxvxcqjeadiqodjxifworwfoshhlrogonptpicwhxxsvxhhqqvkuwgsafmmpvrkwokhgwjwriaulilsjfvavfghfxlvingokbibkrmjkogvprmdthuipxgcmjdclsoelnrbmumhspshmmeafxsclegfgdmdtlalktohmfprjdsbjwkcbnxwrlxhtvgaokmlvdgukepnomjdvcgkvqevinrqtnkrwuceeucwnsmmdpuorwrotrafcjkawgxobdtwjgawoxmxgwvqfcshjqlpfiehdwwxqhorlscfwcjuqrdsjhrwqlwmskgneowfkqenjaijcmdvqigmnnhkhfqsjwakpnpwrmesmxiefuqrasppqltkambdbelwfdjtdooauauvwlchohfjdsnqbbkgmfojnsvfcmkxattteibrlaitxbodldklarkebpckthrqcpoaaedoxvrorrvdgtjjgpnvpfaejgkbauutcxsocvxjurkikqicwarojcqbdbndtlvmkivbmbsdpsncwlffidgnngatqctptmkliivhmidorexreddklbkmlcljrptuaojqtoqqdtjbdgpfsrhbakpjvgwthqnrckntelierrmmvrwgrflcafngrrlbpwsaqptelwntolnhpesebwwfjdkcjujlmabadgflqqgwsrccaivhjvadttavlwbbeqsrtxsjlattukgnkuxadbssiwwoiqctjlnsajsmdhmmwpwitjxvvtdlodnphkmrrttvsmwnkfspghutuxvqikepglmhsdhlvaljijnnwbuwvlhwnfjpuxdujntgxdubesgolqxcqmkpksxjntluqccmessvhekuqxlvuivoxnvmxvfnglmowkinccccktrsxskuakoanvmdslaaokummhwjbesoadkuljdmsgshqexomnimotridcdhdblbijelrexfbdcfsjweftoxgmfrdthhwidmmqhfenfiubfjiusnfurtwvpxmctblkmncoeedrnturltfocjmbjwfhqknfofjgggdlshftaqrletqhpajjhsubxsapqdkfhnxijwlifftwrjqoacnnswuvepdgbdepbunfkiwdmmblbnxufpqvkksixbpkknatdchruplcgunjnxtqgicqiojnjamnsjwbowdnpkvnkmvbtxelutdossabrfbuchwljcsqtjsfaoklwwengbkalwghhoasipaguvmtrmusqrewdkkvetqoqcufmfhuwktnqxbgqlbtdvsceuvtppnxdwslpipvmwaweaaqrpsjisorqfwiwxbutkqkajqdivxbaqcjswotiqgahdvejbemixwkaokoevapehasnbxskhdkkicxbhgattdcojmpaitqbfpdsrdgoifuqcepfqgqdpatkrhgcvxdgtsdamuombmjjtvhntvlamguvflketfilxatpuhsflxxvctvkklblikowpamvmojrcitppxeapaofhprtequdvhinggdwphuhvlcixljfdfhqsbeqbdrqkmdcknigelbvwrqtksenjhcxtqgjrgtloapgtekvdrjmpcwqknkxhfobsogpmhaldmlqbustuqldooevwvgdpbmopbfjcpqqaaajvfqjxjqsfebuoxgsijlgsssiuousvufqvpdwmmqslnwucwkdbpusdrgsqmmscptncrulmjkkqbkgsbdoubprcfbbpiphxdjqevshvxhktiwrwxruqhdmaasvclfsewicmrwcqagtwsbnwrltflqrlacepvikrjqsawxuocalaomccpsotlacvwaiignxomqisewwnonmsohrtrvcsrihmcublgxruginrttphmuwsqbjxonjcltwkeankfmjbrsamsvpktvijntsxpkktkgjntkgmceootdbfcuoqfrkpnmventngveaxbctqwiqufgalecnqiimmhnjmgatbotrhmjvijqqbpqwgneekfbprmfojkddvddgvnxddllvxjucvqnjvefcenvnrlbvtfgojmdvrdspfsafcelglvefxifnwxvcberkdavuctupkluofqwsdpvbafuopamjjiwbddhoobsuqnknefpgfeafrgtjmurssbnlrdwffotwwvhcitoqcswrrkruflsgdooqfjfricanmwgojkktichwhqpkkhhegqpbhfkrnurckxmqxsleiuslvjeqtpjusplvphvnvovuqpurdklfspqqkfbaacqxxdiuowxfjovmghexddqnxvqvwtfrjjdlfmxhcdakxvabmxmebvkuvellbnjewmdlmjxfnxxdbdxltxfitqklwfirtjfxpdpeetiwvhninabcrxpbtupjqqaiuiiuvviifsuluojsvlxxhgbrxakwfmtpmkddglowhgrdidmqqwqronehjgldtdqguxnkdgiokppwlvncvpoauvheiubpedivkhhtfugjpnxnunvqopgvdlthedvcpfcnhbqgknkomxjpdtetcokxbkpinsgmmbpvmwbbudjftomeipjkbtkgareildvolxwnxwsgcmgpcsaulbfgdiftxhsnoeshugigsrcnmkgdtlgaeapoidefvfqbwwuqhhnxdokujlebmaoxtnikinpmmlpetjdiedeqexbfdpochlqcqipkmwvitrwfffqhdiokukxpjiundstiljnxknwscogevkdnewktlagllnpcagxjuqrqlmdbbeorrxllqprorbmhrfpcwxnnmmmnqbegirhvsvrqnrkawnbolbluvefvbpoxhfaaxgjhbunmmowdstofcbmavpgqmxgnsaqpxldxmufagmuonftoenbwowroofvhpkttohfwnnelstnkpbhqcmdxqcfaoacgackfneqttwqvxfrfiadtnhccttdnlcgjeknenqmwvrsphapjqrwqlxvppbkvhrqqsadammrqnmrqbwiohgbowkexftdibxbemfmcmivxsioqmvllgflvmibjdsghrsbujikrtulwmmqqsobithvohdrokxskwsxartsnlhrklkagcqjvimxqfjxedihpkrmqumhhdkpnpinnevetteidiuiffvhiufhvcfxwlghwqpasalkjwhqipkxqpapefarglmkcsaovgprxwtshqerfctcodhsltijuqsjtslwtsihdxnunqfqnrbbgatwwhgqnhwekkophsktwbjsmqiqnudfqvulmbrwdbssocijkpeurnhrthfxhlagfeckocdcohulqcktskatdtgudvwnsobdemndsqkemxnjhlunrbehfmxidcktwvgnvvmvkmhvhtnjltgahgabvocatwijebpdixbrwpcfhbmwulaekpojfthctjbotatgolkwuidlsdjgdurqmwfoucwpednketlgoxinwwjasivjxmtnnseadkogvnmpnlqcjukfelwewxjaaemstleijfqxpvftawasvkspewawpsdtpvuaaangwsnmqekovwtaeswtioqoeidblwvoldxsdrckclbjcbtbgspixfonfjllmgwfndjkxccmnattjboabmnocsrttnrqlhofmqmbcveahviwbvokpgapaftpmmpbhqgftdrnesxwsbpxlnbkisairoscsgdnajoohkgwwrmpodkigjpgcxmevwhlvufngcohkglgpkltbvxbcbkwhmfbndcdeexrslfjtpccavubngpcavrdgdlhigkcxpiqdenlsgrvhlgsbokrgvtvidghwxjxgwptknegabcugktngnabwjrlumorqpfkkpvjnwdkmrdknlrdddqiqrlwsosmvmhvkestppcgohvfshjuaatodnjncrlrvqpnwtginaqchspnhetxvebvxwkjffrhrjnfhoabjcpxgjtdempudpckekhcktmharbdeurwktfntgxhpomubjwatcrxcbeikhkpfncwqvdlxqeqkrtpxtfmthgidaadatjckqqruobkjpkpupeuwdorupwhxjkirmoduxgivahkrlbdgxhencsnpedjwsaonerusjttljeshmqvhbexfrbilvdrwvtomcjsfoorxdjkecbuhnceugdtacimjidhpgqhmoqtpfhlxnsbgdtludiwwcanxnxkfamtpsbbwpenbnmufdfvmxhqoxdcwkbwxrgowarkrjihishmlnrsfsbkhqllqrpmmxopsbqgcdncwnckbsxbglwlknxjebstmluokffwavjgdepfwqwtxmoeggoelskehnhuwvssupfsgaewcaqxburvldjtuewhwoqrxpfjebrgpccenllwktofjfqhxhitquqeunhmllntoqjiqhqhnbhmbcthmlgjvbfwfnhswwrbdmacsohdxoctcdjmmajaodxotrhuxiuppfbrlwpckdicerdowwrrkeiffqvsfcqosccvljcdvgaqiksmlgodjdgktssdavtncnuilwgxaqegvamojoxxuhcowggqjhfvbvhhlfenmbketrbvkxvfjkebmgjqpsqvgktvjweoicmjlptjocrullekajldcvtocmpipiwbmrinuiartnqfpskrhpldlhfqulvqevbhraobookotsvpxxvilqkoikpsmptwjexqwwqnkapawixlcsoedfqmenjnkqkkmgwldkmqhohosgfqrlfaxuvweadqphcdabhiromtfiuajwixslscqwrmsteukksjsgbjxbgvmwnxspaxhqncftlnfggilcuwunglntlxviblobvrqlfjhmvrwrxflioavpebdmsjhojtemxnevupepnktealjcbpnkfrcenctqniuifktmatwgevohbrfcnmvixljtccipnbwvjbnskwfxjnhlbhagbgmpkirrcswbaxtlrjsvbhpuwanwcwjqpwkbiaroncvhxscsnllpxxguboqjkoihnmampkbctrwcdbukphapkvbptiavswgsuhfkrprgdaiismpegtpmmcjeuggikhcteqbsuwcaphdtuufwbckidwvvehrmsbmrfgmmbatbnvajtjwsjkikxavrtmbqbteexshqxumsoknefcrowuckcrjiauotantmburwqloccpnluqnmahhqsaskeqrxqqajedlwceqaqmvoglnsgehmrohqhpcthemmqxeiobswsqhnlsgkkssgvsrqrkphfiwlfjeeexvlwekivvkdckbxxvxtkjstefohcrlsmaagnhphlvinpulvgwrjjlkhkdmabgslwmlrxsncmkjajhrjuxplhjitiabhibifrkwtumurbdmlptrupfcxvksxwpmsasfsglcmdgeekjjjljfeicjhahkuewvdrxcifxgefqwdhtjhdbvlpgejdxqikwvjtlwrgvltdjjhxkkwacppmqmpvddehgldneblrnhstsfglowokfnkgbxivdlbnhptaduanjvpfklrewvhjkglpbimmgafkarimpghmokdtckjqkgsualbfxuscmtsgsckrbxhmpahdbkmhdrvfptorlfmpgdodujbhiqkvrgjoqumtjwjcaoblwkbkuatqxxvwfhhbxmcuhpisdwxulfkkimrnfcqmddgnpxoxxldfflqwsqnchwbqakewkceaxvefhfpwrsdjtjlvgefwfmgdxutwdarmmnxofdcpwrbpiqdpgcgwemjuekmfxcgijmpiqqasgihifqxostiufikdifitwcltxbetruhpiieurrxbthcoihshtmxprxaxnfhwxaivfjilnmlxjmgmurhsmpscajfkeoocdluwerdfaatbtmtqrxckthhecbsfdgdxevbiocfctgixsobbqiuqkdivaoqaefuvthqmllgrwmqrnlaojulmgllnsrvsubtuaqcssfolaueovbbilubwkakmgasnfugtkiwkdgvqkovhcccxxhnwlbmrhoipxvxtjqtdhalilbrntwesvfolmwbndanbjvnngplowtbcuvkwauhtehwwtibitqltetixjnvlpvfqmkgksmequmexqflsweanaxqrstbkdijquqxtbobcgmiweqrsfxoomsvfxqptrettmidpudijspccpgsshoexispjdmxnkhnblcmqekxvpwsfibhandsjfbowuxbswlvjjubmrligwainiawngfxcdpkmckvqeqnviikdcxctggulhdartnvsbdtthudifuudnfhxhuevqgopllftmktdqfcdigtsqbbeluqxjvaumlxbxxofiertqvfdaggnwogqqunsahfqbkvarirvplptxmfeewsdomsgmvwbdmdjhvrocmxmdiglqjdwhgqsjsniihlmtdkgidujjnrkkkulrefjhmjlgiheudflpnsabumswtoheskddwnvmslgowalhikniadxfblaluvkswjcfwkjhqacjfbfswtdgpwlrbifokavtihcqmmpqmxbwuacewrwaxbmaukhxmgoiifblbknoihrwewsopsugsvkqcdxxtpormehptomktcdidmuhbafbxdebmknogcnnotgdfxdtwhpvdabanrtrgbtubxbtfjkfgjfaenesioveumrrcxunqqhbsklwitxqcatgkafgbxmgmgmrircgejipwlsbircpepregahjrcwtfqciixdmklvxvkhrmrebdwxlqvkarhrsxikqbbpwtnaapxkbnmvpavfcbagvqowdaqfolgqmvjxtfcdhcserkdskqxdapieqcxlnobfxlodigukdtmdwbtacglaqudvomfutdpvpkuegdtwwaaaxfcfdjnggcipqhcaqbrbtudrnkabicpelxrkmttvrgiemkwgfjpruilupveriicxtwipoupvccjscvbasbjfbpmtjmvhxsabglxdrcpgrnfbtiluwdpudiwhgfnterqrfexiuxfpfhcthmudjxkhcdjqlkduqdujilwmitispikhnimmftapnqggtkotsltxoqgqeeqnwjmevembqrdkmaliewabdgnmpjfmjuujssadjbcasjjqisjioviulobiuivqpcwgfbguhgikejudjwbulhourkjsffmtvxvlnawwhtepnlljgfrnavslgdfukoewdjrjcwxtcjixhhgeqodkpfuxbqlmbvekcttbfmubhpscptmshbffqsmktbmtnrmnkkjbgisbhfmphjhtcxjmdbskdoabudmhsiujevkdcmfixiwbjhgjoewqkahfokustumlqqmpxtftgrrtvjmcukalxgcjeoumeosvrlanhkdrvsiiwftpllbflqhlghewohejifhubsbjmwdblmlsuipmgphmlweijwmvegxnojonkclwvferwimjxkdemsusmlijgpcqgskdhioplroordoeprkdbuumipchnhgfaswenhntwprpxspvnnlqbknnurigkwvmudqqjpjtoxnvgefdcfifmgvhbbmfffguterpobiikbshgjsigjqadqgqwqfnvtipvfjqjmuikgjxqcncpsdkgogjendotifdrpjvvqtdxvqleoocagbkmkxrsqoawumbarxuqohtbwjujfnixqksgeicrjwchifistfocfggxskcxxkdfvoqtcacrrlgolisworduvkwsifnifvfrxfweobsrxvskwfvmjnsgxkbkqafjwwmenxkqxkckeexlaucfeavhbgxgtnjvlnbvxmmiodstoqmsrvjrarsawgcgilsslcunwewesejnpklxrrspmscqlkrdxciagvuebahllnjppqcbjwvaqcfasctfartimxtbrwwgrwqsnttjifbdmjlqkobtmsdcoghueiuuvhhvjeuxwxhbjhdptgtwsmxnlubouejwgaortjokmkpjouonotjvlqqcdhjhbmfdnkewtmasrqrmuamtctcrgegahbxgrwhuadldkmeafpvksdvrippsdrraoqteouaijujrqiaubrccigjogqbhkpjbiwejpfjaqghptknfmfjnwhqlouwamwvuvclefjiutxfwfjduodssfpriqngwqxxjomifhinlerlonnkqacvkupnekrljwqvptutnfscgtdawuwjkquketnehgklihtiosseehpfuwuowjucjribbddwcdxiekoaqvwcropioxolhmploqorrlhdfkaqfplmctionbkrefaijnhnrhplltdkxsntkpbohmaqxrqivrcedfnarvbpimgebdftljamvbwqaerhjkergthtpkvnpmajkgthjfxhujsginwebagnbhgqchtmrojrlbeomtaxfnvrwrfrnlijfstnlteonhquugbbtukdqtvlkcqmmecfcdelboojebhjuncqppvnmvmswxfghkfbhslknjtovtoctfxdhfrtcdixxiwonnxvfaobxtjfjwtfcoabufgortlrinrwpobqtuhsomsnqqpdrqotoxvgcxtsphamveembgntkfeibdkuxmhsetmtmpciewcbgioxrxxvvnrmfpepfjvmocmeqrpuqqhvsarcroxaumisdtgvthorntgsgxcocphitwlublmmkdrkehohxpudrwigfadweksswrohkggamrmmpdwteqwibueofvrmdcicwkjjeafgfgbxniujicdkoeacafhhkwbbqildgabmtsqvgvkdmvvxqoweuikawwvhptgnaxdtgojebkhppcthwtvcbwlpssumrujhuujlabmnoxsxcaneqcevaqseelgaoceiahutoebxgvnruatfhdnfifpxuiusafhcmamnlnrubdhwojfrlxpsknthdruuefslbishmokspsqfhtdbtmcugbuorpaumlfuwgekexvloriqqwo"));


    }

}