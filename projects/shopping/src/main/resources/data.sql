/************************ SAMPLE DATA ************************/

-- grade ----------------------------------------------------
INSERT INTO grade (id, name) VALUES (null, 'admin');
INSERT INTO grade (id, name) VALUES (null, 'vip');
INSERT INTO grade (id, name) VALUES (null, 'gold');
INSERT INTO grade (id, name) VALUES (null, 'newbie');


-- member ----------------------------------------------------
INSERT INTO member (id, email, name, nickname, password, phone, address, zip_code, tel_number, height, weight, sex, birth_date, point, grade_id)
VALUES (null, 'admin@admin.com', 'admin', 'admin', '1234', '010-9999-9999', 'admin', 99999, '999-999-9999', 999, 99, 'u', '9999-99-99', 999999, 1);
INSERT INTO member (id, email, name, nickname, password, phone, address, zip_code, tel_number, height, weight, sex, birth_date, point, grade_id)
VALUES (null, 'euismod@blanditNam.edu', '최정', 'crosby', '2984dss5', '010-2444-4574', '서울시 종로구', 87235, '032-346-2344', 173, 67, 'm', '1994-08-13', 3000, 2);
INSERT INTO member (id, email, name, nickname, password, phone, address, zip_code, tel_number, height, weight, sex, birth_date, point, grade_id)
VALUES (null, 'molestie@egestas.net', '김광현', 'oral', 'slfkj23', '010-5742-2754', '경기도 안산시', 18734, '032-463-3454', 176, 68, 'm', '1980-09-12', 5420, 2);
INSERT INTO member (id, email, name, nickname, password, phone, address, zip_code, tel_number, height, weight, sex, birth_date, point, grade_id)
VALUES (null, 'diam.dictum@Curabitur.org', '힐만', 'Trey', '9u0sdf', '010-4572-3563', '서울시 강동구', 98734, '032-395-8945', 164, 78, 'm', '1967-03-29', 320, 2);
INSERT INTO member (id, email, name, nickname, password, phone, address, zip_code, tel_number, height, weight, sex, birth_date, point, grade_id)
VALUES (null, 'blandit@natoquepenatibus.co.uk', '예이츠', 'rebekah', '2394hd', '010-1446-2522', '인천시 부평구', 12222, '032-973-2984', 158, 48, 'f', '1973-11-30', 450, 2);
INSERT INTO member (id, email, name, nickname, password, phone, address, zip_code, tel_number, height, weight, sex, birth_date, point, grade_id)
VALUES (null, 'tortor@euismodestarcu.ca', '한동민', 'dongminican', '238usd', '010-9456-4564', '부산시 동래구', 29873, '032-784-2974', 165, 88, 'm', '1963-02-28', 7200, 3);
INSERT INTO member (id, email, name, nickname, password, phone, address, zip_code, tel_number, height, weight, sex, birth_date, point, grade_id)
VALUES (null, 'lobortis@squetincidunt.com', '최항', 'hanggg', '09s0jkd', '010-1234-5678', '서울시 마포구', 34298, '032-982-6843', 167, 94, 'f', '1987-05-05', 4500, 4);
INSERT INTO member (id, email, name, nickname, password, phone, address, zip_code, tel_number, height, weight, sex, birth_date, point, grade_id)
VALUES (null, 'enean@dolorFusce.com', '로맥', 'Jamie', 'po1323', '010-5092-3843', '충청남도 서천', 23482, '032-983-3464', 176, 78, 'm', '1997-05-13', 75000, 4);


-- category ----------------------------------------------------
INSERT INTO category (id, name) VALUES (null, '상의');
INSERT INTO category (id, name) VALUES (null, '아우터');
INSERT INTO category (id, name) VALUES (null, '원피스');
INSERT INTO category (id, name) VALUES (null, '하의');
INSERT INTO category (id, name) VALUES (null, '가방');
INSERT INTO category (id, name) VALUES (null, '스니커');
INSERT INTO category (id, name) VALUES (null, '신발');
INSERT INTO category (id, name) VALUES (null, '시계');
INSERT INTO category (id, name) VALUES (null, '모자');
INSERT INTO category (id, name) VALUES (null, '스포츠/용품');
INSERT INTO category (id, name) VALUES (null, '레그웨어/속옷');
INSERT INTO category (id, name) VALUES (null, '안경');
INSERT INTO category (id, name) VALUES (null, '악세서리');
INSERT INTO category (id, name) VALUES (null, '디지털/테크');
INSERT INTO category (id, name) VALUES (null, '생활/취미/예술');
INSERT INTO category (id, name) VALUES (null, '코스메틱');
INSERT INTO category (id, name) VALUES (null, '반려동물');


