package GreetingsGenerator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Generator {
    private ArrayList<Word> rimata;
    private ArrayList<Word> ousiastika;
    private ArrayList<Word> epitheta_arsenika;
    private ArrayList<Word> epitheta_oudetera;
    private ArrayList<String> ektaseis;
    private ArrayList<String> playlist;
    private ArrayList<String> emoticons;
    private int hour;
    private String version;

    public Generator() {
        this.version = " v.0.3";

        Calendar calendar = new GregorianCalendar();
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);

        this.rimata = new ArrayList();
        this.ousiastika = new ArrayList();
        this.epitheta_arsenika = new ArrayList();
        this.epitheta_oudetera = new ArrayList();
        this.ektaseis = new ArrayList();
        this.playlist = new ArrayList();
        this.emoticons = new ArrayList();

        this.rimata.add(new Word("Χαιρετίζω", Word_Types.RHMA));
/*  42 */     this.rimata.add(new Word("Καλημερίζω", Word_Types.RHMA));
/*  43 */     this.rimata.add(new Word("Καλησπερίζω", Word_Types.RHMA));
/*     */
/*  45 */     this.ousiastika.add(new Word("ατσίδεζ", Word_Types.OUSIASTIKO_A));
/*  46 */     this.ousiastika.add(new Word("street fightaz", Word_Types.OUSIASTIKO_A));
/*  47 */     this.ousiastika.add(new Word("gang membaz", Word_Types.OUSIASTIKO_A));
/*  48 */     this.ousiastika.add(new Word("νταβατζήδεζ", Word_Types.OUSIASTIKO_A));
/*  49 */     this.ousiastika.add(new Word("αλητάμπουρεζ", Word_Types.OUSIASTIKO_A));
/*  49 */     this.ousiastika.add(new Word("βρρρρρωμιάριδες", Word_Types.OUSIASTIKO_A));
/*  50 */     this.ousiastika.add(new Word("μάγκεζ", Word_Types.OUSIASTIKO_A));
/*  51 */     this.ousiastika.add(new Word("αλήτεζ", Word_Types.OUSIASTIKO_A));
/*  52 */     this.ousiastika.add(new Word("συμμορίτεζ", Word_Types.OUSIASTIKO_A));
/*  53 */     this.ousiastika.add(new Word("μαγκιόριδεζ", Word_Types.OUSIASTIKO_A));
/*  54 */     this.ousiastika.add(new Word("εγκληματίεζ", Word_Types.OUSIASTIKO_A));
/*  55 */     this.ousiastika.add(new Word("μόρτεζ", Word_Types.OUSIASTIKO_A));
/*  56 */     this.ousiastika.add(new Word("νταβατζήδες", Word_Types.OUSIASTIKO_A));
/*  57 */     this.ousiastika.add(new Word("φασαρτζήδες", Word_Types.OUSIASTIKO_A));
/*     */
/*  59 */     this.ousiastika.add(new Word("αλητόνια", Word_Types.OUSIASTIKO_O));
/*  60 */     this.ousiastika.add(new Word("αλητόπαιδα", Word_Types.OUSIASTIKO_O));
/*  61 */     this.ousiastika.add(new Word("αλάνια", Word_Types.OUSIASTIKO_O));
/*  62 */     this.ousiastika.add(new Word("τζιμάνια", Word_Types.OUSIASTIKO_O));
/*  63 */     this.ousiastika.add(new Word("εργαλεία", Word_Types.OUSIASTIKO_O));
/*     */
/*  65 */     this.epitheta_arsenika.add(new Word("σκληροπυρηνικούς", Word_Types.EPITHETO_A));
/*  66 */     this.epitheta_arsenika.add(new Word("αδίστακτους", Word_Types.EPITHETO_A));
/*  67 */     this.epitheta_arsenika.add(new Word("αλανιάριδες", Word_Types.EPITHETO_A));
/*  68 */     this.epitheta_arsenika.add(new Word("ανελέητους", Word_Types.EPITHETO_A));
/*  69 */     this.epitheta_arsenika.add(new Word("επιθετικούς", Word_Types.EPITHETO_A));
/*  70 */     this.epitheta_arsenika.add(new Word("εκδικητικούς", Word_Types.EPITHETO_A));
/*  71 */     this.epitheta_arsenika.add(new Word("ηρωικούς", Word_Types.EPITHETO_A));
/*  72 */     this.epitheta_arsenika.add(new Word("αυταρχικούς", Word_Types.EPITHETO_A));
/*  73 */     this.epitheta_arsenika.add(new Word("γλεντζέδες", Word_Types.EPITHETO_A));
/*  74 */     this.epitheta_arsenika.add(new Word("καμένους", Word_Types.EPITHETO_A));
/*  75 */     this.epitheta_arsenika.add(new Word("πωρωμένους", Word_Types.EPITHETO_A));
/*  76 */     this.epitheta_arsenika.add(new Word("μάχημους", Word_Types.EPITHETO_A));
/*     */
/*  78 */     this.epitheta_oudetera.add(new Word("σκληροπυρηνικά", Word_Types.EPITHETO_O));
/*  79 */     this.epitheta_oudetera.add(new Word("αδίστακτα", Word_Types.EPITHETO_O));
/*  80 */     this.epitheta_oudetera.add(new Word("αλανιάρικα", Word_Types.EPITHETO_O));
/*  81 */     this.epitheta_oudetera.add(new Word("επιθετικά", Word_Types.EPITHETO_O));
/*  82 */     this.epitheta_oudetera.add(new Word("εκδικητικά", Word_Types.EPITHETO_O));
/*  83 */     this.epitheta_oudetera.add(new Word("ηρωικά", Word_Types.EPITHETO_O));
/*  84 */     this.epitheta_oudetera.add(new Word("αυταρχικά", Word_Types.EPITHETO_O));
/*  85 */     this.epitheta_oudetera.add(new Word("γλεντζέδικα", Word_Types.EPITHETO_O));
/*  86 */     this.epitheta_oudetera.add(new Word("καμένα", Word_Types.EPITHETO_O));
/*  87 */     this.epitheta_oudetera.add(new Word("πωρωμένα", Word_Types.EPITHETO_O));
/*  88 */     this.epitheta_oudetera.add(new Word("μάχημα", Word_Types.EPITHETO_O));
/*     */
/*  90 */     this.ektaseis.add("της βορείου Ελλάδας, του Ανατολικού Αιγαίου, Νότιας Πελοποννήσου, Αττικής και Ανατολικής Μεσογείου");
/*  91 */     this.ektaseis.add("της Ευρώπης");
/*  92 */     this.ektaseis.add("του Σύμπαντος");
/*  93 */     this.ektaseis.add("του Milky Way");
/*  93 */     this.ektaseis.add("του Multiverse");
/*  93 */     this.ektaseis.add("του Matrix");
/*     */
/*     */
/*  96 */     this.playlist.add("https://www.youtube.com/watch?v=sgL9fTGmB1Y");
/*  97 */     this.playlist.add("https://www.youtube.com/watch?v=Qvj7RA_1kNc");
/*  98 */     this.playlist.add("https://www.youtube.com/watch?v=d8b0mkZOqB0");
/*  99 */     this.playlist.add("https://www.youtube.com/watch?v=JIENe6Z9Viw");
/* 100 */     this.playlist.add("https://www.youtube.com/watch?v=zwM5E3BcfLY");
/*     */
/* 102 */     this.playlist.add("https://www.youtube.com/watch?v=f8eT7nEz1Mk");
/* 103 */     this.playlist.add("https://www.youtube.com/watch?v=u9sTHE3QKyw");
/* 104 */     this.playlist.add("https://www.youtube.com/watch?v=fYZdP56TckQ");
/* 105 */     this.playlist.add("https://www.youtube.com/watch?v=V3x6KR8qP9Y");
/* 106 */     this.playlist.add("https://www.youtube.com/watch?v=qsbpUOnH6QQ");
/* 107 */     this.playlist.add("https://www.youtube.com/watch?v=OkO2tpFPs9Y");
/*     */
/* 109 */     this.emoticons.add("\uD83D\uDE0E");
/* 110 */     this.emoticons.add("\uD83E\uDD18");
/* 111 */     this.emoticons.add("\uD83D\uDCB5");
/* 112 */     this.emoticons.add("\uD83C\uDF89");
/* 113 */     this.emoticons.add("\uD83C\uDF1F");
/* 114 */     this.emoticons.add("\uD83D\uDCAA");
/* 115 */     this.emoticons.add("\uD83D\uDC4D");
/*     */
/*     */
/*     */
/* 119 */     if ((month == 11) || ((month == 0) && (day < 6))) {
/* 120 */       this.epitheta_arsenika.add(new Word("Χριστουγενιάτικους", Word_Types.EPITHETO_A));
/* 121 */       this.epitheta_arsenika.add(new Word("παιχνιδιάρικους", Word_Types.EPITHETO_A));
/* 122 */       this.epitheta_arsenika.add(new Word("ΑγιοΒασιλιάτικους", Word_Types.EPITHETO_A));
/* 123 */       this.epitheta_oudetera.add(new Word("Χριστουγενιάτικα", Word_Types.EPITHETO_O));
/* 124 */       this.epitheta_oudetera.add(new Word("παιχνιδιάρικα", Word_Types.EPITHETO_O));
/* 125 */       this.epitheta_oudetera.add(new Word("ΑγιοΒασιλιάτικα", Word_Types.EPITHETO_O));
/* 126 */       this.ektaseis.add("του Βορείου Πόλου");
/* 127 */       this.ousiastika.add(new Word("ξωτικά", Word_Types.OUSIASTIKO_O));
/* 128 */       this.ousiastika.add(new Word("τάρανδους", Word_Types.OUSIASTIKO_A));
/* 129 */       this.ousiastika.add(new Word("χιονάθρωπους", Word_Types.OUSIASTIKO_A));
/*     */     }
/*     */
/* 132 */     if ((month == 1) && (day == 14)) {
/* 133 */       this.epitheta_arsenika.add(new Word("kinky", Word_Types.EPITHETO_A));
/* 134 */       this.epitheta_arsenika.add(new Word("nasty", Word_Types.EPITHETO_A));
/* 135 */       this.epitheta_arsenika.add(new Word("dirty", Word_Types.EPITHETO_A));
/* 136 */       this.epitheta_arsenika.add(new Word("πουτόπιστους", Word_Types.EPITHETO_A));
/* 137 */       this.epitheta_arsenika.add(new Word("πουτόφατσους (λέξη του Κυρ)", Word_Types.EPITHETO_A));
/* 138 */       this.epitheta_arsenika.add(new Word("μουνόδουλους", Word_Types.EPITHETO_A));
/* 139 */       this.epitheta_oudetera.add(new Word("kinky", Word_Types.EPITHETO_O));
/* 140 */       this.epitheta_oudetera.add(new Word("nasty", Word_Types.EPITHETO_O));
/* 141 */       this.epitheta_oudetera.add(new Word("dirty", Word_Types.EPITHETO_O));
/* 141 */       this.epitheta_oudetera.add(new Word("βρρρρρωμιάριδες", Word_Types.EPITHETO_A));
/*     */     }
    }

    public Object getRandom(ArrayList lista) {
        Random rnd = new Random();
        int size = lista.size();
        int random_int = Math.abs(rnd.nextInt());

        int index = random_int % size;
        return lista.get(index);
    }

    public GeneratedPhraseResult compileMsg(String[] parts) {
        String msg = "";
        for (int i = 0; i < parts.length; i++) {
            msg = msg + parts[i];
        }
        String extra_str = "\nCreated With PutsoBanana Greeting Generator" + this.version;
        //String url = " https://goo.gl/q4HYed";

        String song = (String) getRandom(this.playlist);
        msg = msg + "\n" + song;
        msg = msg + extra_str;
        if ((parts[0].equals("\uD83C\uDF89")) && (parts[1].equals("\uD83D\uDC4D")) && (parts[(parts.length - 2)].equals("\uD83E\uDD18")) && (parts[(parts.length - 1)].equals("\uD83C\uDF1F"))) {
            msg = msg + "\nOMFG PARTY LIKE A DOUMA https://goo.gl/q4HYed";
        }
        //copyToClipBoard(msg);
        return new GeneratedPhraseResult(msg,song);
    }

    public String[] generate() {
        Word rima;
        if ((this.hour >= 4) && (this.hour <= 15)) {
            rima = (Word) this.rimata.get(1);
        } else {
            if ((this.hour >= 20) && (this.hour < 4)) {
                rima = (Word) this.rimata.get(2);
            } else {
                rima = (Word) this.rimata.get(0);
            }
        }
        Word ousiastiko = (Word) getRandom(this.ousiastika);
        String ektasi = (String) getRandom(this.ektaseis);
        Word epitheto;
        String arthro;
        if (ousiastiko.getType() == Word_Types.OUSIASTIKO_A) {
            epitheto = (Word) getRandom(this.epitheta_arsenika);
            arthro = "τους";
        } else {
            epitheto = (Word) getRandom(this.epitheta_oudetera);
            arthro = "τα";
        }
        String[] emo = new String[4];
        for (int i = 0; i < emo.length; i++) {
            emo[i] = ((String) getRandom(this.emoticons));
        }
        String[] output = {emo[0], emo[1], " ", rima.getValue(), " ", arthro, " πιο ", epitheto.getValue(), " ",
                ousiastiko.getValue(), " ", ektasi, ". ", emo[2], emo[3]};

        compileMsg(output);

        return output;
    }

    public static void main(String[] args) {
        Generator main = new Generator();
        System.out.println(main.compileMsg(main.generate()));
    }
}

