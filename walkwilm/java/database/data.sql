BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO badge (badge_name) VALUES
    ('Arts & Culture Badge'),
	('Food & Drink Badge'),
	('Entertainment Badge'),
	('Outdoor Recreation Badge'),
	('Education Badge'),
	('Defender of the Land Badge');

INSERT INTO category (category_name, badge_id) VALUES
    ('Arts & Culture Category', (Select badge_id from badge where badge_name = 'Arts & Culture Badge')),
    ('Food & Drink Category', (Select badge_id from badge where badge_name = 'Food & Drink Badge')),
    ('Entertainment Category', (Select badge_id from badge where badge_name = 'Entertainment Badge')),
    ('Outdoor Recreation Category', (Select badge_id from badge where badge_name = 'Outdoor Recreation Badge')),
    ('Education Category', (Select badge_id from badge where badge_name = 'Education Badge'));

INSERT INTO location (location_name, category_id, phone_number, street, city, state, zip, latitude, longitude) VALUES
    ('Delaware Art Museum', (Select category_id from category where category_name = 'Arts & Culture Category'), '(302) 571-9590', '2301 Kentmere Pkwy', 'Wilmington', 'DE', '19806', '39.765587746408656', '-75.56467454424887'),
    ('The Delaware Contemporary', (Select category_id from category where category_name = 'Arts & Culture Category'), '(302) 656-6466', '200 S Madison St', 'Wilmington', 'DE', '19801', '39.73848623190845', '-75.56023308842764'),
    ('Winterthur Museum, Garden & Library', (Select category_id from category where category_name = 'Arts & Culture Category'), '(800) 448-3883', '5105 Kennett Pike', 'Winterthur', 'DE', '19735', '39.80773457249289', '-75.60172232890521'),
    ('Delaware Children''s Museum', (Select category_id from category where category_name = 'Arts & Culture Category'), '(302) 654-2340', '550 Justison St', 'Wilmington', 'DE', '19801', '39.73463203882925', '-75.56055877493463'),
    ('Wilmington & Western Railroad', (Select category_id from category where category_name = 'Arts & Culture Category'), '(302) 998-1930', '2201 Newport Gap Pike', 'Wilmington', 'DE', '19808', '39.739033276739974', '-75.63215782698612'),

	('Taco Grande', (Select category_id from category where category_name = 'Food & Drink Category'), '(302) 407-3180', '600 Justison St', 'Wilmington', 'DE', '19801', '39.73387158667072', '-75.56038416146238'),
	('Wilmington Brew Works', (Select category_id from category where category_name = 'Food & Drink Category'), '(302) 722-4828', '3129 Miller Rd', 'Wilmington', 'DE', '19802', '39.766436185195275', '-75.53709005582178'),
	('Bardea Food & Drink', (Select category_id from category where category_name = 'Food & Drink Category'), '(302) 426-2069', '620 N Market St', 'Wilmington', 'DE', '19801', '39.742674172099875', '-75.54970975959196'),
	('Charcoal Pit', (Select category_id from category where category_name = 'Food & Drink Category'), '(302) 478-2165', '2600 Concord Pike', 'Wilmington', 'DE', '19803', '39.79647109804585', '-75.5476229442482'),
	('Oddity Bar', (Select category_id from category where category_name = 'Food & Drink Category'), '(302) 668-1078', '500 Greenhill Ave', 'Wilmington', 'DE', '19805', '39.75304275105368', '-75.57913578842734'),

	('The Queen Wilmington', (Select category_id from category where category_name = 'Entertainment Category'), '(302) 400-7020', '500 N Market St', 'Wilmington', 'DE', '19801', '39.74115157727016', '-75.55006987308501'),
	('Grand Opera House', (Select category_id from category where category_name = 'Entertainment Category'), '(302) 652-5577', '818 N Market St', 'Wilmington', 'DE', '19801', '39.7440640189293', '-75.54874971726309'),
	('The Candlelight Theatre', (Select category_id from category where category_name = 'Entertainment Category'), '(302) 475-2313', '2208 Millers Rd', 'Wilmington', 'DE', '19810', '39.80828304828878', '-75.4827179595904'),
	('Delaware Children''s Theatre', (Select category_id from category where category_name = 'Entertainment Category'), '(302) 803-4184', '1014 Delaware Ave', 'Wilmington', 'DE', '19806', '39.75193293913678', '-75.55619873075602'),
	('Daniel S Frawley Stadium (Wilmington Blue Rocks Baseball)', (Select category_id from category where category_name = 'Entertainment Category'), '(302) 777-5772', '801 Shipyard Dr', 'Wilmington', 'DE', '19801', '39.73250270968988', '-75.5650000019208'),

    ('Ashland Nature Center', (Select category_id from category where category_name = 'Outdoor Recreation Category'), '(302) 239-2334', '3511 Barley Mill Rd', 'Hockessin', 'DE', '19707', '39.79824131056433', '-75.66036338842633'),
    ('Jack A. Markell Trail', (Select category_id from category where category_name = 'Outdoor Recreation Category'), null, '1200 Justison St', 'Wilmington', 'DE', '19801', '39.727971459384065', '-75.56341563075657'),
    ('Goodstay Gardens', (Select category_id from category where category_name = 'Outdoor Recreation Category'), null, '2600 Pennsylvania Ave', 'Wilmington', 'DE', '19806', '39.76105021864352', '-75.57747378842708'),
    ('Alapocas Run State Park', (Select category_id from category where category_name = 'Outdoor Recreation Category'), '(302) 577-1164', '1914 W Park Dr', 'Wilmington', 'DE', '19803', '39.77321188302543', '-75.5582465828765'),
    ('Rockford Park', (Select category_id from category where category_name = 'Outdoor Recreation Category'), '(302) 577-7020', 'Lookout Dr', 'Wilmington', 'DE', '19806', '39.76789656728556', '-75.57244994000327'),

	('Brandywine Zoo', (Select category_id from category where category_name = 'Education Category'), '(302) 571-7788', '1001 N Park Dr', 'Wilmington', 'DE', '19802', '39.75618143263809', '-75.54973644609854'),
	('Kalmar Nyckel', (Select category_id from category where category_name = 'Education Category'), '(302) 429-7447', '1124 E 7th St', 'Wilmington', 'DE', '19801', '39.73745789465631', '-75.53663708657808'),
	('DuPont Environmental Education Center', (Select category_id from category where category_name = 'Education Category'), '(302) 656-1490', '1400 Delmarva Ln', 'Wilmington', 'DE', '19801', '39.723229415297304', '-75.5613161442498'),
	('Mitchell Center for African American Heritage', (Select category_id from category where category_name = 'Education Category'), '(302) 656-0637', '504 N Market St', 'Wilmington', 'DE', '19801', '39.74151902608011', '-75.55041644424938'),
	('Rockwood Park & Museum', (Select category_id from category where category_name = 'Education Category'), '(302) 761-4340', '4651 Washington Street Extension', 'Wilmington', 'DE', '19809', '39.772485630872815', '-75.52074882706506');


COMMIT TRANSACTION;
