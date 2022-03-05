package com.example.reader.logic.global

import com.example.reader.logic.model.NovelDataModel
import com.example.reader.logic.model.UserDataModel
import okhttp3.Cookie

object GlobalVarible {
     var downLoadBook=ArrayList<NovelDataModel.Book>()
     var collectionBook=ArrayList<NovelDataModel.Book>()
     var Online:Boolean = false
     lateinit var User:UserDataModel.User
     var BookList=ArrayList<NovelDataModel.Book>()//临时设计的全局变量
     var cookieList= mutableListOf<Cookie>()
     var url:String="https://0236-120-36-50-161.jp.ngrok.io"
     var LocalMode:Boolean=false
     var once=false
     val Texttest="可堇-bad end1\n" +
             "触发条件：可可没有在nonfiction开演之前认可堇，关键道具王冠未得到。\n" +
             "\n" +
             "（liella全员上台，鞠躬准备开演。）\n" +
             "堇：（看着台下的观众，再用余光看了看在自己左手边的可可，心里突然升起了一股紧张感）\n" +
             "（音乐响起）\n" +
             "堇：【没问题的，一定没问题的】\n" +
             "堇：“Hey，......”（看了一眼台下，突然卡住）\n" +
             "堇：【怎么回事，不要紧张啊平安名堇，快唱出来啊，下一句歌词是什么，快从嘴里唱出来啊】\n" +
             "（台下看见堇的突然卡壳，观众席开始骚动。）\n" +
             "观众A：“这是怎么回事啊，怎么不都是之前那个橙头发的小姑娘来领唱吗，怎么换了个不认识的小姑娘啊”\n" +
             "观众B：“是啊，怎么唱个歌还卡壳了呢，台下的时候究竟有没认真练习啊，不要上来抹黑lovelive的舞台好不好。”\n" +
             "观众C：“下去吧你！”\n" +
             "众观众：“下去！别在这里丢人现眼！”\n" +
             "（感受着舞台下观众们的嘘声，平安名堇眼前一黑晕了过去。）\n" +
             "\n" +
             "屏幕红字：LIVE失败\n" +
             "\n" +
             "\n" +
             "高中毕业一年后，liella练习的天台。\n" +
             "堇：（坐在天台边打开一罐啤酒，一边喝一边对着可可之前送她的具足虫头套自言自语。）\n" +
             "堇：“在那场live之后，已经过去三年了啊。”\n" +
             "堇：“结果，可可还是回上海了。”\n" +
             "堇：（把具足虫头套举到自己面前，与其对视）\n" +
             "堇：“因为我的无能，因为我的懦弱。”\n" +
             "堇：“是我亲手，葬送了可可的梦想。真是个没出息的具足虫。”\n" +
             "堇：“不但葬送了可可的梦想，还让香音再次唱不出声，香音也一定…非常恨我吧。”\n" +
             "堇：“还有恋也是，那场live以后，结丘第二年的入学希望人数没有增加，也没有拉到足够的赞助，一年不如一年。结丘在我们毕业的那年同时废校了，我们成了结丘最后一届毕业生………”\n" +
             "堇：“虽然毕业典礼的时候，她笑着说不后悔，但是躲在卫生间的哭声我可是全听见了………”\n" +
             "堇：“如果，如果那个时候我再拿出一些勇气的话，如果我不是那么懦弱的话，是不是，结果就会变得不一样呢？”\n" +
             "堇：“可可的梦想就能继续下去，香音也不会因为那场失败的live再次失声，结丘说不定也能延续下去。”\n" +
             "堇：“说到底，都是因为我是个无能的笨蛋具足虫，什么galaxy的演艺圈偶像啊，连业余的大赛都比不好，还算什么galaxy偶像啊！不就只是一个骄傲自大的废物而已吗！”\n" +
             "堇：（捏瘪手中的酒罐，站起身来）\n" +
             "堇：“啊哈，这个天台真高呢，从这里跳下去的话，就能有一个废物该有的下场了吧。”\n" +
             "堇：（戴上具足虫头套）\n" +
             "堇：“gusogumuxi~gusogumuxi~哈哈哈”\n" +
             "堇：（从天台跳下）\n" +
             "堇：“再见了，下辈子，就让我做一个具足虫吧。\n"

