package com.dragon.ejderha;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import java.util.Random;

public class Ejderha extends ApplicationAdapter {

	SpriteBatch batch;

	Preferences prefs;

	Texture img[] = new Texture[10];
	Texture basla,state_2;
	Texture dragonArkaplan;
	Texture dragon, dragon2;
	Texture meteor1, meteor2, meteor3, meteor4;
	Texture meteorA, meteorB;
	Texture bayrak;
	Texture can;
	Texture sesOn, sesOff;
	Texture ayarIconu;
	Texture tekrarDene;
	Texture uyari;
	Texture ayarlarEkran;
	Texture seslerOn,seslerOff;
	Texture titresimOn, titresimOff;
	Texture kanatOn, kanatOff;
	Texture skor, yuksekSkor, yuksekSkorYeni;
	Texture geriSayim[] = new Texture[8];
	Texture byBekirGeris;
	Texture bilgi, bilgiler;
	Texture toast;

	float telefonunEkranininEni, telefonunEkranininBoyu;

	float ekraninMerkeziX, ekraninMerkeziY;

	float baslaEni, baslaBoyu, baslaX, baslaY;

	float uyariEni, uyariBoyu, uyariX, uyariY;

	float ayarlarEkranEni, ayarlarEkranBoyu, ayarlarEkranX, ayarlarEkranY;

	float seslerOnEni, seslerOnBoyu, seslerOnX, seslerOnY;
	float seslerOffEni, seslerOffBoyu, seslerOffX, seslerOffY;

	float titresimOnEni, titresimOnBoyu, titresimOnX, titresimOnY;
	float titresimOffEni, titresimOffBoyu, titresimOffX, titresimOffY;

	float kanatOnEni, kanatOnBoyu, kanatOnX, kanatOnY;
	float kanatOffEni, kanatOffBoyu, kanatOffX, kanatOffY;

	float sesOnX, sesOnY;

	float tekrarDeneX, tekrarDeneY, tekrarDeneEni, tekrarDeneBoyu;

	float skorX, skorY, skorEni, skorBoyu;
	float yuksekSkorX, yuksekSkorY, yuksekSkorEni, yuksekSkorBoyu;

	float byX, byY, byEni, byBoyu;

	float bilgiX, bilgiY, bilgiEni, bilgiBoyu;
	float bilgilerX, bilgilerY, bilgilerEni, bilgilerBoyu;

	float dragonX, dragonY;

	float dragonunEni, dragonunBoyu;

	float gravity = 1f;
	float ilkGravity = 0f;
	float velcity = 0.0f;

	float aralikMesafesi;

	float j;

	int state;
	int canAdeti;
	int meteorSayisi = 4;

	int kanatSüresi;
	int kanatAcik;

	int puan;
	int highScore;
	int oynamaSayisi;

	float meteorsX[] = new float[meteorSayisi];
	float meteorlarArasiMesafe;
	float meteorsY[][] = new float[4][meteorSayisi];
	float canKonumX, canKonumY;

	Circle cDragon;
	Circle c2Dragon;
	Circle cCan;
	Circle cMeteor1[] = new Circle[meteorSayisi];
	Circle cMeteor2[] = new Circle[meteorSayisi];
	Circle cMeteor3[] = new Circle[meteorSayisi];
	Circle cMeteor4[] = new Circle[meteorSayisi];

	ShapeRenderer sr;

	Boolean flag;
	Boolean flag1;

	Boolean flagSesKontrol;
	Boolean flagOyunKontrol;

	Boolean canEksiltmeFlag;
	Boolean canArttirmaFlag;

	Boolean kanatFlag;
	Boolean ayarFlag;

	Boolean flagGeriSayim;
	Boolean baslaFlag;
	Boolean flagBilgi;

	Boolean seslerBtnFlag;
	Boolean titresimBtnFlag;
	Boolean kanatBtnFlag;

	float a;
	int b;
	int iTest;

	float meteorHizi;
	float meteorHiziArtisi;
	static float sabitMeteorHizi;

	BitmapFont anaSayfaMetniStart;
	BitmapFont font;
	BitmapFont oyunBitti;

	Sound yanmaSesi;
	Sound puanSesi;
	Sound oyunaBaslamaSesi;
	Music oyunSesiMusic;


	Random y1;
	Random y2;
	Random y3;
	Random y4;
	Random canY;