-- product ----------------------------------------------------
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 659554, '하프 폴라 니트 티셔츠', 78000, 36800, 324, '봄, 가을부터 겨울철까지 활용도가 높은 하프 폴라 니트입니다. 은은한 광택감에 부드러운 촉감이 특징이며 신축성이 좋아 신체 사이즈에 구애 없는 활용이 가능합니다.', 10, 3680, 1);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 624932, '1987MMLG HOOD (GREY)', 79000, 77420, 80, 'Recruit 87MM Co., Ltd.에서 직접 개발하여 완성된 헤비 코튼 패브릭입니다. 균일한 짜임과 적당한 조직감을 표현하는 표면에 집중하였으며, 중량감과 터치감이 매우 좋습니다.', 4, 7740, 1);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 836499, 'LOCATION LOGO CREWNECK HA [INDIGO BLUE]', 58000, 55100, 32, '미니멀한 레터링과 기본로고의 조화가 돋보이는 디자인 입니다. 비바스튜디오가 이번 시즌 추구하는 무드에 걸 맞는 새로운 시그니쳐 그래픽이 특징입니다. 뒤틀림과 수축 방지를 위해 원단 상태로 고온에서 (80℃) 두 번의 덤블 텐타가공을 했습니다. RIB 원단 또한 cotton 100% 원사에 복원력이 강한 140D의 고강력 스판사를 사용하여 목 늘어남을 방지하였습니다. 전체적으로 여유 있고 일자로 떨어지는 핏입니다.', 5, 5510, 1);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 811905, 'N184UDW890 카이만 엑스 덕다운 벤치 다운 자켓 롱패딩 점퍼 BLACK 2', 390000, 299000, 122, '내셔널지오그래픽의 활동 범위는 자연을 넘어 도시와 문화, 인류에까지 이르고 있습니다. 도심에서 만나는 변덕스러운 날씨는 아웃도어 활동 못지 않게 제품의 기능성도 요구합니다. 기능성 원단과 아웃도어 웨더의 디테일이 숨어 있지만 도시적 감수성을 모던하고 심플하게 해석한 제품들로 매일매일 주어지는 새로운 하루와 도시에 어울리는 라인입니다.', 70, 29900, 2);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 260755, 'SOLIST OVERSIZE CASHEMERE COAT (black)', 248000, 210000, 32, '과하지 않은 자연스러운 세미 오버사이즈 핏 코트입니다. 인위적인 드롭숄더 코트 착용시 발생하는 활동성의 불편함을 해소하기 위해 어깨선을 기본적인 테일러드 코트보다 약 2cm 정도 적당히 드롭하였습니다. 수차례의 수정작업을 거친 패턴 개발로 시각적으로 가장 트렌디하면서도 안정감있는 최적의 실루엣을 구현했습니다. 여러 체형과 상황에 상관없이 편안하게 착용할 수 있으며, 다양한 스타일의 이너 아이템들과 조화롭게 어루어져 코디네이션이 매우 용이합니다.', 5, 21000, 2);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 606312, '브이넥 라이트 다운 베스트 [블랙]', 36900, 29500, 45, '겨울 아우터에 이너로 활용하기 좋은 라이트 다운 베스트이다. 무난한 가로 퀼팅에 브이 넥 라인으로 다양한 아우터류에 레이어드가 용이하다. 단독 착용을 고려하여 표면을 적당히 매트한 질감으로 설정했다. 이너 웨어로서 과하지 않으면서도 단독 아우터 활용 시 지나치게 얇지 않도록 600FP의 필파워를 가진 덕다운을 65g 충전하여 적절한 부피를 갖추었다. 축열 기능을 강화하여 개발한 기능성 경량 소재인 WARM SAVER를 사용하여 뛰어난 보온효과를 갖추었고, 충전재는 다운생산 전문 기업인 ㈜신주원의 DIVO 다운을 사용하여 우수한 품질을 보증한다.', 10, 2950, 2);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 848783, 'LINE VELVET ONEPIECE BLACK (NF18A018H)', 72000, 68400, 68, '벨벳 원단을 사용하고 양 옆의 띠를 둘러 디자인한 제품입니다.', 5, 6840, 3);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 825946, 'VELVET SPADE COLLAR ROLA ONE-PIECE BLACK', 83000, 68850, 40, '로라로라의 시그니처 로고와 뒷판에 체크 배색 자수로 포인트를 살린 제품입니다. 벨벳소재의 원피스로 보온성이 탁월해 겨울에도 따뜻하게 착용 가능합니다.', 4, 6880, 3);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 882358, '자켓 원피스_블랙', 139000, 136220, 28, '', 10, 13620, 3);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 896527, '테이퍼드 밴딩 기모 10부 슬랙스 [블랙]', 32900, 27900, 143, '편안하고 슬림한 실루엣의 테이퍼드 핏 기모 슬랙스. 허리 부분에 이중으로 구성된 사이드 밴딩과 3%의 폴리우레탄이 포함된 뛰어난 신축성의 T/R 원단을 사용해 편안한 활동성을 제공한다. 실리콘 프린팅으로 처리한 허리 안쪽의 웨이스트 밴드는 상의를 넣어서 입을 때 옷이 바지 바깥으로 빠져나오는 걸 방지한다.', 12, 2790, 4);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 405682, 'LONG WIDE SLACKS_F BLACK', 62000, 59000, 243, '에드의 시그니처 아이템 LONG WIDE SLACKS 입니다. 18FW 새로운 시즌의 트렌드가 반영된 업데이트 버전입니다. 기존의 사이즈보다 조금 더 넓게 조정된 힙사이즈와 바지통 패턴은 부드럽게 떨어지는 에드만의 와이드 핏을 구현합니다. 에드의 와이프 핏은 사이즈와 패턴 뿐만 아니라, 와이드 팬츠에 최적화된 원단 사용과 봉재 공정의 노하우로 제작됩니다. 일반적인 구조의 원단과 다른 높은 퀄리티의 2중 직조 방식의 원단이 사용되었으며, 어느 옷과 입어도 트렌디한 핏을 연출할 수 있게 도와주는 와이드 팬츠입니다.', 10, 5900, 4);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 655627, 'Plant Manager2 / New Crop', 84000, 75600, 430, 'Cotton 98%, Lycra 2% 혼용률로 12 oz 중량감의 데님원단을 사용했습니다. 워싱과정에서 하이라이트 브러쉬 부분의 꽉찬 사방슬럽이 인상적이며 Lycra가 함유되어 텐션력과 복원력이 뛰어납니다. 레이져를 이용하여 일률적인 캣이 특징이며, 개체 차이가 확연하게 줄어들었습니다. 2차 공정으로 올 샌딩 페이퍼 작업과 올 핸드 브러쉬 수작업 공정으로 인위적일 수도 있는 레이져 캣을 한층 더 보완하여 음양각의 컬러 그라데이션 효과를 최대한 끌어 올렸습니다.', 15, 7560, 4);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 403697, 'MODESTO HQ_BLACK', 49000, 38220, 8, '내구성 좋은 인조 가죽으로 무게는 물론 가격 거품까지 감량한 숄더백입니다. 사용자의 취향에 따라 토트백, 크로스백, 숄더백으로 다양한 활용이 가능한 제품입니다. 고급스러움과 심플한 디자인으로 남녀노소 누구에게나 잘 어울리는 데일리백 입니다.', 2, 3820, 5);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 693318, 'ABSOLUTE BACKPACK / BLACK', 114000, 74100, 96, '앞면과 옆면의 메쉬포켓에 인형, 악세사리 등으로 자신만의 개성있는 수납이 가능하며, 총 14칸의 수납섹션과 넉넉한 대용량 수납공간으로 캠퍼스 및 여행용 백팩으로 손색이 없는 모델입니다. 양 옆의 버클과 스트랩으로 가방 폭을 조절할 수 있으며, 쿠션패드가 내장된 노트북 수납섹션이 있어 15인치 랩탑까지 안전하게 수납이 가능합니다. 또한 바닥의 접이식 쿠션패드는 무거운 책과 물건을 수납해도 처짐현상을 최소한으로 줄여주는 역할을 합니다. 등판에는 여행용 캐리어와 가방이 결합가능한 고정패드를 추가하여 편리성을 제공하는 제품입니다.', 10, 7410, 5);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 826798, 'CORDURA® 750D Nylon Messenger Bag Black', 69000, 67620, 320, '', 10, 6760, 5);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 577636, '[BZ0579] BW 독일군 스니커즈 - 화이트', 139000, 103900, 148, '과거 독일군 인도어 트레이닝 슈즈를 참조한 이번 신발은 클래식한 모습을 선보입니다. 어퍼는 가죽 소재로 만들어졌으며 앞부분은 스웨이드로 막아 마무리했으며 절제되고 세밀한 대비를 보여줍니다. 검 러버 아웃솔은 과거와 연결되어 있으며, 트리포일 로고가 텅 부분에서 아디다스 헤리티지를 보여줍니다.', 6, 10390, 6);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 825978, 'V2 Shoes', 89000, 79000, 120, '23.65 2018 시즌 야심차게 선보이는 런닝화 V2입니다. 23.65만의 아이덴티티가 돋보이는 런닝화 제품입니다. 이번 런닝화 디자인은 두가지로 출시되었으며 PU, 스웨이드, 매쉬, 벨크로 등 다양한 소재를 다양하게 사용하여 23.65만의 특별한 감성을 자아내는 신발입니다.', 5, 7900, 6);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 886513, '스케이트 하이 리이슈 길리 - (Leather) 블랙 / VN0A3ZCH68X1', 109000, 91900, 46, '올드스쿨 다음으로 사이드 스트라이프를 가미한 실루엣인 스케이트-하이는 1978년에 처음으로 소개되었습니다. 스케이터에게 주로 발생하는 발목 부상을 방지하기 위해 패드가 내장된 카라가 발목까지 올라와 착용감이 최적화되었으며, 특별한 스타일링으로 사랑받는 제품입니다.', 3, 9190, 6);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 464267, '닥터마틴 1461 모노 블랙 14345001', 190000, 171000, 28, '심플하고 스탠다드한 3홀 더비슈즈 스타일로 어떠한 스타일링에도 자연스럽고 멋지게 활용이 가능할 정도로 다양한 매력이 있는 모델입니다. 부드럽고 유연함으로 편안한 착화감 그리고 튼튼한 내구성과 내마모성을 제공하는 Smooth Leather를 소재로 사용하였습니다. 닥터마틴만의 특수한 공법으로 제작된 오리지널 아웃솔은 특유의 오리지널리티한 분위기와 튼튼한 내구성을 제공합니다.', 3, 17100, 7);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 600545, '1461 3홀 깁슨 블랙 스무스 래더 R11838002', 190000, 129000, 18, '', 2, 12900, 7);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 607298, '375 웰던 더비 구두 루시블랙', 46900, 37500, 42, 'BSQT by classy 375 더비 슈즈는 매년 BESTSELLER 1위 자리를 지키고 있는 인기 상품입니다. 격식을 따지지 않고 스포티함 + 모던함을 모두 표현 가능한 다재다능한 슈즈입니다. 화이트 삭스와 데미지 진 매치는 셀럽들이 자주 보여 주고 있는 코디 입니다.', 10, 3750, 7);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 412489, '시계 A158WA-1DF 디지털 메탈시계', 49000, 25800, 75, '', 4, 2580, 8);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 722951, 'AQ-230A-7DMQ 남여공용 빈티지 메탈밴드 디지털시계', 51800, 50700, 430, '', 900, 5070, 8);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 450240, 'T086.407.11.031.00(T0864071103100) AUTOMATIC Gent', 1020000, 730000, 45, '티쏘는 최첨단 기술, 특수 소재 및 앞선 기능 개발 덕분에 시계의 선두주자로 우뚝 섰다. 그리고 어떠한 스위스 시계 브랜드보다도 경쟁력 있는 가격, 다양한 고품질 시계를 통해 누구나 쉽게 이용할 수 있는 시계에 대한 열정을 보여주고 있다.', 20, 73000, 8);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 466080, '나이키 레거시91 테크 스우시캡 블랙 / 892651-010', 59000, 28900, 1232, '심플한 디자인, 블랙&화이트의 색상으로 어디에나 어울리는 간편한 코디아이템', 49, 2890, 9);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 371179, '(cotton) watch cap [BLACK]', 34000, 23800, 420, '코튼 아크릴 혼방실로 제작된 와치캡입니다.', 10, 2380, 9);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 699197, '[unisex]F/W REVERSIBLE SATIN TROOPER HAT BLACK', 63000, 56700, 49, '겨울시즌 따뜻하게 착용할수있는 트루퍼 햇 이다. 머리 전체를 감싸주는 디자인이며 겉감은 슬리피슬립에서 자체적으로 제작된 밀도높은 짜임에 poly소재로 봉제후에 수축되지않는 성질을 가지고있어 구김이 적으며 후가공 방수(코팅)작업을 진행하여 겨울시즌 눈,비오는날 착용해도 크게 무리가 없는 원단이며 보세제품과 비교해 월등히 높은 퀄리티로 만나볼 수 있다.', 5, 5670, 9);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 872095, '맨즈 메가히트 스탠다드 크루넥 티셔츠 [블랙]', 9900, 5900, 180, '타이트하지 않고 넉넉한 사이즈로 크루넥 타입과 9부 소매 기장이 레이어드시에도 깔끔하고 편안하게 입으실 수 있으며 VENTEX사의 고급스러운 메가히트 원단을 사용하여 얇고 부드러우며 우수한 보온성으로 따스한 포근함으로 항상 기분 좋게 만들어 주는 겨울 이너웨어입니다.', 20, 590, 10);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 872097, '맨즈 메가히트 스탠다드 타이즈 [블랙]', 9900, 5900, 230, '웨이스트의 나일론 소재 아웃밴드는 부드러운 촉감과 탄력으로 피부에 부담감을 줄여주고 활동성을 높였습니다. 추위에 노출되는 다리 부분을 VENTEX사의 메가히트 소재의 원단을 사용하여 피부와의 밀착감이 좋아 외부 활동에도 불편함 없이 부드럽게 감싸주며 보온성을 높였습니다.', 10, 590, 10);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 872096, '맨즈 메가히트 스탠다드 크루넥 티셔츠 [차콜]', 9900, 5900, 430, '타이트하지 않고 넉넉한 사이즈로 크루넥 타입과 9부 소매 기장이 레이어드시에도 깔끔하고 편안하게 입으실 수 있으며 VENTEX사의 고급스러운 메가히트 원단을 사용하여 얇고 부드러우며 우수한 보온성으로 따스한 포근함으로 항상 기분 좋게 만들어 주는 겨울 이너웨어입니다.', 10, 590, 10);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 746158, '크루 삭스 5팩 [화이트]', 12900, 10900, 865, '탄탄하게 짜여진 캐주얼 삭스로, 형태상으로는 종아리 중간까지의 길이감을 지닌 크루 삭스로(Crew Socks)로 분류된다. 땀 흡수와 부드러운 착용감을 위해 코튼 코마사를, 적절한 신축성과 탄성을 위해 스판덱스와 라텍스를 혼용하였다.', 20, 1090, 11);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 391476, '[10PACK] 양말 패키지 DRUG_UX 무지 카바', 23900, 14900, 2321, '드러그 위드아웃 사이드 이펙트의 양말은 어떠한 스타일링에도 무난히 매치할 수 있는 기본 아이템이며, 발목 부분을 부드럽게 감싸주는 패드와 마찰이 심한 발가락부분을 1.3배 고밀도로 직조한 제품입니다.', 50, 1490, 11);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 746159, '크루 삭스 5팩 [블랙]', 12900, 10900, 10, '탄탄하게 짜여진 캐주얼 삭스로, 형태상으로는 종아리 중간까지의 길이감을 지닌 크루 삭스로(Crew Socks)로 분류된다.', 10, 1090, 11);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 608042, 'LICORNE RTGA739G (골드) 패션 안경테 (청광렌즈)', 89000, 38270, 34, '', 5, 3820, 12);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 685410, 'RC 3579 SILVER', 29000, 25900, 132, '', 10, 2590, 12);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 134562, '치바 글라스 (블랙)', 38000, 34200, 530, '', 10, 3420, 12);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 690595, 'Layla unconditional love Layla reversible muffler 3 6color', 68000, 49900, 184, '양면으로 사용이 가능한 실용적인 상품으로 기호에 맞게 선택하여 스타일링 하기 좋습니다. 소재의 뒤틀림을 방지하는 6개의 스티치 자수가 되어있습니다.', 5, 4990, 13);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 652363, '247 CASHMERE MUFFLER [6 COLORS]', 79800, 52900, 523, '247 SEOUL에서 선보이는 클래식한 디자인의 247 CASHMERE MUFFLER입니다.', 20, 5290, 13);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 864555, '캐시미어 100 머플러', 46900, 39900, 22, '캐시미어 100%로 짜여진 머플러이다. 120g의 적당한 중량으로 가벼운 착용감과 적당한 두께감을 느낄 수 있으며 미니멀하게 디자인하여 데일리 아이템으로 적합하다.', 2, 3990, 13);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 271552, 'PHONE CASE COMPTON BEAR BLACK', 32000, 32000, 18, 'STIGMA는 FUNKY FRESH와 NASTY의 코드를 해학적으로 풀어나가며 음악과 예술가, AGGRESSIVE와 도전을 추구하는 도시의 스케이터와 댄서를 표현합니다.', 5, 3200, 14);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 848948, '노티스 아이폰 케이스', 19000, 18620, 54, 'Multicolor logo graphic printed at face', 10, 1860, 14);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 824189, '체리 범퍼 폰 케이스 HA [화이트]', 25000, 24000, 42, '범퍼 휴대폰 케이스입니다. KIRSH의 시그니처 로고인 체리 패턴으로 키르시만의 키치함을 표현하였습니다.', 5, 2400, 14);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 793813, '무신사 장우산 [블랙]', 9900, 5900, 140, '베이식한 디자인의 장우산이다. 고밀도의 폴리에스터 원단에 테프론 코팅을 더해 탁월한 발수 및 방수 기능을 갖추었고, 블랙으로 코팅 된 스틸 소재의 중봉과 섬유강화플라스틱(FRP)으로 만들어진 살대는 튼튼한 내구성을 지닌다.', 5, 590, 15);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 805827, '아임낫어휴먼비잉 콜라보 완자동 우산', 15900, 15740, 43, '슈펜 X 아임 낫 휴먼 비잉 콜라보레이션', 10, 1570, 15);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 497279, 'Agent Umbrella Black', 29000, 28710, 18, '동일 사양으로 재입고된 Espionage Agent Umbrella 입니다. 겉감으로는 방풍, 발수에 우수한 밀도 높은 Polyester 원단을 사용하였으며 내부의 살대는 거센 바람에도 저항할 수 있는 견고한 소재를 사용하여 완성도를 향상시킨 제품입니다. 제품 전면에는 Espionage OG Logo 나염 처리 되어있으며 고압력 및 고열의 특수 나염 처리 방식을 사용하여 오랜 사용감에도 데미지가 적도록 제작되었습니다.', 5, 2870, 15);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 705055, '[향수] 아티산 EDT 75ml', 82000, 45500, 15, '내추럴하면서도 현대적이며 세련된 감각의 결정체. 자유롭고 창조적인 캐주얼함, 동시에 모던한 남성을 위한 향수', 2, 4550, 16);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 835600, '[패키지] 드레스퍼퓸 150ml', 30000, 16900, 57, 'W.DRESSROOM은 뉴욕 스트릿에서 보이는 모던하고 트렌디한 디자인을 바탕으로 품격있는 매혹적인 향을 만들어냅니다', 10, 1690, 16);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 867413, '올인원 톤업 에센스 포맨', 32000, 22000, 32, '촉촉한 수분 공급과 함께 자연스러운 톤업 효과를 주어 깔끔한 피부로 정돈해주는 올인원 톤업 에센스', 10, 2200, 16);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 710669, '양면 보아털 후리스 베스트 (아이보리)', 62000, 60760, 32, '시중에 판매되는 일반 후리스가 아닌 양면 보아털로 보온성이 탁월한 베스트입니다. 또한 가벼운 원단으로 편안하게 착용할 수 있습니다.', 5, 6070, 17);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 663052, '프리미엄 구스 패딩 베스트 (베이지)', 68000, 66640, 14, '프리미엄 구스를 풍성하게 넣어 따듯함을 더하고, 베이직한 4가지 컬러와 캐주얼한 디자인으로 추운 겨울 반려견들의 따듯함을 함께해줄 데일리아이템입니다. 이너와 함께 입어도 부담스럽지 않으며 안정된 착용감으로 오래도록 따듯하게 착용할 수 있는 프리미엄 구스 패딩 조끼 입니다.', 1, 6660, 17);
INSERT INTO product (id, number, name, tag_price, selling_price, stock_quantity, description, max_order_quantity, point, category_id)
VALUES (null, 690340, '폴라베어 그랜마 올인원(머스타드)', 51000, 49980, 32, '겨울을 대표하는 북극곰 친구들이 가득히 프린팅된 아우터 시리즈로, 면 100% 원단으로 제작하여 어떤 견종이든 편안하게 입을 수 있습니다.', 5, 4990, 17);


