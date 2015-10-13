/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitterpostforcoucou;

import com.amandine.twitterpostforcoucou.Tweet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import com.amandine.model.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

/**
 *
 * @author janit_000
 */
public class TweetTest {

    String[] adjectives
            = {"#accurate", "#adorn", "#apparel", "#chic", "#colour",
                "#comfortable", "#contemporary",
                "#cosy", "#cotton", "#wool", "#alpaca", "#silk", "#pleats", "#folds", "#drape", "#dance", "#easy", "#elegant",
                "#everyday", "#fabric", "#flow", "#french", "#japanese",
                "#freedom", "#hug", "#intemporal", "#intimate", "#italian",
                "#knitwear", "#life", "#loose", "#oversized", "#squarecut", "#minimalist", "#morphology", "#move",
                "#pursue", "#soft", "#sophisticated", "#winter", "#subdued",
                "#autumn", "#sweaters", "#sweats", "#sweet", "#timeless",
                "#wear", "#woman", "#2015", "#freeshipping"};

    String[] usernames = //{"@janitha_j","@amandinelefRTW"};  
            {"@10Ronaldinho", "@ActuallyNPH", "@agnezmo", "@AlejandroSanz", "@aliciakeys", "@aplusk", "@ArianaGrande", "@ashleytisdale", "@AvrilLavigne", "@BarackObama", "@BeingSalmanKhan", "@Beyonce", "@BillGates", "@blakeshelton", "@britneyspears", "@BrunoMars", "@charliesheen", "@chrisbrown",
                "@ClaudiaLeitte", "@coldplay", "@ConanOBrien", "@Cristiano", "@DalaiLama", "@danieltosh", "@davidguetta", "@ddlovato", "@Drake", "@edsheeran", "@Eminem", "@EmWatson", "@FCBarcelona", "@Harry_Styles", "@iamsrk", "@iamwill", "@ivetesangalo",
                "@JimCarrey", "@jimmyfallon", "@JLo", "@jtimberlake", "@justinbieber",
                "@KAKA", "@kanyewest", "@katyperry", "@KevinHart4real", "@khloekardashian",
                "@KimKardashian", "@KingJames", "@kourtneykardash", "@ladygaga", "@LeoDiCaprio",
                "@LilTunechi", "@Louis_Tomlinson", "@MariahCarey", "@MileyCyrus", "@MohamadAlarefe",
                "@narendramodi", "@neymarjr", "@NiallOfficial", "@NICKIMINAJ", "@OfficialAdele",
                "@onedirection", "@Oprah", "@ParisHilton", "@Pink", "@pitbull", "@Real_Liam_Payne",
                "@realmadrid", "@ricky_martin", "@rihanna", "@RyanSeacrest", "@selenagomez",
                "@shakira", "@SimonCowell", "@SnoopDogg", "@SrBachchan", "@taylorswift13",
                "@TheEllenShow", "@tyrabanks", "@UberSoc", "@WayneRooney", "@wizkhalifa",
                "@xtina", "@zaynmalik", "@3gerardpique", "@106andpark", "@adamlevine",
                "@9GAG", "@_CristineReyes_", "@aarbeloa17", "@_Pedro17_",
                "@1LoganHenderson", "@6BillionPeople", "@50cent", "@143redangel",
                "@ahickmann", "@Ahlam_Alshamsi", "@1victorvaldes", "@AdamSchefter",
                "@21LVA", "@2chainz", "@ABCFpll", "@afgansyah_reza", "@5SOS",
                "@AlArabiya", "@AJArabic", "@3ajel_news", "@Adela_Micha", "@abdulrahman",
                "@ahmethc", "@Ahmet_Davutoglu", "@aguerosergiokun", "@Akon",
                "@AP", "@AlanCarr", "@ABC", "@alexoficial", "@acunilicali",
                "@AHMTKURAL", "@algore", "@akshaykumar", "@andersoncooper",
                "@Arsenal", "@aliaa08", "@AdelAliBinAli", "@AlvaroUribeVel",
                "@ajaydevgn", "@Alwaleed_Talal", "@alinebarros", "@AlArabiya_Brk",
                "@bellathorne", "@atademirer", "@antanddec", "@alyankovic",
                "@amandabynes", "@ana_maria_braga", "@Amazinggimages", "@AllRiseSilver",
                "@Anahi", "@BigSean", "@azizansari", "@AnupamPkher", "@amrkhaled",
                "@amrdiab", "@Angelluisr", "@AndreaSernaRCN", "@Alyssa_Milano",
                "@andresiniesta8", "@CalvinHarris", "@bep", "@AnushkaSharma",
                "@AndreaLegarreta", "@AppStore", "@aristeguicnn", "@andy_murray",
                "@andreolifelipe",
                "@Android", "@carmeloanthony", "@bepe20s", "@ariyoshihiroiki", "@angelicaksy", "@apriliokevin", "@billclinton", "@ArabicBest", "@AnselElgort", "@annecurtissmith", "@cbabdullahgul", "@bhogleharsha", "@ArvindKejriwal", "@AnnaKendrick47", "@AshBenzo", "@BradPaisley", "@AristoteIes", "@ashleesimpson", "@arrahman", "@channingtatum", "@Calle13Oficial", "@bclsinclair", "@AristeguiOnline", "@Ashton5SOS", "@BustaRhymes", "@battalalgoos", "@assihallani", "@AustinMahone", "@CHAYANNEMUSIC", "@Calum5SOS", "@bernardokath", "@BBCNews", "@autocorrects", "@chrisrock", "@billmaher", "@BoAkwon", "@BBCWorld", "@chelseahandler", "@CarlosLoret", "@BlackBerry", "@Bellaudya829", "@BBCSport", "@cnnarabic", "@blakegriffin32", "@CaioCastanheira", "@BreakingNews", "@CherLloyd", "@CH14_", "@bridgitmendler", "@BillCosby", "@belindapop", "@cnni", "@brazuca", "@CaracolTV", "@Carles5puyol", "@ChespiritoRGB", "@ChelseaFC", "@camerondallas", "@Burberry", "@BestTextMsgs", "@cuneytozdemir", "@brozoxmiswebs", "@CocaCola", "@carlyraejepsen", "@ciara", "@CherylOfficial", "@carrieunderwood", "@ChinoyNacho", "@BigBang_CBS", "@DannyDeVito", "@brunogagliasso", "@ConnorFranta", "@cesc4official", "@cinema21", "@ClaroBrasil", "@CasillasWorld", "@ComedyTruth", "@bigtimerush", "@DebbouzeJamel", "@BRUNOIERULLO", "@corbuzier",
                "@ChampionsLeague", "@cuervotinelli", "@FabioPorchat", "@chavezcandanga", "@CP3", "@BillSimmons", "@DeboConfesarQue", "@CamilaMX", "@Crowdfire", "@CHANEL", "@DaniAlvesD2", "@FarOutAkhtar", "@chetan_bhagat", "@dahSyatMusik", "@bipsluvurself", "@dilmabr", "@cerati", "@DaRealAmberRose", "@CMYLMZ", "@DavidLuiz_4", "@FCBarcelona_cat", "@D_DeGea", "@DebbyRyan", "@carlosvives", "@Discovery", "@ComedyPosts", "@DavidKWilliams", "@CNNEE", "@Dior", "@Fiuk", "@DemetAkalin", "@diegotorres", "@CBSNews", "@disneywords", "@common", "@dedesecco", "@CodySimpson", "@DulceMaria", "@Forbes", "@DiegoForlan7", "@DisneyPixar", "@CFKArgentina", "@DjKingAssassin", "@Corinthians", "@El_Universal_Mx", "@daddy_yankee", "@DwightHoward", "@FoxNews", "@Disney", "@DjokerNole", "@ChrisMoyles", "@EA", "@damnitstrue", "@ENews", "@DaniloGentili", "@elissakh", "@G_Higuain", "@DJPaulyD", "@Dropbox", "@DollyParton", "@ElBaradei", "@danawhite", "@EsAdolescencia", "@davidbisbal", "@EugenioDerbez", "@g1", "@donghae861015", "@el_pais", "@DrOz", "@ELLEmagazine", "@DaneCook", "@Estadao",
                "@deepikapadukone", "@Fearnecotton", "@GalatasaraySK", "@DONOMAR", "@ELTIEMPO", "@eddieizzard", "@ElUniversal", "@DaniellePeazer", "@Factsionary", "@detikcom", "@FIFAcom", "@GalileaMontijo", "@DrBassemYoussef", "@EPN", "@EleanorJCalder", "@ErikaDLV", "@DavidHenrie", "@farisf9", "@Dr_alqarnee", "@FloydMayweather", "@GermanGarmendia", "@DwyaneWade", "@facufacundo", "@EmilyOsment", "@EspinozaOficial", "@deadmau5", "@FemaleTexts", "@enrique305", "@GarethBale11", "@girIpossts", "@elliegoulding", "@fayez_malki", "@EW", "@FelipeCalderon", "@dolcegabbana", "@FinancialTimes", "@eonline", "@Guaje7Villa", "@girlposts", "@FactsOfSchool", "@gadiiing", "@felipeneto", "@FePaesLeme", "@DrakeBell", "@firefox", "@EvaLongoria", "@hootsuite", "@googlechrome", "@Fenerbahce", "@galifianakisz", "@Fergie", "@FIFAWorldCup", "@drdrew", "@geneliad", "@FALCAO", "@IAMQUEENLATIFAH", "@GooglePlay", "@gabyespino", "@GaryBarlow", "@fifacom_es", "@Fonseca", "@dylanobrien", "@GLEEonFOX", "@FCBarcelona_es", "@iansomerhalder", "@Gusttavo_lima", "@gitagut", "@GaryLineker", "@FIirtationship", "@GemmaAnneStyles", "@echofon", "@gmanews",
                "@funnyordie", "@ImRaina", "@hcapriles", "@GloriaTrevi", "@GreenDay", "@FinallyMario", "@GiulianaRancic", "@ElNacionalWeb", "@GNev2", "@iamdiddy", "@iTunesMusic", "@hm", "@gmail", "@hazardeden10", "@FrancoDVita", "@HillaryClinton", "@folha", "@goodhealth", "@iHrithik", "@jason_mraz", "@hollywills", "@HilaryDuff", "@HHShkMohd", "@FraseDeSarcasmo", "@jackwhitehall", "@funnyortruth", "@GreatestQuotes", "@imVkohli", "@JColeNC", "@HuffingtonPost", "@iamjamiefoxx", "@HitamPutihT7", "@FraseSimple", "@jasonderulo", "@FunnySayings", "@huryazarlar", "@jamesdrodriguez", "@jennettemccurdy", "@IGGYAZALEA", "@IrfanBachdim10", "@hulyavsar", "@FreddyAmazin", "@jessicacediel", "@HaifaWehbe", "@IPL", "@jessicaalba", "@jess_iskandar", "@INDONESIAinLOVE", "@jamieoliver", "@iamsuperbianca", "@Funny_Truth", "@JoelOsteen", "@HamzaNamira", "@isco_alarcon", "@JessicaSimpson", "@JessieJ", "@JeremyClarkson", "@jesseyjoy", "@IBGDRGN", "@gadelmaleh", "@JoeyEssex_", "@handeyener", "@itsgabrielleu", "@joejonas", "@JohnCena", "@jimmycarr", "@jk_rowling", "@iCarly", "@globovision", "@JoyceMeyer", "@heidiklum", "@ItsLifeFact",
                "@juanes", "@johnlegend", "@jimmykimmel", "@JonahHill", "@indrabektiasli", "@guardian", "@kuyakim_atienza", "@ICC", "@jack", "@KDTrey5", "@JuanLuisGuerra", "@JKCorden", "@jonas_ent", "@intel", "@gulbenergen", "@lala", "@InStyle", "@JBALVIN", "@kelly_clarkson", "@juniorbachchan", "@justdemi", "@JordinSparks", "@Jenna_Marbles", "@HashKSA", "@LaurenConrad", "@ithinkthatway", "@JerrySeinfeld", "@KendallJenner", "@karanjohar", "@kendricklamar", "@juanmata8", "@JohnCleese", "@hitRECordJoe", "@LIFE", "@itsenriquegil", "@jhutch1992", "@KylieJenner", "@kata2bijak", "@kevinjonas", "@la_patilla", "@johngreen", "@IAMJHUD", "@LifeFacts", "@jackybrv", "@jimmyeatworld", "@lindsaylohan", "@KELLYROWLAND", "@KrisJenner", "@Lakers", "@JuanManSantos", "@imdanielpadilla", "@lordemusic", "@JamesFrancoTV", "@jokowi_do2", "@LMFAO", "@kobebryant", "@LanaDelRey", "@LFC", "@julietav", "@iyavillania", "@manomenezes", "@jamesmaslow", "@jupaesoficial", "@LucianoHuck", "@Legendarios", "@LennyKravitz", "@linkinpark", "@kc_concepcion", "@jaimecamil", "@MensHumor", "@JanetJackson", "@kilicdarogluk",
                "@Ludacris", "@LittleMix", "@lilyallen", "@llcoolj", "@KellyOsbourne", "@JakeTAustin", "@miseleccionmx", "@Joey7Barton", "@lafouine78", "@LuisFonsi", "@Luke5SOS", "@luansantana", "@lopezdoriga", "@KeriHilson", "@JENNIWOWW", "@MrPeterAndre", "@JohnBishop100", "@LeighFrancis", "@LunaMaya26", "@marcoluque", "@LuisSuarez9", "@LouisVuitton", "@KevinSpacey", "@jimjonescapo", "@MuratBoz", "@JornalOGlobo", "@lnsaneTweets", "@MarcAnthony", "@Metro_TV", "@ManUtd", "@lucyhale", "@lancearmstrong", "@joelmchale", "@NellyFurtado", "@Khunnie0624", "@Manuel_Neuer", "@MarceloTas", "@Microsoft", "@maryjblige", "@lulopilato", "@lemondefr", "@jorgeemateus", "@NHL", "@lemontwittor", "@manuginobili", "@marcosmion", "@mishari_alafasy", "@Mascherano", "@MacMiller", "@Lmao", "@JoshDevineDrums", "@nikestore", "@lopezandres", "@marcjacobs", "@maroon5", "@montanertwiter", "@mashable", "@MikeTyson", "@Lord_Sugar", "@juliaperrez", "@nikkigil", "@maddow", "@marley_ok", "@MesutOzil1088", "@msdhoni", "@Michael5SOS", "@mirandalambert", "@LuceroMexico", "@KeshaRose", "@ohteenquotes", "@mangeshkarlata", "@mbc2",
                "@MirandaCosgrove", "@NabilAlawadhy", "@MichelleObama", "@MLB", "@luckymanzano", "@kompascom", "@pattiemallette", "@marca", "@McDonalds", "@NASA", "@NancyAjram", "@MTLovenHoney", "@msleamichele", "@LukeBryanOnline", "@LAURAGII", "@PaulaFernandes7", "@MarthaStewart", "@mcuban", "@NatGeo", "@NasehatSuper", "@muyinteresante", "@MYXphilippines", "@MarceloM12", "@LaVidaEnLetras", "@paulpierce34", "@MiamiHEAT", "@MensHealthMag", "@nickjonas", "@NeYoCompound", "@NickCannon", "@Nashgrier", "@mbc1tweets", "@leopoldolopez", "@pedroalfonsoo", "@michkeegan", "@Metallica", "@paulocoelho", "@oceara", "@NicoleScherzy", "@NewYorker", "@MeekMill", "@LuisChataing", "@petewentz", "@missA_suzy", "@MichaelKors", "@paurubio", "@ollyofficial", "@ninadobrev", "@nicolerichie", "@micheltelo", "@luisnani", "@PochoLavezzi", "@mrsayudewi", "@MsLeaSalonga", "@Pontifex_es", "@OMGFacts", "@Notebook", "@Nike", "@mindykaling", "@MadhuriDixit", "@Poconggg", "@mustafaceceli", "@mtvspain", "@premierleague", "@people", "@NoticiasCaracol", "@NoelSchajris", "@MTVNews", "@MaiteOficial", "@PrincesSyahrini", "@myfabolouslife", "@mustafa_agha",
                "@priyankachopra", "@PerezHilton", "@NoticiasRCN", "@ntv", "@ndtv", "@MasQuePalabras", "@questlove", "@NathanFillion", "@Niltakipte", "@programapanico", "@Persie_Official", "@official_flo", "@ntvspor", "@Nelly_Mo", "@MCHammer", "@raghebalama", "@NormanDesVideos", "@NOAH_ID", "@radityadika", "@pewdiepie", "@officialjaden", "@okanbayulgen", "@NickelodeonTV", "@MedvedevRussia", "@rialjorge", "@Number10gov", "@PearlJam", "@RafaelNadal", "@Pharrell", "@OMARCHAPARRO", "@olla_ramlan", "@noaheverett", "@MirandaKerr", "@Rubiu5", "@Olympics", "@penguendergi", "@realwbonner", "@PlayStation", "@OneLouderApps", "@ParineetiChopra", "@OfficialWillow", "@MonsieurDream", "@SaraBareilles", "@pamyurin", "@pepsi", "@RedeGlobo", "@PMOIndia", "@oserginho", "@piersmorgan", "@OzzyOsbourne", "@montesjulia", "@Schofe", "@paugasol", "@realDonaldTrump", "@rickygervais", "@Pontifex", "@pepatah", "@raisa6690", "@paulitachaves", "@najwakaram", "@Schwarzenegger", "@PBiaL", "@realmadridarab", "@rustyrockets", "@RaffiAhmadLagi", "@pittyleone", "@RealLamarOdom", "@polo_polo", "@NBCTheVoice", "@SignosFodas", "@RealTracyMorgan", "@RealVolya",
                "@SabrinaSatoReal", "@rafinhabastos", "@RealHughJackman", "@RevRunWisdom", "@PretaGil", "@neiltyson", "@snaptu", "@ReggieBush", "@ReikMx", "@sachin_rt", "@Reuters", "@realmadriden", "@RitaOra", "@PrinceRoyce", "@nprnews", "@sneijder101010", "@RelatableQuote", "@rogerfederer", "@SamsungMobile", "@Ricardo_Arjona", "@RedHourBen", "@RobertDowneyJr", "@psy_oppa", "@ochocinco", "@SoloReflexiones", "@rickyrozay", "@RolaWorLD", "@SHAQ", "@rioferdy5", "@richardbranson", "@RockstarGames", "@rainnwilson", "@officialtulisa", "@Sony", "@RobertsEmma", "@ryeong9", "@sherinasinna", "@RT_Erdogan", "@robkardashian", "@RollingStone", "@RandyOrton", "@paramore", "@SonyPics_4Teens", "@RomeoSantosPage", "@SaudiNews50", "@showdavida", "@salman_alodah", "@rodrigovesgo", "@sectorkekz", "@RELATlONSHlP", "@paulwesley", "@TFLN", "@S_C_", "@sertaberener", "@shugairi", "@SarahKSilverman", "@sabqorg", "@serenawilliams", "@RNTata2000", "@PEPATAHKU", "@TheArabHash", "@sfa_2000000000", "@sethmeyers", "@SofiaVergara", "@SBYudhoyono", "@SamsungMobileUS", "@siwon407", "@SalehAlmoghamsy", "@portalR7", "@TheDailyShow", "@ShawnMendes", "@Sethrogen",
                "@Starbucks", "@SethMacFarlane", "@SamuelLJackson", "@Skype", "@scooterbraun", "@QueenRania", "@TheFunnyTeens", "@shfly3424", "@ShashiTharoor", "@StephenAtHome", "@shahidkapoor", "@SandyLeah", "@SoDamnTrue", "@silagencoglu", "@realpreityzinta", "@TheLifeDiaries", "@Slash", "@ShawnMichaels", "@stephenfry", "@shireensungkar", "@ScottDisick", "@sonakshisinha", "@Skrillex", "@Riteishd", "@TherealTaraji", "@smoss", "@shitmydadsays", "@thalia", "@snooki", "@SergioRamos", "@souljaboy", "@SonReflexiones", "@robdyrdek", "@TheseDamnQuote", "@special1004", "@SkySports", "@TheEconomist", "@sonamakapoor", "@simonpegg", "@TareqAlSuwaidan", "@SteveCarell", "@samuelmilby", "@TMZ", "@susoelpaspi", "@smosh", "@TheOnion", "@SpiderAnderson", "@Talhabeeb", "@thekiranbedi", "@Support", "@SandraDewi88", "@TRANS7", "@Tbambino", "@SportsNation", "@TheRock", "@SteveMartinToGo", "@TechCrunch", "@TiagoLeifert", "@syntekoficial", "@SeanKingston", "@TRANSTV_CORP", "@themichaelowen", "@steveaustinBSR", "@TIME", "@Tatawerneck", "@TEDTalks", "@TigerWoods", "@ThatsSarcasm", "@shreyaghoshal", "@TravieMcCoy", "@TheWeirdWorld", "@Su_Gimenez",
                "@tomhanks", "@TheXFactor", "@TomCruise", "@timesofindia", "@TMCPoldaMetro", "@SkySportsNewsHQ", "@twittermobile", "@TheXFactorUSA", "@ThatKevinSmith", "@TreySongz", "@Tip", "@twitcam", "@washingtonpost", "@TomCavalcante1", "@TheShilpaShetty", "@urgantcom", "@thiaguinhocomth", "@TheMattEspinosa", "@TweetRAMALAN", "@tvOneNews", "@twittermedia", "@WhatTheFFacts", "@tonyhawk", "@TheVijayMallya", "@ValeYellow46", "@twitterapi", "@TimTebow", "@TwitPic", "@TwitterMusic", "@TwitterSports", "@WIRED", "@tyleroakley", "@ThislsAmazing", "@Vevo", "@Tyrese", "@Titi_KamaLL", "@UberFacts", "@Tyga", "@VanessaHudgens", "@wisinyyandel", "@tylerperry", "@tiesto", "@VhongX44", "@Ubisoft", "@TODAYshow", "@Usher", "@VictoriasSecret", "@VEJA", "@wossy", "@UN", "@toptweets", "@VINNYGUADAGNINO", "@waleedalfarraj", "@tonyhsieh", "@victoriabeckham", "@voguemagazine", "@vicegandako", "@yelyahwilliams", "@UNICEF", "@UncleRUSH", "@vjdaniel", "@williecolon", "@Torres", "@VictoriaJustice", "@werevertumorro", "@Windows", "@YengPLUGGEDin", "@Wale", "@usainbolt", "@WalkingDead_AMC", "@YTCreators", "@TwitterMovies",
                "@vidialdiano", "@WhiteHouse", "@WWE", "@yokoono", "@WholeFoods", "@virendersehwag", "@WhennBoys", "@YUVSTRONG12", "@VeraBrezhneva", "@XabiAlonso", "@WSJ", "@Xbox", "@YouTubeTrends", "@wyclef", "@yilmazerdogan", "@WomensHealthMag", "@zoetheband", "@wilw", "@ZacEfron", "@ZooeyDeschanel", "@Zendaya", "@yuyacst", "@YordiRosado", "@", "@ZozeeBo", "@ZonaTown", "@youm7"
            };