	@Override
	public void create () {

		prefs = Gdx.app.getPreferences("My Preferences");

		batch = new SpriteBatch();

		img[0] = new Texture("state_1_0.png");
		img[1] = new Texture("state_1_1.png");
		img[2] = new Texture("state_1_2.png");
		img[3] = new Texture("state_1_3.png");
		img[4] = new Texture("state_1_4.png");
		img[5] = new Texture("state_1_5.png");
		img[6] = new Texture("state_1_6.png");
		img[7] = new Texture("state_1_7.png");
		img[8] = new Texture("state_1_8.png");
		img[9] = new Texture("state_1_9.png");

		basla = new Texture("basla.png");
		dragonArkaplan = new Texture("state_0.png");
		state_2 = new Texture("oyun_bitti_arka_plan.png");
		bayrak = new Texture("bayrak.png");

		uyari = new Texture("uyari.png");

		can = new Texture("can.png");

		sesOn = new Texture("ses_on.png");
		sesOff = new Texture("ses_off.png");

		ayarIconu = new Texture("ayar.png");
		ayarlarEkran = new Texture("ayarlar_cerceve.png");
		tekrarDene = new Texture("tekrar_dene.png");

		dragon = new Texture("reddragonfly1.png");
		dragon2 = new Texture("reddragonfly2.png");

		seslerOn = new Texture("sesler_on.png");
		seslerOff = new Texture("sesler_off.png");

		titresimOn = new Texture("titresim_on.png");
		titresimOff = new Texture("titresim_off.png");

		kanatOn = new Texture("kanat_on.png");
		kanatOff = new Texture("kanat_off.png");

		meteor1 = new Texture("fire_prev.png");
		meteor2 = new Texture("fire_prev.png");
		meteor3 = new Texture("fire_prev.png");
		meteor4 = new Texture("fire_prev.png");

		meteorA = new Texture("fire_prev.png");
		meteorB = new Texture("fire_prev2.png");

		skor = new Texture("skor.png");
		yuksekSkor = new Texture("yuksek_skor.png");
		yuksekSkorYeni = new Texture("yuksek_skor_yeni.png");

		geriSayim[0] = new Texture("kum_saati.png");
		geriSayim[1] = new Texture("kum_saati_0.png");
		geriSayim[2] = new Texture("kum_saati_1.png");
		geriSayim[3] = new Texture("kum_saati_2.png");
		geriSayim[4] = new Texture("kum_saati_3.png");
		geriSayim[5] = new Texture("kum_saati_4.png");
		geriSayim[6] = new Texture("kum_saati_5.png");
		geriSayim[7] = new Texture("kum_saati_6.png");

		byBekirGeris = new Texture("by_bekirgeris.png");

		bilgi = new Texture("bilgi.png");
		bilgiler = new Texture("bilgiler.png");

		toast = new Texture("toast.png");

		telefonunEkranininEni = Gdx.graphics.getWidth();
		telefonunEkranininBoyu = Gdx.graphics.getHeight();

		dragonunEni = telefonunEkranininEni / 12;
		dragonunBoyu = telefonunEkranininBoyu / 9;
		dragonX = telefonunEkranininEni / 4;
		dragonY = telefonunEkranininBoyu / 2;

		meteorlarArasiMesafe = Gdx.graphics.getWidth() / 2;

		ekraninMerkeziX = telefonunEkranininEni / 2;
		ekraninMerkeziY = telefonunEkranininBoyu / 2;

		baslaEni = telefonunEkranininEni / 5;
		baslaBoyu = telefonunEkranininBoyu / 8;
		baslaX =  telefonunEkranininEni / 2 - baslaEni / 2;
		baslaY =  baslaBoyu / 3;

		uyariEni = telefonunEkranininEni / 2;
		uyariBoyu = dragonunBoyu * 2;
		uyariX = ekraninMerkeziX - uyariEni / 2;
		uyariY = ekraninMerkeziY - dragonunEni - dragonunBoyu / 10;

		ayarlarEkranEni = telefonunEkranininEni / 3;
		ayarlarEkranBoyu = telefonunEkranininBoyu / 2;
		ayarlarEkranX = ekraninMerkeziX - ayarlarEkranEni / 2;
		ayarlarEkranY = ekraninMerkeziY - ayarlarEkranBoyu / 2;

		seslerOnEni = dragonunBoyu * 1.80f;
		seslerOnBoyu = dragonunBoyu * 0.7f;
		seslerOnX = ekraninMerkeziX - seslerOnEni / 2;
		seslerOnY = ekraninMerkeziY + dragonunBoyu / 2;

		seslerOffEni = dragonunBoyu * 1.80f;
		seslerOffBoyu = dragonunBoyu * 0.7f;
		seslerOffX = ekraninMerkeziX - seslerOffEni / 2;
		seslerOffY = ekraninMerkeziY + dragonunBoyu / 2;

		titresimOnEni = dragonunBoyu * 1.80f;
		titresimOnBoyu = dragonunBoyu * 0.7f;
		titresimOnX = ekraninMerkeziX - titresimOnEni / 2;
		titresimOnY = ekraninMerkeziY - dragonunBoyu / 3;

		titresimOffEni = dragonunBoyu * 1.80f;
		titresimOffBoyu = dragonunBoyu * 0.7f;
		titresimOffX = ekraninMerkeziX - titresimOffEni / 2;
		titresimOffY = ekraninMerkeziY - dragonunBoyu / 3;

		kanatOnEni = dragonunBoyu * 1.80f;
		kanatOnBoyu = dragonunBoyu * 0.7f;
		kanatOnX = ekraninMerkeziX - kanatOnEni / 2;
		kanatOnY = ekraninMerkeziY - dragonunBoyu - dragonunBoyu / 6;

		kanatOffEni = dragonunBoyu * 1.80f;
		kanatOffBoyu = dragonunBoyu * 0.7f;
		kanatOffX = ekraninMerkeziX - kanatOffEni / 2;
		kanatOffY = ekraninMerkeziY - dragonunBoyu - dragonunBoyu / 6;

		sesOnX = 0;
		sesOnY = telefonunEkranininBoyu - dragonunBoyu;

		tekrarDeneEni = telefonunEkranininEni / 5;
		tekrarDeneBoyu = telefonunEkranininBoyu / 8;
		tekrarDeneX = ekraninMerkeziX - tekrarDeneEni / 2;
		tekrarDeneY = tekrarDeneBoyu;

		skorEni = 2 * dragonunBoyu;
		skorBoyu = dragonunBoyu;
		skorX = telefonunEkranininEni / 7 - skorEni / 2;
		skorY = telefonunEkranininBoyu / 2;

		yuksekSkorEni = 4 * dragonunBoyu;
		yuksekSkorBoyu = dragonunBoyu;
		yuksekSkorX = telefonunEkranininEni - telefonunEkranininEni / 7 - yuksekSkorEni / 2;
		yuksekSkorY = telefonunEkranininBoyu / 2;

		byEni = 2 * dragonunBoyu;
		byBoyu = dragonunBoyu / 2;
		byX = ekraninMerkeziX - byEni / 2;
		byY = 0;

		bilgiEni = dragonunEni / 2;
		bilgiBoyu = dragonunEni / 2;
		bilgiX = telefonunEkranininEni - bilgiEni - dragonunBoyu / 10;
		bilgiY = dragonunBoyu / 10;

		bilgilerEni = telefonunEkranininEni / 2;
		bilgilerBoyu = telefonunEkranininEni / 3;
		bilgilerX = ekraninMerkeziX - bilgilerEni / 2;
		bilgilerY = ekraninMerkeziY - bilgilerBoyu / 2;

		cDragon = new Circle();
		c2Dragon = new Circle();
		cCan = new Circle();
		cMeteor1 = new Circle[meteorSayisi];
		cMeteor2 = new Circle[meteorSayisi];
		cMeteor3 = new Circle[meteorSayisi];
		cMeteor4 = new Circle[meteorSayisi];

		sr = new ShapeRenderer();

		j = 0;

		state = 0;
		aralikMesafesi = 3f * dragonunBoyu;

		kanatSüresi = 7;
		kanatAcik = 0;

		puan = 0;
		highScore = 0;
		oynamaSayisi = 0;

		a = 80;
		iTest = 0;

		meteorHizi = 10;
		meteorHiziArtisi = 0.8f;
		sabitMeteorHizi = meteorHizi;

		canAdeti = 1;
		canKonumX = 0f;

		font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.getData().setScale(dragonunBoyu / 20);

		anaSayfaMetniStart = new BitmapFont();
		anaSayfaMetniStart.setColor(Color.WHITE);
		anaSayfaMetniStart.getData().setScale(3);

		yanmaSesi = Gdx.audio.newSound(Gdx.files.internal("ghost.ogg"));
		puanSesi = Gdx.audio.newSound(Gdx.files.internal("game_m.ogg"));
		oyunaBaslamaSesi = Gdx.audio.newSound(Gdx.files.internal("ghost.ogg"));
		oyunSesiMusic = Gdx.audio.newMusic(Gdx.files.internal("oyunsesi.ogg"));

		oyunBitti = new BitmapFont();
		oyunBitti.setColor(Color.WHITE);
		oyunBitti.getData().setScale(dragonunBoyu / 20);

		flag = true;
		flag1 = true;

		flagSesKontrol = false;
		flagOyunKontrol = true;

		canEksiltmeFlag = true;
		canArttirmaFlag = true;

		kanatFlag = true;
		ayarFlag = true;

		flagGeriSayim = true;
		baslaFlag = true;
		flagBilgi = true;

		seslerBtnFlag = false;
		titresimBtnFlag = false;
		kanatBtnFlag = false;

		y1 = new Random();
		y2 = new Random();
		y3 = new Random();
		y4 = new Random();
		canY = new Random();

		for (int i = 0; i < 1; i++) {

			canY = new Random();
			canKonumX += Gdx.graphics.getWidth() * 16 / 3;
			canKonumY = canY.nextFloat() * Gdx.graphics.getHeight() * 8 / 10 + dragonunBoyu;
			cCan = new Circle();

		}

		for (int i = 0;i < meteorSayisi;i++) {

			meteorsX[i] = Gdx.graphics.getWidth() + i * meteorlarArasiMesafe;

			do {
				y1 = new Random();
				y2 = new Random();
				y3 = new Random();
				y4 = new Random();
				meteorsY[0][i] = y1.nextFloat() * Gdx.graphics.getHeight() / 4 - dragonunBoyu;
				meteorsY[1][i] = y2.nextFloat() * Gdx.graphics.getHeight() / 4 + Gdx.graphics.getHeight() / 4 - dragonunBoyu;
				meteorsY[2][i] = y3.nextFloat() * Gdx.graphics.getHeight() / 4 + 2 * Gdx.graphics.getHeight() / 4 - dragonunBoyu;
				meteorsY[3][i] = y4.nextFloat() * Gdx.graphics.getHeight() / 4 + 3 * Gdx.graphics.getHeight() / 4 - dragonunBoyu;
				cMeteor1[i] = new Circle();
				cMeteor2[i] = new Circle();
				cMeteor3[i] = new Circle();
				cMeteor4[i] = new Circle();
			}while (!(telefonunEkranininBoyu - meteorsY[3][i] >= aralikMesafesi
					|| meteorsY[0][i] >= aralikMesafesi
					|| meteorsY[3][i] - meteorsY[2][i] >= aralikMesafesi
					|| meteorsY[2][i] - meteorsY[1][i] >= aralikMesafesi
					|| meteorsY[1][i] - meteorsY[0][i] >= aralikMesafesi));

		}
	}