-- product_image ----------------------------------------------------
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product1.png', 1045, 1);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product2.png', 2094, 2);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product3.png', 385, 3);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product4.png', 184, 4);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product5.png', 1943, 5);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product6.png', 124, 6);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product7.png', 235, 7);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product8.png', 456, 8);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product9.png', 124, 9);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product10.png', 754, 10);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product11.png', 235, 11);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product12.png', 3434, 12);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product13.png', 234, 13);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product14.png', 754, 14);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product15.png', 1943, 15);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product16.png', 754, 16);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product17.png', 2094, 17);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product18.png', 1943, 18);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product19.png', 1943, 19);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product20.png', 754, 20);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product21.png', 2094, 21);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product22.png', 1943, 22);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product23.png', 2094, 23);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product24.png', 1943, 24);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product25.png', 2094, 25);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product26.png', 754, 26);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product27.png', 1943, 27);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product28.png', 2094, 28);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product29.png', 1943, 29);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product30.png', 1045, 30);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product31.png', 754, 31);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product32.png', 1943, 32);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product33.png', 2094, 33);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product34.png', 1943, 34);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product35.png', 754, 35);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product36.png', 1943, 36);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product37.png', 1045, 37);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product38.png', 1045, 38);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product39.png', 1943, 39);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product40.png', 2094, 40);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product41.png', 1943, 41);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product42.png', 1943, 42);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product43.png', 754, 43);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product44.png', 1045, 44);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product45.png', 2094, 45);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product46.png', 1943, 46);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product47.png', 754, 47);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product48.png', 1943, 48);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product49.png', 2094, 49);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product50.png', 754, 50);
INSERT INTO product_image (id, file_name, file_size, product_id) VALUES (null, 'product51.png', 1943, 51);