    String imageUrls[] = {
        "http://www.amandineleforestier.fr/images/automn%20winter%202015/collection/adana.jpg",
        "http://www.amandineleforestier.fr/images/automn%20winter%202015/collection/ara.jpg",
        "http://www.amandineleforestier.fr/images/automn%20winter%202015/collection/capella.jpg",
        "http://www.amandineleforestier.fr/images/automn%20winter%202015/collection/dravoauriga.jpg",
        "http://www.amandineleforestier.fr/images/automn%20winter%202015/collection/homan.jpg",
        "http://www.amandineleforestier.fr/images/automn%20winter%202015/collection/lybra.jpg",
        "http://www.amandineleforestier.fr/images/automn%20winter%202015/collection/nialstrerope.jpg",
        "http://www.amandineleforestier.fr/images/automn%20winter%202015/collection/orionini.jpg",
        "http://www.amandineleforestier.fr/images/automn%20winter%202015/collection/spikawezen.jpg",
        "http://www.amandineleforestier.fr/images/automn%20winter%202015/collection/yildun.jpg",};
    private String[] targetUrls = {//"https://youtu.be/sVNvJ-j-4Z4", 
        "http://shop.amandineleforestier.fr", //"https://youtu.be/1XNQ_dswQBo", "https://youtu.be/sL7tpK5GZsE", "https://youtu.be/7ELJVS8cbTc", "https://youtu.be/WzTCcbEJb04","https://youtu.be/lQJ_8NnhTO8"
    };

