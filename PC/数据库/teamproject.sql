/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : teamproject

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2021-04-28 17:01:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `Blog_ID` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `Blog_Title` text NOT NULL COMMENT '文章标题',
  `Blog_Content` longtext NOT NULL COMMENT '文章内容',
  `Blog_UserID` varchar(20) NOT NULL COMMENT '文章用户',
  `Blog_Likes` bigint(255) DEFAULT '0' COMMENT '文章点赞量',
  `Blog_ImgID` bigint(255) DEFAULT NULL COMMENT '文章图片ID',
  `Blog_ReleaseDate` datetime NOT NULL COMMENT '文章发布日期',
  `Blog_Comment` bigint(255) DEFAULT '0',
  `Blog_ContextStr` longtext NOT NULL,
  PRIMARY KEY (`Blog_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '红烧肉的做法', '红烧肉可说是一家常菜，不同地方，不同人，做法肯定不一样。俺出来乍到，献上一道红烧肉，给各位饕哥、饕姐解谗。\r\n买肉一定要买带皮的五花肉，肥肉、瘦肉基本各占一半，一定要带猪皮，不然干脆不做。\r\n肉洗净切方块，2厘米见方，不用水焯，直接拿锅倒油适量（俺用花生油），油热后放肉入锅，炸！炸这道工序少不得，一是将肥肉里的猪油*出，吃起来不腻，二是可增加肉的香味（个人体验…………火不要太猛），炸到肉的外表有些金黄，停火，肉捞出，油倒出。\r\n另起锅，倒油适量，放入葱、姜、花椒煸炒，特别提醒，要放大蒜，略拍，去皮，不用切，整个放入，份量至少一头，一起煸炒至出香味，然后很重要——别忘放糖！冰糖最好，白糖也行，至少1汤匙，（俺是放2匙，）不用怕放多，肉是喜糖的。接着倒入酱油，不要太多。动作要快，不然糖会糊的。\r\n熬出汁后，倒入炸好的肉，翻炒一下，倒入清水（有骨头汤最好了，可惜俺没工夫熬），然后——上高压锅！（要是有时间，或没高压锅，那就慢慢炖吧，至少一小时，越烂越好，期间别忘添水）。高压锅里的水以略没过肉即可，加盐，加大料，大火烧开，盖上盖焖煮25分钟后，停火自然冷却，没压力后打开盖，再开火收汁，汁浓后，加味精一点，停火出锅.', '野鸡', '2000', '1', '2020-11-01 18:36:46', '600', '红烧肉可说是一家常菜，不同地方，不同人，做法肯定不一样。俺出来乍到，献上一道红烧肉，给各位饕哥、饕姐解谗。\r\n买肉一定要买带皮的五花肉，肥肉、瘦肉基本各占一半，一定要带猪皮，不然干脆不做。\r\n肉洗净切方块，2厘米见方，不用水焯，直接拿锅倒油适量（俺用花生油），油热后放肉入锅，炸！炸这道工序少不得，一是将肥肉里的猪油*出，吃起来不腻，二是可增加肉的香味（个人体验…………火不要太猛），炸到肉的外表有些金黄，停火，肉捞出，油倒出。\r\n另起锅，倒油适量，放入葱、姜、花椒煸炒，特别提醒，要放大蒜，略拍，去皮，不用切，整个放入，份量至少一头，一起煸炒至出香味，然后很重要——别忘放糖！冰糖最好，白糖也行，至少1汤匙，（俺是放2匙，）不用怕放多，肉是喜糖的。接着倒入酱油，不要太多。动作要快，不然糖会糊的。\r\n熬出汁后，倒入炸好的肉，翻炒一下，倒入清水（有骨头汤最好了，可惜俺没工夫熬），然后——上高压锅！（要是有时间，或没高压锅，那就慢慢炖吧，至少一小时，越烂越好，期间别忘添水）。高压锅里的水以略没过肉即可，加盐，加大料，大火烧开，盖上盖焖煮25分钟后，停火自然冷却，没压力后打开盖，再开火收汁，汁浓后，加味精一点，停火出锅.');
INSERT INTO `blog` VALUES ('2', '鱼香肉丝的做法', '1. 注：配料里(一汤匙=15ml、一茶匙=5ml)\r\n　　准备材料。黑木耳用温水泡发开洗净。\r\n　　2. 猪里脊肉顺势切成丝，先用一小撮盐和抓捏到发粘。\r\n　　3. 一茶匙干淀粉加一点水搅成水淀粉，加入肉丝中用手抓捏到全部被吸收。\r\n　　4. 最后加一汤匙色拉油，拌匀后腌制待用。\r\n　　5. 冬笋切片后入开水锅中煮两分钟，捞出切丝，胡萝卜去皮切丝，泡发的黑木耳切丝。准备好葱姜蒜末。\r\n　　6. 一汤匙干淀粉加三汤匙清水调匀成水淀粉，把料酒、醋、生抽、白糖、香麻油和水调匀成调味汁(材料调味汁部分的所有调料)。\r\n　　7. 锅烧热放油，在低油温时倒入肉丝大火煸炒到肉丝表面变色盛出备用。\r\n　　8. 用锅中余油煸炒姜蒜末小火炒出香味，再倒入剁椒一起炒出香味。\r\n　　9. 倒入冬笋丝、胡萝卜丝和黑木耳丝转大火翻炒一会儿，再倒入肉丝。\r\n　　10. 倒入步骤6准备好的调味汁，翻炒一分钟。\r\n　　11. 慢慢倒入水淀粉，边倒边炒，直到汤汁呈你想要的浓稠度，关火。\r\n　　12. 撒上葱花，出锅。', '深院空巷锁千秋 ', '2400', '1', '2019-11-23 18:39:55', '800', '1. 注：配料里(一汤匙=15ml、一茶匙=5ml)\r\n　　准备材料。黑木耳用温水泡发开洗净。\r\n　　2. 猪里脊肉顺势切成丝，先用一小撮盐和抓捏到发粘。\r\n　　3. 一茶匙干淀粉加一点水搅成水淀粉，加入肉丝中用手抓捏到全部被吸收。\r\n　　4. 最后加一汤匙色拉油，拌匀后腌制待用。\r\n　　5. 冬笋切片后入开水锅中煮两分钟，捞出切丝，胡萝卜去皮切丝，泡发的黑木耳切丝。准备好葱姜蒜末。\r\n　　6. 一汤匙干淀粉加三汤匙清水调匀成水淀粉，把料酒、醋、生抽、白糖、香麻油和水调匀成调味汁(材料调味汁部分的所有调料)。\r\n　　7. 锅烧热放油，在低油温时倒入肉丝大火煸炒到肉丝表面变色盛出备用。\r\n　　8. 用锅中余油煸炒姜蒜末小火炒出香味，再倒入剁椒一起炒出香味。\r\n　　9. 倒入冬笋丝、胡萝卜丝和黑木耳丝转大火翻炒一会儿，再倒入肉丝。\r\n　　10. 倒入步骤6准备好的调味汁，翻炒一分钟。\r\n　　11. 慢慢倒入水淀粉，边倒边炒，直到汤汁呈你想要的浓稠度，关火。\r\n　　12. 撒上葱花，出锅。');
INSERT INTO `blog` VALUES ('3', '吃', '吃的境界 《中庸》有言在先：“人莫不能饮食也，鲜能知味也。”吃饭是件容易的事，但能吃好的人极为稀少，不知其味，吃了白吃，白痴就是由白吃一词演化而来，所以，您每白吃一顿，就离白痴狠狠进了一步。清代袁枚说的好：“学问之道，先知而后行，饮食亦然。”那么这世界上到底有多少种味呢？我可以肯定没有人能说全了，就是发扬寓公移山的精神，子子孙孙挨着辈连轴转地吃也说不全、说不完，为什么呢？\r\n自然界能产生气味的物质有20～40万种，一般人所能辨识的有200～400种。中国烹饪采用的调味品可达500种左右。味可分为基本型和复合型两种。基本型有9种：酸、甜、苦、辣、咸、鲜、香、麻、淡。复合型则难以胜计，目前可归纳为50 种左右：一、酸味型：辣酸、甜酸、姜醋、番茄汁。\r\n二、甜味型：香甜、咸甜、蜜甜、水果。\r\n三、咸味型：香咸、酸咸、辣咸、椒盐、黄酱、腐乳、怪味。\r\n四、辣味型：胡椒、辣椒、芥末、生姜、大蒜、大葱、鱼香、家常。\r\n五、鲜味型：咸鲜、甜鲜、蚝油、蟹黄。\r\n六、麻味型：咸麻、辣麻。\r\n七、淡味型：淡香、本味。\r\n八、苦味型：咸苦、香苦。\r\n九、香味型：酒香、糟香、五香、十香、花香、清香、果香、奶香、烟香、糊香、腊香、孜然、豆豉、桂皮、陈皮、咖喱、芝麻、冷香、臭香。 这么多味，大家肯定晕了，不要紧，有一条线索可以作为救命稻草来抓住，这就是本味。要想知味，先得知道什么是本味。本味就是真味，是自然味，是味的基础。其他味是人为可造的，随心所欲，巧夺天工，曲意奉承，瞒天过海。但是，追求味的本意，追求味的真善美，以科学严谨的态度对待味，是要从娃娃开始抓起的。 明代陆树声在《清暑笔谈》中讲道：“都下庖制食物，凡鹅鸭鸡豚类，永远料物炮炙，气味辛浓，已失本然之味。夫五味主淡，淡则味真。昔人偶断羞食淡饭者曰：今日方知真味，向来几为舌本所瞒。” 这意思大有点迷途知返的精神，我们不是反对大鱼大肉地死吃，也不是一味地要求大家严守清汤寡水的戒律，而是希望大家在混乱中追求一点真味，油腻时讲究一点清纯，不为所惑，不为所动，心存一点平淡。 清代袁枚说：“使一物各献一性，一碗各成一味。”因此他提出忌火锅的理由也有一定的道理：“冬日宴客，惯用火锅，对客喧腾，已属可厌；且各菜之味，有一定火候，宜文宜武，宜撤宜添，瞬息难差。今一例以火通之，其味尚可问哉？近人用烧酒代炭，以为得计，而不知物经多滚，总能变味。”因此要想探索本味切不可去吃火锅，否则会南辕北辙。 在四大菜系中对本味相对比较重视的是淮扬菜，一个初学者最好是从淮扬菜开始吃起，有了这个基础后，再吃其他菜才能有对比，无论料怎么花，味怎么变，就能逐渐体会“有味者使其入，无味者使其出”的道理。 明代陈继儒在《养生肤语》中讲道：“日常所养，一赖五味，若过多偏胜，则五脏偏重，不唯不得养，且以伐矣。试以真味尝之，如五谷，如菽麦，如瓜果，味皆淡，此可见天地养人之本意，至味皆在淡中。今人务为浓厚者，殆失其味之正邪？” 这位先生的境界就更高了，他老人家把知味和养生联系起来了，真令人佩服得五股投地，其实何止是养生呢，哲学、伦理、生物、文化、卫生、宗教、科技，等等，哪一门学科不和知味紧密相关呢？只有我们尚未发现的的内在联系，而绝没有实际不存在的客观规律。 还有一些在野的好吃鬼，对味知不全，辨不清，评不出，但是能赏味，自我陶醉，钻牛角尖，他们的理论基础是“食无定味，适口者珍。” 也就是说，不管什么味，好吃就行，没必要研究味是怎么来的，怎么构成的，到了我的口里，我说好就好，不好你别吃。他们仅代表了一个特殊的群体，是以自身感觉和经验为是非标准的，或许也创造了一些灿烂的文化。 对味的认识是一种技艺，是古老的，无止境的，而它又不同于一般技艺，因为它有一定的思想性，历史性。艺术的饮食活动最核心的内容是提高人们对味的认识，通过知味、辨味、评味、赏味的过程，丰富了精神生活，创造出一种舌头上的世界观，用它比较现实生活中的善味，恶味，臭味，香味，霉味，美味，没味，酸味，甜味，苦味，辛辣味，腐败味，邪恶味，清新味，清高味。', '佚名', '3000', '1', '2018-04-23 18:40:57', '600', '吃的境界 《中庸》有言在先：“人莫不能饮食也，鲜能知味也。”吃饭是件容易的事，但能吃好的人极为稀少，不知其味，吃了白吃，白痴就是由白吃一词演化而来，所以，您每白吃一顿，就离白痴狠狠进了一步。清代袁枚说的好：“学问之道，先知而后行，饮食亦然。”那么这世界上到底有多少种味呢？我可以肯定没有人能说全了，就是发扬寓公移山的精神，子子孙孙挨着辈连轴转地吃也说不全、说不完，为什么呢？\r\n自然界能产生气味的物质有20～40万种，一般人所能辨识的有200～400种。中国烹饪采用的调味品可达500种左右。味可分为基本型和复合型两种。基本型有9种：酸、甜、苦、辣、咸、鲜、香、麻、淡。复合型则难以胜计，目前可归纳为50 种左右：一、酸味型：辣酸、甜酸、姜醋、番茄汁。\r\n二、甜味型：香甜、咸甜、蜜甜、水果。\r\n三、咸味型：香咸、酸咸、辣咸、椒盐、黄酱、腐乳、怪味。\r\n四、辣味型：胡椒、辣椒、芥末、生姜、大蒜、大葱、鱼香、家常。\r\n五、鲜味型：咸鲜、甜鲜、蚝油、蟹黄。\r\n六、麻味型：咸麻、辣麻。\r\n七、淡味型：淡香、本味。\r\n八、苦味型：咸苦、香苦。\r\n九、香味型：酒香、糟香、五香、十香、花香、清香、果香、奶香、烟香、糊香、腊香、孜然、豆豉、桂皮、陈皮、咖喱、芝麻、冷香、臭香。 这么多味，大家肯定晕了，不要紧，有一条线索可以作为救命稻草来抓住，这就是本味。要想知味，先得知道什么是本味。本味就是真味，是自然味，是味的基础。其他味是人为可造的，随心所欲，巧夺天工，曲意奉承，瞒天过海。但是，追求味的本意，追求味的真善美，以科学严谨的态度对待味，是要从娃娃开始抓起的。 明代陆树声在《清暑笔谈》中讲道：“都下庖制食物，凡鹅鸭鸡豚类，永远料物炮炙，气味辛浓，已失本然之味。夫五味主淡，淡则味真。昔人偶断羞食淡饭者曰：今日方知真味，向来几为舌本所瞒。” 这意思大有点迷途知返的精神，我们不是反对大鱼大肉地死吃，也不是一味地要求大家严守清汤寡水的戒律，而是希望大家在混乱中追求一点真味，油腻时讲究一点清纯，不为所惑，不为所动，心存一点平淡。 清代袁枚说：“使一物各献一性，一碗各成一味。”因此他提出忌火锅的理由也有一定的道理：“冬日宴客，惯用火锅，对客喧腾，已属可厌；且各菜之味，有一定火候，宜文宜武，宜撤宜添，瞬息难差。今一例以火通之，其味尚可问哉？近人用烧酒代炭，以为得计，而不知物经多滚，总能变味。”因此要想探索本味切不可去吃火锅，否则会南辕北辙。 在四大菜系中对本味相对比较重视的是淮扬菜，一个初学者最好是从淮扬菜开始吃起，有了这个基础后，再吃其他菜才能有对比，无论料怎么花，味怎么变，就能逐渐体会“有味者使其入，无味者使其出”的道理。 明代陈继儒在《养生肤语》中讲道：“日常所养，一赖五味，若过多偏胜，则五脏偏重，不唯不得养，且以伐矣。试以真味尝之，如五谷，如菽麦，如瓜果，味皆淡，此可见天地养人之本意，至味皆在淡中。今人务为浓厚者，殆失其味之正邪？” 这位先生的境界就更高了，他老人家把知味和养生联系起来了，真令人佩服得五股投地，其实何止是养生呢，哲学、伦理、生物、文化、卫生、宗教、科技，等等，哪一门学科不和知味紧密相关呢？只有我们尚未发现的的内在联系，而绝没有实际不存在的客观规律。 还有一些在野的好吃鬼，对味知不全，辨不清，评不出，但是能赏味，自我陶醉，钻牛角尖，他们的理论基础是“食无定味，适口者珍。” 也就是说，不管什么味，好吃就行，没必要研究味是怎么来的，怎么构成的，到了我的口里，我说好就好，不好你别吃。他们仅代表了一个特殊的群体，是以自身感觉和经验为是非标准的，或许也创造了一些灿烂的文化。 对味的认识是一种技艺，是古老的，无止境的，而它又不同于一般技艺，因为它有一定的思想性，历史性。艺术的饮食活动最核心的内容是提高人们对味的认识，通过知味、辨味、评味、赏味的过程，丰富了精神生活，创造出一种舌头上的世界观，用它比较现实生活中的善味，恶味，臭味，香味，霉味，美味，没味，酸味，甜味，苦味，辛辣味，腐败味，邪恶味，清新味，清高味。');
INSERT INTO `blog` VALUES ('4', '美食是熬出来的', '花生糖又香又甜又酥脆，采用最传统的方法做的花生糖是我的最爱。小时候，每到年末的时节，家家都要做上十多斤花生糖，作为来年家里人的零食或是客人来了招待客人的佳品。\r\n　　把花生放到锅里用小火不断翻炒，炒至九成熟放到簸箕里，等冷下来后用手不断揉搓，花生外面过着的那层红衣壳就和花生仁分开了，在风中一簸，就只剩下白色的花生仁了。\r\n　　在锅里倒进少许菜油加热把油烧熟，等油锅冷下来后倒入凉水，把切好的红糖和筛好的麦芽粉倒进锅里，大火让锅沸腾起来，不断翻搅，等锅里的糖水开始慢慢变得粘稠大量翻泡泡的时候，改用小火，这时候，翻搅得要勤，一直翻搅到底，不能粘锅，也不能糊锅。不能急躁，慢慢熬制糖稀，是做花生糖最为关键的一步。慢工出细活，锅里的糖稀越来越粘稠，期间得不时用一根筷子沾下糖稀，等筷子上的糖稀可以拉出丝时，尝一下糖稀是否变脆不粘牙，发果很脆不粘牙那就意味着糖稀熬好了。 \r\n　　把米花均匀地放在一个瓷盘里，把熬制好的糖稀用勺子倒在米花上，撒上炒熟的花生仁，让花生仁粘在米花上，在反复浇上糖稀，完全冷却下来的时候，花生糖就做好了。用刀子把花生糖切成一块块的形状，放进密封的塑料袋子里，吃的时候再拿出来，可以保存很长时间呢！\r\n　　忙了大半天的功夫，吃着香甜可口的花生糖，想着熬制糖稀的辛苦，我想，其实我们的生活也是像做花生糖一样，是用汗水一点点熬出来的，没有熬制过程的辛苦，怎么会有吃时的香甜呢？', '赵元波', '1500', '1', '2021-02-01 18:42:13', '400', '花生糖又香又甜又酥脆，采用最传统的方法做的花生糖是我的最爱。小时候，每到年末的时节，家家都要做上十多斤花生糖，作为来年家里人的零食或是客人来了招待客人的佳品。\r\n　　把花生放到锅里用小火不断翻炒，炒至九成熟放到簸箕里，等冷下来后用手不断揉搓，花生外面过着的那层红衣壳就和花生仁分开了，在风中一簸，就只剩下白色的花生仁了。\r\n　　在锅里倒进少许菜油加热把油烧熟，等油锅冷下来后倒入凉水，把切好的红糖和筛好的麦芽粉倒进锅里，大火让锅沸腾起来，不断翻搅，等锅里的糖水开始慢慢变得粘稠大量翻泡泡的时候，改用小火，这时候，翻搅得要勤，一直翻搅到底，不能粘锅，也不能糊锅。不能急躁，慢慢熬制糖稀，是做花生糖最为关键的一步。慢工出细活，锅里的糖稀越来越粘稠，期间得不时用一根筷子沾下糖稀，等筷子上的糖稀可以拉出丝时，尝一下糖稀是否变脆不粘牙，发果很脆不粘牙那就意味着糖稀熬好了。 \r\n　　把米花均匀地放在一个瓷盘里，把熬制好的糖稀用勺子倒在米花上，撒上炒熟的花生仁，让花生仁粘在米花上，在反复浇上糖稀，完全冷却下来的时候，花生糖就做好了。用刀子把花生糖切成一块块的形状，放进密封的塑料袋子里，吃的时候再拿出来，可以保存很长时间呢！\r\n　　忙了大半天的功夫，吃着香甜可口的花生糖，想着熬制糖稀的辛苦，我想，其实我们的生活也是像做花生糖一样，是用汗水一点点熬出来的，没有熬制过程的辛苦，怎么会有吃时的香甜呢？');
INSERT INTO `blog` VALUES ('5', '糖醋排骨的家常做法', '　糖醋排骨是糖醋味型中具有代表性的一道大众喜爱的特色传统名菜，它选用新鲜猪子排作料，肉质鲜嫩而且成莱色泽红亮油润。相信大多数人都吃过糖醋排骨，但是你知道糖醋排骨的做法吗?那么你知道糖醋排骨的家常做法吗？下面一起来看看糖醋排骨怎么做好吃吧。\r\n　　材料：\r\n　　肋排500克、香葱1棵、生姜1块、大蒜2瓣、淀粉适量、食用油500克(实耗45克)、酱油1/2大匙、香醋1大匙、精盐1/2小匙、白糖1大匙、味精1/2小匙。\r\n糖醋排骨的做法：\r\n1、小排500克焯水后，煮三十分钟，肉汤可以煮面条，别倒掉了。\r\n　　2、用一汤匙料酒，一汤匙生抽，半汤匙老抽，二汤匙香醋(不是白醋)腌渍20分钟。\r\n　　3、 捞出洗净控水备用，炸制金黄，油别放多，可以省油，只要翻身的勤就好了。\r\n　　4、锅内放排骨，腌排骨的水，三汤勺白糖。半碗肉汤大火烧开、调入半茶匙盐提味。\r\n　　5、 小火焖十分钟大火收汁，收汁的时候最后加一汤匙香醋，那个酸甜口就出来了。\r\n　　6、 临出锅撒葱花芝麻，少许味精。', '折了翼丶的鹰 ', '2135', '1', '2021-03-23 18:42:53', '532', '　糖醋排骨是糖醋味型中具有代表性的一道大众喜爱的特色传统名菜，它选用新鲜猪子排作料，肉质鲜嫩而且成莱色泽红亮油润。相信大多数人都吃过糖醋排骨，但是你知道糖醋排骨的做法吗?那么你知道糖醋排骨的家常做法吗？下面一起来看看糖醋排骨怎么做好吃吧。\r\n　　材料：\r\n　　肋排500克、香葱1棵、生姜1块、大蒜2瓣、淀粉适量、食用油500克(实耗45克)、酱油1/2大匙、香醋1大匙、精盐1/2小匙、白糖1大匙、味精1/2小匙。\r\n糖醋排骨的做法：\r\n1、小排500克焯水后，煮三十分钟，肉汤可以煮面条，别倒掉了。\r\n　　2、用一汤匙料酒，一汤匙生抽，半汤匙老抽，二汤匙香醋(不是白醋)腌渍20分钟。\r\n　　3、 捞出洗净控水备用，炸制金黄，油别放多，可以省油，只要翻身的勤就好了。\r\n　　4、锅内放排骨，腌排骨的水，三汤勺白糖。半碗肉汤大火烧开、调入半茶匙盐提味。\r\n　　5、 小火焖十分钟大火收汁，收汁的时候最后加一汤匙香醋，那个酸甜口就出来了。\r\n　　6、 临出锅撒葱花芝麻，少许味精。');
INSERT INTO `blog` VALUES ('6', '正宗川菜系宫保鸡丁的做法与技巧', '宫保鸡丁谁敢说没吃过那以后就不要在吃饭了，宫保鸡丁有很多种菜系的做法，川菜、鲁菜、北京菜、贵州菜都有自己做宫保鸡丁的方法，可以说是闻名中内外的一道菜谱，但是很多人都不知道宫保鸡丁怎么做，这里小冷就教大家宫保鸡丁的做法，其实想做一道正宗的宫保鸡丁还是有一定难度的，而且也是有一定的技巧的，如果没有经验的小伙伴肯定没那么容易做好，而且制作这道菜在选材上就有一定的讲究，比如淀粉一定要用豌豆粉，而不是普通的淀粉，还有鸡肉要选择鸡腿肉，而不是鸡胸肉，而且用料也非常多。\r\n原料：鸡腿两个、花生米一把；\r\n辅料：鸡蛋1个、小葱、生姜、蒜头、干辣椒、干花椒、黄瓜1根、青红酒、豌豆粉、花生油、白糖、香醋、生抽、老抽、辣椒面、盐；\r\n1、准备所有食材，把小葱切一段，黄瓜也切一段，鸡腿、干辣椒、干花椒准备好，然后在抓一把花生剥壳，剥成花生米；\r\n2、处理食材，然后把黄瓜段切成小块，小葱切葱花、生姜切小块，蒜头切片，干辣椒切两段备用；\r\n3、处理鸡腿，把鸡腿的骨头用刀给剔掉，然后用水浸泡下把血水给泡出来，泡好之后捞出来沥干切成小粒装到碗里，把鸡蛋戳个洞，让鸡蛋清流到鸡肉上，再放点青红酒、盐和豌豆粉搅拌均匀放着腌制，腌制的时间可以久点，放到冰箱去腌制几个小时，最好是能晚上放进去腌到第二天最入味，这一步也是制作宫保鸡丁最关键一步，很多人不腌制直接做所以不够入味；\r\n4、把锅烧热，加入适量花生油烧热，把刚剥好的花生米放下去小火炒至酥脆，然后装起来备用；\r\n5、在锅里下点花生油烧热，把生姜快、蒜头片和一半葱花放下去爆香下，然后加入干辣椒和花椒继续翻炒一会；\r\n6、此时可以把腌制好的鸡肉下锅去炒至变色；\r\n7、然后加入适量的盐、白糖、生抽、老抽、香醋和辣椒面调味，继续翻炒均匀，让鸡肉都均匀上色；\r\n8、接着把炒好的花生米、黄瓜和另外一半葱花加入继续翻炒一会，等差不多汁收干了即可出锅；\r\n9、炒好之后装盘，一碗色香味俱全的正宗川菜系宫保鸡丁就完成了；', '小张', '2140', '1', '2021-04-08 18:43:14', '621', '宫保鸡丁谁敢说没吃过那以后就不要在吃饭了，宫保鸡丁有很多种菜系的做法，川菜、鲁菜、北京菜、贵州菜都有自己做宫保鸡丁的方法，可以说是闻名中内外的一道菜谱，但是很多人都不知道宫保鸡丁怎么做，这里小冷就教大家宫保鸡丁的做法，其实想做一道正宗的宫保鸡丁还是有一定难度的，而且也是有一定的技巧的，如果没有经验的小伙伴肯定没那么容易做好，而且制作这道菜在选材上就有一定的讲究，比如淀粉一定要用豌豆粉，而不是普通的淀粉，还有鸡肉要选择鸡腿肉，而不是鸡胸肉，而且用料也非常多。\r\n原料：鸡腿两个、花生米一把；\r\n辅料：鸡蛋1个、小葱、生姜、蒜头、干辣椒、干花椒、黄瓜1根、青红酒、豌豆粉、花生油、白糖、香醋、生抽、老抽、辣椒面、盐；\r\n1、准备所有食材，把小葱切一段，黄瓜也切一段，鸡腿、干辣椒、干花椒准备好，然后在抓一把花生剥壳，剥成花生米；\r\n2、处理食材，然后把黄瓜段切成小块，小葱切葱花、生姜切小块，蒜头切片，干辣椒切两段备用；\r\n3、处理鸡腿，把鸡腿的骨头用刀给剔掉，然后用水浸泡下把血水给泡出来，泡好之后捞出来沥干切成小粒装到碗里，把鸡蛋戳个洞，让鸡蛋清流到鸡肉上，再放点青红酒、盐和豌豆粉搅拌均匀放着腌制，腌制的时间可以久点，放到冰箱去腌制几个小时，最好是能晚上放进去腌到第二天最入味，这一步也是制作宫保鸡丁最关键一步，很多人不腌制直接做所以不够入味；\r\n4、把锅烧热，加入适量花生油烧热，把刚剥好的花生米放下去小火炒至酥脆，然后装起来备用；\r\n5、在锅里下点花生油烧热，把生姜快、蒜头片和一半葱花放下去爆香下，然后加入干辣椒和花椒继续翻炒一会；\r\n6、此时可以把腌制好的鸡肉下锅去炒至变色；\r\n7、然后加入适量的盐、白糖、生抽、老抽、香醋和辣椒面调味，继续翻炒均匀，让鸡肉都均匀上色；\r\n8、接着把炒好的花生米、黄瓜和另外一半葱花加入继续翻炒一会，等差不多汁收干了即可出锅；\r\n9、炒好之后装盘，一碗色香味俱全的正宗川菜系宫保鸡丁就完成了；');
INSERT INTO `blog` VALUES ('7', '酸菜鱼', '导语：鱼的做法有非常的多，那么我们在家的时候怎么做才是最美味的呢，以下是小编收集的它的美味做法大全，大家可以学习下哦。\r\n　　　原料：草鱼1条、酸菜1小把、鸡蛋白、野山椒、油、盐、鸡精2克、姜5克、蒜5克、料酒、淀粉、白糖2克、香菜、胡椒粉、剁椒\r\n　　做法：\r\n　　1.鱼头鱼骨剁块，鱼身上的肉片则斜切成鱼片，分别加入盐，料酒，淀粉和少许蛋清抓匀腌制10分钟左右。\r\n　　2.酸菜洗净用手挤干水分，切成块;姜蒜，泡野山椒，小米椒剁碎。\r\n　　3.热锅上油烧热，下切好的姜蒜末，泡野山椒末，小米椒丁炒香，倒入酸菜翻炒后倒入足量开水大火烧开。\r\n　　4.将鱼头鱼骨放入再次煮开后，转中小火，加盐、白糖、胡椒粉调味，加2勺泡椒水再煮15分钟左右。\r\n　　5.将腌好的鱼片放入汤中，稍凝固后用筷子划散，等鱼片煮至变色，加鸡精提味后盛出，浇少许热油，撒上香菜即可。', '忧桑君', '4235', '1', '2021-04-01 18:44:03', '1234', '导语：鱼的做法有非常的多，那么我们在家的时候怎么做才是最美味的呢，以下是小编收集的它的美味做法大全，大家可以学习下哦。\r\n　　　原料：草鱼1条、酸菜1小把、鸡蛋白、野山椒、油、盐、鸡精2克、姜5克、蒜5克、料酒、淀粉、白糖2克、香菜、胡椒粉、剁椒\r\n　　做法：\r\n　　1.鱼头鱼骨剁块，鱼身上的肉片则斜切成鱼片，分别加入盐，料酒，淀粉和少许蛋清抓匀腌制10分钟左右。\r\n　　2.酸菜洗净用手挤干水分，切成块;姜蒜，泡野山椒，小米椒剁碎。\r\n　　3.热锅上油烧热，下切好的姜蒜末，泡野山椒末，小米椒丁炒香，倒入酸菜翻炒后倒入足量开水大火烧开。\r\n　　4.将鱼头鱼骨放入再次煮开后，转中小火，加盐、白糖、胡椒粉调味，加2勺泡椒水再煮15分钟左右。\r\n　　5.将腌好的鱼片放入汤中，稍凝固后用筷子划散，等鱼片煮至变色，加鸡精提味后盛出，浇少许热油，撒上香菜即可。');
INSERT INTO `blog` VALUES ('8', '梅菜扣肉正宗做法', '导语：梅菜扣肉，肉烂味香，吃起来咸中略带甜味，肥而不腻，是特色传统名菜，属粤菜客家菜，其中以广东梅州最具代表性。下面一起来跟小编学习没菜扣肉的做法吧。\r\n食材：\r\n　　主料:五花肉1000g,梅干菜200g\r\n　　辅料:油适量，盐适量，酱适量，冰糖碎适量，腐乳汁适量\r\n　　做法：\r\n　　1.把猪肉的肉皮刮洗干净，放入冷水锅中，大火煮至八成熟。\r\n　　2.捞出擦去水分，趁热抹上酱油。\r\n　　3.炒锅倒油，烧至八成热时，将五花肉皮朝下放入锅中炸至呈深红色，捞出晾凉。\r\n　　4.把炸好的五花肉切成大长片。\r\n　　5.取一大碗，倒少许油和冰糖碎抹匀。\r\n　　6.将肉片的肉皮朝下，整齐地码在碗内。\r\n　　7.梅干菜泡软洗净，锅中放少许油，将洗净的梅菜倒入锅中，调入生抽、腐乳汁翻炒均匀，关火。\r\n　　8.肉上放上炒过的梅干菜，入蒸锅蒸约30分钟至肉软烂，或者放入高压锅中，蒸熟也可。关火后取出肉碗，用圆盘盖在上面，滗出汤汁，再将碗倒扣在盘中，大火烧热炒锅，将倒出的汤汁烧开，熬至浓稠，淋在肉上即可。', '农民范', '2400', '1', '2021-04-11 18:44:40', '234', '导语：梅菜扣肉，肉烂味香，吃起来咸中略带甜味，肥而不腻，是特色传统名菜，属粤菜客家菜，其中以广东梅州最具代表性。下面一起来跟小编学习没菜扣肉的做法吧。\r\n食材：\r\n　　主料:五花肉1000g,梅干菜200g\r\n　　辅料:油适量，盐适量，酱适量，冰糖碎适量，腐乳汁适量\r\n　　做法：\r\n　　1.把猪肉的肉皮刮洗干净，放入冷水锅中，大火煮至八成熟。\r\n　　2.捞出擦去水分，趁热抹上酱油。\r\n　　3.炒锅倒油，烧至八成热时，将五花肉皮朝下放入锅中炸至呈深红色，捞出晾凉。\r\n　　4.把炸好的五花肉切成大长片。\r\n　　5.取一大碗，倒少许油和冰糖碎抹匀。\r\n　　6.将肉片的肉皮朝下，整齐地码在碗内。\r\n　　7.梅干菜泡软洗净，锅中放少许油，将洗净的梅菜倒入锅中，调入生抽、腐乳汁翻炒均匀，关火。\r\n　　8.肉上放上炒过的梅干菜，入蒸锅蒸约30分钟至肉软烂，或者放入高压锅中，蒸熟也可。关火后取出肉碗，用圆盘盖在上面，滗出汤汁，再将碗倒扣在盘中，大火烧热炒锅，将倒出的汤汁烧开，熬至浓稠，淋在肉上即可。');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `Com_ID` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `Com_BlogID` bigint(255) NOT NULL COMMENT '评论的文章ID',
  `Com_ParentID` bigint(255) DEFAULT '0' COMMENT '父评论ID',
  `Com_Likes` bigint(255) DEFAULT '0' COMMENT '点赞量',
  `Com_UserID` bigint(255) NOT NULL COMMENT '发表用户ID',
  `Com_Date` datetime NOT NULL COMMENT '评论日期',
  `Com_Content` longtext NOT NULL COMMENT '评论内容',
  PRIMARY KEY (`Com_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `Launch_ID` bigint(255) NOT NULL COMMENT '发起方用户ID（也就是关注别人的用户ID)',
  `Receive_ID` bigint(255) NOT NULL COMMENT '接收方用户ID（也就是被关注用户）',
  `Follow_Type` int(10) NOT NULL DEFAULT '1' COMMENT '行为(0代表取消关注；1代表关注)',
  PRIMARY KEY (`Launch_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follow
-- ----------------------------

-- ----------------------------
-- Table structure for headimg
-- ----------------------------
DROP TABLE IF EXISTS `headimg`;
CREATE TABLE `headimg` (
  `img_ID` int(10) NOT NULL AUTO_INCREMENT,
  `img_Percorso` varchar(100) NOT NULL,
  PRIMARY KEY (`img_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of headimg
-- ----------------------------
INSERT INTO `headimg` VALUES ('1', '/img/HeadImg/a.png');
INSERT INTO `headimg` VALUES ('2', '/img/HeadImg/1.jpg');
INSERT INTO `headimg` VALUES ('3', '/img/HeadImg/2.jpg');
INSERT INTO `headimg` VALUES ('4', '/img/HeadImg/3.jpg');
INSERT INTO `headimg` VALUES ('5', '/img/HeadImg/4.jpg');
INSERT INTO `headimg` VALUES ('6', '/img/HeadImg/5.jpg');
INSERT INTO `headimg` VALUES ('7', '/img/HeadImg/6.jpg');
INSERT INTO `headimg` VALUES ('8', '/img/HeadImg/7.jpg');
INSERT INTO `headimg` VALUES ('9', '/img/HeadImg/8.jpg');
INSERT INTO `headimg` VALUES ('10', '/img/HeadImg/9.jpg');
INSERT INTO `headimg` VALUES ('11', '/img/HeadImg/10.jpg');
INSERT INTO `headimg` VALUES ('12', '/img/HeadImg/11.jpg');
INSERT INTO `headimg` VALUES ('13', '/img/HeadImg/12.jpg');
INSERT INTO `headimg` VALUES ('14', '/img/HeadImg/13.jpg');
INSERT INTO `headimg` VALUES ('15', '/img/HeadImg/14.jpg');
INSERT INTO `headimg` VALUES ('16', '/img/HeadImg/15.jpg');
INSERT INTO `headimg` VALUES ('17', '/img/HeadImg/16.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `User_ID` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `User_IP` varchar(255) DEFAULT NULL COMMENT '用户IP',
  `User_Name` varchar(255) NOT NULL COMMENT '用户名',
  `User_Pass` varchar(255) NOT NULL COMMENT '用户密码',
  `User_Email` varchar(255) NOT NULL COMMENT '用户邮箱',
  `User_RegTime` datetime NOT NULL COMMENT '用户注册时间',
  `User_Birthday` datetime DEFAULT NULL COMMENT '用户生日',
  `User_Age` int(255) NOT NULL DEFAULT '0' COMMENT '用户年龄',
  `User_HeadImg` bigint(255) NOT NULL DEFAULT '1' COMMENT '用户头像(对应头像表中的ID)',
  `User_FansNumber` bigint(11) NOT NULL DEFAULT '0' COMMENT '用户粉丝数量',
  PRIMARY KEY (`User_ID`),
  KEY `headimg_imgID_Fk` (`User_HeadImg`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '127.0.0.1', 'Jaoden', '123123', '1835784566@qq.com', '2021-04-23 14:25:06', '1999-05-25 14:25:08', '22', '1', '0');