-- cart_product ----------------------------------------------------
INSERT INTO cart_product (id, added_date, price, quantity, product_id, member_id)
VALUES (null, now(), 29500, 1, 6, 2);
INSERT INTO cart_product (id, added_date, price, quantity, product_id, member_id)
VALUES (null, now(), 25900, 3, 35, 2);
INSERT INTO cart_product (id, added_date, price, quantity, product_id, member_id)
VALUES (null, now(), 38220, 1, 13, 4);
INSERT INTO cart_product (id, added_date, price, quantity, product_id, member_id)
VALUES (null, now(), 28710, 1, 45, 5);
INSERT INTO cart_product (id, added_date, price, quantity, product_id, member_id)
VALUES (null, now(), 45500, 1, 46, 5);
INSERT INTO cart_product (id, added_date, price, quantity, product_id, member_id)
VALUES (null, now(), 66640, 2, 50, 5);
INSERT INTO cart_product (id, added_date, price, quantity, product_id, member_id)
VALUES (null, now(), 49980, 1, 51, 5);
INSERT INTO cart_product (id, added_date, price, quantity, product_id, member_id)
VALUES (null, now(), 39900, 1, 39, 7);
INSERT INTO cart_product (id, added_date, price, quantity, product_id, member_id)
VALUES (null, now(), 68850, 2, 8, 8);
INSERT INTO cart_product (id, added_date, price, quantity, product_id, member_id)
VALUES (null, now(), 5900, 1, 28, 8);