	@Override
	public void render () {

		flagSesKontrol = prefs.getBoolean("flagseskontrol");
		seslerBtnFlag = prefs.getBoolean("seslerBtnFlag");
		titresimBtnFlag = prefs.getBoolean("titresimBtnFlag");
		kanatBtnFlag = prefs.getBoolean("kanatBtnFlag");

		if (!flagSesKontrol) {
			oyunSesiMusic.play();
		}else {
			oyunSesiMusic.pause();
		}

		batch.begin();

		//------------------------------------------STATE = 0-----------------------------------------
		if (state == 0) {

			highScore = prefs.getInteger("highscore");
			oynamaSayisi = prefs.getInteger("oynama_sayisi");

			batch.draw(seslerOn, 0, 0, seslerOnEni, seslerOnBoyu);

			puan = 0;
			canAdeti = 1;
			j = 0;

			dragonY = telefonunEkranininBoyu / 2;
			velcity = 0;

			batch.draw(dragonArkaplan, 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);
			batch.draw(bayrak, telefonunEkranininEni - 1.2f * dragonunBoyu, telefonunEkranininBoyu - 1.2f * dragonunBoyu, telefonunEkranininEni / 20, telefonunEkranininBoyu / 10);

			batch.draw(basla, baslaX, baslaY, baslaEni, baslaBoyu);
			batch.draw(byBekirGeris, byX, byY, byEni, byBoyu);
			batch.draw(bilgi, bilgiX, bilgiY, bilgiEni, bilgiBoyu);

			anaSayfaMetniStart.draw(batch, "Highscore: " + String.valueOf(highScore), dragonunBoyu / 3, dragonunBoyu * 2);
			anaSayfaMetniStart.draw(batch,"Oynanan Oyunlar: " + String.valueOf(oynamaSayisi), dragonunBoyu / 3, dragonunEni);

			//bilgi kontrol++++++++bilgi kontrol++++++++bilgi kontrol++++++++bilgi kontrol++++++++bilgi kontrol++++++++bilgi kontrol++++++++bilgi kontrol++++++++
			if (flagBilgi) {

				if (Gdx.input.justTouched()) {

					if (bilgiX < Gdx.input.getX() && Gdx.input.getX() < bilgiX + bilgiEni
							&& telefonunEkranininBoyu - bilgiY - bilgiBoyu < Gdx.input.getY() && Gdx.input.getY() < telefonunEkranininBoyu - bilgiY) {

						flagBilgi = false;

					}

				}

			}else {

				batch.draw(bilgiler, bilgilerX, bilgilerY, bilgilerEni, bilgilerBoyu);

				if (Gdx.input.justTouched()) {

					if (!(bilgilerX < Gdx.input.getX() && Gdx.input.getX() < bilgilerX + bilgilerEni
							&& telefonunEkranininBoyu - bilgilerY - bilgilerBoyu < Gdx.input.getY() && Gdx.input.getY() < telefonunEkranininBoyu - bilgilerY)) {

						flagBilgi = true;

					}

				}
			}
			//bilgi kontrol++++++++bilgi kontrol++++++++bilgi kontrol++++++++bilgi kontrol++++++++bilgi kontrol++++++++bilgi kontrol++++++++bilgi kontrol++++++++

			//muzik_kontrol+++++++muzik_kontrol+++++++muzik_kontrol+++++++muzik_kontrol+++++++muzik_kontrol+++++++muzik_kontrol+++++++
			if (!flagSesKontrol) {

				batch.draw(sesOn, sesOnX, sesOnY, dragonunEni * 0.8f, dragonunBoyu * 0.8f);

				if (Gdx.input.justTouched()) {

					if (0 < Gdx.input.getX() && Gdx.input.getX() < dragonunEni
							&& 0 < Gdx.input.getY() && Gdx.input.getY() < dragonunBoyu) {

						flagSesKontrol = true;
						prefs.putBoolean("flagseskontrol", flagSesKontrol);
						prefs.flush();;

					}

				}

			}else {
				batch.draw(sesOff, sesOnX, sesOnY, dragonunEni * 0.8f, dragonunBoyu * 0.8f);

				if (Gdx.input.justTouched()) {

					if (0 < Gdx.input.getX() && Gdx.input.getX() < dragonunEni
							&& 0 < Gdx.input.getY() && Gdx.input.getY() < dragonunBoyu) {

						flagSesKontrol = false;
						prefs.putBoolean("flagseskontrol", flagSesKontrol);
						prefs.flush();;

					}

				}
			}
			//muzik_kontrol+++++++muzik_kontrol+++++++muzik_kontrol+++++++muzik_kontrol+++++++muzik_kontrol+++++++muzik_kontrol+++++++

			if (ayarFlag) {
				batch.draw(ayarIconu, 10, 10, dragonunEni / 2, dragonunEni / 2);

				if (Gdx.input.justTouched()) {

					if (0 < Gdx.input.getX() && Gdx.input.getX() < dragonunEni
							&& telefonunEkranininBoyu - dragonunBoyu < Gdx.input.getY() && Gdx.input.getY() < telefonunEkranininBoyu) {

						ayarFlag = false;

					}

				}

			}else {
				batch.draw(ayarIconu, 10, 10, dragonunEni / 2, dragonunEni / 2);
				batch.draw(ayarlarEkran, ayarlarEkranX, ayarlarEkranY, ayarlarEkranEni, ayarlarEkranBoyu);

				//seslerKontrol----seslerKontrol----seslerKontrol-----seslerKontrol-----seslerKontrol
				if (!seslerBtnFlag) {

					batch.draw(seslerOn, seslerOnX, seslerOnY, seslerOnEni, seslerOnBoyu);

					if (Gdx.input.justTouched()) {

						if (seslerOnX < Gdx.input.getX() && Gdx.input.getX() < seslerOnX + seslerOnEni
								&& telefonunEkranininBoyu - seslerOnY - seslerOnBoyu < Gdx.input.getY() && Gdx.input.getY() < telefonunEkranininBoyu - seslerOnY) {

							seslerBtnFlag = true;
							prefs.putBoolean("seslerBtnFlag", seslerBtnFlag);
							prefs.flush();;

						}

					}

				}else {
					batch.draw(seslerOff, seslerOffX, seslerOffY, seslerOffEni, seslerOffBoyu);

					if (Gdx.input.justTouched()) {

						if (seslerOnX < Gdx.input.getX() && Gdx.input.getX() < seslerOnX + seslerOnEni
								&& telefonunEkranininBoyu - seslerOnY - seslerOnBoyu < Gdx.input.getY() && Gdx.input.getY() < telefonunEkranininBoyu - seslerOnY) {

							seslerBtnFlag = false;
							prefs.putBoolean("seslerBtnFlag", seslerBtnFlag);
							prefs.flush();;

						}

					}
				}
				//seslerKontrol----seslerKontrol----seslerKontrol-----seslerKontrol-----seslerKontrol

				//titresimKontrol----titresimKontrol----titresimKontrol-----titresimKontrol-----titresimKontrol
				if (!titresimBtnFlag) {

					batch.draw(titresimOn, titresimOnX, titresimOnY, titresimOnEni, titresimOnBoyu);

					if (Gdx.input.justTouched()) {

						if (titresimOnX < Gdx.input.getX() && Gdx.input.getX() < titresimOnX + titresimOnEni
								&& telefonunEkranininBoyu - titresimOnY - titresimOnBoyu < Gdx.input.getY() && Gdx.input.getY() < telefonunEkranininBoyu - titresimOnY) {

							titresimBtnFlag = true;
							prefs.putBoolean("titresimBtnFlag", titresimBtnFlag);
							prefs.flush();;

						}

					}

				}else {
					batch.draw(titresimOff, titresimOffX, titresimOffY, titresimOffEni, titresimOffBoyu);

					if (Gdx.input.justTouched()) {

						if (titresimOnX < Gdx.input.getX() && Gdx.input.getX() < titresimOnX + titresimOnEni
								&& telefonunEkranininBoyu - titresimOnY - titresimOnBoyu < Gdx.input.getY() && Gdx.input.getY() < telefonunEkranininBoyu - titresimOnY) {

							titresimBtnFlag = false;
							prefs.putBoolean("titresimBtnFlag", titresimBtnFlag);
							prefs.flush();;

						}

					}
				}
				//titresimKontrol----titresimKontrol----titresimKontrol-----titresimKontrol-----titresimKontrol

				//kanatKontrol------kanatKontrol------kanatKontrol------kanatKontrol------kanatKontrol-----kanatKontrol
				if (!kanatBtnFlag) {

					batch.draw(kanatOn, kanatOnX, kanatOnY, kanatOnEni, kanatOnBoyu);

					if (Gdx.input.justTouched()) {

						if (kanatOnX < Gdx.input.getX() && Gdx.input.getX() < kanatOnX + kanatOnEni
								&& telefonunEkranininBoyu - kanatOnY - kanatOnBoyu < Gdx.input.getY() && Gdx.input.getY() < telefonunEkranininBoyu - kanatOnY) {

							kanatBtnFlag = true;
							prefs.putBoolean("kanatBtnFlag", kanatBtnFlag);
							prefs.flush();;

						}

					}

				}else {
					batch.draw(kanatOff, kanatOffX, kanatOffY, kanatOffEni, kanatOffBoyu);

					if (Gdx.input.justTouched()) {

						if (kanatOnX < Gdx.input.getX() && Gdx.input.getX() < kanatOnX + kanatOnEni
								&& telefonunEkranininBoyu - kanatOnY - kanatOnBoyu < Gdx.input.getY() && Gdx.input.getY() < telefonunEkranininBoyu - kanatOnY) {

							kanatBtnFlag = false;
							prefs.putBoolean("kanatBtnFlag", kanatBtnFlag);
							prefs.flush();;

						}

					}
				}
				//kanatKontrol------kanatKontrol------kanatKontrol------kanatKontrol------kanatKontrol-----kanatKontrol

				if (Gdx.input.justTouched()) {

					if (!(ayarlarEkranX < Gdx.input.getX() && Gdx.input.getX() < ayarlarEkranX + ayarlarEkranEni
							&& ekraninMerkeziY - ayarlarEkranBoyu / 2 < Gdx.input.getY() && Gdx.input.getY() < ekraninMerkeziY + ayarlarEkranBoyu / 2)) {

						ayarFlag = true;

					}

				}
			}

			if (Gdx.input.justTouched()) {

				if (telefonunEkranininEni / 2 - baslaEni / 2 < Gdx.input.getX() && Gdx.input.getX() < telefonunEkranininEni / 2 + baslaEni / 2
						&& telefonunEkranininBoyu - baslaY - baslaBoyu < Gdx.input.getY() && Gdx.input.getY() < telefonunEkranininBoyu - baslaY) {

					state = 1;
					oynamaSayisi++;

				}
			}

			if (Gdx.input.justTouched()) {

				if (telefonunEkranininEni - dragonunEni< Gdx.input.getX() && Gdx.input.getX() < telefonunEkranininEni
						&& 0 < Gdx.input.getY() && Gdx.input.getY() < dragonunEni) {

					b = 40;

				}
			}

			if (b > 0) {
				batch.draw(toast, ekraninMerkeziX - dragonunEni * 3, ekraninMerkeziY - telefonunEkranininBoyu / 3, telefonunEkranininEni / 2, dragonunEni / 2);
				b--;
			}

			ilkGravity = 0f;
		}

		//------------------------------------------STATE = 1-----------------------------------------
		if (state == 1) {

			if (j > 10000) {

				if (baslaFlag) {

					batch.draw(img[0], 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);

					a = a - 0.65f;
					batch.draw(geriSayim[(int)(a / 10)], ekraninMerkeziX - dragonunBoyu / 2, ekraninMerkeziY, dragonunBoyu, dragonunEni - dragonunBoyu / 2);
					batch.draw(uyari, uyariX, uyariY, uyariEni, uyariBoyu);

					if (a < 0) {
						a = 80;
						baslaFlag = false;
					}

				}else {

					if (puan < 10) {
						font.setColor(Color.BLACK);
						batch.draw(img[0], 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);
					}else {
						if (puan < 20) {
							font.setColor(Color.WHITE);
							batch.draw(img[1], 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);
						}else {
							if (puan < 30) {
								font.setColor(Color.BLACK);
								batch.draw(img[2], 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);
							}else {
								if (puan < 40) {
									font.setColor(Color.WHITE);
									batch.draw(img[3], 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);
								}else {
									if (puan < 50) {
										font.setColor(Color.BLACK);
										batch.draw(img[4], 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);
									}else {
										if (puan < 60) {
											font.setColor(Color.WHITE);
											batch.draw(img[5], 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);
										}else {
											if (puan < 70) {
												font.setColor(Color.WHITE);
												batch.draw(img[6], 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);
											}else {
												if (puan < 80) {
													font.setColor(Color.BLACK);
													batch.draw(img[7], 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);
												}else {
													if (puan < 90) {
														font.setColor(Color.BLACK);
														batch.draw(img[8], 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);
													}else {
														font.setColor(Color.WHITE);
														batch.draw(img[9], 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);
													}
												}
											}
										}
									}
								}
							}
						}
					}

					if (puan <= 100) {
						meteorHizi = sabitMeteorHizi + (puan / 10) * meteorHiziArtisi;
					}

					kanatAcik++;

					if (kanatFlag && !kanatBtnFlag) {
						batch.draw(dragon2, dragonX, dragonY, dragonunEni, dragonunBoyu);
					}else {
						batch.draw(dragon, dragonX, dragonY, dragonunEni, dragonunBoyu);
					}

					if (kanatAcik % kanatSüresi == 0) {
						kanatFlag = !kanatFlag;
						kanatAcik = 0;
					}

					flag1 = true;

					if (Gdx.input.justTouched()) {

						velcity = -15;
						ilkGravity = gravity;

					}

					for (int i = 0;i < meteorSayisi; i++) {

						if (meteorsX[i] < 10) {

							meteorsX[i] += meteorSayisi * meteorlarArasiMesafe;

							do {
								y1 = new Random();
								y2 = new Random();
								y3 = new Random();
								y4 = new Random();
								meteorsY[0][i] = y1.nextFloat() * Gdx.graphics.getHeight() / 4 - dragonunBoyu;
								meteorsY[1][i] = y2.nextFloat() * Gdx.graphics.getHeight() / 4 + Gdx.graphics.getHeight() / 4 - dragonunBoyu;
								meteorsY[2][i] = y3.nextFloat() * Gdx.graphics.getHeight() / 4 + 2 * Gdx.graphics.getHeight() / 4 - dragonunBoyu;
								meteorsY[3][i] = y4.nextFloat() * Gdx.graphics.getHeight() / 4 + 3 * Gdx.graphics.getHeight() / 4 - dragonunBoyu;
								cMeteor1[i] = new Circle();
								cMeteor2[i] = new Circle();
								cMeteor3[i] = new Circle();
								cMeteor4[i] = new Circle();
							}while (!(telefonunEkranininBoyu - meteorsY[3][i] >= aralikMesafesi
									|| meteorsY[0][i] >= aralikMesafesi
									|| meteorsY[3][i] - meteorsY[2][i] >= aralikMesafesi
									|| meteorsY[2][i] - meteorsY[1][i] >= aralikMesafesi
									|| meteorsY[1][i] - meteorsY[0][i] >= aralikMesafesi));

						}

						if (dragonX > meteorsX[i] + dragonunEni / 2 && flag) {

							puan++;
							if (!seslerBtnFlag) {
								puanSesi.play();
							}
							flag = false;

						}

						font.draw(batch, String.valueOf(puan), ekraninMerkeziX - 100, telefonunEkranininBoyu - 20);

						if (meteorsX[i] < 10 + meteorHizi) {

							flag = true;

						}

						meteorsX[i] -= meteorHizi;

						batch.draw(meteor1, meteorsX[i], meteorsY[0][i], 2 * dragonunEni, 2 * dragonunBoyu);
						batch.draw(meteor2, meteorsX[i], meteorsY[1][i] , 2 * dragonunEni, 2 * dragonunBoyu);
						batch.draw(meteor3, meteorsX[i], meteorsY[2][i], 2 * dragonunEni, 2 * dragonunBoyu);
						batch.draw(meteor4, meteorsX[i], meteorsY[3][i], 2 * dragonunEni, 2 * dragonunBoyu);

						if (Intersector.overlaps(cDragon, cMeteor1[i])
								|| Intersector.overlaps(cDragon, cMeteor2[i])
								|| Intersector.overlaps(cDragon, cMeteor3[i])
								|| Intersector.overlaps(cDragon, cMeteor4[i])
								|| Intersector.overlaps(c2Dragon, cMeteor1[i])
								|| Intersector.overlaps(c2Dragon, cMeteor2[i])
								|| Intersector.overlaps(c2Dragon, cMeteor3[i])
								|| Intersector.overlaps(c2Dragon, cMeteor4[i])) {

							if (canEksiltmeFlag) {

								canAdeti--;
								if (!titresimBtnFlag) {
									Gdx.input.vibrate(500);
								}
								canEksiltmeFlag = false;
								iTest = i;

							}
							if (canAdeti == 0) {

								state = 2;

							}
						}else {
							if (!(Intersector.overlaps(cDragon, cMeteor1[iTest])
									|| Intersector.overlaps(cDragon, cMeteor2[iTest])
									|| Intersector.overlaps(cDragon, cMeteor3[iTest])
									|| Intersector.overlaps(cDragon, cMeteor4[iTest])
									|| Intersector.overlaps(c2Dragon, cMeteor1[iTest])
									|| Intersector.overlaps(c2Dragon, cMeteor2[iTest])
									|| Intersector.overlaps(c2Dragon, cMeteor3[iTest])
									|| Intersector.overlaps(c2Dragon, cMeteor4[iTest]))) {

								canEksiltmeFlag = true;

							}
						}

					}

					for(int i = 0; i < 1; i++) {

						if (canKonumX < 5) {

							canKonumX += Gdx.graphics.getWidth() * 16 / 3;

							canY = new Random();
							canKonumY = canY.nextFloat() * Gdx.graphics.getHeight() * 8 / 10 + dragonunBoyu;
							cCan = new Circle();

						}

						canKonumX -= meteorHizi;

						batch.draw(can, canKonumX, canKonumY, telefonunEkranininEni / 10, telefonunEkranininBoyu / 5);
					}

					if (Intersector.overlaps(cDragon, cCan)) {

						canAdeti++;
						if (!titresimBtnFlag) {
							Gdx.input.vibrate(500);
						}
						canKonumY = 10000f;

					}

					if (canAdeti == 1) {

						batch.draw(can, telefonunEkranininEni - 100, telefonunEkranininBoyu - 80, dragonunEni / 3 + 20, dragonunBoyu / 2 + 20);

					}else {

						if (canAdeti == 2) {

							batch.draw(can, telefonunEkranininEni - 100, telefonunEkranininBoyu - 80, dragonunEni / 3 + 20, dragonunBoyu / 2 + 20);
							batch.draw(can, telefonunEkranininEni - 150, telefonunEkranininBoyu - 80, dragonunEni / 3 + 20, dragonunBoyu / 2 + 20);

						}else {

							batch.draw(can, telefonunEkranininEni - 100, telefonunEkranininBoyu - 80, dragonunEni / 3 + 20, dragonunBoyu / 2 + 20);
							batch.draw(can, telefonunEkranininEni - 150, telefonunEkranininBoyu - 80, dragonunEni / 3 + 20, dragonunBoyu / 2 + 20);
							batch.draw(can, telefonunEkranininEni - 200, telefonunEkranininBoyu - 80, dragonunEni / 3 + 20, dragonunBoyu / 2 + 20);
							canAdeti = 3;

						}
					}

					if (dragonY + dragonunBoyu / 2 < 0 || dragonY > telefonunEkranininBoyu - dragonunBoyu / 2) {

						state = 2;
						if (!titresimBtnFlag) {
							Gdx.input.vibrate(500);
						}

					}else {

						velcity = velcity + ilkGravity;
						dragonY = dragonY - velcity;

					}
				}

			}else {

				batch.draw(dragonArkaplan, 0 - j / 2, 0 - j / 3, telefonunEkranininEni + j, telefonunEkranininBoyu + j / 1.2f);
				j = j + 500f ;

			}

		}

		//------------------------------------------STATE = 2-----------------------------------------
		if (state == 2) {

			batch.draw(state_2, 0, 0, telefonunEkranininEni, telefonunEkranininBoyu);

			batch.draw(skor, skorX, skorY, skorEni, skorBoyu);

			oyunBitti.draw(batch, String.valueOf(puan), skorX + skorEni / 2 - (int)(dragonunEni / 8) * String.valueOf(puan).length(), skorY - (int)(dragonunEni / 10));
			oyunBitti.draw(batch, String.valueOf(highScore), yuksekSkorX + yuksekSkorEni / 2 - (int)(dragonunEni / 8) * String.valueOf(highScore).length(), yuksekSkorY - (int)(dragonunEni / 10));

			batch.draw(tekrarDene, tekrarDeneX, tekrarDeneY, tekrarDeneEni, tekrarDeneBoyu);

			if (puan >= highScore) {
				prefs.putInteger("highscore", puan);
				highScore = prefs.getInteger("highscore");
				batch.draw(yuksekSkorYeni, yuksekSkorX, yuksekSkorY, yuksekSkorEni, yuksekSkorBoyu);
			}else {
				batch.draw(yuksekSkor, yuksekSkorX, yuksekSkorY, yuksekSkorEni, yuksekSkorBoyu);
			}
			prefs.putInteger("oynama_sayisi", oynamaSayisi);

			if (flag1) {

				if (!seslerBtnFlag) {
					yanmaSesi.play();
				}
				flag1 = false;

			}

			for (int i = 0; i < 1; i++) {

				canY = new Random();
				canKonumX  = (float)Gdx.graphics.getWidth() * 16 / 3;
				canKonumY = canY.nextFloat() * Gdx.graphics.getHeight() * 8 / 10 + dragonunBoyu;
				cCan = new Circle();

			}

			for (int i = 0;i < meteorSayisi;i++) {

				meteorsX[i] = Gdx.graphics.getWidth() + i * meteorlarArasiMesafe;
				do {
					y1 = new Random();
					y2 = new Random();
					y3 = new Random();
					y4 = new Random();
					meteorsY[0][i] = y1.nextFloat() * Gdx.graphics.getHeight() / 4 - dragonunBoyu;
					meteorsY[1][i] = y2.nextFloat() * Gdx.graphics.getHeight() / 4 + Gdx.graphics.getHeight() / 4 - dragonunBoyu;
					meteorsY[2][i] = y3.nextFloat() * Gdx.graphics.getHeight() / 4 + 2 * Gdx.graphics.getHeight() / 4 - dragonunBoyu;
					meteorsY[3][i] = y4.nextFloat() * Gdx.graphics.getHeight() / 4 + 3 * Gdx.graphics.getHeight() / 4 - dragonunBoyu;
					cMeteor1[i] = new Circle();
					cMeteor2[i] = new Circle();
					cMeteor3[i] = new Circle();
					cMeteor4[i] = new Circle();
				}while (!(telefonunEkranininBoyu - meteorsY[3][i] >= aralikMesafesi
						|| meteorsY[0][i] >= aralikMesafesi
						|| meteorsY[3][i] - meteorsY[2][i] >= aralikMesafesi
						|| meteorsY[2][i] - meteorsY[1][i] >= aralikMesafesi
						|| meteorsY[1][i] - meteorsY[0][i] >= aralikMesafesi));

			}

			if (Gdx.input.justTouched()) {

				if (tekrarDeneX < Gdx.input.getX() && Gdx.input.getX() < tekrarDeneX + tekrarDeneEni
						&& telefonunEkranininBoyu - tekrarDeneY - tekrarDeneBoyu < Gdx.input.getY() && Gdx.input.getY() < telefonunEkranininBoyu - tekrarDeneY) {

					state = 0;

				}

			}

			flag = true;
			flagGeriSayim = true;
			baslaFlag = true;

			prefs.flush();
		}



		cDragon.set(dragonX + dragonunEni / 2, dragonY + dragonunBoyu / 2, dragonunBoyu / 2);
		c2Dragon.set(dragonX, dragonY + dragonunBoyu / 2, dragonunBoyu / 3);
		cCan.set(canKonumX + dragonunBoyu, canKonumY + dragonunBoyu, dragonunBoyu / 2);

		//sr.begin(ShapeRenderer.ShapeType.Filled);

		//sr.setColor(Color.BLUE);
		//sr.circle(dragonX + dragonunEni / 2, dragonY + dragonunBoyu / 2, dragonunBoyu / 2);
		//sr.circle(dragonX, dragonY + dragonunBoyu / 2, dragonunBoyu / 3);
		//sr.circle(canKonumX + dragonunBoyu, canKonumY + dragonunBoyu, dragonunBoyu / 2);

		for (int i = 0; i < meteorSayisi; i++){

			cMeteor1[i].set(meteorsX[i] + dragonunEni / 2, meteorsY[0][i] + dragonunBoyu, dragonunBoyu * 0.45f);
			cMeteor2[i].set(meteorsX[i] + dragonunEni / 2, meteorsY[1][i] + dragonunBoyu, dragonunBoyu * 0.45f);
			cMeteor3[i].set(meteorsX[i] + dragonunEni / 2, meteorsY[2][i] + dragonunBoyu, dragonunBoyu * 0.45f);
			cMeteor4[i].set(meteorsX[i] + dragonunEni / 2, meteorsY[3][i] + dragonunBoyu, dragonunBoyu * 0.45f);

			//sr.circle(meteorsX[i] + dragonunEni / 2, meteorsY[0][i] + dragonunBoyu, dragonunBoyu * 0.55f);
			//sr.circle(meteorsX[i] + dragonunEni / 2, meteorsY[1][i] + dragonunBoyu, dragonunBoyu * 0.55f);
			//sr.circle(meteorsX[i] + dragonunEni / 2, meteorsY[2][i] + dragonunBoyu, dragonunBoyu * 0.55f);
			//sr.circle(meteorsX[i] + dragonunEni / 2, meteorsY[3][i] + dragonunBoyu, dragonunBoyu * 0.55f);

		}
		//sr.end();
		batch.end();
	}
}
