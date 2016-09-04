CREATE TABLE Picture (
    id INT NOT NULL auto_increment,
    name VARCHAR(200) NOT NULL,
    path VARCHAR(1000) NOT NULL,
    businessType INT,
    bussinessId INT,
    PRIMARY KEY(id)
);

insert into Picture(name,path,businessType,bussinessId)
values('pic1','https://static.student-cdn.com/media/cache/light_gallery_main_desktop/mstr/country/united-kingdom/city/london/property/nido-west-hampstead/image-o6i642.jpeg',1,1);
insert into Picture(name,path,businessType,bussinessId)
values('pic2','https://static.student-cdn.com/media/cache/light_gallery_main_desktop/mstr/country/united-kingdom/city/london/property/nido-west-hampstead/gallery/image-22/image-nofrls.jpeg',1,1);
insert into Picture(name,path,businessType,bussinessId)
values('pic3','https://static.student-cdn.com/media/cache/light_gallery_main_desktop/mstr/country/united-kingdom/city/london/property/nido-west-hampstead/gallery/image-2/image-nofr8v.jpeg',1,1);
insert into Picture(name,path,businessType,bussinessId)
values('pic4','https://static.student-cdn.com/media/cache/light_gallery_main_desktop/mstr/country/united-kingdom/city/london/property/nido-west-hampstead/gallery/image-16/image-nofri7.jpeg',1,1);
insert into Picture(name,path,businessType,bussinessId)
values('pic5','https://static.student-cdn.com/media/cache/light_gallery_main_desktop/mstr/country/united-kingdom/city/london/property/nido-west-hampstead/gallery/image-6/image-nofrae.jpeg',1,1);

CREATE TABLE Introduce (
    id INT NOT NULL auto_increment,
    title VARCHAR(200) NOT NULL,
    digest VARCHAR(1000),
    content Text,
    businessType INT,
    bussinessId INT,
    PRIMARY KEY(id)
);


insert into Introduce(title,digest,content,businessType,bussinessId)
values('标题范例','','<p class=\"para\">Woburn Place提供一系列高品质、高标准的学生套房，所有房间都配备完善的现代化电器。套房类型有单间套房、1室1厅、2室1厅和双人间四种。每间卧室都包含独立卫浴，单间套房的床更大一些以及带有一个独立的厨房。</p>
<p class=\"para\">为丰富同学们的住宿生活，公寓安排了一些公共区域供大家休闲和娱乐，其中包括公共休息室、自习室、洗衣房和自行车库。公共休息室提供免费桌球和电视。公寓提供24小时安保服务，严格的门禁系统和监控设备为同学们的住宿安全提供保障。接待处的服务人员也随时为你提供各种服务，方便同学们的生活。</p>
<p class=\"para\">我们提供的所有伦敦学生公寓租约中，都已经包含了无线网络、财产保险和公共设施账单（例如水电）的费用，因此无需担心产生任何额外支出。</p>',1,2);
insert into Introduce(title,digest,content,businessType,bussinessId)
values('标题范例','','为丰富同学们的住宿生活，公寓安排了一些公共区域供大家休闲和娱乐，其中包括公共休息室、自习室、洗衣房和自行车库。公共休息室提供免费桌球和电视。公寓提供24小时安保服务，严格的门禁系统和监控设备为同学们的住宿安全提供保障。接待处的服务人员也随时为你提供各种服务，方便同学们的生活。',1,1);
insert into Introduce(title,digest,content,businessType,bussinessId)
values('周边场所','','<ul>
          <li>地铁站，步行4分钟</li>
          <li>中央火车站，步行4分钟</li>
          <li>探索博物馆，步行30秒</li>
          <li>Academy 现场音乐场所，步行3分钟</li>
          <li>The Gate娱乐中心，步行4分钟</li>
          <li>市中心购物，步行5分钟</li>
          <li>中国城，步行3分钟</li>
          <li>中央图书馆，步行9分钟</li>
        </ul>',1,1);