     val Textlocal="[不知不觉一年了呢，目想起这一年来，喜悦也有，烦恼也有。但是,我得到了我这毕生唯一\n" +
             "的挚爱——平安名堇。]我盯着窗外，看的有些出神。\n" +
             "［女士们，先生们：\n" +
             "飞机已经降落在0-2机场，外面温度3摄氏度，飞机正在滑行,为了您和他人的安全,请先\n" +
             "不要站起或打开行李架。\n" +
             "等飞机完全停稳后，请你再解开安全带，,整理好手提物品准备下飞机。从行李架里取物品\n" +
             "时，请注意安全。\n" +
             "您交运的行李请到行李提取处领取。需要在本站转乘飞机到其他地方的旅客请到候机室中转\n" +
             "柜办理。\n" +
             "感谢您选择XX航空公司班机!下次旅途再会！］\n" +
             "突然，飞机的广播声打断了我的思绪。\n" +
             "“堇～飞机要到站了哟，醒醒了。”我推了推身边咁睡的恋人。\n" +
             "“嗯…已经要到了吗？！”\n" +
             "［女士们，先生们：\n" +
             "本架飞机已经完全停稳，请您从前登机门下飞机。谢谢！］\n" +
             "“嗯！走吧。”“嗯…”\n" +
             "…………\n" +
             "…………\n" +
             "我们一同走出机场“奈～堇你的脸色不太好奥～”从下飞机我就开始发觉了，应该是即将见\n" +
             "到我父母了，很紧张吧。\n" +
             "“哎？哎！有吗？”她听到后，变的慌张起来。\n" +
             "“噗…哈哈哈…有哟，很明显哟～”\n" +
             "“唔……”\n" +
             "“不用害怕，我父母很和善的。”我快步走向她前面，轻轻在她额头落下一吻。\n" +
             "“走了！”我反扣住她的手，握着她的手向出口走去。\n" +
             "“堇，可可这里！”我望到母亲向我们招手，“这里。”拉住她的手力气又用大了些。\n" +
             "“这是我母亲—诹访半夏。”我说着将堇向前拉了一下\n" +
             "“妈，这是你女儿未来的媳妇儿。”我笑着将旁边的堇向前推了推。\n" +
             "“お母さん、平安民すみれです”她真是一紧张就会说日语呢。\n" +
             "“妈，她说她叫平安民堇，是您女儿未来的媳妇。”我特意加了一些没必要的话。\n" +
             "“孩子真漂亮，听可可说还会做饭，怎么看上我家可可了呢。你看她做饭不会，睡觉还不老\n" +
             "实。”我母亲脸上的笑意更浓了，同时又开始了“贬低”我。\n" +
             "“妈—!我们还是先回家吧。”我连忙打断了她。\n" +
             "“好好，你这孩子总不让人说话。你学学人小堇多乖。”她朝堇一笑。\n" +
             "“母亲，过奖了。”堇笑着回礼。\n" +
             "“妈——！到底誰才是你亲生女儿！”我有些赌气。\n" +
             "“两个都是我的好女儿。”她笑着回应。\n" +
             "…………\n" +
             "堇看着我们在不断的嬉戏打闹中回到了家。\n" +
             "…………\n" +
             "“爸，姐姐你们好”这次她没上次那么紧张了，表现的很自然。\n" +
             "“哎——这就是小堇吗？长的真漂亮呢，奈—可可，告诉姐姐你怎么撩到的？”“宣娇，不许\n" +
             "胡闹了。”“是是是。”我姐姐的恶趣味被父亲一句话就压了下去。\n" +
             "“我去做饭你们先聊”我母亲走向厨房\n" +
             "“妈，我也可以帮忙的。”说着，堇就向厨房走去。\n" +
             "“不行不行，怎么可以让你做饭呢。”我妈连忙拒绝了堇。\n" +
             "“没事的，我喜欢做家务。”\n" +
             "“好好好，真是好孩子。”说后就和堇进了厨房，临进门还不忘撇我一眼。\n" +
             "［……谁到底才是她女儿啊……］“奈—，快告诉姐姐，你怎么追到她的。”旁边的姐姐出\n" +
             "言打断了我的思绪。\n" +
             "“我们啊——”“怎么！怎么！”我看着姐姐嬉笑的口舌。\n" +
             "“是一见钟情奥！砰！”说着，我抓起旁边的本子，对着她头顶就是一拍。\n" +
             "“你们两个天天就会闹，还给人留个好印象吗。”我父亲说后，瞥了一眼，接着就继续看自\n" +
             "己的早报。\n" +
             "“就是啊，我的好妹妹，小心被人抢跑奥。”她还是在不断的嬉笑。\n" +
             "“啊啦～我对别的没保证，但是对于堇对我的爱可是十分确信呢～”你看看“这是堇送给我的\n" +
             "御守哟～她亲自编的哟～”我拿出堇送我的御守，不停的在她面前晃。\n" +
             "“不就是一个御守吗，能确定什么啊？”\n" +
             "“阿啦～我可是记得某人已经二十四了，却到现在还没有过对象。”\n" +
             "“唐！可！可……”“好了，你两个别吵了，过来端菜吃饭了。”母亲的话打断了两人的争\n" +
             "执。\n" +
             "“没想到，小堇还会做这么多菜呢。”我注意到我母亲脸上的笑意越来越浓了。\n" +
             "“小堇，吃这个。”我看着我母亲不断的向堇的碗里夹菜。\n" +
             "“谢谢妈。妈吃这个，尝尝我的手艺。”看着她们两人互相夹菜，我觉得我就不像她女儿。\n" +
             "“哎～吃不下了，吃饱了。”我将碗筷放下，向后一仰。碗里还剩了小半碗米饭，和一个鸡\n" +
             "翅。\n" +
             "“别浪费，给我吧。”说着，堇拿过我的碗，二话也不说的吃了起来。\n" +
             "几人看到这场面愣起来“堇，那是我的剩饭啊。”从小时候就父母吃过我的剩饭，看到堇在\n" +
             "吃我觉得有些怪异。\n" +
             "“可可，你这个习惯要改，不能总让堇吃你的剩饭。还有，堇不用一直宠着她，该她干的就\n" +
             "让她干。”说后，她便露出淡淡的笑容。\n" +
             "“妈，您别这样说。”她向我露出无比温暖的笑意“我喜欢宠着她，无论她想干什么。”\n" +
             "“看到没有，我老婆多宠我。”我笑着向父母炫耀，同时向姐姐瞥了一眼。\n" +
             "“小堇她宠你是你的福气知道吗，你可要好好爱着她。”\n" +
             "“啊对对对，饭桌上不要数落人。”我急忙打断了她。\n" +
             "时间不断在嘈杂声中不断流逝，我听着［叮呤咣啷］的洗碗声、母亲与堇交流的声音。\n" +
             "“可可这孩子任性，不要总惯着她。”我隐约听着我母亲一遍一遍的嘱咐堇。\n" +
             "“嗯，好的妈，我会好好照顾她的。”每次堇都是一样的答案。\n" +
             "“奈——堇我们要不要出去逛逛啊。”我站在厨房门口。\n" +
             "“哎—可这里还要帮忙。”堇回头看向还未洗完的碗筷。\n" +
             "“没事，你们先去玩吧，这里我来就行。可可，要好好照顾堇，听到没有！”\n" +
             "“好好好，我知道了。”\n" +
             "来到琳琅满目的商店街“老婆想要买什么？”“就你那次说的煎饼果子吧。”“嗯，好我去买，\n" +
             "你在这里等着。”说罢，我就走向旁边的小店。\n" +
             "“堇，你的。”我将煎饼果子递给她，坐到她旁边。\n" +
             "“怎么样好吃吗？”\n" +
             "“嗯……好吃。”\n" +
             "…………\n" +
             "“这一年要过去了呢。”我看着她望着天空。\n" +
             "“这一年不也挺好的吗，结识了我毕生的爱人，结识了你。”\n" +
             "“我们去别处逛逛吧！”“嗯！”两人相视一笑，我拉着她的手不断穿梭在人群中。\n" +
             "“可可！？你什么时候回来的啊。”一声熟悉且陌生的声音响起。\n" +
             "“你是…张雨梦，好久不见了呢。”\n" +
             "“堇，这个是张雨梦，是我的初中同学。”我笑着向堇介绍。\n" +
             "“雨梦小姐，你好。”堇笑着向她打招呼。\n" +
             "“哎，这位是…”她对突如其来的金发少女感到疑惑。\n" +
             "“奥，忘了介绍了，她是我的恋人——平安民堇”“哎！？这样吗，祝你们新的一年幸福\n" +
             "奥。”不知不觉中我笑的更浓了，她明显有些惊讶。\n" +
             "“雨梦，在和谁聊呢，要走了。”“好，可可 堇回头见了，我女朋友叫我了。”“哎—小雨梦也\n" +
             "找女朋友了吗？看样子是个大美人哟？”我不断的戏弄她。\n" +
             "“说什么呢，先走了。”她鼓鼓嘴，向另一边走了。\n" +
             "“可可，这样戏弄别人不好吧。”堇一脸担忧的看着我。\n" +
             "“没什么有关系啦，好了，我们继续逛街吧。”我继续拉着堇不断的走来走去。\n" +
             "路上我突然想到了什么“堇，我有些事情，在这里等我一会。”\n" +
             "时间随嬉戏打闹而过，天边渐渐泛起黄昏。\n" +
             "“回家吧。”“嗯。”\n" +
             "路上我突然想到了什么“堇，我有些事情，在这里等我一会。”“嗯。”她看着我走向远处，\n" +
             "有看着我急匆匆的回来。\n" +
             "“买了什么嘛？”\n" +
             "“嘿嘿，现在不能告诉你。”\n" +
             "“走吧，快回家了。”\n" +
             "我牵住她的手，拉着她向家的地方跑去。\n" +
             "…………\n" +
             "「吱…哐当…」\n" +
             "“回来啦，洗洗手，快过来吃饭吧。”刚进门就见到母亲向我们招手。\n" +
             "“嗯，好。”\n" +
             "“可可，有没有好好照顾小堇啊？”我刚坐下，母亲就开始质问我。\n" +
             "“有啦有啦。”\n" +
             "“看样子是没照顾好。”\n" +
             "“唐宣娇！”我生气的瞪着姐姐。\n" +
             "“行了行了，你们两个，天天就是闹闹闹，多学学人家小堇，你看看多乖，来，多吃一\n" +
             "点。”说着，我母亲又向堇碗里夹了一个鸡翅。\n" +
             "“嗯嗯，谢谢妈。”\n" +
             "“妈，到底誰才是您亲闺女啊。”\n" +
             "“三个都是我的好女儿，快吃饭。”\n" +
             "“啊好好好”\n" +
             "晚饭时间在愉快的气氛中渐渐走过。\n" +
             "…………\n" +
             "客厅里，四人在看电视，我无趣的掰着手指头“嘶……”用力比较大，有些掰痛了。\n" +
             "“可可，怎么了嘛？”\n" +
             "“哎…没什么。小具足虫，我们回屋吧。”我露出坏笑。\n" +
             "“哎？！现在吗？这又不好吧。”堇明显对我的要求有些震惊。\n" +
             "“嘿嘿，没事啦，我父母不会在意的。”说着我拉着她的手回了屋。\n" +
             "「哐当」我将门锁好，回过头来，我将衣服褪下，扔掉落地窗傍。\n" +
             "“小具足虫～”我像许久没进食的饿狼一般扑向堇。\n" +
             "“唔……”我吻住她的嘴唇，用舌尖顶顶她的牙齿，示意她开门，我将舌尖刺入，舌与舌的\n" +
             "纠缠，那如漆似胶的纠缠，如同漩涡般将两人卷入欲望的海底。\n" +
             "“呼…呼……”持续了许久，这热吻才彻底停下，两人急促的吸食着这来之不易的空气。\n" +
             "我整个人跨坐在她身上，我一个一个的将她的衣扣解开，将她的衬衫褪下。\n" +
             "“唔……”唇与唇再次接触，我双手插在她背后将胸罩解开，抽出来扔到一边。\n" +
             "“呼…呼…”我将她推到，硕大的果实映入眼帘。我双手抚上那乳白，开始不断的把玩着那\n" +
             "嫩红的花骨朵。\n" +
             "我凑到她耳边“又大了，小心以后会垂哟。”“那你可要给我托好了，别让她垂下来。”她轻\n" +
             "轻在我耳边吹了一口气“那是自然，我怎么舍得放手。”说着我吻上她的颈间，渐渐向下滑去，\n" +
             "舔舐着她的锁骨。\n" +
             "我渐渐向下滑去，最终目标停在那硕大的如白上，我张口含住那嫩红的花骨朵“唔…\n" +
             "唔…”耳边满是她的呜咽声。\n" +
             "我不断的用舌尖挑逗着那花骨朵“可…可，另…另一边…也要。”强烈的刺激让堇说话有些\n" +
             "断断续续，我将左手抚上另一边，用指尖代替舌尖，不断的捏玩着那挺立的花骨朵。\n" +
             "耳边的呜咽声越来越频繁，我放弃进攻，离开那诱人的果实，渐渐退到后面。\n" +
             "“哎？！可可你要干什么！”我将她的下衣褪下“嗯……你猜。”我脸上露出一抹邪笑。\n" +
             "双手将她的腿撑开“什么嘛，都已经湿透了。”我将嘴唇附上那花园“可可…那里很脏\n" +
             "的……”她伸出手用力的推着我“没有，堇那里才不脏。”我将舌尖刺入，不停的冲撞，顶刺着那\n" +
             "敏感点。\n" +
             "“可…啊…可…嗯…要……要…去了”她激烈的弓，我被她用力的夹在谷间，双手死死摁住\n" +
             "我的头部。\n" +
             "“唔…唔…”我将那溢出的花蜜一丝不剩的咽入腹中，即使我将大部分揽入口中，也有少量\n" +
             "溅出。\n" +
             "「铛铛……」“可可啊，你们两个小点声。”母亲的声音在门外响起“奥……好的！”我看向\n" +
             "她，上前吻住她，起身时一滴液体，落到她脸上，渐渐划到她嘴里。\n" +
             "“这是什么…你哭了……？”这时我才意识到刚才的行为多么羞耻“老婆…你自己的味道怎么\n" +
             "样。”\n" +
             "“哎？！”四目相对，两人羞的脸红“还…做吗……？”\n" +
             "「砰…砰砰…」窗外的烟火声打断了局面“看烟花吧，回日本再做。”“嗯”两人蹲在落地窗\n" +
             "前静静的看着窗外，窗外的烟火在天空中溅射。\n" +
             "“等会有个惊喜哟～”“嗯……？”“没什么，好好看烟花吧。” 「愛してるよ平安民すみれ!」\n" +
             "巨大的日语在空中溅射。\n" +
             "“哎？！这是你定制的？”看到好看的场面了“嗯，不错吧。还有一份礼物哟。”我将扔在旁\n" +
             "边的上衣拿过，从口袋拿出一个中国结发卡。\n" +
             "“收了，就是我的人了，一辈子都要爱着我。”我将手中的中国结发卡晃来晃去。\n" +
             "“那我不收了。”\n" +
             "“哎！？？”\n" +
             "“我要你每天给我带上。”\n" +
             "“哼！狡猾。”\n" +
             "“就算不收也会一直爱着你的。”\n" +
             "“那你不要了？”\n" +
             "“要！”她一把将我手中的发卡夺去。\n" +
             "“噗哈哈哈哈”四目相射“以后要永远永远在一起。”\n" +
             "窗外的烟火转瞬即逝，但这刻的美好永存心中………\n"
     val introduction="出生于中国上海。本人：纯上海人。\n" +
             "2013年第一次cos，cos角色是呆唯。后来被本人吐槽化妆技术完全看不下去。\n" +
             "早年曾以“黎狱Ritsuki”“黎狱Ristuki”名义进行Cosplay活动。高三时被妈妈说了后停止一年。\n" +
             "2015年进入大学学习商品设计包装设计，据本人说也是妈妈的意思，自己没太大兴趣，设计过一些饭团或者小零食的包装。\n" +
             "2018年与Horipro International事务所签约成为艺人。\n" +
             "2019年6月举办首次个人Fan Meeting活动「Liyuu ファンミーティングVOL1」。\n" +
             "2019年从大学毕业（2021年2月的直播中称毕业一年多）。大学学的是平面设计。\n" +
             "2020年1月，演唱TV动画《奇幻怪盗》片头曲《Magic Words》发售，正式作为歌手出道。\n" +
             "2020年10月，事务建立了Liyuu的Fan Club，名为YuU Koi Days，以app的形式发放一些会员限定的视频和内容，以及提供会员限定的周边商城。\n" +
             "于2020年12月14日宣布成为LoveLive!系列新企划LoveLive!Superstar!!成员之一的唐可可的声优。是LL系列企划第一位中国人主役，也是LL系列企划第一位外国人主役。其实Liyuu是一位2012年入坑的老拉拉人，拉拉人终成拉拉人！[2][3]\n" +
             "个人日语广播节目「Liyuuのはつらじ」从2021年2月26日起每周五上线。\n" +
             "2021年5月23日在个人活动上宣布粉丝名为鲤友（こいとも）。\n" +
             "2022年2月9日，首张个人专辑《Fo(u)r YuU》正式发售。\n" +
             "2022年2月11日，首次个人演唱会《Fo(u)r YuU》在横滨国际平和会议场举办，并在Bilibili同步转播。\n" +
             "人物\n" +
             "兴趣是欣赏音乐和动画。\n" +
             "特技为绘画、饶舌、唱歌。因为是学绘画出身，自称画技其实还可以。在这个画伯遍地走的LoveLive!系列里，已经算是非常好的了。\n" +
             "身高（167.8cm）在Liella!及其之前的LoveLive!系列声优偶像中是最高的。原记录保持者是164.5cm的高槻加奈子。巨型鲤鱼王实锤。\n" +
             "小学的时候有过一瞬成为歌手的梦想，但因为“这是残酷的世界”而放弃。[4]可你现在不还是在做歌手和偶像吗！\n" +
             "因为自小擅长画画，所以有“进入美术系”“将来成为美术老师”的想法。[4]但是不擅长速写，在b站直播唠嗑时说自己绘画时使用橡皮频率较高。\n" +
             "早期的ID“黎狱”是中二病时期取的[5]，后来觉得羞耻便改成了纯英文的Liyuu。\n" +
             "体育不好，从小到大800米没有及格过。唐可可兴趣是cos和不喜欢体育的设定疑似逆输入。但擅长仰卧起坐（被直播弹幕调侃为“鲤鱼打挺”）。现已逆输入至LoveLive!Superstar!!动画第二集。\n" +
             "因为从小在家里吃饭，自己不太会做饭，经常去“711大饭店”等便利店吃饭。\n" +
             "似乎不知道便利店是个梗。然而在生放送中直接进行了公然迫害。[6]\n" +
             "“人没有碳水就活不下去。”——Liyuu\n" +
             "因为平时蔬菜吃得不多，所以就会喝蔬菜汁。\n" +
             "酒量很差。\n" +
             "玩过一段时间的邦邦。拉邦结派。\n" +
             "身为老拉拉人，很早就开始玩LoveLive!学园偶像祭，曾经也爆肝过。时间太久以至于已经记不清出的第一张UR是谁的了。\n" +
             "SIF的技术存疑。在和法元明菜的特别节目里第一次作为Liella!的声优玩SIF时打出了个非常丢人的成绩，连击不到C。“一世英名毁于一旦”“太久没玩”“第一次用平板”“接触不好”。但是成功活到了最后，让国服的玩家每人获得了一张11连招募券。快说谢谢鲤鱼姐。\n" +
             "打开的是自己的账号，其中Liella!的歌曲里面只有Tiny Stars是双S。可香实锤。可香可香了！\n" +
             "第一次去日本是高考结束的暑假，那时候还不会说日语，但是2021年现在日语已经很好而且进步神速。\n" +
             "会看粉丝制作的熟肉，并曾抱怨有些自己说的话被误认成了别人说的。[7]\n" +
             "不会开车，不会骑自行车。\n" +
             "因为成长于中国义务教育，所以汉语和英语都很好（虽然有时会被粉丝说是“母语复健”）；去日本工作之后，日语水平也与日俱增。因此鲤鱼常被调侃为“三文鱼”。\n" +
             "是Liella!的汉语、英语担当，在LoveLive!Superstar!! 结女放学后放送局 LieRadi!和生放送的通知环节里十分标准地念出LoveLive!系列跨年演唱会的标题，引得其他成员阵阵夸赞。\n" +
             "LoveLive!Superstar!! 结女放学后放送局 LieRadi!的常驻空气嘉宾。\n" +
             "在2021年12月29日播出的广播LoveLive!系列的ALL NIGHT NIPPON GOLD中误把“宫城公演”说成了“小宫公演”，引起群体爆笑。[8]\n" +
             "被Liella!的各位和法元明菜爆料过，在吃到好吃的时候会疯狂抓住过路人员安利。大致都是：这个好吃！XXX你吃了吗？没吃吗？快吃啊！[9]\n" +
             "在2021年12月1日的Liella!生放送上提到队友在广播中模仿自己一事，随后又被当面模仿了一遍。[10]\n" +
             "2021年末的LoveLive!系列跨年live完成后，去了nagi家和她共进晚餐。[11]\n" +
             "人际关系\n" +
             "与同唱片公司的铃木爱奈关系很好，在鲤鱼加入Liella!前两人就有过工作上的共事，还留了合影。爱喵前辈\n" +
             "工作后回家有时会和Payton尚未（支付宝）坐同一辆电车，所以经常在路上聊天。曾有一天要求对方叫自己姐姐。\n" +
             "和隔壁虹咲的钟岚珠的CV，在LoveLive!Superstar!!动画作为音响协力（主要是帮忙把导演的要求翻译给Liyuu）的法元明菜关系很好。\n" +
             "每次见到新田惠海时都会激动到泪流满面，无论线上还是线下。[12]Emi也一直在支持鲤鱼和Liella!。鲤鱼：她是神啊！\n" +
             "2021年末的LoveLive!系列跨年live结束后众人向线上观众打招呼的环节前，由于水团成员逐一同Liella!成员碰拳鼓励，鲤鱼因此感动到哭出来。\n" +
             "此时是菜宝第一个上前用汉语安慰：“之后还要拍照，你怎么了？再哭妆会花的哦！”[13]\n" +
             "有一天去拍摄现场的时候因为太累了，就把头枕在小百合的膝盖上睡着了[14]。\n" +
             "\n" +
             "阅读更多：https://zh.moegirl.org.cn/Liyuu\n" +
             "爱好\n" +
             "超级超级超级喜欢喜茶，喜欢到想成为喜茶代言人。最喜欢喝七分甜的杨枝甘露。最喜欢的水果是西瓜。\n" +
             "喜欢喜茶的水果绿妍（已下架）、芝芝桃桃、芝芝莓莓、芋泥波波茶。认为喜茶的奶茶太浓郁了高情商发言，所以比较喜欢果茶。由于在日本喝不到，只能喝也喜欢的大麦茶，拿铁咖啡（从不加糖）和热水。\n" +
             "除了喜茶，还喜欢一点点奶茶的三分糖四季奶青加仙草加波霸、三分糖四季春茶加波霸；KOI的乌龙奶茶加小芋圆。（喝一切奶茶都是三分糖）本人评价：绝了！喜茶：所以爱会消失的对吗？Liyuu原话：爱是永存的，只不过我把它平分了一下。DD发言。\n" +
             "喜欢吃七宝老街的宁波大汤圆，豆沙馅和肉馅的都喜欢吃。还喜欢吃酒酿小圆子，因为上海的小囡都爱吃。对于八宝饭也是爱得深沉，但是不喜欢吃青团。\n" +
             "喜欢看后宫番，并且从里面选择自己最爱的角色。直播时的表现完全就是一个CDD。\n" +
             "喜欢甜点，包括日式甜口水果可丽饼。LoveLive!Superstar!!的ED中唐可可吃可丽饼的画面疑似是逆输入。\n" +
             "因为没有在「Liella! 突击外景 通往1st Live Tour的道路」取得冠军而错失吃到可丽饼的机会（获胜的是青山渚和岬奈子），在生放送中摆出异常失落的表情，还被给长时间特写。[15]师承没吃到特大海胆的三森铃子。[16]\n" +
             "喜欢吃好吃的，被Liella!爆料过大口大口吃着成吉思汗烤羊肉[9]，还疯狂试图拉人一起吃。无情的干饭人！\n" +
             "在岚珠和可可的特别节目中，Liyuu还问法元明菜岚珠什么时候请可可吃肉。[17]\n" +
             "偶像是王心凌，自称从小学喜欢到现在，所有的歌都会听。\n" +
             "喜欢的声优是坂本真绫，但还没和本人见过面。@法元明菜\n" +
             "喜欢娇小可爱的女孩子。@伊达小百合@前田佳织里\n" +
             "京阿尼铁粉一枚。\n" +
             "丰崎爱生铁粉。看轻音少女长大的，第一次出的cos也是呆唯。[18]\n" +
             "最喜欢的零食是麦当劳的薯条，还有薯片。\n" +
             "喜欢的乐队是樱高轻音部。\n" +
             "不喜欢穿花哨的衣服。\n" +
             "害怕玩鬼屋。我的妈呀，何それ。也不喜欢剧本杀，因为用日语读剧本太累了。\n" +
             "μ's中最喜欢的是穗乃果，但是同时还喜欢Maki、花阳（菜宝：你又DD了是吧），Aqours中最喜欢的是小原鞠莉（爱喵前辈），虹咲学园学园偶像同好会中最喜欢的是近江彼方。（因~为~可~以~慢~悠~悠~的。）[17]所以就在演唱会上公然开睡。\n" +
             "最喜欢的μ's的歌曲是《爱上你万岁！》、Aqours的歌曲是三单、虹学会的歌曲是OP1。[17]\n" +
             "\n" +
             "阅读更多：https://zh.moegirl.org.cn/Liyuu\n" +
             "本文引自萌娘百科(https://zh.moegirl.org.cn )，文字内容默认使用《知识共享 署名-非商业性使用-相同方式共享 3.0》协议。"
}