-- delivery_company ----------------------------------------------------
INSERT INTO delivery_company (id, name, account_number, bank, address, corp_number, depositor, tel_number)
VALUES (null, 'CJ대한통운', '282202-04-158668', '국민', '경기도 평택시 신장로 55', '323-24-48734', '김영한', '031-783-3874');
INSERT INTO delivery_company (id, name, account_number, bank, address, corp_number, depositor, tel_number)
VALUES (null, '롯데택배', '151-3435-45445', '농협', '서울특별시 강남구 신사동 640-2', '875-35-35089', '윤지수', '02-9843-8343');
INSERT INTO delivery_company (id, name, account_number, bank, address, corp_number, depositor, tel_number)
VALUES (null, '한진택배', '93-324-346422', '신한', '경기도 용인시 처인구 이동면 화산리 168-2번지', '987-23-34804', '박희진', '031-487-8193');


-- delivery ----------------------------------------------------
INSERT INTO delivery (id, address, fee, message, recipient_name, recipient_phone, delivery_company_id)
VALUES (null, '서울시 종로구', 2500, '부재시 경비실에 맡겨주세요.', '최정', '010-2444-4574', 1);
INSERT INTO delivery (id, address, fee, message, recipient_name, recipient_phone, delivery_company_id)
VALUES (null, '경기도 안산시', 2500, '배송 전 연락주세요.', '김광현', '010-5742-2754', 1);
INSERT INTO delivery (id, address, fee, message, recipient_name, recipient_phone, delivery_company_id)
VALUES (null, '서울시 강동구', 2500, '부재시 경비실에 맡겨주세요.', '힐만', '010-4572-3563', 2);
INSERT INTO delivery (id, address, fee, message, recipient_name, recipient_phone, delivery_company_id)
VALUES (null, '부산시 동래구', 2500, '부재시 경비실에 맡겨주세요.', '한동민', '010-9456-4564', 2);
INSERT INTO delivery (id, address, fee, message, recipient_name, recipient_phone, delivery_company_id)
VALUES (null, '서울시 마포구', 0, '경비실에 맡겨주세요.', '최항', '010-1234-5678', 3);


