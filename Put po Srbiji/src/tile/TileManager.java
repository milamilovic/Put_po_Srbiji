package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

	GamePanel gamePanel;
	Tile[] tiles;
	int mapTileNum[][];
	
	public TileManager(GamePanel gamePanel) {
		
		this.gamePanel = gamePanel;
		tiles = new Tile[1000];
		
		mapTileNum = new int[gamePanel.columns][gamePanel.rows];
		
		this.getTileImages();
		this.loadMap();
	}
	
	public void getTileImages() {
		
		try {
			
			tiles[0] = new Tile();
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(01).png"));
			tiles[1] = new Tile();
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(02).png"));
			tiles[2] = new Tile();
			tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(03).png"));
			tiles[3] = new Tile();
			tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(04).png"));
			tiles[4] = new Tile();
			tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(05).png"));
			tiles[5] = new Tile();
			tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(06).png"));
			tiles[6] = new Tile();
			tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(07).png"));
			tiles[7] = new Tile();
			tiles[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(08).png"));
			tiles[8] = new Tile();
			tiles[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(09).png"));
			tiles[9] = new Tile();
			tiles[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(10).png"));
			tiles[10] = new Tile();
			tiles[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(11).png"));
			tiles[11] = new Tile();
			tiles[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(12).png"));
			tiles[12] = new Tile();
			tiles[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(13).png"));
			tiles[13] = new Tile();
			tiles[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(14).png"));
			tiles[14] = new Tile();
			tiles[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(15).png"));
			tiles[15] = new Tile();
			tiles[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(16).png"));
			tiles[16] = new Tile();
			tiles[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(17).png"));
			tiles[17] = new Tile();
			tiles[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(18).png"));
			tiles[18] = new Tile();
			tiles[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(19).png"));
			tiles[19] = new Tile();
			tiles[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(20).png"));
			tiles[20] = new Tile();
			tiles[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(21).png"));
			tiles[21] = new Tile();
			tiles[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(22).png"));
			tiles[22] = new Tile();
			tiles[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(23).png"));
			tiles[23] = new Tile();
			tiles[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(24).png"));
			tiles[24] = new Tile();
			tiles[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(25).png"));
			tiles[25] = new Tile();
			tiles[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(26).png"));
			tiles[26] = new Tile();
			tiles[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(27).png"));
			tiles[27] = new Tile();
			tiles[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(28).png"));
			tiles[28] = new Tile();
			tiles[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(29).png"));
			tiles[29] = new Tile();
			tiles[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(30).png"));
			tiles[30] = new Tile();
			tiles[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(31).png"));
			tiles[31] = new Tile();
			tiles[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(32).png"));
			tiles[32] = new Tile();
			tiles[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(33).png"));
			tiles[33] = new Tile();
			tiles[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(34).png"));
			tiles[34] = new Tile();
			tiles[34].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(35).png"));
			tiles[35] = new Tile();
			tiles[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush(36).png"));
			
			tiles[100] = new Tile();
			tiles[100].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(01).png"));
			tiles[101] = new Tile();
			tiles[101].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(02).png"));
			tiles[102] = new Tile();
			tiles[102].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(03).png"));
			tiles[103] = new Tile();
			tiles[103].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(04).png"));
			tiles[104] = new Tile();
			tiles[104].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(05).png"));
			tiles[105] = new Tile();
			tiles[105].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(06).png"));
			tiles[106] = new Tile();
			tiles[106].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(07).png"));
			tiles[107] = new Tile();
			tiles[107].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(08).png"));
			tiles[108] = new Tile();
			tiles[108].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(09).png"));
			tiles[109] = new Tile();
			tiles[109].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(10).png"));
			tiles[110] = new Tile();
			tiles[110].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(11).png"));
			tiles[111] = new Tile();
			tiles[111].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(12).png"));
			tiles[112] = new Tile();
			tiles[112].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(13).png"));
			tiles[113] = new Tile();
			tiles[113].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(14).png"));
			tiles[114] = new Tile();
			tiles[114].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(15).png"));
			tiles[115] = new Tile();
			tiles[115].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(16).png"));
			tiles[116] = new Tile();
			tiles[116].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(17).png"));
			tiles[117] = new Tile();
			tiles[117].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(18).png"));
			tiles[118] = new Tile();
			tiles[118].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(19).png"));
			tiles[119] = new Tile();
			tiles[119].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(20).png"));
			tiles[120] = new Tile();
			tiles[120].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(21).png"));
			tiles[121] = new Tile();
			tiles[121].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(22).png"));
			tiles[122] = new Tile();
			tiles[122].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(23).png"));
			tiles[123] = new Tile();
			tiles[123].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(24).png"));
			tiles[124] = new Tile();
			tiles[124].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(25).png"));
			tiles[125] = new Tile();
			tiles[125].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(26).png"));
			tiles[126] = new Tile();
			tiles[126].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(27).png"));
			tiles[127] = new Tile();
			tiles[127].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(28).png"));
			tiles[128] = new Tile();
			tiles[128].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(29).png"));
			tiles[129] = new Tile();
			tiles[129].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(30).png"));
			tiles[130] = new Tile();
			tiles[130].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(31).png"));
			tiles[131] = new Tile();
			tiles[131].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(32).png"));
			tiles[132] = new Tile();
			tiles[132].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(33).png"));
			tiles[133] = new Tile();
			tiles[133].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(34).png"));
			tiles[134] = new Tile();
			tiles[134].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(35).png"));
			tiles[135] = new Tile();
			tiles[135].image = ImageIO.read(getClass().getResourceAsStream("/tiles/summerforest(36).png"));
			
			tiles[200] = new Tile();
			tiles[200].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(01).png"));
			tiles[201] = new Tile();
			tiles[201].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(02).png"));
			tiles[202] = new Tile();
			tiles[202].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(03).png"));
			tiles[203] = new Tile();
			tiles[203].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(04).png"));
			tiles[204] = new Tile();
			tiles[204].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(05).png"));
			tiles[205] = new Tile();
			tiles[205].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(06).png"));
			tiles[206] = new Tile();
			tiles[206].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(07).png"));
			tiles[207] = new Tile();
			tiles[207].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(08).png"));
			tiles[208] = new Tile();
			tiles[208].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(09).png"));
			tiles[209] = new Tile();
			tiles[209].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(10).png"));
			tiles[210] = new Tile();
			tiles[210].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(11).png"));
			tiles[211] = new Tile();
			tiles[211].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(12).png"));
			tiles[212] = new Tile();
			tiles[212].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(13).png"));
			tiles[213] = new Tile();
			tiles[213].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(14).png"));
			tiles[214] = new Tile();
			tiles[214].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(15).png"));
			tiles[215] = new Tile();
			tiles[215].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(16).png"));
			tiles[216] = new Tile();
			tiles[216].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(17).png"));
			tiles[217] = new Tile();
			tiles[217].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(18).png"));
			tiles[218] = new Tile();
			tiles[218].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(19).png"));
			tiles[219] = new Tile();
			tiles[219].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(20).png"));
			tiles[220] = new Tile();
			tiles[220].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(21).png"));
			tiles[221] = new Tile();
			tiles[221].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(22).png"));
			tiles[222] = new Tile();
			tiles[222].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(23).png"));
			tiles[223] = new Tile();
			tiles[223].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(24).png"));
			tiles[224] = new Tile();
			tiles[224].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(25).png"));
			tiles[225] = new Tile();
			tiles[225].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(26).png"));
			tiles[226] = new Tile();
			tiles[226].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(27).png"));
			tiles[227] = new Tile();
			tiles[227].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(28).png"));
			tiles[228] = new Tile();
			tiles[228].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(29).png"));
			tiles[229] = new Tile();
			tiles[229].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(30).png"));
			tiles[230] = new Tile();
			tiles[230].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(31).png"));
			tiles[231] = new Tile();
			tiles[231].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(32).png"));
			tiles[232] = new Tile();
			tiles[232].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(33).png"));
			tiles[233] = new Tile();
			tiles[233].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(34).png"));
			tiles[234] = new Tile();
			tiles[234].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(35).png"));
			tiles[235] = new Tile();
			tiles[235].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sun-wall(36).png"));
			
			tiles[300] = new Tile();
			tiles[300].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(01).png"));
			tiles[301] = new Tile();
			tiles[301].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(02).png"));
			tiles[302] = new Tile();
			tiles[302].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(03).png"));
			tiles[303] = new Tile();
			tiles[303].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(04).png"));
			tiles[304] = new Tile();
			tiles[304].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(05).png"));
			tiles[305] = new Tile();
			tiles[305].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(06).png"));
			tiles[306] = new Tile();
			tiles[306].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(07).png"));
			tiles[307] = new Tile();
			tiles[307].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(08).png"));
			tiles[308] = new Tile();
			tiles[308].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(09).png"));
			tiles[309] = new Tile();
			tiles[309].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(10).png"));
			tiles[310] = new Tile();
			tiles[310].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(11).png"));
			tiles[311] = new Tile();
			tiles[311].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(12).png"));
			tiles[312] = new Tile();
			tiles[312].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(13).png"));
			tiles[313] = new Tile();
			tiles[313].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(14).png"));
			tiles[314] = new Tile();
			tiles[314].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(15).png"));
			tiles[315] = new Tile();
			tiles[315].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(16).png"));
			tiles[316] = new Tile();
			tiles[316].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(17).png"));
			tiles[317] = new Tile();
			tiles[317].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(18).png"));
			tiles[318] = new Tile();
			tiles[318].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(19).png"));
			tiles[319] = new Tile();
			tiles[319].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(20).png"));
			tiles[320] = new Tile();
			tiles[320].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(21).png"));
			tiles[321] = new Tile();
			tiles[321].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(22).png"));
			tiles[322] = new Tile();
			tiles[322].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(23).png"));
			tiles[323] = new Tile();
			tiles[323].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(24).png"));
			tiles[324] = new Tile();
			tiles[324].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(25).png"));
			tiles[325] = new Tile();
			tiles[325].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(26).png"));
			tiles[326] = new Tile();
			tiles[326].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(27).png"));
			tiles[327] = new Tile();
			tiles[327].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(28).png"));
			tiles[328] = new Tile();
			tiles[328].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(29).png"));
			tiles[329] = new Tile();
			tiles[329].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(30).png"));
			tiles[330] = new Tile();
			tiles[330].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(31).png"));
			tiles[331] = new Tile();
			tiles[331].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(32).png"));
			tiles[332] = new Tile();
			tiles[332].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(33).png"));
			tiles[333] = new Tile();
			tiles[333].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(34).png"));
			tiles[334] = new Tile();
			tiles[334].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(35).png"));
			tiles[335] = new Tile();
			tiles[335].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water-road-grass(36).png"));
			
			tiles[400] = new Tile();
			tiles[400].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(01).png"));
			tiles[401] = new Tile();
			tiles[401].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(02).png"));
			tiles[402] = new Tile();
			tiles[402].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(03).png"));
			tiles[403] = new Tile();
			tiles[403].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(04).png"));
			tiles[404] = new Tile();
			tiles[404].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(05).png"));
			tiles[405] = new Tile();
			tiles[405].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(06).png"));
			tiles[406] = new Tile();
			tiles[406].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(07).png"));
			tiles[407] = new Tile();
			tiles[407].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(08).png"));
			tiles[408] = new Tile();
			tiles[408].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(09).png"));
			tiles[409] = new Tile();
			tiles[409].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(10).png"));
			tiles[410] = new Tile();
			tiles[410].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(11).png"));
			tiles[411] = new Tile();
			tiles[411].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(12).png"));
			tiles[412] = new Tile();
			tiles[412].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(13).png"));
			tiles[413] = new Tile();
			tiles[413].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(14).png"));
			tiles[414] = new Tile();
			tiles[414].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(15).png"));
			tiles[415] = new Tile();
			tiles[415].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(16).png"));
			tiles[416] = new Tile();
			tiles[416].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(17).png"));
			tiles[417] = new Tile();
			tiles[417].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(18).png"));
			tiles[418] = new Tile();
			tiles[418].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(19).png"));
			tiles[419] = new Tile();
			tiles[419].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(20).png"));
			tiles[420] = new Tile();
			tiles[420].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(21).png"));
			tiles[421] = new Tile();
			tiles[421].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(22).png"));
			tiles[422] = new Tile();
			tiles[422].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(23).png"));
			tiles[423] = new Tile();
			tiles[423].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(24).png"));
			tiles[424] = new Tile();
			tiles[424].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(25).png"));
			tiles[425] = new Tile();
			tiles[425].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(26).png"));
			tiles[426] = new Tile();
			tiles[426].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(27).png"));
			tiles[427] = new Tile();
			tiles[427].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(28).png"));
			tiles[428] = new Tile();
			tiles[428].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(29).png"));
			tiles[429] = new Tile();
			tiles[429].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(30).png"));
			tiles[430] = new Tile();
			tiles[430].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(31).png"));
			tiles[431] = new Tile();
			tiles[431].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(32).png"));
			tiles[432] = new Tile();
			tiles[432].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(33).png"));
			tiles[433] = new Tile();
			tiles[433].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(34).png"));
			tiles[434] = new Tile();
			tiles[434].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(35).png"));
			tiles[435] = new Tile();
			tiles[435].image = ImageIO.read(getClass().getResourceAsStream("/tiles/winterforest(36).png"));
			
			tiles[500] = new Tile();
			tiles[500].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house(01).png"));
			tiles[501] = new Tile();
			tiles[501].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house(02).png"));
			tiles[502] = new Tile();
			tiles[502].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house(03).png"));
			tiles[503] = new Tile();
			tiles[503].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house(04).png"));
			tiles[504] = new Tile();
			tiles[504].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house(05).png"));
			tiles[505] = new Tile();
			tiles[505].image = ImageIO.read(getClass().getResourceAsStream("/tiles/house(06).png"));
			
			tiles[550] = new Tile();
			tiles[550].image = ImageIO.read(getClass().getResourceAsStream("/tiles/roof(01).png"));
			tiles[551] = new Tile();
			tiles[551].image = ImageIO.read(getClass().getResourceAsStream("/tiles/roof(02).png"));
			tiles[552] = new Tile();
			tiles[552].image = ImageIO.read(getClass().getResourceAsStream("/tiles/roof(03).png"));
			tiles[553] = new Tile();
			tiles[553].image = ImageIO.read(getClass().getResourceAsStream("/tiles/roof(04).png"));
			tiles[554] = new Tile();
			tiles[554].image = ImageIO.read(getClass().getResourceAsStream("/tiles/roof(05).png"));
			tiles[555] = new Tile();
			tiles[555].image = ImageIO.read(getClass().getResourceAsStream("/tiles/roof(06).png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap() {
		try {
			
			InputStream is = getClass().getResourceAsStream("/maps/examplemap.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));	
			
			int col = 0;
			int row = 0;
			
			while(col < gamePanel.columns && row < gamePanel.rows) {
				
				String line = br.readLine();
				
				while(col<gamePanel.columns) {	
					String[] numbers = line.split(" ");
					
					int number = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = number;
					col++;
				}
					
				if(col == gamePanel.columns) {
					col = 0;
					row++;
				}
				br.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gamePanel.columns && row < gamePanel.rows) {
			
			int tileNum = mapTileNum[col][row];
			
			g2.drawImage(tiles[tileNum].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
			col++;
			x += gamePanel.tileSize;
			
			if(col==gamePanel.columns) {
				col = 0;
				x = 0;
				row++;
				y += gamePanel.tileSize;
			}
		}
	}
	
	
}