    /**
     * Test of main method, of class Tweet.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        //Tweet.main(args);
        assertEquals(1, 1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    @Ignore
    public void tweettoUsers() {
        //http://twittercounter.com/pages/100
        Tweet t = new Tweet();
        String[] usernames = {"@janitha_j"};
        //String auser = rusernames.get(0);
        for (String u : usernames) {
            t.tweetMessageToUser(u);
            try {
                Thread.sleep(1000 * 70);

            } catch (InterruptedException ex) {
                Logger.getLogger(TweetTest.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        assertEquals(1, 1);
    }

    @Test
    public void getFollowersTest() {
        Tweet t = new Tweet();
        t.getFollowers("@Android");
        assertEquals(t, t);
    }

    @Test
    public void getARandomURLTest() {
        String[] urls = {
            "http://www.amandineleforestier.fr/images/slider/amandine-leforestier-accueil-1.jpg",
            "http://www.amandineleforestier.fr/images/slider/amandine-leforestier-accueil-2.jpg"};
        RandomElements rs = new RandomElements(urls);
        List<?> ourls = rs.getElementsInRadomOrder(2);
        assertNotEquals("http://www.amandineleforestier.fr/images/slider/amandine-leforestier-accueil-1.jpg", ourls.get(0));

    }

    @Test
    @Ignore
    public void tweetUserWithHashTagsandImages() {
        assertTrue(true);
        Tweet t = new Tweet();
        RandomElements<String> randomizedUsernames = new RandomElements(usernames);
        List<String> rusernames;
        RandomElements<String> randomizedAdjectives = new RandomElements(adjectives);
        List<String> radjectives;// = randomizedAdjectives.getElementsInRadomOrder(adjectives.length);
        RandomElements<String> randomizedImageUrls = new RandomElements(imageUrls);
        RandomElements<String> randomizedTargetUrls = new RandomElements(targetUrls);
        //List<String> rimageUrls = randomizedImageUrls.getElementsInRadomOrder(imageUrls.length);
        //t.tweetMessageToUser("@janitha_j", "#cosy #chic #sporty", "http://www.amandineleforestier.fr/images/slider/amandine-leforestier-accueil-2.jpg");
        //do {
        rusernames = randomizedUsernames.getElementsInRadomOrder(usernames.length);
        for (String u : rusernames) {
            radjectives = randomizedAdjectives.getElementsInRadomOrder(3);
            t.tweetMessageToUser(u, radjectives.get(0) + " " + radjectives.get(1) + " " + radjectives.get(2), randomizedImageUrls.getElementsInRadomOrder(1).get(0), randomizedTargetUrls.getElementsInRadomOrder(1).get(0));
            try {
                Thread.sleep(1000 * 61);
            } catch (InterruptedException ex) {
                Logger.getLogger(TweetTest.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

        //} while (true);
    }

    @Test
    public void getFollowerIdsTest() {
        Tweet t = new Tweet();
        t.getFollowersInformation("@janitha_j");
        //assertEquals(t, t);
    }

    @Test
    public void getUsers() {
        //http://www.javaguicodexample.com/javawejsfjpamysqlbdatabase12ver2.html
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");
        Tweet t = new Tweet();
        Users[] users = t.getRandomUser();
        assertEquals("112122", users[0].getUsersPK().getTwitterid());
        assertEquals("@screenname", users[0].getScreenname());
    }

    @Test
    public void writeATwitterIDToTheTable() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction entr = em.getTransaction();
            entr.begin();
            Users emp = new Users();
            emp.getUsersPK().setTwitterid("112122");
            emp.setScreenname("@" + "screenname");
            em.persist(emp);
            entr.commit();
        } catch (RollbackException e) {
            Logger.getLogger(TweetTest.class
                    .getName()).log(Level.INFO, "Primary key violation", e.getMessage());
        } finally {
            em.close();
        }
    }

    @Test
    public void writeToTableTest() {
        Tweet t = new Tweet();
        t.writeToTable("1", "@screenname", "@fromscreenname");
    }

    @Test
    public void getKeywordById() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");
        Keywords[] adj = null;
        try {
            javax.persistence.Query q = emf.createEntityManager().createNamedQuery("Keywords.findById").setParameter("id", 1);
            adj = (Keywords[]) q.getResultList().toArray(new Keywords[0]);
        } finally {
            emf.createEntityManager().close();
        }
        assertEquals(1, adj[0].getKeywordsPK().getId());
        assertEquals("#2015", adj[0].getKeywordsPK().getKeyword());
    }

    @Test
    public void getKeywordByRandomId() {
        Tweet t = new Tweet();
        Keywords[] adj = t.getRandomKeyword();
        assertEquals(1, adj[0].getKeywordsPK().getId());
        assertEquals("#2015", adj[0].getKeywordsPK().getKeyword());
    }



    @Test
    public void getImageUrlById() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");
        Tweet t = new Tweet();
        Imageurls[] adj = t.getRandomImageUrl();
        assertEquals(1, adj[0].getImageurlsPK().getId());
        assertEquals("http://www.amandineleforestier.fr/images/automn%20winter%202015/collection/adana.jpg", adj[0].getImageurlsPK().getUrl());
    }


    @Test
    public void getTargetUrlById() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");
        Tweet t = new Tweet();
        Targeturls[] adj = t.getRandomTargetUrl();
        assertEquals(1, adj[0].getTargeturlsPK().getId());
        assertEquals("http://shop.amandineleforestier.fr", adj[0].getTargeturlsPK().getUrl());
    }

    @Test
    public void contructATweet(){
        Tweet t = new Tweet();
        System.out.println(
                t.getRandomUser()[0].getScreenname()+ " " +
                t.getRandomKeyword()[0].getKeywordsPK().getKeyword() + " " + 
                t.getRandomKeyword()[0].getKeywordsPK().getKeyword() + " " + 
                t.getRandomKeyword()[0].getKeywordsPK().getKeyword() + " " + 
                t.getRandomImageUrl()[0].getImageurlsPK().getUrl() + " " +
                t.getRandomTargetUrl()[0].getTargeturlsPK().getUrl());
    }
    
}
