package com.khansa.filmcatalogue.utils

import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.data.source.remote.response.MovieResponse
import com.khansa.filmcatalogue.data.source.remote.response.ShowsResponse

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity("b14",
        "X-Men: First Class",
        "In the early 1960s, during the height of the Cold War, a mutant named Charles Xavier (James McAvoy) meets a fellow mutant named Erik Lehnsherr (Michael Fassbender). Despite their vastly different backgrounds -- Charles grew up with a wealthy family, while Erik lost his parents at Auschwitz -- the two become close friends. As the world teeters on the brink of a nuclear war, Charles and Erik with other mutants join forces to save humanity. However, a situation soon tears the friends apart.",
        "2011",
        "https://resizing.flixster.com/13rq44o7ICTE-qFvZIpkIeHBdMU=/206x305/v2/https://flxt.tmsimg.com/assets/p8118537_p_v13_ao.jpg")
        )
        movies.add(
            MovieEntity("b15",
        "Jade Dynasty 1",
        "After the massacre of his village, Zhang Xiao Fan is taken in by the Qing Yun Sect where he begins his journey of cultivation. When he finds out the truth behind the deaths of his parents, he succumbs to his rage and demonic tendencies and becomes the enemy of the Qing Yun Sect. (Source: ChineseDrama.info)",
        "2019",
        "https://i.mydramalist.com/dYO3zc.jpg?v=1")
        )
        movies.add(
            MovieEntity("b16",
        "The Living Dead",
        "While on his travels, a young man named Wen Ning (Paul Yu) comes across a mysterious town named Fu Feng. The town's inhabitants live in perpetual fear of malevolent spirits who – so they say – are attracted to candle and lantern light at night time.\n" +
                "\n" +
                "A spate of killings has taken place after dark, too, leaving the town's residents shaken and in a state of desperation.\n" +
                "\n" +
                "Their sense of dread leads them to live in darkness after nightfall, for fear of what might happen should they light a fire.\n" +
                "\n" +
                "Determined to break the spell, the fearless Wen Ning purposefully lights a lamp in the dead of night, hoping to confront the evil spirits and fight them off.\n" +
                "\n" +
                "Just as the shadowy forces are drawing near, his old acquaintance and brother-in-arms Lan Si Zhui (Zheng Fan Xing) appears on the scene, hoping to lend a hand.\n" +
                "\n" +
                "Together, Lan Si Zhui and Wen Ning resolve to fight back against the forces of darkness – and rescue the town from the clutches of evil supernatural forces.",
        "2019",
        "https://static.wikia.nocookie.net/drama/images/a/ad/The_Living_Dead.png/revision/latest/scale-to-width-down/300?cb=20200704045453")
        )
        movies.add(
            MovieEntity("b17",
        "Fatal Journey",
        "The story is set during the time when the Qinghe Nie sect was dealing with their ancestral knife tomb incident. Nie Ming Jue brought Nie Huai Sang with other Nie sect disciples to restore the tomb back to its original state to ensure peace in the Nie sect.\n" +
                "Through this, Nie Huai Sang went from a playful disciple to maturing into the next generation sect leader and Nie Ming Jue learned how to better understand his brother and helped him grow.",
        "2020",
        "https://i.mydramalist.com/wedBg_4c.jpg?v=1")
        )
        movies.add(
            MovieEntity("b18",
        "Burn the Stage: the Movie",
        "Burn the Stage: The Movie is a 2018 South Korean musical documentary film directed by Park Jun-soo and produced by Yoon Jiwon, featuring the behind-the-scenes of boy band BTS' 2017 The Wings Tour, an event known for drawing in more than half a million fans in 19 different countries around the world.",
        "2018",
        "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Burn_the_Stage_the_Movie_poster.jpg/220px-Burn_the_Stage_the_Movie_poster.jpg")
        )
        movies.add(
            MovieEntity("b19",
        "BTS (방탄소년단) 'Love Yourself in Seoul'",
        "Shot at the Olympic Stadium in Seoul during the BTS tour `Love Yourself', an exclusive screening of the most sought-after concert of 2018 hits movie theatres worldwide for a one-day only event.",
        "2019",
        "https://upload.wikimedia.org/wikipedia/en/thumb/7/7c/Love_Yourself_in_Seoul.jpg/220px-Love_Yourself_in_Seoul.jpg")
        )
        movies.add(
            MovieEntity("b20",
        "BTS (방탄소년단) 'Bring the Soul: The Movie",
        "Following their landmark `Love Yourself' tour, BTS triumphantly returns to cinema screens. Shining brighter than any light on the stage, now the group invite us behind the spotlight. On the day following the final concert of their Europe tour, on a rooftop in Paris, BTS tells their very own stories from experiencing new cities to performing in front of thousands across the globe.",
        "2019",
        "https://upload.wikimedia.org/wikipedia/en/thumb/f/fa/Bring_the_Soul_The_Movie.jpg/220px-Bring_the_Soul_The_Movie.jpg")
        )
        movies.add(
            MovieEntity("b21",
        "BTS (방탄소년단) 'Break The Silence: The Movie",
        "Break the Silence: The Movie  is a 2020 South Korean documentary film directed by Park Jun-soo and produced by Big Hit Three Sixty, featuring the behind-the-scenes of boy band BTS' 2018–2019 Love Yourself World Tour. Promoted as the sequel to the band's 2019 film Bring the Soul: The Movie, it was released on September 10, 2020 in select countries, with distribution handled by Trafalgar Releasing. The film is an adaptation of the band's third documentary series, Break The Silence: Docu-Series, that was released on the fan platform Weverse in May.[1][2]",
        "2020",
        "https://upload.wikimedia.org/wikipedia/en/thumb/6/62/Break_the_Silence-_The_Movie.jpg/220px-Break_the_Silence-_The_Movie.jpg")
        )
        movies.add(
            MovieEntity("b22",
        "200 Pounds Beauty",
        "Han-Na (Kim A-Joong) is a very large girl with a warm heart. She also possesses an unbelievable voice. Han-Na wants to become a pop-singer, but due to her extra-large appearance, can only work as a faceless singer. She provides the vocals for a popular singer named Amy (Ji Seo-Yun), a beautiful young lady that can’t carry a note to save her life.\n" +
                "\n" +
                "Han-Na is also in love with Amiys music producer, Sang-Joon (Joo Jin-Mo), but it's a one-sided love. One day, Han-Na is invited to Sang-Joon’s birthday party and receives a red dress from him to wear to his party. Han-Na is excited, yet scared. The dress is revealing and quite extravagant. With her very large figure, she is not sure if she can wear such an outfit. Han-Na does eventually go to the birthday party in the red dress, but is mortified when petite Amy appears in the same red dress. During the course of the birthday party, Han-Na absorbs more emotional trauma and she simply disappears for one year.\n" +
                "\n" +
                "Han-Na then returns as the beautiful Jenny ...",
        "2006",
        "https://asianwiki.com/images/b/b9/200poundsbeauty.jpg")
        )
        movies.add(
            MovieEntity("b23",
        "Inglorious Basterds",
        "In Nazi-occupied France during World War II, a plan to assassinate Nazi leaders by a group of Jewish U.S. soldiers coincides with a theatre owner's vengeful plans for the same.",
        "2009",
        "https://m.media-amazon.com/images/M/MV5BOTJiNDEzOWYtMTVjOC00ZjlmLWE0NGMtZmE1OWVmZDQ2OWJhXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_UX182_CR0,0,182,268_AL_.jpg")
        )

        return movies
    }

    fun generateDummyShows(): List<ShowEntity> {

        val shows = ArrayList<ShowEntity>()

        shows.add(
            ShowEntity("a14",
        "Word of Honor",
        "Zhou Zi Shu, the disillusioned leader of a royal praetorian secret service, takes drastic measures to leave his former life behind and wanders the pugilist world. He unexpectedly gets involved in a conspiracy after he steps in to save a young boy.  He also meets the mysterious Wen Ke Xing, who is on a quest to avenge his parents’ deaths. They become bosom friends through a series of adventures involving a legendary treasure that is rumored to give its owner ultimate power over the pugilist world.\n\n (Source: Cfensi)",
        "2021",
        "https://i.mydramalist.com/RpJeV_4f.jpg")
        )
        shows.add(
            ShowEntity("a15",
        "The Untamed",
        "Wei Wu Xian and Lan Wang Ji, two talented disciples of respectable clans, meet during cultivation training and accidentally discover a secret carefully hidden for many years. Taking on the legacy of their ancestors, they decide to rid the world of the ominous threat, but in a dramatic turn of events, Wei Wu Xian dies.\n" +
                "Sixteen years later, Wei Wu Xian is brought back to life through a self-sacrificing ritual. He conceals himself behind a mask and assumes the identity of his summoner. Soon Wei Wu Xian reunites with Lan Wang Ji, and the pair starts working together to solve the mysteries of the present and unravel the truth behind the events of the past.\n" +
                "(Source: MyDramaList)",
        "2019",
        "https://i.mydramalist.com/qOrz5c.jpg?v=1")
        )
        shows.add(
            ShowEntity("a16",
        "Douluo Continent",
        "Having lost his mother at a very young age, Tang San grew up relying on his father just as much as his father relied upon him. Meticulous and mature for his age, with extraordinary talent and wit, he was sent to Nuoding Academy, at the age of sixteen, to begin pursuing his dream of becoming a great soul master. There, under the tutelage of Yu Xiao Gang, he befriends an orphan by the name of Gu Xiao Wu, and together they begin the long and difficult journey of cultivation.  As time passes, the two friends draw ever closer, eventually swearing to look out for each other as siblings for life.\n" +
                "\n" +
                "As their power and connection grow, Yu Xiao Gang realizes they need more guidance than he can provide. Sending the pair to the Shrek Academy, Tang San and Xiao Wu join five other prodigies from various academies, in their journey of cultivation. Strong in their power, the seven students become known throughout the land as the “Shrek Seven Devils”. With their fame ever-growing, the talents of the Seven are eventually noticed by a few very prominent nobles who invite them to continue their cultivation at the esteemed Tian Dou Royal Academy. \n" +
                "\n" +
                "Not long after accepting the invitation, the Seven Devils find themselves caught up in an imperial struggle for power, between the first and fourth princes. At the same time, Tang San uncovers a long-hidden secret about his mother’s death. Suddenly facing battles on many fronts, Tang San finds himself forced to fight, not only to protect those he loves, but to bring honor to his sect, save his country, and complete his quest to become the greatest soul master of all time.\n" +
                "(Source: Viki)",
        "2021",
        "https://i.mydramalist.com/XzL1q_4c.jpg?v=1")
        )
        shows.add(
            ShowEntity("a17",
        "Love is Sweet",
        "Jiang Jun is a girl who is allergic to tears and has a double degree in economics and psychology. She is unrestrained and idealistic due to her family's superior background. After graduation, she worked in a philanthropy organization where she pursues her dreams. However, her father's sudden accident leaves her in a dilemma. Eventually, she decides to work in a top investment company to fulfill her father's dying wish. In MH, Jiang Jun meets her childhood playmate, Yuan Shuai. However, the current Yuan Shuai is no longer her gentle protector, but her rival. In MH, where the \"culture of wolf instinct\" is rampant, someone is plotting against Jiang Jun while someone sees her as an eyesore. However with her kind nature and attention to details, along with her high EQ and sense of judgment, Jiang Jun eventually attains success in both her career and love life.\n" +
                "(Source: DramaWiki)",
        "2020",
        "https://i.mydramalist.com/eWDpE_4c.jpg?v=1")
        )
        shows.add(
            ShowEntity("a18",
        "Guardian",
        "A world beyond scientific understanding with a group of passionate adults trying to solve cases done by such forces. Zhao Yun Lan and Shen Wei are tasked with upholding peace between underworld dwellers and humans, and the story will focus on their friendship that transcends past and present lifetimes.",
        "2018",
        "https://i.mydramalist.com/QpyE6c.jpg?v=1")
        )
        shows.add(
            ShowEntity("a19",
        "Fugou Keiji: Balance: Unlimited",
        "Daisuke Kanbe, a man of extraordinary wealth, is assigned to the Modern Crime Prevention Headquarters as a detective. It is there that he gets partnered with Haru Katou, a humane detective who values justice above all. The two are polar opposites, and their morals clash time and time again. Haru despises Daisuke for using monetary wealth to solve cases, as he believes that money isn't everything. The two will have to combine their efforts, however, to solve the mysteries that are coming their way.",
        "2020",
        "https://cdn.myanimelist.net/images/anime/1066/106556l.webp")
        )
        shows.add(
            ShowEntity("a20",
        "Yuri!!! on Ice",
        "Reeling from his crushing defeat at the Grand Prix Finale, Yuuri Katsuki, once Japan's most promising figure skater, returns to his family home to assess his options for the future. At age 23, Yuuri's window for success in skating is closing rapidly, and his love of pork cutlets and aptitude for gaining weight are not helping either.\n" +
                "\n" +
                "However, Yuuri finds himself in the spotlight when a video of him performing a routine previously executed by five-time world champion, Victor Nikiforov, suddenly goes viral. In fact, Victor himself abruptly appears at Yuuri's house and offers to be his mentor. As one of his biggest fans, Yuuri eagerly accepts, kicking off his journey to make it back onto the world stage. But the competition is fierce, as the rising star from Russia, Yuri Plisetsky, is relentlessly determined to defeat Yuuri and win back Victor's tutelage.",
        "2016",
        "https://static.wikia.nocookie.net/yurionice/images/a/ad/Yuri_On_Ice_Promotional_Art.jpg/revision/latest/scale-to-width-down/620?cb=20161024213957")
        )
        shows.add(
            ShowEntity("a21",
        "Tale of the Nine Tailed",
        "Lee Yeon (Lee Dong-Wook) was once the mountain spirit of Baekdudaegan. He sacrificed his life as a mountain god to resurrect the life of the woman he loved A Eum. Lee Yeon now lives his life as a nine tailed fox in human form. He has lived this way for hundreds of years.\n" +
                "Meanwhile, Nam Ji-A (Jo Bo-Ah) works for TVC station as a PD of documentaries. She seeks out stories on the supernatural. Back in 1999, her parents were involved in a car accident in Yeou Gogae. She remembers a man that saved her in that accident. Now, Nam Ji-A reviews CCTV footage from a wedding hall where the bride disappeared. She sees the man that saved her as child walking out the wedding wall with a red umbrella. His name is Lee Yeon.",
        "2020",
        "https://asianwiki.com/images/1/19/Tale_of_the_Nine_Tailed-P1.jpg")
        )
        shows.add(
            ShowEntity("a22",
        "Heaven Official's Blessing",
        "“Have you heard? The rubbish Heaven Official is having an affair with the ghost realm’s number one big shot!”\n" +
                "\n" +
                "Eight hundred years ago, Xie Lian was the Crown Prince of the Xian Le kingdom; one who was beloved by his citizens and the darling of the world. Unsurprisingly, he ascended to the Heavens at a very young age. Now, eight hundred years later, Xie Lian ascends to the Heavens for the third time as the laughingstock of all three realms. On his first task as a god, he meets a mysterious demon who rules the ghosts and terrifies the Heavens... yet unbeknownst to Xie Lian, this demon king has been paying attention to him for a very, very long time.",
        "2020 - Now",
        "https://static.wikia.nocookie.net/heaven-officials-blessing/images/9/9d/Donghua_01.jpg/revision/latest/scale-to-width-down/620?cb=20200420184846")
        )
        shows.add(
            ShowEntity("a23",
        "Grandmaster of Demonic Cultivation",
        "The Wen Clan's rampage caused untold sufferings, and the other cultivation clans launched the \"Sunshot Campaign\" to join forces against the Wen Clan. Although Wei Wuxian, the Yiling Patriarch, had made great contributions to overthrowing the Wens, he was stigmatized and punished because he was considered too powerful and dangerous. He was persecuted by ten thousand people.\n" +
                "\n" +
                "Thirteen years later, Wei Wuxian was brought back by a sacrificual ritual, and has met again with old acquaintances such as Lan Wangji from the Gusu Lan Clan and Jiang Cheng from the Yunmeng Jiang Clan. The mysteries of Wei Wuxian's past remain, and conflicts in the cultivation world have resurfaced - all of which began from when they were all once youths.",
        "2018 - Now",
        "https://static.wikia.nocookie.net/modao-zushi/images/e/e3/Mdzs-s1.png/revision/latest/scale-to-width-down/620?cb=20191115100416")
        )

        return shows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(MovieResponse("b14",
            "X-Men: First Class",
            "In the early 1960s, during the height of the Cold War, a mutant named Charles Xavier (James McAvoy) meets a fellow mutant named Erik Lehnsherr (Michael Fassbender). Despite their vastly different backgrounds -- Charles grew up with a wealthy family, while Erik lost his parents at Auschwitz -- the two become close friends. As the world teeters on the brink of a nuclear war, Charles and Erik with other mutants join forces to save humanity. However, a situation soon tears the friends apart.",
            "2011",
            "https://resizing.flixster.com/13rq44o7ICTE-qFvZIpkIeHBdMU=/206x305/v2/https://flxt.tmsimg.com/assets/p8118537_p_v13_ao.jpg"))
        movies.add(
            MovieResponse("b15",
            "Jade Dynasty 1",
            "After the massacre of his village, Zhang Xiao Fan is taken in by the Qing Yun Sect where he begins his journey of cultivation. When he finds out the truth behind the deaths of his parents, he succumbs to his rage and demonic tendencies and becomes the enemy of the Qing Yun Sect. (Source: ChineseDrama.info)",
            "2019",
            "https://i.mydramalist.com/dYO3zc.jpg?v=1")
        )
        movies.add(
            MovieResponse("b16",
            "The Living Dead",
            "While on his travels, a young man named Wen Ning (Paul Yu) comes across a mysterious town named Fu Feng. The town's inhabitants live in perpetual fear of malevolent spirits who – so they say – are attracted to candle and lantern light at night time.\n" +
                    "\n" +
                    "A spate of killings has taken place after dark, too, leaving the town's residents shaken and in a state of desperation.\n" +
                    "\n" +
                    "Their sense of dread leads them to live in darkness after nightfall, for fear of what might happen should they light a fire.\n" +
                    "\n" +
                    "Determined to break the spell, the fearless Wen Ning purposefully lights a lamp in the dead of night, hoping to confront the evil spirits and fight them off.\n" +
                    "\n" +
                    "Just as the shadowy forces are drawing near, his old acquaintance and brother-in-arms Lan Si Zhui (Zheng Fan Xing) appears on the scene, hoping to lend a hand.\n" +
                    "\n" +
                    "Together, Lan Si Zhui and Wen Ning resolve to fight back against the forces of darkness – and rescue the town from the clutches of evil supernatural forces.",
            "2019",
            "https://static.wikia.nocookie.net/drama/images/a/ad/The_Living_Dead.png/revision/latest/scale-to-width-down/300?cb=20200704045453")
        )
        movies.add(
            MovieResponse("b17",
            "Fatal Journey",
            "The story is set during the time when the Qinghe Nie sect was dealing with their ancestral knife tomb incident. Nie Ming Jue brought Nie Huai Sang with other Nie sect disciples to restore the tomb back to its original state to ensure peace in the Nie sect.\n" +
                    "Through this, Nie Huai Sang went from a playful disciple to maturing into the next generation sect leader and Nie Ming Jue learned how to better understand his brother and helped him grow.",
            "2020",
            "https://i.mydramalist.com/wedBg_4c.jpg?v=1")
        )
        movies.add(
            MovieResponse("b18",
            "Burn the Stage: the Movie",
            "Burn the Stage: The Movie is a 2018 South Korean musical documentary film directed by Park Jun-soo and produced by Yoon Jiwon, featuring the behind-the-scenes of boy band BTS' 2017 The Wings Tour, an event known for drawing in more than half a million fans in 19 different countries around the world.",
            "2018",
            "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Burn_the_Stage_the_Movie_poster.jpg/220px-Burn_the_Stage_the_Movie_poster.jpg")
        )
        movies.add(
            MovieResponse("b19",
            "BTS (방탄소년단) 'Love Yourself in Seoul'",
            "Shot at the Olympic Stadium in Seoul during the BTS tour `Love Yourself', an exclusive screening of the most sought-after concert of 2018 hits movie theatres worldwide for a one-day only event.",
            "2019",
            "https://upload.wikimedia.org/wikipedia/en/thumb/7/7c/Love_Yourself_in_Seoul.jpg/220px-Love_Yourself_in_Seoul.jpg")
        )
        movies.add(
            MovieResponse("b20",
            "BTS (방탄소년단) 'Bring the Soul: The Movie",
            "Following their landmark `Love Yourself' tour, BTS triumphantly returns to cinema screens. Shining brighter than any light on the stage, now the group invite us behind the spotlight. On the day following the final concert of their Europe tour, on a rooftop in Paris, BTS tells their very own stories from experiencing new cities to performing in front of thousands across the globe.",
            "2019",
            "https://upload.wikimedia.org/wikipedia/en/thumb/f/fa/Bring_the_Soul_The_Movie.jpg/220px-Bring_the_Soul_The_Movie.jpg")
        )
        movies.add(
            MovieResponse("b21",
            "BTS (방탄소년단) 'Break The Silence: The Movie",
            "Break the Silence: The Movie  is a 2020 South Korean documentary film directed by Park Jun-soo and produced by Big Hit Three Sixty, featuring the behind-the-scenes of boy band BTS' 2018–2019 Love Yourself World Tour. Promoted as the sequel to the band's 2019 film Bring the Soul: The Movie, it was released on September 10, 2020 in select countries, with distribution handled by Trafalgar Releasing. The film is an adaptation of the band's third documentary series, Break The Silence: Docu-Series, that was released on the fan platform Weverse in May.[1][2]",
            "2020",
            "https://upload.wikimedia.org/wikipedia/en/thumb/6/62/Break_the_Silence-_The_Movie.jpg/220px-Break_the_Silence-_The_Movie.jpg")
        )
        movies.add(
            MovieResponse("b22",
            "200 Pounds Beauty",
            "Han-Na (Kim A-Joong) is a very large girl with a warm heart. She also possesses an unbelievable voice. Han-Na wants to become a pop-singer, but due to her extra-large appearance, can only work as a faceless singer. She provides the vocals for a popular singer named Amy (Ji Seo-Yun), a beautiful young lady that can’t carry a note to save her life.\n" +
                    "\n" +
                    "Han-Na is also in love with Amiys music producer, Sang-Joon (Joo Jin-Mo), but it's a one-sided love. One day, Han-Na is invited to Sang-Joon’s birthday party and receives a red dress from him to wear to his party. Han-Na is excited, yet scared. The dress is revealing and quite extravagant. With her very large figure, she is not sure if she can wear such an outfit. Han-Na does eventually go to the birthday party in the red dress, but is mortified when petite Amy appears in the same red dress. During the course of the birthday party, Han-Na absorbs more emotional trauma and she simply disappears for one year.\n" +
                    "\n" +
                    "Han-Na then returns as the beautiful Jenny ...",
            "2006",
            "https://asianwiki.com/images/b/b9/200poundsbeauty.jpg")
        )
        movies.add(
            MovieResponse("b23",
            "Inglorious Basterds",
            "In Nazi-occupied France during World War II, a plan to assassinate Nazi leaders by a group of Jewish U.S. soldiers coincides with a theatre owner's vengeful plans for the same.",
            "2009",
            "https://m.media-amazon.com/images/M/MV5BOTJiNDEzOWYtMTVjOC00ZjlmLWE0NGMtZmE1OWVmZDQ2OWJhXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_UX182_CR0,0,182,268_AL_.jpg")
        )

        return movies
    }

    fun generateRemoteDummyShows(): List<ShowsResponse> {

        val shows = ArrayList<ShowsResponse>()

        shows.add(
            ShowsResponse("a14",
            "Word of Honor",
            "Zhou Zi Shu, the disillusioned leader of a royal praetorian secret service, takes drastic measures to leave his former life behind and wanders the pugilist world. He unexpectedly gets involved in a conspiracy after he steps in to save a young boy.  He also meets the mysterious Wen Ke Xing, who is on a quest to avenge his parents’ deaths. They become bosom friends through a series of adventures involving a legendary treasure that is rumored to give its owner ultimate power over the pugilist world.\n" + "(Source: Cfensi)",
            "2021",
            "https://i.mydramalist.com/RpJeV_4f.jpg")
        )
        shows.add(
            ShowsResponse("a15",
            "The Untamed",
            "Wei Wu Xian and Lan Wang Ji, two talented disciples of respectable clans, meet during cultivation training and accidentally discover a secret carefully hidden for many years. Taking on the legacy of their ancestors, they decide to rid the world of the ominous threat, but in a dramatic turn of events, Wei Wu Xian dies.\n" +
                    "Sixteen years later, Wei Wu Xian is brought back to life through a self-sacrificing ritual. He conceals himself behind a mask and assumes the identity of his summoner. Soon Wei Wu Xian reunites with Lan Wang Ji, and the pair starts working together to solve the mysteries of the present and unravel the truth behind the events of the past.\n" +
                    "(Source: MyDramaList)",
            "2019",
            "https://i.mydramalist.com/qOrz5c.jpg?v=1")
        )
        shows.add(
            ShowsResponse("a16",
            "Douluo Continent",
            "Having lost his mother at a very young age, Tang San grew up relying on his father just as much as his father relied upon him. Meticulous and mature for his age, with extraordinary talent and wit, he was sent to Nuoding Academy, at the age of sixteen, to begin pursuing his dream of becoming a great soul master. There, under the tutelage of Yu Xiao Gang, he befriends an orphan by the name of Gu Xiao Wu, and together they begin the long and difficult journey of cultivation.  As time passes, the two friends draw ever closer, eventually swearing to look out for each other as siblings for life.\n" +
                    "\n" +
                    "As their power and connection grow, Yu Xiao Gang realizes they need more guidance than he can provide. Sending the pair to the Shrek Academy, Tang San and Xiao Wu join five other prodigies from various academies, in their journey of cultivation. Strong in their power, the seven students become known throughout the land as the “Shrek Seven Devils”. With their fame ever-growing, the talents of the Seven are eventually noticed by a few very prominent nobles who invite them to continue their cultivation at the esteemed Tian Dou Royal Academy. \n" +
                    "\n" +
                    "Not long after accepting the invitation, the Seven Devils find themselves caught up in an imperial struggle for power, between the first and fourth princes. At the same time, Tang San uncovers a long-hidden secret about his mother’s death. Suddenly facing battles on many fronts, Tang San finds himself forced to fight, not only to protect those he loves, but to bring honor to his sect, save his country, and complete his quest to become the greatest soul master of all time.\n" +
                    "(Source: Viki)",
            "2021",
            "https://i.mydramalist.com/XzL1q_4c.jpg?v=1")
        )
        shows.add(
            ShowsResponse("a17",
            "Love is Sweet",
            "Jiang Jun is a girl who is allergic to tears and has a double degree in economics and psychology. She is unrestrained and idealistic due to her family's superior background. After graduation, she worked in a philanthropy organization where she pursues her dreams. However, her father's sudden accident leaves her in a dilemma. Eventually, she decides to work in a top investment company to fulfill her father's dying wish. In MH, Jiang Jun meets her childhood playmate, Yuan Shuai. However, the current Yuan Shuai is no longer her gentle protector, but her rival. In MH, where the \"culture of wolf instinct\" is rampant, someone is plotting against Jiang Jun while someone sees her as an eyesore. However with her kind nature and attention to details, along with her high EQ and sense of judgment, Jiang Jun eventually attains success in both her career and love life.\n" +
                    "(Source: DramaWiki)",
            "2020",
            "https://i.mydramalist.com/eWDpE_4c.jpg?v=1")
        )
        shows.add(
            ShowsResponse("a18",
            "Guardian",
            "A world beyond scientific understanding with a group of passionate adults trying to solve cases done by such forces. Zhao Yun Lan and Shen Wei are tasked with upholding peace between underworld dwellers and humans, and the story will focus on their friendship that transcends past and present lifetimes.",
            "2018",
            "https://i.mydramalist.com/QpyE6c.jpg?v=1")
        )
        shows.add(
            ShowsResponse("a19",
            "Fugou Keiji: Balance: Unlimited",
            "Daisuke Kanbe, a man of extraordinary wealth, is assigned to the Modern Crime Prevention Headquarters as a detective. It is there that he gets partnered with Haru Katou, a humane detective who values justice above all. The two are polar opposites, and their morals clash time and time again. Haru despises Daisuke for using monetary wealth to solve cases, as he believes that money isn't everything. The two will have to combine their efforts, however, to solve the mysteries that are coming their way.",
            "2020",
            "https://cdn.myanimelist.net/images/anime/1066/106556l.webp")
        )
        shows.add(
            ShowsResponse("a20",
            "Yuri!!! on Ice",
            "Reeling from his crushing defeat at the Grand Prix Finale, Yuuri Katsuki, once Japan's most promising figure skater, returns to his family home to assess his options for the future. At age 23, Yuuri's window for success in skating is closing rapidly, and his love of pork cutlets and aptitude for gaining weight are not helping either.\n" +
                    "\n" +
                    "However, Yuuri finds himself in the spotlight when a video of him performing a routine previously executed by five-time world champion, Victor Nikiforov, suddenly goes viral. In fact, Victor himself abruptly appears at Yuuri's house and offers to be his mentor. As one of his biggest fans, Yuuri eagerly accepts, kicking off his journey to make it back onto the world stage. But the competition is fierce, as the rising star from Russia, Yuri Plisetsky, is relentlessly determined to defeat Yuuri and win back Victor's tutelage.",
            "2016",
            "https://static.wikia.nocookie.net/yurionice/images/a/ad/Yuri_On_Ice_Promotional_Art.jpg/revision/latest/scale-to-width-down/620?cb=20161024213957")
        )
        shows.add(
            ShowsResponse("a21",
            "Tale of the Nine Tailed",
            "Lee Yeon (Lee Dong-Wook) was once the mountain spirit of Baekdudaegan. He sacrificed his life as a mountain god to resurrect the life of the woman he loved A Eum. Lee Yeon now lives his life as a nine tailed fox in human form. He has lived this way for hundreds of years.\n" +
                    "Meanwhile, Nam Ji-A (Jo Bo-Ah) works for TVC station as a PD of documentaries. She seeks out stories on the supernatural. Back in 1999, her parents were involved in a car accident in Yeou Gogae. She remembers a man that saved her in that accident. Now, Nam Ji-A reviews CCTV footage from a wedding hall where the bride disappeared. She sees the man that saved her as child walking out the wedding wall with a red umbrella. His name is Lee Yeon.",
            "2020",
            "https://asianwiki.com/images/1/19/Tale_of_the_Nine_Tailed-P1.jpg")
        )
        shows.add(
            ShowsResponse("a22",
            "Heaven Official's Blessing",
            "“Have you heard? The rubbish Heaven Official is having an affair with the ghost realm’s number one big shot!”\n" +
                    "\n" +
                    "Eight hundred years ago, Xie Lian was the Crown Prince of the Xian Le kingdom; one who was beloved by his citizens and the darling of the world. Unsurprisingly, he ascended to the Heavens at a very young age. Now, eight hundred years later, Xie Lian ascends to the Heavens for the third time as the laughingstock of all three realms. On his first task as a god, he meets a mysterious demon who rules the ghosts and terrifies the Heavens... yet unbeknownst to Xie Lian, this demon king has been paying attention to him for a very, very long time.",
            "2020 - Now",
            "https://static.wikia.nocookie.net/heaven-officials-blessing/images/9/9d/Donghua_01.jpg/revision/latest/scale-to-width-down/620?cb=20200420184846")
        )
        shows.add(ShowsResponse("a23",
            "Grandmaster of Demonic Cultivation",
            "The Wen Clan's rampage caused untold sufferings, and the other cultivation clans launched the \"Sunshot Campaign\" to join forces against the Wen Clan. Although Wei Wuxian, the Yiling Patriarch, had made great contributions to overthrowing the Wens, he was stigmatized and punished because he was considered too powerful and dangerous. He was persecuted by ten thousand people.\n" +
                    "\n" +
                    "Thirteen years later, Wei Wuxian was brought back by a sacrificual ritual, and has met again with old acquaintances such as Lan Wangji from the Gusu Lan Clan and Jiang Cheng from the Yunmeng Jiang Clan. The mysteries of Wei Wuxian's past remain, and conflicts in the cultivation world have resurfaced - all of which began from when they were all once youths.",
            "2018 - Now",
            "https://static.wikia.nocookie.net/modao-zushi/images/e/e3/Mdzs-s1.png/revision/latest/scale-to-width-down/620?cb=20191115100416"))

        return shows
    }

    fun generateDetailMovie(movie: MovieEntity, movieFavorite: Boolean) : MovieEntity {
        movie.favoriteMovie = movieFavorite
        return movie
    }

    fun generateDetailShows(shows: ShowEntity, showsFavorite: Boolean) : ShowEntity {
        shows.favoriteShows = showsFavorite
        return shows
    }
}