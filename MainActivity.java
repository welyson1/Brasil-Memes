package brasilmemes.memeslite;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button djrogerinho;
    private Button negobam;
    private Button dilma;
    private Button away;
    private Button cachorreira;
    private Button alborguetti;
    private Button nuncanemvi;
    private Button morrediabo;
    private Button felipe;
    private Button bolsonaro;
    private Button serjao;
    private Button papaco;
    private Button cepo;
    private Button pesadao;
    private Button filmaefala;
    private Button chico;
    private Button sikerajunior;
    private Button delicia;
    private Button vindiesel;
    private Button voceeburro;
    private Button faustao;
    private Button silvio;
    private Button novosmemes;
    private Button bonecojosias;
    private Button galocego;

    private ListView lv;
    private MediaPlayer mp;
    private ArrayAdapter<memes> arrayAdapter;
    private AdView mAdView;
    private SharedPreferences sPreferences = null;

    private ArrayList<memes> novosList;
    private ArrayList<memes> dilmalist;
    private ArrayList<memes> djrogerinholist;
    private ArrayList<memes> alborghettiList;
    private ArrayList<memes> awayList;
    private ArrayList<memes> bolsonaroList;
    private ArrayList<memes> cachorreiraList;
    private ArrayList<memes> cepoList;
    private ArrayList<memes> chicoList;
    private ArrayList<memes> deliciaList;
    private ArrayList<memes> faustaoList;
    private ArrayList<memes> felipeList;
    private ArrayList<memes> filmaefalaList;
    private ArrayList<memes> galocegoList;
    private ArrayList<memes> morrediaboList;
    private ArrayList<memes> negobamList;
    private ArrayList<memes> nuncanemviList;
    private ArrayList<memes> papacoList;
    private ArrayList<memes> pesadaoList;
    private ArrayList<memes> serjaoList;
    private ArrayList<memes> sikeirajuniorList;
    private ArrayList<memes> silvioList;
    private ArrayList<memes> vindieselList;
    private ArrayList<memes> voceeburroList;
    private ArrayList<memes> bonecojosiasList;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-2906341121100127~6678698466");

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2906341121100127/3254458774");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        isStoragePermissionGranted();

        djrogerinho = findViewById(R.id.djrogerinho);
        djrogerinho.setOnClickListener(this);
        negobam = findViewById(R.id.negobam);
        negobam.setOnClickListener(this);
        dilma = findViewById(R.id.dilma);
        dilma.setOnClickListener(this);
        away = findViewById(R.id.away);
        away.setOnClickListener(this);
        cachorreira = findViewById(R.id.cachorreira);
        cachorreira.setOnClickListener(this);
        alborguetti = findViewById(R.id.alborguetti);
        alborguetti.setOnClickListener(this);
        nuncanemvi = findViewById(R.id.nuncanemvi);
        nuncanemvi.setOnClickListener(this);
        morrediabo = findViewById(R.id.morrediabo);
        morrediabo.setOnClickListener(this);
        felipe = findViewById(R.id.felipe);
        felipe.setOnClickListener(this);
        bolsonaro = findViewById(R.id.bolsonaro);
        bolsonaro.setOnClickListener(this);
        serjao = findViewById(R.id.serjao);
        serjao.setOnClickListener(this);
        papaco = findViewById(R.id.papaco);
        papaco.setOnClickListener(this);
        cepo = findViewById(R.id.cepo);
        cepo.setOnClickListener(this);
        pesadao = findViewById(R.id.pesadao);
        pesadao.setOnClickListener(this);
        filmaefala = findViewById(R.id.filmaefala);
        filmaefala.setOnClickListener(this);
        chico = findViewById(R.id.chico);
        chico.setOnClickListener(this);
        sikerajunior = findViewById(R.id.sikerajunior);
        sikerajunior.setOnClickListener(this);
        delicia = findViewById(R.id.delicia);
        delicia.setOnClickListener(this);
        vindiesel = findViewById(R.id.vindiesel);
        vindiesel.setOnClickListener(this);
        voceeburro = findViewById(R.id.voceeburro);
        voceeburro.setOnClickListener(this);
        faustao = findViewById(R.id.faustao);
        faustao.setOnClickListener(this);
        silvio = findViewById(R.id.silvio);
        silvio.setOnClickListener(this);
        galocego = findViewById(R.id.galocego);
        galocego.setOnClickListener(this);
        bonecojosias = findViewById(R.id.bonecojosias);
        bonecojosias.setOnClickListener(this);
        novosmemes = findViewById(R.id.novosmemes);
        novosmemes.setOnClickListener(this);


        lv = findViewById(R.id.lv);
        mp = new MediaPlayer();

        novosList = new ArrayList<>();

        novosList.add(new memes("Que tiro foi esse", R.raw.quetirofoiesse));
        novosList.add(new memes("do u kno de wae", R.raw.knowtheway));
        novosList.add(new memes("Clucking", R.raw.clucking));
        novosList.add(new memes("Isso é a maior putaria", R.raw.alborghetti_01));
        novosList.add(new memes("Cabação", R.raw.alborghetti_03));
        novosList.add(new memes("Cala boca", R.raw.alborghetti_04));
        novosList.add(new memes("É lamentavel", R.raw.alborghetti_05));
        novosList.add(new memes("E mando todo mundo a puta que pariu", R.raw.alborghetti_06));
        novosList.add(new memes("ÉÉEÉÉ... isso aqui ta uma porra", R.raw.alborghetti_07));
        novosList.add(new memes("Essa gazela do satanas", R.raw.alborghetti_08));
        novosList.add(new memes("Filho da puta", R.raw.alborghetti_10));
        novosList.add(new memes("Esta imperdivel hoje", R.raw.alborghetti_11));
        novosList.add(new memes("Não venha encher meu saco", R.raw.alborghetti_12));
        novosList.add(new memes("Num gosto foda-se cara", R.raw.alborghetti_13));
        novosList.add(new memes("O que voces querem", R.raw.alborghetti_14));
        novosList.add(new memes("Todo dia tem uma merda", R.raw.alborghetti_15));
        novosList.add(new memes("Vcs trocado por merda é caro", R.raw.alborghetti_16));
        novosList.add(new memes("FODA-SE", R.raw.alborghetti_17));
        novosList.add(new memes("Va pro inferno porra", R.raw.alborghetti_18));
        novosList.add(new memes("Eu fico puto da cara", R.raw.alborghetti_19));
        novosList.add(new memes("Responda porra", R.raw.alborghetti_20));
        novosList.add(new memes("Vai trabalhar sua ordinaria", R.raw.alborghetti_21));
        novosList.add(new memes("Bem feito", R.raw.alborguetti_bemfeito));
        novosList.add(new memes("Cade meu pau", R.raw.alborguetti_cademeupau));
        novosList.add(new memes("Eu to louco? Não!", R.raw.alborguetti_toloco));
        novosList.add(new memes("Va a merda", R.raw.alborguetti_vaamerda));
        novosList.add(new memes("Ameno", R.raw.negobam_ameno));
        novosList.add(new memes("Champions", R.raw.negobam_champions));
        novosList.add(new memes("Friends", R.raw.negobam_friends));
        novosList.add(new memes("Gozathens", R.raw.negobam_gozathens));
        novosList.add(new memes("Gozelynflores", R.raw.negobam_gozelynflores));
        novosList.add(new memes("Goza da justiça", R.raw.gozajus));
        novosList.add(new memes("Skrillex", R.raw.bangagozo));
        novosList.add(new memes("A terra é curva", R.raw.dilma_01));
        novosList.add(new memes("Dobramos a meta", R.raw.dilma_03));
        novosList.add(new memes("Eu engasguei comigo mesma", R.raw.dilma_04));
        novosList.add(new memes("Quase que eu n podia", R.raw.dilma_05));
        novosList.add(new memes("Eu vi, parei de ver, voltei a ver", R.raw.dilma_06));
        novosList.add(new memes("Happy basner", R.raw.dilma_07));
        novosList.add(new memes("Meio ambiente é uma ameaça", R.raw.dilma_08));
        novosList.add(new memes("Pasta de dente", R.raw.dilma_09));
        novosList.add(new memes("Saldando a mandioca", R.raw.dilma_10));
        novosList.add(new memes("Vai todo mundo perder", R.raw.dilma_11));
        novosList.add(new memes("Beijos", R.raw.dilma_12));
        novosList.add(new memes("Fecha o cú pra falar comigo", R.raw.fechaocu));
        novosList.add(new memes("O sua monica do caralho", R.raw.awaymonica));
        novosList.add(new memes("Cala boca", R.raw.gil_brother_01));
        novosList.add(new memes("Conversa de puta deus não escuta", R.raw.gil_brother_02));
        novosList.add(new memes("Enfia os pes dentro do cú", R.raw.gil_brother_04));
        novosList.add(new memes("Eu fico perpcso", R.raw.gil_brother_05));
        novosList.add(new memes("F E C H A  O  C Ú", R.raw.gil_brother_06));
        novosList.add(new memes("Nesse verão tira as crianças da sala", R.raw.gil_brother_08));
        novosList.add(new memes("Dez tapa na cara", R.raw.gil_brother_09));
        novosList.add(new memes("Olha esse desgraçado", R.raw.gil_brother_10));
        novosList.add(new memes("Para com essa porra", R.raw.gil_brother_11));
        novosList.add(new memes("Pode virar megazord", R.raw.gil_brother_12));
        novosList.add(new memes("Vou te alisar a cara no chão", R.raw.gil_brother_13));
        novosList.add(new memes("Vai toma no cú", R.raw.gil_brother_16));
        novosList.add(new memes("O cachaceiro", R.raw.gil_brother_17));
        novosList.add(new memes("E fim de papo nessa porra", R.raw.gil_brother_19));
        novosList.add(new memes("Visão", R.raw.gil_brother_21));
        novosList.add(new memes("Cala boca meu aluno", R.raw.gil_brother_22));
        novosList.add(new memes("É muita falcatrua", R.raw.gil_brother_23));
        novosList.add(new memes("Vai tomar no cú tranquilo", R.raw.gil_brother_24));
        novosList.add(new memes("Garotinho criado a leite moça", R.raw.gil_brother_25));
        novosList.add(new memes("Movimento q eu trai", R.raw.gil_brother_27));
        novosList.add(new memes("Ninguem é obrigado a ouvir merda", R.raw.gil_brother_28));
        novosList.add(new memes("Ola os dois podre", R.raw.gil_brother_29));
        novosList.add(new memes("Vai criar porquinho na ilha", R.raw.gil_brother_30));
        novosList.add(new memes("Seja obsetivo", R.raw.gil_brother_31));
        novosList.add(new memes("Em que posso ser util", R.raw.gil_brother_32));
        novosList.add(new memes("Ce louco cachoeira", R.raw.celoucocachoeira_cachoeira));
        novosList.add(new memes("Só por deus", R.raw.celoucocachoeira_sopordeus));
        novosList.add(new memes("Eu sou tarado no sexo", R.raw.celoucocachoeira_tarado));
        novosList.add(new memes("Nunca nem vi", R.raw.nuncanemvi));
        novosList.add(new memes("Que dia foi isso?", R.raw.nuncanemvi_quediafoiisso));
        novosList.add(new memes("Morre diabo", R.raw.morrediabo_morre));
        novosList.add(new memes("Não interessa", R.raw.morrediabo_naointeressa));
        novosList.add(new memes("To falando, Num do falando", R.raw.morrediabo_tofalando));
        novosList.add(new memes("Faz isso comigo não ", R.raw.felipe_fazcomigonao));
        novosList.add(new memes("Guarapari, Buzios é minha arte", R.raw.felipe_guarapari));
        novosList.add(new memes("Sai dae doido", R.raw.felipe_saidaedoido));
        novosList.add(new memes("Samu seu cú", R.raw.felipe_samu));
        novosList.add(new memes("Amigo gay", R.raw.amigogay));
        novosList.add(new memes("Amizade gay", R.raw.amizadegay));
        novosList.add(new memes("Animal", R.raw.animal));
        novosList.add(new memes("Bigodudo ou careca", R.raw.bigodudooucareca));
        novosList.add(new memes("Cabo", R.raw.cabo));
        novosList.add(new memes("Cagando pra vc", R.raw.cagandopravc));
        novosList.add(new memes("Canalhas", R.raw.canalhas));
        novosList.add(new memes("Canalhas mil vezes", R.raw.canalhasmilvezes));
        novosList.add(new memes("Chupao", R.raw.chupao));
        novosList.add(new memes("Coisa de viado", R.raw.coisadeviado));
        novosList.add(new memes("Consumo de droga", R.raw.consumodedroga));
        novosList.add(new memes("Da que te dou outra", R.raw.daquetedououtra));
        novosList.add(new memes("Detesto esse governo", R.raw.detestoessegoverno));
        novosList.add(new memes("Direitos humanos", R.raw.direitoshumanos));
        novosList.add(new memes("Espero nada de grave aconteca", R.raw.esperodadagraveaconteca));
        novosList.add(new memes("Falar fino", R.raw.falarfino));
        novosList.add(new memes("Fode nois", R.raw.fodenois));
        novosList.add(new memes("Garoto adotado", R.raw.garotoadotado));
        novosList.add(new memes("Jamais iria estuprar voce", R.raw.jamaisiriaestuprarvoce));
        novosList.add(new memes("Flho de quem? joao ou pedrao", R.raw.joaopedrao));
        novosList.add(new memes("Mae bigoduda", R.raw.maebigoduda));
        novosList.add(new memes("Maranhão", R.raw.maranhao));
        novosList.add(new memes("Masoque e isso", R.raw.masoqueeisso));
        novosList.add(new memes("Menor vagabundo", R.raw.menorvagabundo));
        novosList.add(new memes("Minha cara", R.raw.minhacara));
        novosList.add(new memes("Não entendi", R.raw.naoentendi));
        novosList.add(new memes("Não não", R.raw.naonao));
        novosList.add(new memes("Não quero que ele morra", R.raw.naoqueroqueelemorra));
        novosList.add(new memes("Não sequestrar", R.raw.naosequestrar));
        novosList.add(new memes("Não vai votar", R.raw.naovaivotar));
        novosList.add(new memes("Não vou polemizar", R.raw.naovoupolemizar));
        novosList.add(new memes("Nhanha", R.raw.nhanha));
        novosList.add(new memes("Orgão excretor", R.raw.orgaoexcretor));
        novosList.add(new memes("Orgulho gay", R.raw.orgulhogay));
        novosList.add(new memes("Pena", R.raw.pena));
        novosList.add(new memes("Poha q decipcao", R.raw.pohqdecipcao));
        novosList.add(new memes("Porrada", R.raw.porrada));
        novosList.add(new memes("Presidios", R.raw.presidios));
        novosList.add(new memes("Que porra de verdade", R.raw.queporradeverdade));
        novosList.add(new memes("Risada", R.raw.risada));
        novosList.add(new memes("Rosquinha", R.raw.rosquinha));
        novosList.add(new memes("Rua onde ela mora", R.raw.ruaondeelamora));
        novosList.add(new memes("Soco", R.raw.soco));
        novosList.add(new memes("Sucesso", R.raw.sucesso));
        novosList.add(new memes("Tem que se fude", R.raw.temquesefude));
        novosList.add(new memes("Tetas do governo", R.raw.tetasdogoverno));
        novosList.add(new memes("Tu é cubano", R.raw.tuecubano));
        novosList.add(new memes("Vagabunda", R.raw.vagabunda));
        novosList.add(new memes("Vai pra cuba", R.raw.vaipracuba));
        novosList.add(new memes("Viu dois homens se beijando", R.raw.viobeijo));
        novosList.add(new memes("Voto obrigatorio é MEU PINTO", R.raw.votoobrigatorio));
        novosList.add(new memes("Aqui tem coragem", R.raw.serjao_aquitemcoragem));
        novosList.add(new memes("Autoridades do ibama", R.raw.serjao_autoridadesdoibama));
        novosList.add(new memes("Onça", R.raw.serjao_barulhoonca));
        novosList.add(new memes("Com fé n opai eterno", R.raw.serjao_comfenopaieterno));
        novosList.add(new memes("É a verdade", R.raw.serjao_eaverdade));
        novosList.add(new memes("Matador de onça", R.raw.serjao_matadordeonca));
        novosList.add(new memes("Serjao mclan", R.raw.serjao_mclan));
        novosList.add(new memes("Perigoso na calça ele cagar", R.raw.serjao_nacalcacagar));
        novosList.add(new memes("Pipoco come", R.raw.serjao_oncanozoologico));
        novosList.add(new memes("Valeu por duas ou mais", R.raw.serjao_valeuporduasoumais));
        novosList.add(new memes("Ainda bem", R.raw.papaco_aindabem));
        novosList.add(new memes("Ei seu bunda mole", R.raw.papaco_bundamole));
        novosList.add(new memes("Quem foi o cagão", R.raw.papaco_cagao));
        novosList.add(new memes("Falou comigo?", R.raw.papaco_faloucomigo));
        novosList.add(new memes("Cepo de madeira", R.raw.cepodemadeira));
        novosList.add(new memes("Cepo bem duro", R.raw.cepodemadeira_bemduro));
        novosList.add(new memes("Gatinha", R.raw.gatinha));
        novosList.add(new memes("Menino lobo", R.raw.meninolobo));
        novosList.add(new memes("Pesadão", R.raw.pesadao));
        novosList.add(new memes("1990", R.raw.pesadao1990));
        novosList.add(new memes("Pesadaummm", R.raw.pesadaum));
        novosList.add(new memes("Telefone 3990", R.raw.telefone3990));
        novosList.add(new memes("Ce o bixão memo em doido", R.raw.bixao));
        novosList.add(new memes("Ce filma e fala", R.raw.filma));
        novosList.add(new memes("Capeta prego", R.raw.filmaefala_capeteprego));
        novosList.add(new memes("Suspeito", R.raw.filmaefala_suspeito));
        novosList.add(new memes("Eu quero saber quem transa", R.raw.chicobioca));
        novosList.add(new memes("Chupa um cú e pá", R.raw.chupaumcuepa));
        novosList.add(new memes("Comer vaginas e tudo mais", R.raw.comervaginas));
        novosList.add(new memes("Sexo anal", R.raw.sexoanal));
        novosList.add(new memes("Um tabaco bem massa", R.raw.umtabaco));
        novosList.add(new memes("DJ Rogerinho Completo", R.raw.djrogerinho));
        novosList.add(new memes("Cabeca de tangerina", R.raw.tangerina));
        novosList.add(new memes("Cabeça de caramelo", R.raw.caramelo));
        novosList.add(new memes("Canal do youtube", R.raw.canal));
        novosList.add(new memes("Espiga de milho queimada", R.raw.espiga));
        novosList.add(new memes("Feijao queimado", R.raw.feijao));
        novosList.add(new memes("Hackearam meu e-mail", R.raw.email));
        novosList.add(new memes("Tortao que nem vergado", R.raw.tortao));
        novosList.add(new memes("Lança um site", R.raw.lanca));
        novosList.add(new memes("DJ Rogerinho Parte 2", R.raw.djrogerinho_partedois));
        novosList.add(new memes("É o crime é nois", R.raw.sikerajunior_eocrimeenois));
        novosList.add(new memes("É maconha doido", R.raw.sikerajunior_maconhamusica));
        novosList.add(new memes("Que delicia cara", R.raw.quedelicia));
        novosList.add(new memes("Essa peça que vc queria?", R.raw.quedelicia_essapeca));
        novosList.add(new memes("Ahhh que pika gostosa", R.raw.ahhhquepikagostosa));
        novosList.add(new memes("Ai que gostoso", R.raw.aiquegostoso));
        novosList.add(new memes("Como assim nâo intendi", R.raw.comoassimnaointendi));
        novosList.add(new memes("Como assim vc n vai por", R.raw.comoassimvcnvaipor));
        novosList.add(new memes("To afim de relaxar", R.raw.toafimderelaxar));
        novosList.add(new memes("Trabalhando e relaxando", R.raw.trabalhandoerelaxando));
        novosList.add(new memes("Vou te deixar oco", R.raw.voudeixaroco));
        novosList.add(new memes("Can hugs", R.raw.vindiesel_canhugs));
        novosList.add(new memes("Como vc é burro", R.raw.comovceburro));
        novosList.add(new memes("Que coisa absurda", R.raw.quecoisaabsurda));
        novosList.add(new memes("Vc fala de uma maneira burra", R.raw.vcfaladeumamaneiraburra));
        novosList.add(new memes("Como vc é burro(COMPLETO)", R.raw.seburrocompleto));
        novosList.add(new memes("Lave o pinto", R.raw.faustao_04));
        novosList.add(new memes("Ninguem acertou", R.raw.faustao_05));
        novosList.add(new memes("Pourra meu", R.raw.faustao_06));
        novosList.add(new memes("Puta vida", R.raw.faustao_07));
        novosList.add(new memes("Frango de macumba", R.raw.faustao_11));
        novosList.add(new memes("Ih serjão sujo", R.raw.faustao_12));
        novosList.add(new memes("Errou", R.raw.faustao_errou));
        novosList.add(new memes("Ta pegando fogo bixo", R.raw.faustao_tapegandofogo));
        novosList.add(new memes("Vai morrer", R.raw.morrer));
        novosList.add(new memes("E o bambu?", R.raw.silvio_enfianoteucu));
        novosList.add(new memes("Não consegue", R.raw.silvio_naoconsegue));
        novosList.add(new memes("Que pena vc erro", R.raw.silvio_santos_04));
        novosList.add(new memes("Calma, calma sua piranha", R.raw.silvio_santos_07));
        novosList.add(new memes("Está certo disso?", R.raw.silvio_santos_08));
        novosList.add(new memes("Tem que mandar matar", R.raw.silvio_santos_09));
        novosList.add(new memes("Oiiih", R.raw.silvio_santos_11));
        novosList.add(new memes("Morre porra", R.raw.silvio_santos_12));
        novosList.add(new memes("Tira esse dedo dai", R.raw.silvio_santos_13));
        novosList.add(new memes("Parabens", R.raw.silvio_santos_14));
        novosList.add(new memes("É claro que não", R.raw.galo_cego_01));
        novosList.add(new memes("É ué", R.raw.galo_cego_02));
        novosList.add(new memes("Não nada ver irmão", R.raw.galo_cego_03));
        novosList.add(new memes("Comprar alimento", R.raw.galo_cego_04));
        novosList.add(new memes("Corpo de delito", R.raw.galo_cego_05));
        novosList.add(new memes("Eu? Não sabia", R.raw.galo_cego_06));
        novosList.add(new memes("Vai comer doce", R.raw.vaicomerdoce));
        novosList.add(new memes("Nem um homem te quer", R.raw.tequer));
        novosList.add(new memes("Vou tacar o prato", R.raw.tacarprato));
        novosList.add(new memes("Sua irma", R.raw.suairma));
        novosList.add(new memes("Sai daqui", R.raw.saidaqui));
        novosList.add(new memes("Pobre adotado", R.raw.pobreadotado));
        novosList.add(new memes("Menina sem braço", R.raw.piadabalanco));
        novosList.add(new memes("Penis na boca", R.raw.penesnaboca));
        novosList.add(new memes("Medo da policia", R.raw.medodapolicia));
        novosList.add(new memes("Me abandono", R.raw.meabandono));
        novosList.add(new memes("Programa", R.raw.marcelogarota));
        novosList.add(new memes("Ingrediente", R.raw.ingrediente));
        novosList.add(new memes("Escravo", R.raw.escravonabolivia));
        novosList.add(new memes("Vou comer seu coração", R.raw.comercoracao));
        novosList.add(new memes("Carrocinha", R.raw.carrocinha));
        novosList.add(new memes("Cala boca", R.raw.calaboca));
        novosList.add(new memes("2 reais", R.raw.bonecoreais));
        novosList.add(new memes("Amamente", R.raw.amamente));
        novosList.add(new memes("Ahh cala boca", R.raw.ahhhcalaboca));


        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, novosList);
        lv.setAdapter(arrayAdapter);

        //play audio
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                playSong(position);
            }
        });
        // click longo para compartilhar
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                isStoragePermissionGranted();
                sendWhatsAppAudio(position);
                abrirPropaganda();
                return true;

            }
        });

        sPreferences = getSharedPreferences("Avaliar", MODE_PRIVATE);
        sPreferences = getSharedPreferences("youtube", MODE_PRIVATE);


    }

    @Override
    public void onResume() {
        if (mAdView != null) {
            mAdView.resume();
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    private void abrirPropaganda(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    @SuppressLint("WrongConstant")
    private void isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 &&
                checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 0:
                boolean isPerpermissionForAllGranted = false;
                if (grantResults.length <= 0 || permissions.length != grantResults.length) {
                    isPerpermissionForAllGranted = true;
                } else {
                    for (int i = 0; i < permissions.length; i++) {
                        isPerpermissionForAllGranted = grantResults[i] == 0;
                    }
                }
                if (!isPerpermissionForAllGranted) {
                    return;
                }
                return;
            default:
        }
    }

    private void sendWhatsAppAudio(int songIndex){
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        try {
            inputStream = getResources().openRawResource(arrayAdapter.getItem(songIndex).getResId());
            fileOutputStream = new FileOutputStream(
                    new File(Environment.getExternalStorageDirectory(), arrayAdapter.getItem(songIndex) +".mp3"));

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }

            inputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        Uri uri;
        intent.putExtra(Intent.EXTRA_STREAM, uri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID, new File(
                Environment.getExternalStorageDirectory(), arrayAdapter.getItem(songIndex) +".mp3")));
        intent.setDataAndType(uri, "audio/*");
        startActivity(Intent.createChooser(intent, "Escolha onde deseja compartilhar"));
    }

    //Tocar o som
    private void playSong(int songIndex) {

        mp.reset();
        mp = MediaPlayer.create(this, arrayAdapter.getItem(songIndex).getResId());

        mp.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.release();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.avaliar:
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=brasilmemes.memeslite")));
                    return true;
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=brasilmemes.memeslite")));
                }
                return true;
            case R.id.action_settings:
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                share.putExtra(Intent.EXTRA_SUBJECT,
                        "Baixa esse aplicativo ai é muito divertido.");
                share.putExtra(Intent.EXTRA_TEXT,
                        "Baixa esse aplicativo ai!!! é muito divertido " +
                                " https://play.google.com/store/apps/details?id=brasilmemes.memeslite");

                startActivity(Intent.createChooser(share, "Mostrar para amigos"));
                return true;

            case R.id.tuto:
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Olá, Marilene!");
                alertDialog.setMessage("😍COMO COMPARTILHAR \nPara compartilhar os audios, Fique apertado sobre o meme desejado por alguns segundos, depois é so escolher onde deseja compartilhar. \n\n👌COMO NAVEGAR ENTRE AS CATEGORIAS \nClick sobre a foto do rosto do meme sera exibido uma lista com todos os memes do personagem clicado. \n\n😁É NOIS MLK LOKO, NÃO ESQUEÇA DE AVALIAR NOSSO APP.");
                alertDialog.setButton("Entendi! Mestre supremo pika das galaxias", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        abrirPropaganda();
                    }
                });
                alertDialog.show();
                return true;

            default:
            case R.id.youtube:
                Uri uri = Uri.parse("https://www.youtube.com/channel/UCLIdUFCo6HGUVmQeMnhsJ8g");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                return super.onOptionsItemSelected(item);

        }
    }

    private void pedirAvaliar() {

        // setup the alert builder
        if (sPreferences.getBoolean("Avaliar", true)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Olá amiguinho");
            builder.setMessage("Para desbloquear essa categoria avalie o app com 5 estrelas\uD83D\uDE0D");

            // add the buttons
            builder.setNegativeButton("Não\uD83D\uDE2D", null);

            builder.setPositiveButton("Avaliar\uD83D\uDC4D", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    comentario();
                    sPreferences.edit().putBoolean("Avaliar", false).apply();
                }
            });


            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
    public void inscricaoYT() {

        // setup the alert builder
        if (sPreferences.getBoolean("youtube", true)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Olá amiguinho");
            builder.setMessage("Para liberar essa categoria inscreva-se em nosso canal\uD83D\uDE0D");

            // add the buttons
            builder.setNegativeButton("Não\uD83D\uDE2D", null);

            builder.setPositiveButton("Inscrever-se", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Uri uri = Uri.parse("https://www.youtube.com/channel/UCLIdUFCo6HGUVmQeMnhsJ8g");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    sPreferences.edit().putBoolean("youtube", false).apply();
                }
            });


            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    private void comentario() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=brasilmemes.memeslite")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=brasilmemes.memeslite")));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alborguetti:
                alborghettiList = new ArrayList<>();

                alborghettiList.add(new memes("Isso é a maior putaria", R.raw.alborghetti_01));
                alborghettiList.add(new memes("Cabação", R.raw.alborghetti_03));
                alborghettiList.add(new memes("Cala boca", R.raw.alborghetti_04));
                alborghettiList.add(new memes("É lamentavel", R.raw.alborghetti_05));
                alborghettiList.add(new memes("E mando todo mundo a puta que pariu", R.raw.alborghetti_06));
                alborghettiList.add(new memes("ÉÉEÉÉ... isso aqui ta uma porra", R.raw.alborghetti_07));
                alborghettiList.add(new memes("Essa gazela do satanas", R.raw.alborghetti_08));
                alborghettiList.add(new memes("Filho da puta", R.raw.alborghetti_10));
                alborghettiList.add(new memes("Esta imperdivel hoje", R.raw.alborghetti_11));
                alborghettiList.add(new memes("Não venha encher meu saco", R.raw.alborghetti_12));
                alborghettiList.add(new memes("Num gosto foda-se cara", R.raw.alborghetti_13));
                alborghettiList.add(new memes("O que voces querem", R.raw.alborghetti_14));
                alborghettiList.add(new memes("Todo dia tem uma merda", R.raw.alborghetti_15));
                alborghettiList.add(new memes("Vcs trocado por merda é caro", R.raw.alborghetti_16));
                alborghettiList.add(new memes("FODA-SE", R.raw.alborghetti_17));
                alborghettiList.add(new memes("Va pro inferno porra", R.raw.alborghetti_18));
                alborghettiList.add(new memes("Eu fico puto da cara", R.raw.alborghetti_19));
                alborghettiList.add(new memes("Responda porra", R.raw.alborghetti_20));
                alborghettiList.add(new memes("Vai trabalhar sua ordinaria", R.raw.alborghetti_21));
                alborghettiList.add(new memes("Bem feito", R.raw.alborguetti_bemfeito));
                alborghettiList.add(new memes("Cade meu pau", R.raw.alborguetti_cademeupau));
                alborghettiList.add(new memes("Eu to louco? Não!", R.raw.alborguetti_toloco));
                alborghettiList.add(new memes("Va a merda", R.raw.alborguetti_vaamerda));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alborghettiList);
                lv.setAdapter(arrayAdapter);
                pedirAvaliar();


                break;

            case R.id.negobam:
                negobamList = new ArrayList<>();

                negobamList.add(new memes("Ameno", R.raw.negobam_ameno));
                negobamList.add(new memes("Champions", R.raw.negobam_champions));
                negobamList.add(new memes("Friends", R.raw.negobam_friends));
                negobamList.add(new memes("Gozathens", R.raw.negobam_gozathens));
                negobamList.add(new memes("Gozelynflores", R.raw.negobam_gozelynflores));
                negobamList.add(new memes("Goza da justiça", R.raw.gozajus));
                negobamList.add(new memes("Skrillex", R.raw.bangagozo));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, negobamList);
                lv.setAdapter(arrayAdapter);


                break;

            case R.id.dilma:
                dilmalist = new ArrayList<>();

                dilmalist.add(new memes("A terra é curva", R.raw.dilma_01));
                dilmalist.add(new memes("Dobramos a meta", R.raw.dilma_03));
                dilmalist.add(new memes("Eu engasguei comigo mesma", R.raw.dilma_04));
                dilmalist.add(new memes("Quase que eu n podia", R.raw.dilma_05));
                dilmalist.add(new memes("Eu vi, parei de ver, voltei a ver", R.raw.dilma_06));
                dilmalist.add(new memes("Happy basner", R.raw.dilma_07));
                dilmalist.add(new memes("Meio ambiente é uma ameaça", R.raw.dilma_08));
                dilmalist.add(new memes("Pasta de dente", R.raw.dilma_09));
                dilmalist.add(new memes("Saldando a mandioca", R.raw.dilma_10));
                dilmalist.add(new memes("Vai todo mundo perder", R.raw.dilma_11));
                dilmalist.add(new memes("Beijos", R.raw.dilma_12));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dilmalist);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.away:
                awayList = new ArrayList<>();

                awayList.add(new memes("Fecha o cú pra falar comigo", R.raw.fechaocu));
                awayList.add(new memes("O sua monica do caralho", R.raw.awaymonica));
                awayList.add(new memes("Cala boca", R.raw.gil_brother_01));
                awayList.add(new memes("Conversa de puta deus não escuta", R.raw.gil_brother_02));
                awayList.add(new memes("Enfia os pes dentro do cú", R.raw.gil_brother_04));
                awayList.add(new memes("Eu fico perpcso", R.raw.gil_brother_05));
                awayList.add(new memes("F E C H A  O  C Ú", R.raw.gil_brother_06));
                awayList.add(new memes("Nesse verão tira as crianças da sala", R.raw.gil_brother_08));
                awayList.add(new memes("Dez tapa na cara", R.raw.gil_brother_09));
                awayList.add(new memes("Olha esse desgraçado", R.raw.gil_brother_10));
                awayList.add(new memes("Para com essa porra", R.raw.gil_brother_11));
                awayList.add(new memes("Pode virar megazord", R.raw.gil_brother_12));
                awayList.add(new memes("Vou te alisar a cara no chão", R.raw.gil_brother_13));
                awayList.add(new memes("Vai toma no cú", R.raw.gil_brother_16));
                awayList.add(new memes("O cachaceiro", R.raw.gil_brother_17));
                awayList.add(new memes("E fim de papo nessa porra", R.raw.gil_brother_19));
                awayList.add(new memes("Visão", R.raw.gil_brother_21));
                awayList.add(new memes("Cala boca meu aluno", R.raw.gil_brother_22));
                awayList.add(new memes("É muita falcatrua", R.raw.gil_brother_23));
                awayList.add(new memes("Vai tomar no cú tranquilo", R.raw.gil_brother_24));
                awayList.add(new memes("Garotinho criado a leite moça", R.raw.gil_brother_25));
                awayList.add(new memes("Movimento q eu trai", R.raw.gil_brother_27));
                awayList.add(new memes("Ninguem é obrigado a ouvir merda", R.raw.gil_brother_28));
                awayList.add(new memes("Ola os dois podre", R.raw.gil_brother_29));
                awayList.add(new memes("Vai criar porquinho na ilha", R.raw.gil_brother_30));
                awayList.add(new memes("Seja obsetivo", R.raw.gil_brother_31));
                awayList.add(new memes("Em que posso ser util", R.raw.gil_brother_32));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, awayList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.cachorreira:
                cachorreiraList = new ArrayList<>();

                cachorreiraList.add(new memes("Ce louco cachoeira", R.raw.celoucocachoeira_cachoeira));
                cachorreiraList.add(new memes("Só por deus", R.raw.celoucocachoeira_sopordeus));
                cachorreiraList.add(new memes("Eu sou tarado no sexo", R.raw.celoucocachoeira_tarado));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cachorreiraList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.nuncanemvi:
                nuncanemviList = new ArrayList<>();

                nuncanemviList.add(new memes("Nunca nem vi", R.raw.nuncanemvi));
                nuncanemviList.add(new memes("Que dia foi isso?", R.raw.nuncanemvi_quediafoiisso));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nuncanemviList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.morrediabo:
                morrediaboList = new ArrayList<>();

                morrediaboList.add(new memes("Morre diabo", R.raw.morrediabo_morre));
                morrediaboList.add(new memes("Não interessa", R.raw.morrediabo_naointeressa));
                morrediaboList.add(new memes("To falando, Num do falando", R.raw.morrediabo_tofalando));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, morrediaboList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.felipe:
                felipeList = new ArrayList<>();

                felipeList.add(new memes("Faz isso comigo não ", R.raw.felipe_fazcomigonao));
                felipeList.add(new memes("Guarapari, Buzios é minha arte", R.raw.felipe_guarapari));
                felipeList.add(new memes("Sai dae doido", R.raw.felipe_saidaedoido));
                felipeList.add(new memes("Samu seu cú", R.raw.felipe_samu));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, felipeList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.bolsonaro:
                bolsonaroList = new ArrayList<>();

                bolsonaroList.add(new memes("Amigo gay", R.raw.amigogay));
                bolsonaroList.add(new memes("Amizade gay", R.raw.amizadegay));
                bolsonaroList.add(new memes("Animal", R.raw.animal));
                bolsonaroList.add(new memes("Bigodudo ou careca", R.raw.bigodudooucareca));
                bolsonaroList.add(new memes("Cabo", R.raw.cabo));
                bolsonaroList.add(new memes("Cagando pra vc", R.raw.cagandopravc));
                bolsonaroList.add(new memes("Canalhas", R.raw.canalhas));
                bolsonaroList.add(new memes("Canalhas mil vezes", R.raw.canalhasmilvezes));
                bolsonaroList.add(new memes("Chupao", R.raw.chupao));
                bolsonaroList.add(new memes("Coisa de viado", R.raw.coisadeviado));
                bolsonaroList.add(new memes("Consumo de droga", R.raw.consumodedroga));
                bolsonaroList.add(new memes("Da que te dou outra", R.raw.daquetedououtra));
                bolsonaroList.add(new memes("Detesto esse governo", R.raw.detestoessegoverno));
                bolsonaroList.add(new memes("Direitos humanos", R.raw.direitoshumanos));
                bolsonaroList.add(new memes("Espero nada de grave aconteca", R.raw.esperodadagraveaconteca));
                bolsonaroList.add(new memes("Falar fino", R.raw.falarfino));
                bolsonaroList.add(new memes("Fode nois", R.raw.fodenois));
                bolsonaroList.add(new memes("Garoto adotado", R.raw.garotoadotado));
                bolsonaroList.add(new memes("Jamais iria estuprar voce", R.raw.jamaisiriaestuprarvoce));
                bolsonaroList.add(new memes("Flho de quem? joao ou pedrao", R.raw.joaopedrao));
                bolsonaroList.add(new memes("Mae bigoduda", R.raw.maebigoduda));
                bolsonaroList.add(new memes("Maranhão", R.raw.maranhao));
                bolsonaroList.add(new memes("Masoque e isso", R.raw.masoqueeisso));
                bolsonaroList.add(new memes("Menor vagabundo", R.raw.menorvagabundo));
                bolsonaroList.add(new memes("Minha cara", R.raw.minhacara));
                bolsonaroList.add(new memes("Não entendi", R.raw.naoentendi));
                bolsonaroList.add(new memes("Não não", R.raw.naonao));
                bolsonaroList.add(new memes("Não quero que ele morra", R.raw.naoqueroqueelemorra));
                bolsonaroList.add(new memes("Não sequestrar", R.raw.naosequestrar));
                bolsonaroList.add(new memes("Não vai votar", R.raw.naovaivotar));
                bolsonaroList.add(new memes("Não vou polemizar", R.raw.naovoupolemizar));
                bolsonaroList.add(new memes("Nhanha", R.raw.nhanha));
                bolsonaroList.add(new memes("Orgão excretor", R.raw.orgaoexcretor));
                bolsonaroList.add(new memes("Orgulho gay", R.raw.orgulhogay));
                bolsonaroList.add(new memes("Pena", R.raw.pena));
                bolsonaroList.add(new memes("Poha q decipcao", R.raw.pohqdecipcao));
                bolsonaroList.add(new memes("Porrada", R.raw.porrada));
                bolsonaroList.add(new memes("Presidios", R.raw.presidios));
                bolsonaroList.add(new memes("Que porra de verdade", R.raw.queporradeverdade));
                bolsonaroList.add(new memes("Risada", R.raw.risada));
                bolsonaroList.add(new memes("Rosquinha", R.raw.rosquinha));
                bolsonaroList.add(new memes("Rua onde ela mora", R.raw.ruaondeelamora));
                bolsonaroList.add(new memes("Soco", R.raw.soco));
                bolsonaroList.add(new memes("Sucesso", R.raw.sucesso));
                bolsonaroList.add(new memes("Tem que se fude", R.raw.temquesefude));
                bolsonaroList.add(new memes("Tetas do governo", R.raw.tetasdogoverno));
                bolsonaroList.add(new memes("Tu é cubano", R.raw.tuecubano));
                bolsonaroList.add(new memes("Vagabunda", R.raw.vagabunda));
                bolsonaroList.add(new memes("Vai pra cuba", R.raw.vaipracuba));
                bolsonaroList.add(new memes("Viu dois homens se beijando", R.raw.viobeijo));
                bolsonaroList.add(new memes("Voto obrigatorio é MEU PINTO", R.raw.votoobrigatorio));


                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bolsonaroList);
                lv.setAdapter(arrayAdapter);
                pedirAvaliar();
                break;
            case R.id.serjao:
                serjaoList = new ArrayList<>();

                serjaoList.add(new memes("Aqui tem coragem", R.raw.serjao_aquitemcoragem));
                serjaoList.add(new memes("Autoridades do ibama", R.raw.serjao_autoridadesdoibama));
                serjaoList.add(new memes("Onça", R.raw.serjao_barulhoonca));
                serjaoList.add(new memes("Com fé n opai eterno", R.raw.serjao_comfenopaieterno));
                serjaoList.add(new memes("É a verdade", R.raw.serjao_eaverdade));
                serjaoList.add(new memes("Matador de onça", R.raw.serjao_matadordeonca));
                serjaoList.add(new memes("Serjao mclan", R.raw.serjao_mclan));
                serjaoList.add(new memes("Perigoso na calça ele cagar", R.raw.serjao_nacalcacagar));
                serjaoList.add(new memes("Pipoco come", R.raw.serjao_oncanozoologico));
                serjaoList.add(new memes("Valeu por duas ou mais", R.raw.serjao_valeuporduasoumais));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, serjaoList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.papaco:
                papacoList = new ArrayList<>();

                papacoList.add(new memes("Ainda bem", R.raw.papaco_aindabem));
                papacoList.add(new memes("Ei seu bunda mole", R.raw.papaco_bundamole));
                papacoList.add(new memes("Quem foi o cagão", R.raw.papaco_cagao));
                papacoList.add(new memes("Falou comigo?", R.raw.papaco_faloucomigo));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, papacoList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.cepo:
                cepoList = new ArrayList<>();

                cepoList.add(new memes("Cepo de madeira", R.raw.cepodemadeira));
                cepoList.add(new memes("Cepo bem duro", R.raw.cepodemadeira_bemduro));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cepoList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.pesadao:
                pesadaoList = new ArrayList<>();

                pesadaoList.add(new memes("Gatinha", R.raw.gatinha));
                pesadaoList.add(new memes("Menino lobo", R.raw.meninolobo));
                pesadaoList.add(new memes("Pesadão", R.raw.pesadao));
                pesadaoList.add(new memes("1990", R.raw.pesadao1990));
                pesadaoList.add(new memes("Pesadaummm", R.raw.pesadaum));
                pesadaoList.add(new memes("Telefone 3990", R.raw.telefone3990));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pesadaoList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.filmaefala:
                filmaefalaList = new ArrayList<>();

                filmaefalaList.add(new memes("Ce o bixão memo em doido", R.raw.bixao));
                filmaefalaList.add(new memes("Ce filma e fala", R.raw.filma));
                filmaefalaList.add(new memes("Capeta prego", R.raw.filmaefala_capeteprego));
                filmaefalaList.add(new memes("Suspeito", R.raw.filmaefala_suspeito));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filmaefalaList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.chico:
                chicoList = new ArrayList<>();

                chicoList.add(new memes("Eu quero saber quem transa", R.raw.chicobioca));
                chicoList.add(new memes("Chupa um cú e pá", R.raw.chupaumcuepa));
                chicoList.add(new memes("Comer vaginas e tudo mais", R.raw.comervaginas));
                chicoList.add(new memes("Sexo anal", R.raw.sexoanal));
                chicoList.add(new memes("Um tabaco bem massa", R.raw.umtabaco));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chicoList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.djrogerinho:
                djrogerinholist = new ArrayList<>();

                djrogerinholist.add(new memes("DJ Rogerinho Completo", R.raw.djrogerinho));
                djrogerinholist.add(new memes("Cabeca de tangerina", R.raw.tangerina));
                djrogerinholist.add(new memes("Cabeça de caramelo", R.raw.caramelo));
                djrogerinholist.add(new memes("Canal do youtube", R.raw.canal));
                djrogerinholist.add(new memes("Espiga de milho queimada", R.raw.espiga));
                djrogerinholist.add(new memes("Feijao queimado", R.raw.feijao));
                djrogerinholist.add(new memes("Hackearam meu e-mail", R.raw.email));
                djrogerinholist.add(new memes("Tortao que nem vergado", R.raw.tortao));
                djrogerinholist.add(new memes("Lança um site", R.raw.lanca));
                djrogerinholist.add(new memes("DJ Rogerinho Parte 2", R.raw.djrogerinho_partedois));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, djrogerinholist);
                lv.setAdapter(arrayAdapter);
                pedirAvaliar();

                break;
            case R.id.sikerajunior:
                sikeirajuniorList = new ArrayList<>();

                sikeirajuniorList.add(new memes("É o crime é nois", R.raw.sikerajunior_eocrimeenois));
                sikeirajuniorList.add(new memes("É maconha doido", R.raw.sikerajunior_maconhamusica));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sikeirajuniorList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.delicia:
                deliciaList = new ArrayList<>();

                deliciaList.add(new memes("Que delicia cara", R.raw.quedelicia));
                deliciaList.add(new memes("Essa peça que vc queria?", R.raw.quedelicia_essapeca));
                deliciaList.add(new memes("Ahhh que pika gostosa", R.raw.ahhhquepikagostosa));
                deliciaList.add(new memes("Ai que gostoso", R.raw.aiquegostoso));
                deliciaList.add(new memes("Como assim nâo intendi", R.raw.comoassimnaointendi));
                deliciaList.add(new memes("Como assim vc n vai por", R.raw.comoassimvcnvaipor));
                deliciaList.add(new memes("To afim de relaxar", R.raw.toafimderelaxar));
                deliciaList.add(new memes("Trabalhando e relaxando", R.raw.trabalhandoerelaxando));
                deliciaList.add(new memes("Vou te deixar oco", R.raw.voudeixaroco));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, deliciaList);
                lv.setAdapter(arrayAdapter);
                pedirAvaliar();
                break;
            case R.id.vindiesel:
                vindieselList = new ArrayList<>();

                vindieselList.add(new memes("Can hugs", R.raw.vindiesel_canhugs));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vindieselList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.voceeburro:
                voceeburroList = new ArrayList<>();

                voceeburroList.add(new memes("Como vc é burro", R.raw.comovceburro));
                voceeburroList.add(new memes("Que coisa absurda", R.raw.quecoisaabsurda));
                voceeburroList.add(new memes("Vc fala de uma maneira burra", R.raw.vcfaladeumamaneiraburra));
                voceeburroList.add(new memes("Como vc é burro(COMPLETO)", R.raw.seburrocompleto));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, voceeburroList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.faustao:
                faustaoList = new ArrayList<>();

                faustaoList.add(new memes("Lave o pinto", R.raw.faustao_04));
                faustaoList.add(new memes("Ninguem acertou", R.raw.faustao_05));
                faustaoList.add(new memes("Pourra meu", R.raw.faustao_06));
                faustaoList.add(new memes("Puta vida", R.raw.faustao_07));
                faustaoList.add(new memes("Frango de macumba", R.raw.faustao_11));
                faustaoList.add(new memes("Ih serjão sujo", R.raw.faustao_12));
                faustaoList.add(new memes("Errou", R.raw.faustao_errou));
                faustaoList.add(new memes("Ta pegando fogo bixo", R.raw.faustao_tapegandofogo));
                faustaoList.add(new memes("Vai morrer", R.raw.morrer));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, faustaoList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.silvio:
                silvioList = new ArrayList<>();

                silvioList.add(new memes("E o bambu?", R.raw.silvio_enfianoteucu));
                silvioList.add(new memes("Não consegue", R.raw.silvio_naoconsegue));
                silvioList.add(new memes("Que pena vc erro", R.raw.silvio_santos_04));
                silvioList.add(new memes("Calma, calma sua piranha", R.raw.silvio_santos_07));
                silvioList.add(new memes("Está certo disso?", R.raw.silvio_santos_08));
                silvioList.add(new memes("Tem que mandar matar", R.raw.silvio_santos_09));
                silvioList.add(new memes("Oiiih", R.raw.silvio_santos_11));
                silvioList.add(new memes("Morre porra", R.raw.silvio_santos_12));
                silvioList.add(new memes("Tira esse dedo dai", R.raw.silvio_santos_13));
                silvioList.add(new memes("Parabens", R.raw.silvio_santos_14));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, silvioList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.galocego:
                galocegoList = new ArrayList<>();

                galocegoList.add(new memes("É claro que não", R.raw.galo_cego_01));
                galocegoList.add(new memes("É ué", R.raw.galo_cego_02));
                galocegoList.add(new memes("Não nada ver irmão", R.raw.galo_cego_03));
                galocegoList.add(new memes("Comprar alimento", R.raw.galo_cego_04));
                galocegoList.add(new memes("Corpo de delito", R.raw.galo_cego_05));
                galocegoList.add(new memes("Eu? Não sabia", R.raw.galo_cego_06));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, galocegoList);
                lv.setAdapter(arrayAdapter);
                break;
            case R.id.novosmemes:
                novosList = new ArrayList<>();

                novosList.add(new memes("Que tiro foi esse", R.raw.quetirofoiesse));
                novosList.add(new memes("do u kno de wae", R.raw.knowtheway));
                novosList.add(new memes("Clucking", R.raw.clucking));
                novosList.add(new memes("Isso é a maior putaria", R.raw.alborghetti_01));
                novosList.add(new memes("Cabação", R.raw.alborghetti_03));
                novosList.add(new memes("Cala boca", R.raw.alborghetti_04));
                novosList.add(new memes("É lamentavel", R.raw.alborghetti_05));
                novosList.add(new memes("E mando todo mundo a puta que pariu", R.raw.alborghetti_06));
                novosList.add(new memes("ÉÉEÉÉ... isso aqui ta uma porra", R.raw.alborghetti_07));
                novosList.add(new memes("Essa gazela do satanas", R.raw.alborghetti_08));
                novosList.add(new memes("Filho da puta", R.raw.alborghetti_10));
                novosList.add(new memes("Esta imperdivel hoje", R.raw.alborghetti_11));
                novosList.add(new memes("Não venha encher meu saco", R.raw.alborghetti_12));
                novosList.add(new memes("Num gosto foda-se cara", R.raw.alborghetti_13));
                novosList.add(new memes("O que voces querem", R.raw.alborghetti_14));
                novosList.add(new memes("Todo dia tem uma merda", R.raw.alborghetti_15));
                novosList.add(new memes("Vcs trocado por merda é caro", R.raw.alborghetti_16));
                novosList.add(new memes("FODA-SE", R.raw.alborghetti_17));
                novosList.add(new memes("Va pro inferno porra", R.raw.alborghetti_18));
                novosList.add(new memes("Eu fico puto da cara", R.raw.alborghetti_19));
                novosList.add(new memes("Responda porra", R.raw.alborghetti_20));
                novosList.add(new memes("Vai trabalhar sua ordinaria", R.raw.alborghetti_21));
                novosList.add(new memes("Bem feito", R.raw.alborguetti_bemfeito));
                novosList.add(new memes("Cade meu pau", R.raw.alborguetti_cademeupau));
                novosList.add(new memes("Eu to louco? Não!", R.raw.alborguetti_toloco));
                novosList.add(new memes("Va a merda", R.raw.alborguetti_vaamerda));
                novosList.add(new memes("Ameno", R.raw.negobam_ameno));
                novosList.add(new memes("Champions", R.raw.negobam_champions));
                novosList.add(new memes("Friends", R.raw.negobam_friends));
                novosList.add(new memes("Gozathens", R.raw.negobam_gozathens));
                novosList.add(new memes("Gozelynflores", R.raw.negobam_gozelynflores));
                novosList.add(new memes("Goza da justiça", R.raw.gozajus));
                novosList.add(new memes("Skrillex", R.raw.bangagozo));
                novosList.add(new memes("A terra é curva", R.raw.dilma_01));
                novosList.add(new memes("Dobramos a meta", R.raw.dilma_03));
                novosList.add(new memes("Eu engasguei comigo mesma", R.raw.dilma_04));
                novosList.add(new memes("Quase que eu n podia", R.raw.dilma_05));
                novosList.add(new memes("Eu vi, parei de ver, voltei a ver", R.raw.dilma_06));
                novosList.add(new memes("Happy basner", R.raw.dilma_07));
                novosList.add(new memes("Meio ambiente é uma ameaça", R.raw.dilma_08));
                novosList.add(new memes("Pasta de dente", R.raw.dilma_09));
                novosList.add(new memes("Saldando a mandioca", R.raw.dilma_10));
                novosList.add(new memes("Vai todo mundo perder", R.raw.dilma_11));
                novosList.add(new memes("Beijos", R.raw.dilma_12));
                novosList.add(new memes("Fecha o cú pra falar comigo", R.raw.fechaocu));
                novosList.add(new memes("O sua monica do caralho", R.raw.awaymonica));
                novosList.add(new memes("Cala boca", R.raw.gil_brother_01));
                novosList.add(new memes("Conversa de puta deus não escuta", R.raw.gil_brother_02));
                novosList.add(new memes("Enfia os pes dentro do cú", R.raw.gil_brother_04));
                novosList.add(new memes("Eu fico perpcso", R.raw.gil_brother_05));
                novosList.add(new memes("F E C H A  O  C Ú", R.raw.gil_brother_06));
                novosList.add(new memes("Nesse verão tira as crianças da sala", R.raw.gil_brother_08));
                novosList.add(new memes("Dez tapa na cara", R.raw.gil_brother_09));
                novosList.add(new memes("Olha esse desgraçado", R.raw.gil_brother_10));
                novosList.add(new memes("Para com essa porra", R.raw.gil_brother_11));
                novosList.add(new memes("Pode virar megazord", R.raw.gil_brother_12));
                novosList.add(new memes("Vou te alisar a cara no chão", R.raw.gil_brother_13));
                novosList.add(new memes("Vai toma no cú", R.raw.gil_brother_16));
                novosList.add(new memes("O cachaceiro", R.raw.gil_brother_17));
                novosList.add(new memes("E fim de papo nessa porra", R.raw.gil_brother_19));
                novosList.add(new memes("Visão", R.raw.gil_brother_21));
                novosList.add(new memes("Cala boca meu aluno", R.raw.gil_brother_22));
                novosList.add(new memes("É muita falcatrua", R.raw.gil_brother_23));
                novosList.add(new memes("Vai tomar no cú tranquilo", R.raw.gil_brother_24));
                novosList.add(new memes("Garotinho criado a leite moça", R.raw.gil_brother_25));
                novosList.add(new memes("Movimento q eu trai", R.raw.gil_brother_27));
                novosList.add(new memes("Ninguem é obrigado a ouvir merda", R.raw.gil_brother_28));
                novosList.add(new memes("Ola os dois podre", R.raw.gil_brother_29));
                novosList.add(new memes("Vai criar porquinho na ilha", R.raw.gil_brother_30));
                novosList.add(new memes("Seja obsetivo", R.raw.gil_brother_31));
                novosList.add(new memes("Em que posso ser util", R.raw.gil_brother_32));
                novosList.add(new memes("Ce louco cachoeira", R.raw.celoucocachoeira_cachoeira));
                novosList.add(new memes("Só por deus", R.raw.celoucocachoeira_sopordeus));
                novosList.add(new memes("Eu sou tarado no sexo", R.raw.celoucocachoeira_tarado));
                novosList.add(new memes("Nunca nem vi", R.raw.nuncanemvi));
                novosList.add(new memes("Que dia foi isso?", R.raw.nuncanemvi_quediafoiisso));
                novosList.add(new memes("Morre diabo", R.raw.morrediabo_morre));
                novosList.add(new memes("Não interessa", R.raw.morrediabo_naointeressa));
                novosList.add(new memes("To falando, Num do falando", R.raw.morrediabo_tofalando));
                novosList.add(new memes("Faz isso comigo não ", R.raw.felipe_fazcomigonao));
                novosList.add(new memes("Guarapari, Buzios é minha arte", R.raw.felipe_guarapari));
                novosList.add(new memes("Sai dae doido", R.raw.felipe_saidaedoido));
                novosList.add(new memes("Samu seu cú", R.raw.felipe_samu));
                novosList.add(new memes("Amigo gay", R.raw.amigogay));
                novosList.add(new memes("Amizade gay", R.raw.amizadegay));
                novosList.add(new memes("Animal", R.raw.animal));
                novosList.add(new memes("Bigodudo ou careca", R.raw.bigodudooucareca));
                novosList.add(new memes("Cabo", R.raw.cabo));
                novosList.add(new memes("Cagando pra vc", R.raw.cagandopravc));
                novosList.add(new memes("Canalhas", R.raw.canalhas));
                novosList.add(new memes("Canalhas mil vezes", R.raw.canalhasmilvezes));
                novosList.add(new memes("Chupao", R.raw.chupao));
                novosList.add(new memes("Coisa de viado", R.raw.coisadeviado));
                novosList.add(new memes("Consumo de droga", R.raw.consumodedroga));
                novosList.add(new memes("Da que te dou outra", R.raw.daquetedououtra));
                novosList.add(new memes("Detesto esse governo", R.raw.detestoessegoverno));
                novosList.add(new memes("Direitos humanos", R.raw.direitoshumanos));
                novosList.add(new memes("Espero nada de grave aconteca", R.raw.esperodadagraveaconteca));
                novosList.add(new memes("Falar fino", R.raw.falarfino));
                novosList.add(new memes("Fode nois", R.raw.fodenois));
                novosList.add(new memes("Garoto adotado", R.raw.garotoadotado));
                novosList.add(new memes("Jamais iria estuprar voce", R.raw.jamaisiriaestuprarvoce));
                novosList.add(new memes("Flho de quem? joao ou pedrao", R.raw.joaopedrao));
                novosList.add(new memes("Mae bigoduda", R.raw.maebigoduda));
                novosList.add(new memes("Maranhão", R.raw.maranhao));
                novosList.add(new memes("Masoque e isso", R.raw.masoqueeisso));
                novosList.add(new memes("Menor vagabundo", R.raw.menorvagabundo));
                novosList.add(new memes("Minha cara", R.raw.minhacara));
                novosList.add(new memes("Não entendi", R.raw.naoentendi));
                novosList.add(new memes("Não não", R.raw.naonao));
                novosList.add(new memes("Não quero que ele morra", R.raw.naoqueroqueelemorra));
                novosList.add(new memes("Não sequestrar", R.raw.naosequestrar));
                novosList.add(new memes("Não vai votar", R.raw.naovaivotar));
                novosList.add(new memes("Não vou polemizar", R.raw.naovoupolemizar));
                novosList.add(new memes("Nhanha", R.raw.nhanha));
                novosList.add(new memes("Orgão excretor", R.raw.orgaoexcretor));
                novosList.add(new memes("Orgulho gay", R.raw.orgulhogay));
                novosList.add(new memes("Pena", R.raw.pena));
                novosList.add(new memes("Poha q decipcao", R.raw.pohqdecipcao));
                novosList.add(new memes("Porrada", R.raw.porrada));
                novosList.add(new memes("Presidios", R.raw.presidios));
                novosList.add(new memes("Que porra de verdade", R.raw.queporradeverdade));
                novosList.add(new memes("Risada", R.raw.risada));
                novosList.add(new memes("Rosquinha", R.raw.rosquinha));
                novosList.add(new memes("Rua onde ela mora", R.raw.ruaondeelamora));
                novosList.add(new memes("Soco", R.raw.soco));
                novosList.add(new memes("Sucesso", R.raw.sucesso));
                novosList.add(new memes("Tem que se fude", R.raw.temquesefude));
                novosList.add(new memes("Tetas do governo", R.raw.tetasdogoverno));
                novosList.add(new memes("Tu é cubano", R.raw.tuecubano));
                novosList.add(new memes("Vagabunda", R.raw.vagabunda));
                novosList.add(new memes("Vai pra cuba", R.raw.vaipracuba));
                novosList.add(new memes("Viu dois homens se beijando", R.raw.viobeijo));
                novosList.add(new memes("Voto obrigatorio é MEU PINTO", R.raw.votoobrigatorio));
                novosList.add(new memes("Aqui tem coragem", R.raw.serjao_aquitemcoragem));
                novosList.add(new memes("Autoridades do ibama", R.raw.serjao_autoridadesdoibama));
                novosList.add(new memes("Onça", R.raw.serjao_barulhoonca));
                novosList.add(new memes("Com fé n opai eterno", R.raw.serjao_comfenopaieterno));
                novosList.add(new memes("É a verdade", R.raw.serjao_eaverdade));
                novosList.add(new memes("Matador de onça", R.raw.serjao_matadordeonca));
                novosList.add(new memes("Serjao mclan", R.raw.serjao_mclan));
                novosList.add(new memes("Perigoso na calça ele cagar", R.raw.serjao_nacalcacagar));
                novosList.add(new memes("Pipoco come", R.raw.serjao_oncanozoologico));
                novosList.add(new memes("Valeu por duas ou mais", R.raw.serjao_valeuporduasoumais));
                novosList.add(new memes("Ainda bem", R.raw.papaco_aindabem));
                novosList.add(new memes("Ei seu bunda mole", R.raw.papaco_bundamole));
                novosList.add(new memes("Quem foi o cagão", R.raw.papaco_cagao));
                novosList.add(new memes("Falou comigo?", R.raw.papaco_faloucomigo));
                novosList.add(new memes("Cepo de madeira", R.raw.cepodemadeira));
                novosList.add(new memes("Cepo bem duro", R.raw.cepodemadeira_bemduro));
                novosList.add(new memes("Gatinha", R.raw.gatinha));
                novosList.add(new memes("Menino lobo", R.raw.meninolobo));
                novosList.add(new memes("Pesadão", R.raw.pesadao));
                novosList.add(new memes("1990", R.raw.pesadao1990));
                novosList.add(new memes("Pesadaummm", R.raw.pesadaum));
                novosList.add(new memes("Telefone 3990", R.raw.telefone3990));
                novosList.add(new memes("Ce o bixão memo em doido", R.raw.bixao));
                novosList.add(new memes("Ce filma e fala", R.raw.filma));
                novosList.add(new memes("Capeta prego", R.raw.filmaefala_capeteprego));
                novosList.add(new memes("Suspeito", R.raw.filmaefala_suspeito));
                novosList.add(new memes("Eu quero saber quem transa", R.raw.chicobioca));
                novosList.add(new memes("Chupa um cú e pá", R.raw.chupaumcuepa));
                novosList.add(new memes("Comer vaginas e tudo mais", R.raw.comervaginas));
                novosList.add(new memes("Sexo anal", R.raw.sexoanal));
                novosList.add(new memes("Um tabaco bem massa", R.raw.umtabaco));
                novosList.add(new memes("DJ Rogerinho Completo", R.raw.djrogerinho));
                novosList.add(new memes("Cabeca de tangerina", R.raw.tangerina));
                novosList.add(new memes("Cabeça de caramelo", R.raw.caramelo));
                novosList.add(new memes("Canal do youtube", R.raw.canal));
                novosList.add(new memes("Espiga de milho queimada", R.raw.espiga));
                novosList.add(new memes("Feijao queimado", R.raw.feijao));
                novosList.add(new memes("Hackearam meu e-mail", R.raw.email));
                novosList.add(new memes("Tortao que nem vergado", R.raw.tortao));
                novosList.add(new memes("Lança um site", R.raw.lanca));
                novosList.add(new memes("DJ Rogerinho Parte 2", R.raw.djrogerinho_partedois));
                novosList.add(new memes("É o crime é nois", R.raw.sikerajunior_eocrimeenois));
                novosList.add(new memes("É maconha doido", R.raw.sikerajunior_maconhamusica));
                novosList.add(new memes("Que delicia cara", R.raw.quedelicia));
                novosList.add(new memes("Essa peça que vc queria?", R.raw.quedelicia_essapeca));
                novosList.add(new memes("Ahhh que pika gostosa", R.raw.ahhhquepikagostosa));
                novosList.add(new memes("Ai que gostoso", R.raw.aiquegostoso));
                novosList.add(new memes("Como assim nâo intendi", R.raw.comoassimnaointendi));
                novosList.add(new memes("Como assim vc n vai por", R.raw.comoassimvcnvaipor));
                novosList.add(new memes("To afim de relaxar", R.raw.toafimderelaxar));
                novosList.add(new memes("Trabalhando e relaxando", R.raw.trabalhandoerelaxando));
                novosList.add(new memes("Vou te deixar oco", R.raw.voudeixaroco));
                novosList.add(new memes("Can hugs", R.raw.vindiesel_canhugs));
                novosList.add(new memes("Como vc é burro", R.raw.comovceburro));
                novosList.add(new memes("Que coisa absurda", R.raw.quecoisaabsurda));
                novosList.add(new memes("Vc fala de uma maneira burra", R.raw.vcfaladeumamaneiraburra));
                novosList.add(new memes("Como vc é burro(COMPLETO)", R.raw.seburrocompleto));
                novosList.add(new memes("Lave o pinto", R.raw.faustao_04));
                novosList.add(new memes("Ninguem acertou", R.raw.faustao_05));
                novosList.add(new memes("Pourra meu", R.raw.faustao_06));
                novosList.add(new memes("Puta vida", R.raw.faustao_07));
                novosList.add(new memes("Frango de macumba", R.raw.faustao_11));
                novosList.add(new memes("Ih serjão sujo", R.raw.faustao_12));
                novosList.add(new memes("Errou", R.raw.faustao_errou));
                novosList.add(new memes("Ta pegando fogo bixo", R.raw.faustao_tapegandofogo));
                novosList.add(new memes("Vai morrer", R.raw.morrer));
                novosList.add(new memes("E o bambu?", R.raw.silvio_enfianoteucu));
                novosList.add(new memes("Não consegue", R.raw.silvio_naoconsegue));
                novosList.add(new memes("Que pena vc erro", R.raw.silvio_santos_04));
                novosList.add(new memes("Calma, calma sua piranha", R.raw.silvio_santos_07));
                novosList.add(new memes("Está certo disso?", R.raw.silvio_santos_08));
                novosList.add(new memes("Tem que mandar matar", R.raw.silvio_santos_09));
                novosList.add(new memes("Oiiih", R.raw.silvio_santos_11));
                novosList.add(new memes("Morre porra", R.raw.silvio_santos_12));
                novosList.add(new memes("Tira esse dedo dai", R.raw.silvio_santos_13));
                novosList.add(new memes("Parabens", R.raw.silvio_santos_14));
                novosList.add(new memes("É claro que não", R.raw.galo_cego_01));
                novosList.add(new memes("É ué", R.raw.galo_cego_02));
                novosList.add(new memes("Não nada ver irmão", R.raw.galo_cego_03));
                novosList.add(new memes("Comprar alimento", R.raw.galo_cego_04));
                novosList.add(new memes("Corpo de delito", R.raw.galo_cego_05));
                novosList.add(new memes("Eu? Não sabia", R.raw.galo_cego_06));
                novosList.add(new memes("Vai comer doce", R.raw.vaicomerdoce));
                novosList.add(new memes("Nem um homem te quer", R.raw.tequer));
                novosList.add(new memes("Vou tacar o prato", R.raw.tacarprato));
                novosList.add(new memes("Sua irma", R.raw.suairma));
                novosList.add(new memes("Sai daqui", R.raw.saidaqui));
                novosList.add(new memes("Pobre adotado", R.raw.pobreadotado));
                novosList.add(new memes("Menina sem braço", R.raw.piadabalanco));
                novosList.add(new memes("Penis na boca", R.raw.penesnaboca));
                novosList.add(new memes("Medo da policia", R.raw.medodapolicia));
                novosList.add(new memes("Me abandono", R.raw.meabandono));
                novosList.add(new memes("Programa", R.raw.marcelogarota));
                novosList.add(new memes("Ingrediente", R.raw.ingrediente));
                novosList.add(new memes("Escravo", R.raw.escravonabolivia));
                novosList.add(new memes("Vou comer seu coração", R.raw.comercoracao));
                novosList.add(new memes("Carrocinha", R.raw.carrocinha));
                novosList.add(new memes("Cala boca", R.raw.calaboca));
                novosList.add(new memes("2 reais", R.raw.bonecoreais));
                novosList.add(new memes("Amamente", R.raw.amamente));
                novosList.add(new memes("Ahh cala boca", R.raw.ahhhcalaboca));


                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, novosList);
                lv.setAdapter(arrayAdapter);
                break;
            default:
            case R.id.bonecojosias:
                bonecojosiasList = new ArrayList<>();

                bonecojosiasList.add(new memes("Vai comer doce", R.raw.vaicomerdoce));
                bonecojosiasList.add(new memes("Nem um homem te quer", R.raw.tequer));
                bonecojosiasList.add(new memes("Vou tacar o prato", R.raw.tacarprato));
                bonecojosiasList.add(new memes("Sua irma", R.raw.suairma));
                bonecojosiasList.add(new memes("Sai daqui", R.raw.saidaqui));
                bonecojosiasList.add(new memes("Pobre adotado", R.raw.pobreadotado));
                bonecojosiasList.add(new memes("Menina sem braço", R.raw.piadabalanco));
                bonecojosiasList.add(new memes("Penis na boca", R.raw.penesnaboca));
                bonecojosiasList.add(new memes("Medo da policia", R.raw.medodapolicia));
                bonecojosiasList.add(new memes("Me abandono", R.raw.meabandono));
                bonecojosiasList.add(new memes("Programa", R.raw.marcelogarota));
                bonecojosiasList.add(new memes("Ingrediente", R.raw.ingrediente));
                bonecojosiasList.add(new memes("Escravo", R.raw.escravonabolivia));
                bonecojosiasList.add(new memes("Vou comer seu coração", R.raw.comercoracao));
                bonecojosiasList.add(new memes("Carrocinha", R.raw.carrocinha));
                bonecojosiasList.add(new memes("Cala boca", R.raw.calaboca));
                bonecojosiasList.add(new memes("2 reais", R.raw.bonecoreais));
                bonecojosiasList.add(new memes("Amamente", R.raw.amamente));
                bonecojosiasList.add(new memes("Ahh cala boca", R.raw.ahhhcalaboca));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bonecojosiasList);
                lv.setAdapter(arrayAdapter);
                break;

        }
    }

    /*@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.crack:
                crackList = new ArrayList<>();

                crackList.add(new memes("Vira lixo", R.raw.crack_viralixo));
                crackList.add(new memes("Ve tudo isso", R.raw.crack_vetdisso));
                crackList.add(new memes("Ve gnomo", R.raw.crack_vegnomo));
                crackList.add(new memes("Sequestrar criança", R.raw.crack_sequestracrianca));
                crackList.add(new memes("Pow", R.raw.crack_pow));
                crackList.add(new memes("Apunhala criança", R.raw.crack_apunhalacrianca));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, crackList);
                lv.setAdapter(arrayAdapter);

                break;

            case R.id.piton:
                pitonList = new ArrayList<>();

                pitonList.add(new memes("Voce nao e amigo desgraça nenhuma", R.raw.piton_vcneamigodedesgracanenhuma));
                pitonList.add(new memes("Pra comer alguem", R.raw.piton_pracomeralguem));
                pitonList.add(new memes("Pra come alguem desgraça", R.raw.piton_pacumealguemdesgraca));
                pitonList.add(new memes("Eu vou comer todo mundo", R.raw.piton_euvoucomertodomundo));
                pitonList.add(new memes("Eu tenho dinheiro", R.raw.piton_eutenhodinheiro));
                pitonList.add(new memes("Eu sou beneficente", R.raw.piton_eusoubeneficente));
                pitonList.add(new memes("Esfolar uma buceta desgraça", R.raw.piton_esfolarumabucetadesgraca));
                pitonList.add(new memes("Esfolar buceta", R.raw.piton_esfolarbuceta));
                pitonList.add(new memes("Como dizia o filosofo piton", R.raw.piton_comodiziaofilosofopiton));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pitonList);
                lv.setAdapter(arrayAdapter);

                break;

            case R.id.cjescondido:
                cjescondidoList = new ArrayList<>();

                cjescondidoList.add(new memes("Agaraga bitch", R.raw.cj_agaraga));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cjescondidoList);
                lv.setAdapter(arrayAdapter);

                break;

            case R.id.btn_cris:
                crisList = new ArrayList<>();

                crisList.add(new memes("Acho que eu tava brincando?", R.raw.cris_achouqueeutavabrincando));
                crisList.add(new memes("Julius Pao duro", R.raw.cris_juliuspaoduro));
                crisList.add(new memes("Meu marido tem dois empregos", R.raw.cris_meumaridotemdoisempregos));
                crisList.add(new memes("Eu nao preciso trabalhar", R.raw.cris_eunaoprecisotrabalhar));
                crisList.add(new memes("Ah eu nao me gabo", R.raw.cris_aheunaomegabo));
                crisList.add(new memes("Eu vou estar la", R.raw.cris_euvouestarla));
                crisList.add(new memes("O que vc vai fazer", R.raw.cris_oqvcvaifazer));
                crisList.add(new memes("Não use esse meme para zuar amigos", R.raw.cris_apelidos));
                crisList.add(new memes("Cris mesada", R.raw.cris_mesada));
                crisList.add(new memes("Não vou te dar dinheiro", R.raw.cris_naovoudardinheiro));
                crisList.add(new memes("Sorte que eu não conheço meu pai", R.raw.cris_sortesuaqeunaoconhecomeupai));


                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, crisList);
                lv.setAdapter(arrayAdapter);
                Troll();
                break;


            case R.id.vegeta:
                vegetaList = new ArrayList<>();

                vegetaList.add(new memes("Voce e um fracassado", R.raw.goku_vcefracassadomp3));
                vegetaList.add(new memes("Oi eu sou o Goku", R.raw.goku_oieusouogoku));
                vegetaList.add(new memes("Verme maldito", R.raw.vegeta_vermemaldito));
                vegetaList.add(new memes("Cala boca", R.raw.vegeta_calaboca));
                vegetaList.add(new memes("Idiota", R.raw.vegeta_idiota));
                vegetaList.add(new memes("Voce e um inseto", R.raw.vegeta_inseto));
                vegetaList.add(new memes("Voce e retardado", R.raw.vegeta_retardado));
                vegetaList.add(new memes("Verme verde", R.raw.vegeta_vermeverde));
                vegetaList.add(new memes("É de mais de 8 mil", R.raw.vegeta));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vegetaList);
                lv.setAdapter(arrayAdapter);
                Troll();

                break;


            case R.id.acertoumizeravi:
                acertoumizeraviList = new ArrayList<>();

                acertoumizeraviList.add(new memes("Acertou mizeravi", R.raw.miseravel));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, acertoumizeraviList);
                lv.setAdapter(arrayAdapter);

                break;


            case R.id.alborghetti:
                titulo = findViewById(R.id.textView);
                titulo.setText("22:39");
                alborghettiList = new ArrayList<>();

                alborghettiList.add(new memes("Cabação", R.raw.alborghetti_cabacao));
                alborghettiList.add(new memes("Cala boca", R.raw.alborghetti_calabocasaidaqui));
                alborghettiList.add(new memes("Eeeah ta uma merda", R.raw.alborghetti_eeeeeeahhtaumamerda));
                alborghettiList.add(new memes("É lamentavel", R.raw.alborghetti_elamentavel));
                alborghettiList.add(new memes("E mando todo mundo a puta que pariu", R.raw.alborghetti_emandotodomundoaputa));
                alborghettiList.add(new memes("Essa gazela do satanas  ", R.raw.alborghetti_essagazeradosatanas));
                alborghettiList.add(new memes("Esta imperdivel hoje", R.raw.alborghetti_estaimperdivelhoje));
                alborghettiList.add(new memes("Eu adimiro mais a merda do que vocês", R.raw.alborghetti_euadimiromaisamerda));
                alborghettiList.add(new memes("Eu fico puto da cara", R.raw.alborghetti_euficoputodacara));
                alborghettiList.add(new memes("Filho da puta", R.raw.alborghetti_filhodaputa));
                alborghettiList.add(new memes("Fodaaaa", R.raw.alborghetti_fodaaaa));
                alborghettiList.add(new memes("Isto é a maior putaria", R.raw.alborghetti_istoemaiorputaria));
                alborghettiList.add(new memes("Não venha encher meu saco", R.raw.alborghetti_naovenhamenchermeusaco));
                alborghettiList.add(new memes("Num gosto foda-se cara", R.raw.alborghetti_numgostofodasecara));
                alborghettiList.add(new memes("Vai pedir pro Lula", R.raw.alborghetti_oquevcsqueremgrana));
                alborghettiList.add(new memes("Responda porra", R.raw.alborghetti_respondaporra));
                alborghettiList.add(new memes("Todo dia tem uma merda", R.raw.alborghetti_tododiatemumamerda));
                alborghettiList.add(new memes("Vai pro inferno larga de mentira", R.raw.alborghetti_vaiproinfernolargademintira));
                alborghettiList.add(new memes("Vai trabalhar sua ordinária", R.raw.alborghetti_vaitrabalharsuaordinaria));
                alborghettiList.add(new memes("Bem feito", R.raw.alborguetti_bemfeito));
                alborghettiList.add(new memes("Cade meu pau", R.raw.alborguetti_cademeupau));
                alborghettiList.add(new memes("Eu to loco", R.raw.alborguetti_toloco));
                alborghettiList.add(new memes("Va a merda porra", R.raw.alborguetti_vaamerda));
                alborghettiList.add(new memes("Veja bem", R.raw.alborguetti_vejabem));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alborghettiList);
                lv.setAdapter(arrayAdapter);

                break;


            case R.id.andremarques:
                andremarquesList = new ArrayList<>();

                andremarquesList.add(new memes("Deixa os garoto brinca", R.raw.andremarques_deixaosgarotos));
                andremarquesList.add(new memes("Faz o sample de guitarra", R.raw.andremarques_sampleguitarra));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, andremarquesList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;


            case R.id.away:
                awayList = new ArrayList<>();

                awayList.add(new memes("Bota dentadura no cu", R.raw.away_botadentaduranocu));
                awayList.add(new memes("Cala boca", R.raw.away_calaboca));
                awayList.add(new memes("Cala boca meu aluno", R.raw.away_calabocameualuno));
                awayList.add(new memes("Conversa de puta Deus não escuta", R.raw.away_conversadeputadeusnescuta));
                awayList.add(new memes("Dez tapa na cara e meio metro de piroca", R.raw.away_deztapanacaraemeiometro));
                awayList.add(new memes("E fim de papo nessa porra", R.raw.away_efimdebapo));
                awayList.add(new memes("Em que posso ser util", R.raw.away_emquepossoserultil));
                awayList.add(new memes("É muita falcatrua", R.raw.away_emuitafalcatrua));
                awayList.add(new memes("Enfia os dois dedo no cu e rasga", R.raw.away_enfiaosdoisdedonocuerasga));
                awayList.add(new memes("Eu fico perpequito", R.raw.away_euficoperpequito));
                awayList.add(new memes("Fecha o cu pra fala comigo", R.raw.away_fechaocu));
                awayList.add(new memes("Fecha o cu pra fala comigo Pausada   ", R.raw.away_fechaocu_falapausada));
                awayList.add(new memes("Garotinho criado a leite moça", R.raw.away_garotinhociadoaleitemoca));
                awayList.add(new memes("Igual uma garrafinha", R.raw.away_igualumagarrafinha));
                awayList.add(new memes("Sua Mônica do caralho", R.raw.away_monica));
                awayList.add(new memes("Movimento que eu trai", R.raw.away_movimentoqueeutrai));
                awayList.add(new memes("Nesse verão tira as criança da sala", R.raw.away_nesseveraotiraascriancasdasala));
                awayList.add(new memes("Ninguem é obrigado a ouvir merda", R.raw.away_ninguemeobrigadoaouvirmerda));
                awayList.add(new memes("O cachaceiro toma no cu hoje e amanhã de novo   ", R.raw.away_ocachaceirotomanocuhj));
                awayList.add(new memes("Olha esse desgraçado de novo aqui", R.raw.away_olhaessedesgracadodnvaqui));
                awayList.add(new memes("Olha os dois podre", R.raw.away_olhaosdoispodre));
                awayList.add(new memes("Para com essa porra", R.raw.away_paracomessaporraseufdp));
                awayList.add(new memes("Pode entrar um pelo cu do outro", R.raw.away_podevirarmegazord));
                awayList.add(new memes("Seja objetivo", R.raw.away_sejaobjetivo));
                awayList.add(new memes("Tu me encontra pela zero hora vou alizar sua cara no chão", R.raw.away_tumeencontrapelazerohora));
                awayList.add(new memes("Vai criar porquinho na ilha", R.raw.away_vaicriarpoquinhonaila));
                awayList.add(new memes("Vai tomar no cu tranquilo", R.raw.away_vaitomanocutranquilo));
                awayList.add(new memes("Eu to pegando a visão", R.raw.away_visao));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, awayList);
                lv.setAdapter(arrayAdapter);

                break;


            case R.id.bambam:
                bambamList = new ArrayList<>();

                bambamList.add(new memes("Ajuda o amluco que ta doente", R.raw.bambam_ajuda));
                bambamList.add(new memes("Birl", R.raw.bambam_birl));
                bambamList.add(new memes("Aqui é body builder", R.raw.bambam_bodybuilder));
                bambamList.add(new memes("Hora do show porra", R.raw.bambam_horadoshow));
                bambamList.add(new memes("Ta saindo da jaula o monstro", R.raw.bambam_jaula));
                bambamList.add(new memes("Han hein", R.raw.bambam_leo_hanhein));
                bambamList.add(new memes("Maluco é brabo", R.raw.bambam_leo_malucoebrabo));
                bambamList.add(new memes("Monstro não chora", R.raw.bambam_naochora));
                bambamList.add(new memes("Para de chorar", R.raw.bambam_paradechorar));
                bambamList.add(new memes("Sai de casa comi pra caralho", R.raw.bambam_saidecasa));
                bambamList.add(new memes("Eu ia dar um soco dentro da boca", R.raw.bambam_soconaboca));
                bambamList.add(new memes("Não to bem não", R.raw.bambam_tobemnao));
                bambamList.add(new memes("Trapezio descendente", R.raw.bambam_trapezio));
                bambamList.add(new memes("Vem monstro", R.raw.bambam_vemmonstro));
                bambamList.add(new memes("Vou chorar", R.raw.bambam_vouchorar));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bambamList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;


            case R.id.bichopiruleta:
                bichopiruletaList = new ArrayList<>();

                bichopiruletaList.add(new memes("O bixo piruleta", R.raw.piruleta_bicho));
                bichopiruletaList.add(new memes("Cuzão gostoso", R.raw.piruleta_cuzao));
                bichopiruletaList.add(new memes("Olha o saco", R.raw.piruleta_olhaosaco));
                bichopiruletaList.add(new memes("Tira as calça e pula", R.raw.piruleta_tiraascalca));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bichopiruletaList);
                lv.setAdapter(arrayAdapter);


                break;


            case R.id.bolsonaro:
                bolsonaroList = new ArrayList<>();

                bolsonaroList.add(new memes("Xeroque romes", R.raw.bolsonaro_xeroquehomes));
                bolsonaroList.add(new memes("To perto de você aqui agora", R.raw.bolsonaro_amigogay));
                bolsonaroList.add(new memes("Tem tudo pra ser uma gay no futuro", R.raw.bolsonaro_amizadegay));
                bolsonaroList.add(new memes("Um animal", R.raw.bolsonaro_animal));
                bolsonaroList.add(new memes("Bigodudo ou careca", R.raw.bolsonaro_bigodudooucareca));
                bolsonaroList.add(new memes("Cabo caboo", R.raw.bolsonaro_cabo));
                bolsonaroList.add(new memes("Cagando pra você", R.raw.bolsonaro_cagandopravc));
                bolsonaroList.add(new memes("Canalhas", R.raw.bolsonaro_canalhas));
                bolsonaroList.add(new memes("Canalhas mil vezes", R.raw.bolsonaro_canalhasmilvezes));
                bolsonaroList.add(new memes("Chupão na barriga dele", R.raw.bolsonaro_chupao));
                bolsonaroList.add(new memes("Que coisa de viado", R.raw.bolsonaro_coisadeviado));
                bolsonaroList.add(new memes("Consumo de droga", R.raw.bolsonaro_consumodedroga));
                bolsonaroList.add(new memes("Da que te dou outra", R.raw.bolsonaro_daquetedououtra));
                bolsonaroList.add(new memes("Detesto esse governo que ta ai", R.raw.bolsonaro_detestoessegoverno));
                bolsonaroList.add(new memes("Direitos humanos é o cacete", R.raw.bolsonaro_direitoshumanos));
                bolsonaroList.add(new memes("É um partido de pirocas coisa de viado", R.raw.bolsonaro_ecoisadeviado));
                bolsonaroList.add(new memes("Espero que nada grave aconteça", R.raw.bolsonaro_esperodadagraveaconteca));
                bolsonaroList.add(new memes("Falar fino", R.raw.bolsonaro_falarfino));
                bolsonaroList.add(new memes("Fode nois a vida toda", R.raw.bolsonaro_fodenois));
                bolsonaroList.add(new memes("Garoto adotado", R.raw.bolsonaro_garotoadotado));
                bolsonaroList.add(new memes("Jamais irei estuprar você porque você não merece", R.raw.bolsonaro_jamaisiriaestuprarvoce));
                bolsonaroList.add(new memes("João ou Pedrão", R.raw.bolsonaro_joaopedrao));
                bolsonaroList.add(new memes("Mãe bigoduda ou na mãe careca", R.raw.bolsonaro_maebigoduda));
                bolsonaroList.add(new memes("A unica coisa boa do Maranhão", R.raw.bolsonaro_maranhao));
                bolsonaroList.add(new memes("O menor vagabundo ladrão", R.raw.bolsonaro_menorvagabundo));
                bolsonaroList.add(new memes("Minha cara ou a cara do colega", R.raw.bolsonaro_minhacara));
                bolsonaroList.add(new memes("Não não não não", R.raw.bolsonaro_naonao));
                bolsonaroList.add(new memes("Não quero que ele morra não", R.raw.bolsonaro_naoqueroqueelemorra));
                bolsonaroList.add(new memes("Não sequestrar", R.raw.bolsonaro_naosequestrar));
                bolsonaroList.add(new memes("Não to de novo", R.raw.bolsonaro_naoto));
                bolsonaroList.add(new memes("Não vai votar", R.raw.bolsonaro_naovaivotar));
                bolsonaroList.add(new memes("Não vou polemizar", R.raw.bolsonaro_naovoupolemizar));
                bolsonaroList.add(new memes("Orgão excretor", R.raw.bolsonaro_orgaoexcretor));
                bolsonaroList.add(new memes("Capital do orgulho gay do mundo", R.raw.bolsonaro_orgulhogay));
                bolsonaroList.add(new memes("Que pena esse cara merece", R.raw.bolsonaro_pena));
                bolsonaroList.add(new memes("Come ele em porrada", R.raw.bolsonaro_porrada));
                bolsonaroList.add(new memes("Presidios é uma maravilha", R.raw.bolsonaro_presidios));
                bolsonaroList.add(new memes("Que porra de verdade eles querem", R.raw.bolsonaro_queporradeverdade));
                bolsonaroList.add(new memes("Vai queimar tua rosquinha", R.raw.bolsonaro_rosquinha));
                bolsonaroList.add(new memes("Na rua do bairro onde ela mora", R.raw.bolsonaro_ruaondeelamora));
                bolsonaroList.add(new memes("Se eu desse um soco nele", R.raw.bolsonaro_soco));
                bolsonaroList.add(new memes("Você vai ser sucesso na internet", R.raw.bolsonaro_sucesso));
                bolsonaroList.add(new memes("Tem que se fude e acabo", R.raw.bolsonaro_temquesefude));
                bolsonaroList.add(new memes("Tetas do governo", R.raw.bolsonaro_tetasdogoverno));
                bolsonaroList.add(new memes("Tu é Cubano", R.raw.bolsonaro_tuecubano));
                bolsonaroList.add(new memes("Vagabunda", R.raw.bolsonaro_vagabunda));
                bolsonaroList.add(new memes("Vai lá pra Cuba lá", R.raw.bolsonaro_vaipracuba));
                bolsonaroList.add(new memes("Vi os homem se beijando", R.raw.bolsonaro_viobeijo));
                bolsonaroList.add(new memes("Voto obrigatório", R.raw.bolsonaro_votoobrigatorio));
                bolsonaroList.add(new memes("Oque é isso aqui", R.raw.mariadorosario_oqueeisso));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bolsonaroList);
                lv.setAdapter(arrayAdapter);

                break;


            case R.id.bonecojosias:
                bonecojosiasList = new ArrayList<>();

                bonecojosiasList.add(new memes("Ah calaboca", R.raw.bonecojosias_ahcalaboca));
                bonecojosiasList.add(new memes("Amamente seu filho", R.raw.bonecojosias_amamente));
                bonecojosiasList.add(new memes("Calaboca", R.raw.bonecojosias_calaboca));
                bonecojosiasList.add(new memes("Carrocinha", R.raw.bonecojosias_carrocinha));
                bonecojosiasList.add(new memes("Vou comer seu coração", R.raw.bonecojosias_comercoracao));
                bonecojosiasList.add(new memes("Eu era escravo na Bolivia", R.raw.bonecojosias_escravonabolivia));
                bonecojosiasList.add(new memes("Brigadeiro de colher", R.raw.bonecojosias_ingrediente));
                bonecojosiasList.add(new memes("Marcelo é garota de programa", R.raw.bonecojosias_marcelogarota));
                bonecojosiasList.add(new memes("Ele me abandono", R.raw.bonecojosias_meabandono));
                bonecojosiasList.add(new memes("Tem medo da policia", R.raw.bonecojosias_medodapolicia));
                bonecojosiasList.add(new memes("O pênis dele na minha boca", R.raw.bonecojosias_penesnaboca));
                bonecojosiasList.add(new memes("Piada do Balanço", R.raw.bonecojosias_piadabalanco));
                bonecojosiasList.add(new memes("Você é pobre e adotado", R.raw.bonecojosias_pobreadotado));
                bonecojosiasList.add(new memes("Sai daqui", R.raw.bonecojosias_saidaqui));
                bonecojosiasList.add(new memes("Sua irmã", R.raw.bonecojosias_suairma));
                bonecojosiasList.add(new memes("Vou tacar esse prato em você", R.raw.bonecojosias_tacarprato));
                bonecojosiasList.add(new memes("Ta me devendo vinte reais", R.raw.bonecojosias_tamedevendovintereais));
                bonecojosiasList.add(new memes("Nenhum homem te quer", R.raw.bonecojosias_tequer));
                bonecojosiasList.add(new memes("Vai comer doce", R.raw.bonecojosias_vaicomerdoce));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bonecojosiasList);
                lv.setAdapter(arrayAdapter);


                break;


            case R.id.bope:
                bopeList = new ArrayList<>();

                bopeList.add(new memes("Bando de burgues safado", R.raw.bope_bandodegurguessafado));

                bopeList.add(new memes("Cada cachorro que lamba sua caceta", R.raw.bope_cadacachorro));
                bopeList.add(new memes("Calar a sua boca", R.raw.bope_capitaonascimento_calaraboca));
                bopeList.add(new memes("Não vai subir", R.raw.bope_capitaonascimento_naovaisubir));
                bopeList.add(new memes("Esquece essa merda", R.raw.bope_esqueceessamerda));
                bopeList.add(new memes("Que porra é essa marreco", R.raw.bope_queporraessamarreco));
                bopeList.add(new memes("Que satisfação Aspira", R.raw.bope_satisfacaoaspira));
                bopeList.add(new memes("Ta dando cu agora", R.raw.bope_tadandocuagora));
                bopeList.add(new memes("Já avisei que vai da merda isso", R.raw.bope_vaidamerda));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bopeList);
                lv.setAdapter(arrayAdapter);
                pedirAvaliar();

                break;


            case R.id.brksedu:
                brkseduList = new ArrayList<>();

                brkseduList.add(new memes("Bilada", R.raw.brksedu_bilada));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, brkseduList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;


            case R.id.caetanoveloso:
                caetanovelosoList = new ArrayList<>();

                caetanovelosoList.add(new memes("Como você é burro", R.raw.caetanoveloso_comovceburro));
                caetanovelosoList.add(new memes("Que coisa absurda", R.raw.caetanoveloso_quecoisaabsurda));
                caetanovelosoList.add(new memes("Você fala de uma maneira burra", R.raw.caetanoveloso_vcfaladeumamaneiraburra));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, caetanovelosoList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.celoucocachoeirra:
                celoucocachoeirraList = new ArrayList<>();

                celoucocachoeirraList.add(new memes("Cachorreira cantando", R.raw.celouco_cantando));
                celoucocachoeirraList.add(new memes("Eu não assumo esse BO", R.raw.celouco_eunassumoessebo));
                celoucocachoeirraList.add(new memes("Sou safado gosto de buceta", R.raw.celouco_sousafadaogostodebuceta));
                celoucocachoeirraList.add(new memes("Sou trabalhador, ze povim", R.raw.celouco_soutrabalhadorsouzepovin));

                celoucocachoeirraList.add(new memes("Ce é louco em cachoeira", R.raw.celoucocachoeira_cachoeira));
                celoucocachoeirraList.add(new memes("Só por Deus irmão", R.raw.celoucocachoeira_sopordeus));
                celoucocachoeirraList.add(new memes("Eu gosto de buceta", R.raw.celoucocachoeira_tarado));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, celoucocachoeirraList);
                lv.setAdapter(arrayAdapter);

                break;
            case R.id.cepodemadeira:
                cepodemadeiraList = new ArrayList<>();

                cepodemadeiraList.add(new memes("Cepo de madeira", R.raw.cepodemadeira));
                cepodemadeiraList.add(new memes("Bem duro", R.raw.cepodemadeira_bemduro));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cepodemadeiraList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.chaves:
                chavesList = new ArrayList<>();

                chavesList.add(new memes("Gentalha gentalha", R.raw.chaves_gentalhagentalha));
                chavesList.add(new memes("Kiko risada", R.raw.chaves_risada));
                chavesList.add(new memes("Ann nãoooo", R.raw.chaves_seumadrugaannao));
                chavesList.add(new memes("Ai que burro da zero pra ele", R.raw.chaves_aiqueburro));
                chavesList.add(new memes("É você satanas", R.raw.chaves_evocesatanas));
                chavesList.add(new memes("Já chegou o disco voador", R.raw.chaves_jachegouodiscovoador));
                chavesList.add(new memes("Já se foi o disco voador", R.raw.chaves_jasefoiodiscovoador));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chavesList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.chicobioca:
                chicobiocaList = new ArrayList<>();

                chicobiocaList.add(new memes("Eu quero saber quem é que transa nessa porra", R.raw.chicobioca_chicobioca));
                chicobiocaList.add(new memes("Chupa um cu e pa e sla oque lá", R.raw.chicobioca_chupaumcuepa));
                chicobiocaList.add(new memes("Comer vaginas e tudo mais", R.raw.chicobioca_comervaginas));
                chicobiocaList.add(new memes("Sexo anal", R.raw.chicobioca_sexoanal));
                chicobiocaList.add(new memes("Um tabaco bem massa", R.raw.chicobioca_umtabaco));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chicobiocaList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.cleitonchama:
                cleitonchamaList = new ArrayList<>();

                cleitonchamaList.add(new memes("Babilonia", R.raw.cleiton_babilonia));
                cleitonchamaList.add(new memes("Chama chama chama", R.raw.cleiton_chama));
                cleitonchamaList.add(new memes("Ao som do cabeça de gelo", R.raw.cleiton_rasta));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cleitonchamaList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.csgo:
                csgoList = new ArrayList<>();

                csgoList.add(new memes("Ia ou não ia", R.raw.csgo_aspx));
                csgoList.add(new memes("Eu tenho probleminha", R.raw.csgo_fallen_tenhoprobleminha));
                csgoList.add(new memes("Ja vai Boltz", R.raw.csgo_lucascsgo_javai));
                csgoList.add(new memes("Que ota vou dar ota", R.raw.csgo_lucascsgo_querota));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, csgoList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.davyjones:
                davyjonesList = new ArrayList<>();

                davyjonesList.add(new memes("Capoeira", R.raw.davajones_capoeira));
                davyjonesList.add(new memes("Chup chup chup", R.raw.davajones_chupchupchup));

                davyjonesList.add(new memes("Vamo joga um jogo", R.raw.davajones_vamojogaumjogo));
                davyjonesList.add(new memes("Adoro", R.raw.davyjones_adoro));
                davyjonesList.add(new memes("Eu gostei em", R.raw.davyjones_eugostei));
                davyjonesList.add(new memes("Jogo maneirão", R.raw.davyjones_jogomaneirao));
                davyjonesList.add(new memes("Maneiro pra caralho", R.raw.davyjones_maneirocaralho));
                davyjonesList.add(new memes("Quero fuder com os outro", R.raw.davyjones_querofuder));
                davyjonesList.add(new memes("Eu to brabo", R.raw.davyjones_tobrabo));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, davyjonesList);
                lv.setAdapter(arrayAdapter);

                break;
            case R.id.didi:
                didiList = new ArrayList<>();

                didiList.add(new memes("E morreu ", R.raw.didi_emorreu));
                didiList.add(new memes("No ceu tem pão ", R.raw.didi_noceutempao));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, didiList);
                lv.setAdapter(arrayAdapter);
                Troll();

                break;
            case R.id.dilma:
                dilmaList = new ArrayList<>();

                dilmaList.add(new memes("Criança Animal", R.raw.dilma_crianca));
                dilmaList.add(new memes("Dobramos a meta", R.raw.dilma_doblarameta));
                dilmaList.add(new memes("Eu engasguei comigo mesma", R.raw.dilma_engasguei));
                dilmaList.add(new memes("Estocar vento", R.raw.dilma_estocandovento));
                dilmaList.add(new memes("Eu podia e ele podia", R.raw.dilma_eupodia));
                dilmaList.add(new memes("Eu podia e ele podia ", R.raw.dilma_eupodiaelepodia));
                dilmaList.add(new memes("Eu vi se veja", R.raw.dilma_euviseveja));
                dilmaList.add(new memes("Happy basney", R.raw.dilma_happybasney));
                dilmaList.add(new memes("Homosapiens ", R.raw.dilma_homosapiens));
                dilmaList.add(new memes("Eu ja vi parei de ver voltei a ver", R.raw.dilma_javi));
                dilmaList.add(new memes("O meio ambiente é uma amaeaça", R.raw.dilma_meioambiente));
                dilmaList.add(new memes("Beijos", R.raw.dilma_meuqueridobeijos));
                dilmaList.add(new memes("Papeleiro vestido de papeleiro", R.raw.dilma_papeleiro));
                dilmaList.add(new memes("Porta de saida é uma porta de entrada", R.raw.dilma_portadesaida));
                dilmaList.add(new memes("Da sete", R.raw.dilma_pratreze));
                dilmaList.add(new memes("Saudando a mandioca", R.raw.dilma_saldandoamandioca));
                dilmaList.add(new memes("Saudando a mandioca Musica", R.raw.dilma_saudandoamandioca));
                dilmaList.add(new memes("A terra é curva", R.raw.dilma_terraecurva));
                dilmaList.add(new memes("Vai todo mundo perder", R.raw.dilma_vaitodomundoperder));
                dilmaList.add(new memes("Pasta de dente", R.raw.dilma_pastadedente));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dilmaList);
                lv.setAdapter(arrayAdapter);

                break;

            case R.id.djrojerinho:
                djrojerinhoList = new ArrayList<>();

                djrojerinhoList.add(new memes("Piroca de foice", R.raw.djrogerinho));
                djrojerinhoList.add(new memes("Lancei um canal", R.raw.djrogerinho_canal));
                djrojerinhoList.add(new memes("Cabeça de caramelo", R.raw.djrogerinho_caramelo));
                djrojerinhoList.add(new memes("Vou lançar um site", R.raw.djrogerinho_email));
                djrojerinhoList.add(new memes("Espiga de milho queimado", R.raw.djrogerinho_espiga));
                djrojerinhoList.add(new memes("Linguiça de feijão queimado", R.raw.djrogerinho_feijao));
                djrojerinhoList.add(new memes("Lança um site", R.raw.djrogerinho_lanca));
                djrojerinhoList.add(new memes("Cabeça igual tangerina", R.raw.djrogerinho_tangerina));
                djrojerinhoList.add(new memes("Tortão que é envergado", R.raw.djrogerinho_tortao));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, djrojerinhoList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.douglas:
                douglasList = new ArrayList<>();

                douglasList.add(new memes("Ce é feio em fi", R.raw.douglas_ceefeio));
                douglasList.add(new memes("Eu sou o Douglas", R.raw.douglas_eusoudouglas));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, douglasList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.faustao:
                faustaoList = new ArrayList<>();

                faustaoList.add(new memes("E agora pra desligar essa merda ai", R.raw.faustao_desligaressamerda));
                faustaoList.add(new memes("Errou", R.raw.faustao_errou));
                faustaoList.add(new memes("Frando de macumba", R.raw.faustao_frandodemacumba));
                faustaoList.add(new memes("Ih serjão", R.raw.faustao_iserjaosujo));
                faustaoList.add(new memes("Lave o pinto", R.raw.faustao_laveopinto));
                faustaoList.add(new memes("Meu ovo", R.raw.faustao_meuovo));
                faustaoList.add(new memes("Vai morrer", R.raw.faustao_morrer));
                faustaoList.add(new memes("Ninguem acertou", R.raw.faustao_ninguemacertou));
                faustaoList.add(new memes("Oloco meu", R.raw.faustao_olokomeu));
                faustaoList.add(new memes("Poura meu", R.raw.faustao_pourameu));
                faustaoList.add(new memes("Puta vida", R.raw.faustao_putavida));
                faustaoList.add(new memes("Ta pegando fogo bixo", R.raw.faustao_tapegandofogo));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, faustaoList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.felipesmith:
                felipesmithList = new ArrayList<>();

                felipesmithList.add(new memes("Faz isso comigo não", R.raw.felipe_fazcomigonao));
                felipesmithList.add(new memes("Guarapari Buzios é minha arte", R.raw.felipe_guarapari));
                felipesmithList.add(new memes("Sai dae doido", R.raw.felipe_saidaedoido));
                felipesmithList.add(new memes("Samu seu cu", R.raw.felipe_samu));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, felipesmithList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.filmaefala:
                filmaefalaList = new ArrayList<>();

                filmaefalaList.add(new memes("Capeta prego", R.raw.filmaefala_capeteprego));
                filmaefalaList.add(new memes("Ce filma e fala", R.raw.filmaefala_filma));
                filmaefalaList.add(new memes("Suspeito", R.raw.filmaefala_suspeito));
                filmaefalaList.add(new memes("Esse cara ta me tirando", R.raw.filmaefala_tatirando));
                filmaefalaList.add(new memes("Você é o bixão memo em doido", R.raw.filmaefala_vceobixaomemoemdoido));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filmaefalaList);
                lv.setAdapter(arrayAdapter);
                pedirAvaliar();

                break;
            case R.id.galocego:
                galocegoList = new ArrayList<>();

                galocegoList.add(new memes("Eu nunca te amo", R.raw.galocego_eununcateamo));
                galocegoList.add(new memes("Só bagunça", R.raw.galocego_sobagunca));
                galocegoList.add(new memes("Claro que não", R.raw.galocego_claroquenao));
                galocegoList.add(new memes("Comprar alimento", R.raw.galocego_compraralimento));
                galocegoList.add(new memes("é ue", R.raw.galocego_eue));
                galocegoList.add(new memes("Eu não sabia", R.raw.galocego_eunaosabia));
                galocegoList.add(new memes("Não nada ver irmão", R.raw.galocego_naondverirmao));
                galocegoList.add(new memes("Por causa de agressão de corpo", R.raw.galocego_porcausadeagressao));
                galocegoList.add(new memes("Tudo errado", R.raw.galocego_tderrado));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, galocegoList);
                lv.setAdapter(arrayAdapter);
                pedirAvaliar();

                break;
            case R.id.jailsonmendes:
                jailsonmendesList = new ArrayList<>();

                jailsonmendesList.add(new memes("Agora to afim de relaxar", R.raw.jailsonmendes_agoraeutoafimderlx));
                jailsonmendesList.add(new memes("Ai que delicia ai que gostoso", R.raw.jailsonmendes_aiquedlcaiqgostoso));
                jailsonmendesList.add(new memes("Come meu cu vai", R.raw.jailsonmendes_comemeucuvai));
                jailsonmendesList.add(new memes("Como assim nao intendi", R.raw.jailsonmendes_comoassim));
                jailsonmendesList.add(new memes("Da o cu", R.raw.jailsonmendes_daocu));
                jailsonmendesList.add(new memes("Essa peça aqui que você queria", R.raw.jailsonmendes_essapecaquevcqueria));
                jailsonmendesList.add(new memes("Eu vo da o cu", R.raw.jailsonmendes_euvodaocu));
                jailsonmendesList.add(new memes("Musica", R.raw.jailsonmendes_musica));
                jailsonmendesList.add(new memes("Poha que delicia", R.raw.jailsonmendes_pohaquedelicia));
                jailsonmendesList.add(new memes("Que delicia cara", R.raw.jailsonmendes_qdeliciacara));
                jailsonmendesList.add(new memes("Queimando uma rosquinha", R.raw.jailsonmendes_queimandoumarosquinha));
                jailsonmendesList.add(new memes("Trabalhando e relaxando", R.raw.jailsonmendes_trabalhandoerlx));
                jailsonmendesList.add(new memes("Vou deixar o oco nesse rabo", R.raw.jailsonmendes_voudeixarocoesserabo));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jailsonmendesList);
                lv.setAdapter(arrayAdapter);

                break;
            case R.id.joaodanica:
                joaodanicaList = new ArrayList<>();

                joaodanicaList.add(new memes("Gatos não", R.raw.joaodanica_gatosnao));
                joaodanicaList.add(new memes("Lionel Messenger", R.raw.joaodanica_lionelmessenger));
                joaodanicaList.add(new memes("Quero te quebrar filho", R.raw.joaodanica_querotequebrar));
                joaodanicaList.add(new memes("Sabe onde eu to", R.raw.joaodanica_sabeondeto));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, joaodanicaList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.juao:
                juaoList = new ArrayList<>();

                juaoList.add(new memes("O que foi que fiz com a minha vida Jesus", R.raw.juao_oquefizcomminhavida));
                juaoList.add(new memes("Sera que um dia eu vou vencer na vida", R.raw.juao_seraquevouvencer));
                juaoList.add(new memes("Eu sou um merda mermão", R.raw.juao_souummerda));
                juaoList.add(new memes("Vontade de chorar é inevitável", R.raw.juao_vontadedechorar));
                juaoList.add(new memes("A vontade de rir é grande mas a de chorar é maior", R.raw.juao_vontadedechorarmaior));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, juaoList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.kidbengala:
                kidbengalaList = new ArrayList<>();

                kidbengalaList.add(new memes("Meu cu voce nao vai comer", R.raw.kidbengala_meucunvcnaovaicomermeucu));
                kidbengalaList.add(new memes("Eu vo come teu cu", R.raw.kidbengala_comer));
                kidbengalaList.add(new memes("Enterrei é umas 3", R.raw.kidbengala_enterrei3));
                kidbengalaList.add(new memes("Ta arrombado cara", R.raw.kidbengala_taarrombado));
                kidbengalaList.add(new memes("Fica quieta se não te mato", R.raw.kidbengala_temato));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, kidbengalaList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.lol:
                lolList = new ArrayList<>();

                lolList.add(new memes("Eoque", R.raw.lol_eoque));
                lolList.add(new memes("Olha esse gordo", R.raw.lol_hastad_gordofdp));
                lolList.add(new memes("O que o sapo ta fazendo", R.raw.lol_hastadsapo));
                lolList.add(new memes("Fon", R.raw.lol_yoda_fon));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lolList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;

            case R.id.morrediabo:
                morrediaboList = new ArrayList<>();

                morrediaboList.add(new memes("Morre diabo", R.raw.morrediabo_morre));
                morrediaboList.add(new memes("Não interessa pra você palhaço", R.raw.morrediabo_naointeressa));
                morrediaboList.add(new memes("Eu quero que você se foda", R.raw.morrediabo_sefoda));
                morrediaboList.add(new memes("To falando não to falando", R.raw.morrediabo_tofalando));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, morrediaboList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.musica:
                musicaList = new ArrayList<>();

                musicaList.add(new memes("Cachorro chorando", R.raw.musica_cachorrochorando));
                musicaList.add(new memes("Globo rural", R.raw.globo_rural));
                musicaList.add(new memes("Mini boi", R.raw.musica_olhaominiboi));
                musicaList.add(new memes("Show da fé Funk", R.raw.musica_showdafefunk));
                musicaList.add(new memes("Veneza que se cuide", R.raw.musica_venezaquesecuide));
                musicaList.add(new memes("Arquivo X funk", R.raw.musica_arquivoxfunk));
                musicaList.add(new memes("Backyardigans", R.raw.musica_backyardigans));
                musicaList.add(new memes("Balão mágico", R.raw.musica_balaomagicofunk));
                musicaList.add(new memes("Bolsa familia", R.raw.musica_bolsafamilia));
                musicaList.add(new memes("Brincadeira tem hora", R.raw.musica_brincadeiratem_hora));
                musicaList.add(new memes("Vai ser assada", R.raw.musica_carne_vaiserassado));
                musicaList.add(new memes("Carreta Furacão", R.raw.musica_carretafuracao));
                musicaList.add(new memes("Dirigindo meu carro Funk", R.raw.musica_carro_dirigindofunk));
                musicaList.add(new memes("Caue Moura Se fudeo", R.raw.musica_cauemoura_sefudeu));
                musicaList.add(new memes("Chatuba de mesquita", R.raw.musica_chatubademesquita));
                musicaList.add(new memes("Chatuba de mesquita Ben 10", R.raw.musica_chatubademesquita_ben10));
                musicaList.add(new memes("Chaves Funk Triste", R.raw.musica_chaves_funktriste));
                musicaList.add(new memes("Cheirinho de sexo", R.raw.musica_cheirinhodesexo));
                musicaList.add(new memes("Chico Bioca", R.raw.musica_chicobioca_quem));
                musicaList.add(new memes("Chupava até o suvaco ", R.raw.musica_chupavaosuvaco));
                musicaList.add(new memes("Dedo lingua cu buceta", R.raw.musica_dedolinguacuebuceta));
                musicaList.add(new memes("Funk Deepweb", R.raw.musica_deepweb_funk));
                musicaList.add(new memes("Diffrentstrokes", R.raw.musica_diffrentstrokes));
                musicaList.add(new memes("Eu não te perguntei", R.raw.musica_eunaoteperguntei));
                musicaList.add(new memes("Flauta triste", R.raw.musica_flautatriste));
                musicaList.add(new memes("Foda-se Foda-se", R.raw.musica_fodase));
                musicaList.add(new memes("Harry Potter Funk", R.raw.musica_funk_harrypotter));
                musicaList.add(new memes("Gemidão Remix", R.raw.musica_gemidaoremix));
                musicaList.add(new memes("Goaiaba", R.raw.musica_goiaba));
                musicaList.add(new memes("Guitarra Humana", R.raw.musica_guitarrahumana));
                musicaList.add(new memes("Harry Potter", R.raw.musica_harrypotter));
                musicaList.add(new memes("Hello", R.raw.musica_hello));
                musicaList.add(new memes("Hoje vou ensinar a fazer uma bomba", R.raw.musica_hojemanual));
                musicaList.add(new memes("Homem macaco", R.raw.musica_homemmacaco));
                musicaList.add(new memes("Illuminati", R.raw.musica_illuminati));
                musicaList.add(new memes("Illuminati Funk ", R.raw.musica_illuminati_funk));
                musicaList.add(new memes("Inhegas Shooting", R.raw.musica_inhegasshooting));
                musicaList.add(new memes("Irineu Mandela", R.raw.musica_irineu_mandela));
                musicaList.add(new memes("Irineu musica", R.raw.musica_irineu_musica));
                musicaList.add(new memes("Musica Isolados", R.raw.musica_isolados));
                musicaList.add(new memes("John Cena Musica", R.raw.musica_johncena));
                musicaList.add(new memes("JooJ Musica", R.raw.musica_jooj));
                musicaList.add(new memes("Larica dos moleque", R.raw.musica_laricadosmoleque_tocomfome));
                musicaList.add(new memes("Acertou miseravi Musica", R.raw.musica_miseravel_acertou));
                musicaList.add(new memes("Moco Musica", R.raw.musica_moco));
                musicaList.add(new memes("Naruto triste", R.raw.musica_narutofunk));
                musicaList.add(new memes("Ó o gás", R.raw.musica_ohogas));
                musicaList.add(new memes("Peppa pig", R.raw.musica_peppapig_senta));
                musicaList.add(new memes("Musica Potin", R.raw.musica_potin));
                musicaList.add(new memes("Poxa Crush", R.raw.musica_poxacrush));
                musicaList.add(new memes("Proerd", R.raw.musica_proerd));
                musicaList.add(new memes("Proerd Funk", R.raw.musica_proerdfunk));
                musicaList.add(new memes("Pumpedupkicks Funk", R.raw.musica_pumpedupkicks_funk));
                musicaList.add(new memes("Musica Run", R.raw.musica_run));
                musicaList.add(new memes("Sai da frente Remix", R.raw.musica_saidafrenteremix));
                musicaList.add(new memes("Serjao Mclan", R.raw.musica_serjao_mclan));
                musicaList.add(new memes("Serjão Rabetão", R.raw.musica_serjaorabetao));
                musicaList.add(new memes("Sonim Blaine ", R.raw.musica_sonim_blaine_sinim_clevis));
                musicaList.add(new memes("Sound of silence", R.raw.musica_soundofsilence));
                musicaList.add(new memes("Sound of silence Jocelyn", R.raw.musica_soundofsilence_jocelyn));
                musicaList.add(new memes("Sound of silence Whatchasay ", R.raw.musica_soundofsilence_whatchasay));
                musicaList.add(new memes("Sua Puta", R.raw.musica_suaputa));
                musicaList.add(new memes("Suco de maracuja", R.raw.musica_sucodemaracuja_original));
                musicaList.add(new memes("Suco de maracuja Runaway ", R.raw.musica_sucodemaracuja_runaway));
                musicaList.add(new memes("Sweet Dreams", R.raw.musica_sweetdreams));
                musicaList.add(new memes("Eu tenho 2 real", R.raw.musica_tenho2real));
                musicaList.add(new memes("To be continued", R.raw.musica_tobecontinued));
                musicaList.add(new memes("Trololololo", R.raw.musica_trololo));
                musicaList.add(new memes("Vai da merda", R.raw.musica_vaidarmerda));
                musicaList.add(new memes("Vai tomar no cu Musica", R.raw.musica_vaitomarnocu));
                musicaList.add(new memes("Vamos dançar tudo nú", R.raw.musica_vamosdancartudonu));
                musicaList.add(new memes("Ta chovendo ai Aqui ta chovendo", R.raw.musica_velha_tachovendoai));
                musicaList.add(new memes("Nada nada nada nada", R.raw.musica_velhanada));
                musicaList.add(new memes("Ta ficando apertado", R.raw.musica_venomextreme_taficandoapertado));
                musicaList.add(new memes("Viado Play", R.raw.musica_viadoplay));
                musicaList.add(new memes("Winx", R.raw.musica_winx));
                musicaList.add(new memes("Xenhenhem", R.raw.musica_xenhenhem));
                musicaList.add(new memes("Dirigindo meu carro", R.raw.musica_xuxadirigindomeucarro));
                musicaList.add(new memes("Soco bate ", R.raw.musica_xuxasocobate));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, musicaList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.nandomoura:
                nandomouraList = new ArrayList<>();

                nandomouraList.add(new memes("Estou lascado", R.raw.nandomoura_estoulascado));
                nandomouraList.add(new memes("Cala boca vadia", R.raw.nadomoura_calabocavadia));
                nandomouraList.add(new memes("Viado tu és", R.raw.nandomoura_viadaotues));
                nandomouraList.add(new memes("Malakoi", R.raw.nandomoura_malakoi));
                nandomouraList.add(new memes("Mas o que é isso", R.raw.nandomoura_oqueeisso));
                nandomouraList.add(new memes("Você é zoeiro", R.raw.nandomoura_voceezoeiro));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nandomouraList);
                lv.setAdapter(arrayAdapter);
                Troll();

                break;

            case R.id.negobam:
                negobamList = new ArrayList<>();

                negobamList.add(new memes("Dacin", R.raw.negobam_dacin));
                negobamList.add(new memes("OverWatch", R.raw.negobam_overwatch));
                negobamList.add(new memes("A meno", R.raw.negobam_ameno));
                negobamList.add(new memes("Bangagozo", R.raw.negobam_bangagozo));
                negobamList.add(new memes("Champions League", R.raw.negobam_champions));
                negobamList.add(new memes("Friends", R.raw.negobam_friends));
                negobamList.add(new memes("Gozajus", R.raw.negobam_gozajus));
                negobamList.add(new memes("Gozathens", R.raw.negobam_gozathens));
                negobamList.add(new memes("Gozelynflores", R.raw.negobam_gozelynflores));
                negobamList.add(new memes("Mc Gorila", R.raw.negobam_mcgorila));
                negobamList.add(new memes("NegoBam Remix", R.raw.negobam_remix));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, negobamList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;

            case R.id.netopistola:
                netopistolaList = new ArrayList<>();

                netopistolaList.add(new memes("Da e o caramba chara", R.raw.netopistola_daeocarambachara));
                netopistolaList.add(new memes("Eu nao jogo mais", R.raw.netopistola_eunaojogomais));
                netopistolaList.add(new memes("Eu que sou culpado", R.raw.netopistola_euquesouculpado));
                netopistolaList.add(new memes("Seis nao corre", R.raw.netopistola_seisnaocorre));
                netopistolaList.add(new memes("Seus desgraçados", R.raw.netopistola_seusdesgracados));
                netopistolaList.add(new memes("Seus orreiudo", R.raw.netopistola_seusorreiudo));
                netopistolaList.add(new memes("Seus ze ruela", R.raw.netopistola_seuszeruela));
                netopistolaList.add(new memes("Sua mae", R.raw.netopistola_suamae));
                netopistolaList.add(new memes("Num vai da", R.raw.netopistola_numvaida));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, netopistolaList);
                lv.setAdapter(arrayAdapter);
                pedirAvaliar();

                break;

            case R.id.nuncanemvi:
                nuncanemviList = new ArrayList<>();

                nuncanemviList.add(new memes("Não to lembrado não", R.raw.nuncanemvi_lembradonao));
                nuncanemviList.add(new memes("Nunca nem vi", R.raw.nuncanemvi_nuncanemvi));
                nuncanemviList.add(new memes("Que dia foi isso", R.raw.nuncanemvi_quediafoiisso));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nuncanemviList);
                lv.setAdapter(arrayAdapter);
                Troll();

                break;

            case R.id.papaco:
                papacoList = new ArrayList<>();

                papacoList.add(new memes("Fala de uma vez caralho", R.raw.papaco_faladeumavezcrl));
                papacoList.add(new memes("Pooourra tudo isso", R.raw.papaco_porratdisso));
                papacoList.add(new memes("Ainda bem", R.raw.papaco_aindabem));
                papacoList.add(new memes("Bunda mole", R.raw.papaco_bundamole));
                papacoList.add(new memes("Cagão", R.raw.papaco_cagao));
                papacoList.add(new memes("Falou comigo", R.raw.papaco_faloucomigo));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, papacoList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;

            case R.id.pele:
                peleList = new ArrayList<>();

                peleList.add(new memes("Não, sou o Jo Soares sua piranha", R.raw.pele));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, peleList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;

            case R.id.pesadao:
                pesadaoList = new ArrayList<>();

                pesadaoList.add(new memes("Fala gatinha", R.raw.pesadao_gatinha));
                pesadaoList.add(new memes("Izi", R.raw.pesadao_izi));
                pesadaoList.add(new memes("Menino lobo", R.raw.pesadao_meninolobo));
                pesadaoList.add(new memes("Pesadão", R.raw.pesadao_pesadao));
                pesadaoList.add(new memes("1990", R.raw.pesadao_pesadao1990));
                pesadaoList.add(new memes("Quentinho", R.raw.pesadao_quentinho));
                pesadaoList.add(new memes("3940", R.raw.pesadao_telefone3990));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pesadaoList);
                lv.setAdapter(arrayAdapter);

                break;

            case R.id.picapau:
                picapauList = new ArrayList<>();

                picapauList.add(new memes("Vá para o inferno", R.raw.picapau_pauvaparaoinferno));
                picapauList.add(new memes("Minha nossa nossa", R.raw.picapau_minhanossanossa));
                picapauList.add(new memes("Eu não aguento", R.raw.picapau_eunaoaguento));
                picapauList.add(new memes("Vigarice", R.raw.picapau_vigarice));
                picapauList.add(new memes("Oi meu chapa", R.raw.oimeuchapa));
                picapauList.add(new memes("Fui tapeado", R.raw.picapau_fuitapeado));
                picapauList.add(new memes("Essa gente inventa cada coisa", R.raw.picapau_inventa));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, picapauList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;

            case R.id.rezende:
                rezendeList = new ArrayList<>();

                rezendeList.add(new memes("O pau furioso", R.raw.rezende_furioso));
                rezendeList.add(new memes("Levar leite de pinto para os travestis", R.raw.rezende_leite));
                rezendeList.add(new memes("Travesti gay", R.raw.rezende_travestigay));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rezendeList);
                lv.setAdapter(arrayAdapter);

                break;


            case R.id.rolezeiras:
                rolezeirasList = new ArrayList<>();

                rolezeirasList.add(new memes("Eu sou rolezeira", R.raw.rolezeiras_eusourolezeira));
                rolezeirasList.add(new memes("Mó ideia errada", R.raw.rolezeiras_ideiaerrada));
                rolezeirasList.add(new memes("Meninos muitos brutos", R.raw.rolezeiras_meninosbrutos));
                rolezeirasList.add(new memes("E ai vamo fecha", R.raw.rolezeiras_rolezeiras));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rolezeirasList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;

            case R.id.semnexo:
                semnexoList = new ArrayList<>();

                semnexoList.add(new memes("Caralho nada a ver", R.raw.semnexo_nadaaver));
                semnexoList.add(new memes("Caralho sem nexo", R.raw.semnexo_semnexo));
                semnexoList.add(new memes("Teu cu é o cabelo meu pau é o reflexo", R.raw.semnexo_teucu));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, semnexoList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.senhorpoliglota:
                senhorpoliglotaList = new ArrayList<>();

                senhorpoliglotaList.add(new memes("Camboya boa noite", R.raw.senhorpoliglota_camboya));
                senhorpoliglotaList.add(new memes("Lapaloma", R.raw.senhorpoliglota_lapaloma));
                senhorpoliglotaList.add(new memes("Niju", R.raw.senhorpoliglota_niju));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, senhorpoliglotaList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;

            case R.id.serjaobenranteiro:
                serjaobenranteiroList = new ArrayList<>();

                serjaobenranteiroList.add(new memes("Aqui tem coragem", R.raw.serjao_aquitemcoragem));
                serjaobenranteiroList.add(new memes("Autoridades do Ibama", R.raw.serjao_autoridadesdoibama));
                serjaobenranteiroList.add(new memes("Barulho da Onça", R.raw.serjao_barulhoonca));
                serjaobenranteiroList.add(new memes("Com fé no pai eterno", R.raw.serjao_comfenopaieterno));
                serjaobenranteiroList.add(new memes("E a verdade não minto", R.raw.serjao_eaverdade));
                serjaobenranteiroList.add(new memes("Matador de onça", R.raw.serjao_matadordeonca));
                serjaobenranteiroList.add(new memes("Perigoso na calça eu cagar", R.raw.serjao_nacalcacagar));
                serjaobenranteiroList.add(new memes("Pipoco come no pé do ouvido", R.raw.serjao_oncanozoologico));
                serjaobenranteiroList.add(new memes("Valeu por duas ou mais", R.raw.serjao_valeuporduasoumais));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, serjaobenranteiroList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;

            case R.id.seubuceta:
                seubucetaList = new ArrayList<>();

                seubucetaList.add(new memes("Seu buceta", R.raw.seubuceta_seubuceta));
                seubucetaList.add(new memes("É mas não vou devolver não", R.raw.seubuceta_voudevolvernao));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, seubucetaList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.sikeira:
                sikeiraList = new ArrayList<>();

                sikeiraList.add(new memes("Eae maconheiro", R.raw.sikeira_eaemaconheiro));
                sikeiraList.add(new memes("Acho que eu tinha morrido?", R.raw.sikeira_achouqueeutinhamorrido));
                sikeiraList.add(new memes("É o crime é nois", R.raw.sikerajunior_eocrimeenois));
                sikeiraList.add(new memes("Maconha doido", R.raw.sikerajunior_maconhamusica));
                sikeiraList.add(new memes("Vai morrer daqui pro natal", R.raw.sikerajunior_naopassadonatal));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sikeiraList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.silviosantos:
                silviosantosList = new ArrayList<>();

                silviosantosList.add(new memes("Calma calma sua piranha", R.raw.silvio_calmacalmasuapiranha));
                silviosantosList.add(new memes("Chorando ou fingindo", R.raw.silvio_chorandooufingindo));
                silviosantosList.add(new memes("É ta bom", R.raw.silvio_ehtabom));
                silviosantosList.add(new memes("Enfia no teu cu", R.raw.silvio_enfianoteucu));
                silviosantosList.add(new memes("Esta certo disso", R.raw.silvio_estacertodisso));
                silviosantosList.add(new memes("Maoe", R.raw.silvio_maoe));
                silviosantosList.add(new memes("Morre porra", R.raw.silvio_morreporra));
                silviosantosList.add(new memes("Não consegue né Moises", R.raw.silvio_naoconsegue));
                silviosantosList.add(new memes("Oeee", R.raw.silvio_oooee));
                silviosantosList.add(new memes("O que como", R.raw.silvio_oqcomo));
                silviosantosList.add(new memes("Parabéns você acaba de ganhar 1 milhão de reais", R.raw.silvio_parabens));
                silviosantosList.add(new memes("Patricia tira esse dedo dai", R.raw.silvio_patriciatiraessededodai));
                silviosantosList.add(new memes("Que pena você errou", R.raw.silvio_quepenavcerrou));
                silviosantosList.add(new memes("Fingindo", R.raw.silvio_racanegra_fingindo));
                silviosantosList.add(new memes("Ja entendi agora", R.raw.silvio_racanegra_jaentendi));
                silviosantosList.add(new memes("Tem que manda mata", R.raw.silvio_temquemandarmata));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, silviosantosList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;
            case R.id.legalbemlouco:
                legalbemloucoList = new ArrayList<>();

                legalbemloucoList.add(new memes("Legal bem louco", R.raw.bemlouco));
                legalbemloucoList.add(new memes("Empolgante", R.raw.bemlouco_empolgante));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, legalbemloucoList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;


            case R.id.tapita:
                tapitaList = new ArrayList<>();

                tapitaList.add(new memes("Feliz natal", R.raw.tapita));
                tapitaList.add(new memes("Camisa rosa", R.raw.tapita_camisarosa));
                tapitaList.add(new memes("Onde fica a Unimed", R.raw.tapita_unimed));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tapitaList);
                lv.setAdapter(arrayAdapter);


                break;

            case R.id.tiririrca:
                tirirircaList = new ArrayList<>();

                tirirircaList.add(new memes("Discola parasita", R.raw.tiririca_discolaparasita));
                tirirircaList.add(new memes("Abestado", R.raw.tiririca_ecelenticimoabestado));
                tirirircaList.add(new memes("Eu vou morreee", R.raw.tiririca_euvoumorreeee));
                tirirircaList.add(new memes("Fica sendo mandado por essa mulher velha", R.raw.tiririca_ficasendomandadopelamulherveia));
                tirirircaList.add(new memes("Oh menino lindo", R.raw.tiririca_oomeninolindo));
                tirirircaList.add(new memes("Peguei vocês", R.raw.tiririca_pegueivcsenganeivcs));
                tirirircaList.add(new memes("Quem é o cantor", R.raw.tiririca_quemeocantor));
                tirirircaList.add(new memes("Sou euuu", R.raw.tiririca_soueu));
                tirirircaList.add(new memes("Vamo pra balada", R.raw.tiririca_vamoprabalada));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tirirircaList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;

            case R.id.ugandanknuckles:
                ugandanknucklesList = new ArrayList<>();

                ugandanknucklesList.add(new memes("Clucking", R.raw.knuckles_clucking));
                ugandanknucklesList.add(new memes("Know the way", R.raw.knuckles_knowtheway));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ugandanknucklesList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;


            case R.id.vindiesel:
                vindieselList = new ArrayList<>();

                vindieselList.add(new memes("Can hugs", R.raw.vindiesel_canhugs));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vindieselList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;

            case R.id.vittas:
                vittasList = new ArrayList<>();

                vittasList.add(new memes("Falsete", R.raw.vittas_falsetememe));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vittasList);
                lv.setAdapter(arrayAdapter);

                break;

            case R.id.zoio:
                zoioList = new ArrayList<>();

                zoioList.add(new memes("Tira tira carai", R.raw.zoio_tiratiracaraio));
                zoioList.add(new memes("Para de rir Alesk", R.raw.zoio_paraderiralek));
                zoioList.add(new memes("Asideia", R.raw.zoio_asideia));
                zoioList.add(new memes("Hardcore", R.raw.zoio_harcore));
                zoioList.add(new memes("Eu vou pegar minha marreta", R.raw.zoio_pegominhamarreta));
                zoioList.add(new memes("Spinnis pleindi", R.raw.zoio_spinnispleindi));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, zoioList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;

            case R.id.regisjunior:
                regisjuniorList = new ArrayList<>();

                regisjuniorList.add(new memes("Meu nome é Regis Junior", R.raw.regisjunior_regisjunior));
                regisjuniorList.add(new memes("É mentira sou bem macho", R.raw.regisjunior_soubemmacho));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, regisjuniorList);
                lv.setAdapter(arrayAdapter);
                InscricaoCanal();

                break;

            case R.id.zuzu:
                zuzuList = new ArrayList<>();

                zuzuList.add(new memes("Ai que dor", R.raw.zuzu_aiquedor));
                zuzuList.add(new memes("Estou perdida", R.raw.zuzu_estouperdida));

                arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, zuzuList);
                lv.setAdapter(arrayAdapter);
                pedirAvaliar();

                break;


        }
    }*/

}