-- payment ----------------------------------------------------
INSERT INTO payment (id, card_company, bank, fee, method, payment_date, payment_number)
VALUES (null, '국민', '-', 0, '카드', now(), 2357923582);
INSERT INTO payment (id, card_company, bank, fee, method, payment_date, payment_number)
VALUES (null, '-', '농협', 0, '무통장입금', now(), 3945729843);
INSERT INTO payment (id, card_company, bank, fee, method, payment_date, payment_number)
VALUES (null, '-', '수협', 0, '무통장입금', now(), 7287498723);
INSERT INTO payment (id, card_company, bank, fee, method, payment_date, payment_number)
VALUES (null, '국민', '-', 0, '카드', now(), 1298742323);
INSERT INTO payment (id, card_company, bank, fee, method, payment_date, payment_number)
VALUES (null, '신한', '-', 0, '카드', now(), 1984298722);


-- ordering ----------------------------------------------------
INSERT INTO ordering (id, date, discount_price, number, price, quantity, reserved_money, delivery_id, member_id, payment_id)
VALUES (null, now(), 0, 201807151820133543, 169320, 3, 16930, 1, 2, 1);
INSERT INTO ordering (id, date, discount_price, number, price, quantity, reserved_money, delivery_id, member_id, payment_id)
VALUES (null, now(), 15900, 201807151820133565, 59000, 1, 5900, 2, 3, 2);
INSERT INTO ordering (id, date, discount_price, number, price, quantity, reserved_money, delivery_id, member_id, payment_id)
VALUES (null, now(), 0, 201805171012257305, 166500, 2, 16650, 3, 4, 3);
INSERT INTO ordering (id, date, discount_price, number, price, quantity, reserved_money, delivery_id, member_id, payment_id)
VALUES (null, now(), 32300, 201811171012437351, 11800, 2, 1180, 4, 6, 4);
INSERT INTO ordering (id, date, discount_price, number, price, quantity, reserved_money, delivery_id, member_id, payment_id)
VALUES (null, now(), 2740, 201809171012257354, 50620, 2, 5060, 5, 7, 5);


-- claim ----------------------------------------------------
INSERT INTO claim (id, price, reason, type) VALUES (null, 55100, '단순 변심', '환불');
INSERT INTO claim (id, price, reason, type) VALUES (null, 37500, '불량', '환불');
INSERT INTO claim (id, reason, type) VALUES (null, '사이즈', '교환');


-- ordered_product ----------------------------------------------------
INSERT INTO ordered_product (id, price, quantity, ordering_id, product_id) VALUES (null, 36800, 2, 1, 1);
INSERT INTO ordered_product (id, price, quantity, ordering_id, product_id) VALUES (null, 77420, 1, 1, 2);
INSERT INTO ordered_product (id, price, quantity, claim_id, ordering_id, product_id) VALUES (null, 55100, 1, 1, 1, 3);
INSERT INTO ordered_product (id, price, quantity, ordering_id, product_id) VALUES (null, 59000, 1, 2, 11);
INSERT INTO ordered_product (id, price, quantity, ordering_id, product_id) VALUES (null, 129000, 1, 3, 21);
INSERT INTO ordered_product (id, price, quantity, claim_id, ordering_id, product_id) VALUES (null, 37500, 1, 2, 3, 22);
INSERT INTO ordered_product (id, price, quantity, ordering_id, product_id) VALUES (null, 5900, 2, 4, 31);
INSERT INTO ordered_product (id, price, quantity, claim_id, ordering_id, product_id) VALUES (null, 32000, 1, 3, 5, 41);
INSERT INTO ordered_product (id, price, quantity, ordering_id, product_id) VALUES (null, 18620, 1, 5, 42);


-- coupon ----------------------------------------------------
INSERT INTO coupon (id, name, discount_ratio, exp_date) VALUES (null, '11월 무신사 회원 정기 쿠폰 멤버등급', 4.0, now());
INSERT INTO coupon (id, name, discount_ratio, exp_date) VALUES (null, '웰컴백쿠폰', 7.0, now());
INSERT INTO coupon (id, name, discount_price, exp_date) VALUES (null, '생일축하 10,000원 할인쿠폰', 10000, now());


-- member_coupon ----------------------------------------------------
INSERT INTO member_coupon (coupon_id, member_id, quantity) VALUES (1, 2, 1);
INSERT INTO member_coupon (coupon_id, member_id, quantity) VALUES (2, 2, 1);
INSERT INTO member_coupon (coupon_id, member_id, quantity) VALUES (1, 3, 1);
INSERT INTO member_coupon (coupon_id, member_id, quantity) VALUES (2, 4, 2);
INSERT INTO member_coupon (coupon_id, member_id, quantity) VALUES (3, 7, 1);


-- promotion ----------------------------------------------------
INSERT INTO promotion (id, name, start_date, end_date, status)
VALUES (null, '할인전 | 얀13 18 F/W 미드세일', now(), now(), '진행중');
INSERT INTO promotion (id, name, start_date, end_date, status)
VALUES (null, '할인전 | 에스피오나지 2018 A/W 컬렉션 쇼케이스 특별전', now(), now(), '종료');
INSERT INTO promotion (id, name, start_date, end_date, status)
VALUES (null, '할인전 | 컨버스 홀리 시즌 컬렉션', now(), now(), '진행중');
INSERT INTO promotion (id, name, start_date, end_date, status)
VALUES (null, '할인전 | LMC 레드라벨 쇼케이스 특별전', now(), now(), '진행중');


-- product_promotion ----------------------------------------------------
INSERT INTO product_promotion (product_id, promotion_id) VALUES (13, 1);
INSERT INTO product_promotion (product_id, promotion_id) VALUES (19, 2);
INSERT INTO product_promotion (product_id, promotion_id) VALUES (24, 3);
INSERT INTO product_promotion (product_id, promotion_id) VALUES (48, 4);


-- wish_list_member_product ----------------------------------------------------
INSERT INTO wish_list_member_product (member_id, product_id) VALUES (2, 7);
INSERT INTO wish_list_member_product (member_id, product_id) VALUES (2, 17);
INSERT INTO wish_list_member_product (member_id, product_id) VALUES (5, 6);
INSERT INTO wish_list_member_product (member_id, product_id) VALUES (5, 7);
INSERT INTO wish_list_member_product (member_id, product_id) VALUES (5, 44);
INSERT INTO wish_list_member_product (member_id, product_id) VALUES (8, 43);