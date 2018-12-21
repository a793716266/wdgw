$.fn.extend({
	rotatePlay: function(config) {
		/*
		 * config参数对象属性说明：
		 * direction:方向,取值'x'表示横向,'y'表示纵向
		 * inst:滚动距离,取值为number类型
		 * margin:间距,取值为number类型,默认为0
		 * count:显示区图片数量,取值为number类型,默认为1(显示区图片数量大于1时填写,否则显示将会存在问题)
		 * speed:播放速度,取值为number类型
		 * loop:是否无限循环下去,取值为boolean,默认为false
		 * autoWidth:自动重置宽度,取值为boolean类型(浏览器窗口大小发生改变时可能会改变一些百分比宽度的元素尺寸,取true可以解决)
		 */
		//config.direction:方向,value("x"表示横向,"y"表示纵向)
		var index = 0; //当前子元素索引
		var $container = $(this); //获取调用调用该方法的对象
		var autoWidth = config.autoWidth;
		if(autoWidth === undefined)
		autoWidth = true
		var distance = config.inst;
		var margin = config.margin ? config.margin : 0;
		if(!config.inst) {
			if(config.direction === 'x') {
				distance = $container.children().width();
			} else if(config.direction === 'y') {
				distance = $container.children().height();
			}
		}
		var loop = config.loop === undefined ? false : config.loop;
		var count = config.count ? config.count : 1
		var maxIndex = $container.children().length - count; //设置最大索引(子级数量-1)
		var end = new Date(); //上次生效时间
		if(config.direction === "x") {
			$container.width((maxIndex + 1) * $container.width());
		}
		//move(); //调用轮换方法
		var $rotateIndex = $container.parent().find(".rotateIndex")
			//轮换方法
		function move() {
			if(new Date() - end > 1000) { //两次轮换时间间隔需超过1000ms即1s
				if(autoWidth) {
					if(config.direction === 'x') {
						distance = $container.children().width();
					} else if(config.direction === 'y') {
						distance = $container.children().height();
					}
					if(config.direction === "x") {
						$container.width((maxIndex + 1) * $container.width());
					}
				}
				index++;
				if(index > maxIndex) {
					index = 0;
				}
				end = new Date(); //更新最近一次有效时间
				if(loop) {
					if(config.direction === "x") {
						//横向
						$container.find("li").first().css("marginLeft", `${-distance}px`);
						$container.find("li").eq(1).css("marginLeft", 0);
						setTimeout(function() {
							$container.find("li").first().css("marginLeft", margin).appendTo($container);

						}, 500)
					} else if(config.direction === "y") {
						//纵向
						$container.find("li").first().css("marginTop", `${-distance}px`);
						setTimeout(function(){
							$container.find("li").first().css("marginTop", margin).appendTo($container);
						},500);
						$container.find("li").eq(1).css("marginTop", 0);
					}
				} else {
					if(config.direction === "x") {
						//横向
						$container.css("transform", `translateX(${-index*distance}px)`);
					} else if(config.direction === "y") {
						//纵向
						$container.css("transform", `translateY(${-index*distance}px)`);
					}
				}
				$rotateIndex.eq(index).addClass("active").siblings().removeClass("active");

			}
			//实现定时调用
			//setTimeout(move, config.speed ? config.speed : 3000);
		}
		/*
		 * 若使用轮换按钮,需遵循以下原则:
		 * 1.轮换容器($container)需在另一个容器中(body)除外
		 * 2.按钮和轮换容器同级且在轮换容器之前
		 * 3.按钮基类(rotateBtn)必须为按钮添加
		 * 4.除了按钮基类外,还需指定按钮的切换目标,需为其添加样式(btnNext:切换下/btnPrev:切换上)
		 * 5.按钮类不会添加默认样式,如需css样式请自行添加
		 */
		var $rotateBtn = $container.parent().find(".rotateBtn"); //获取轮换按钮
		$rotateBtn.click(function() {
			if(new Date() - end > 500) {
				if(autoWidth) {
					if(config.direction === 'x') {
						distance = $container.children().width();
					} else if(config.direction === 'y') {
						distance = $container.children().height();
					}
					if(config.direction === "x") {
						$container.width((maxIndex + 1) * $container.width());
					}
				}

				let inst = distance;
				if($(this).is(".btnPrev")) { //判断按钮为切换上/下
					inst *= -1;
					index--;
					if(index < 0) {
						index = maxIndex;
					}
					if(loop) {
						let last = $container.find("li").eq(maxIndex+count-1);
						last.prependTo($container);
						if(config.direction === "x") {
							last.css("marginLeft", `${inst}`);
						} else if(config.direction === "y") {
							last.css("marginTop", `${inst}`);
						}
					}
				} else if($(this).is(".btnNext")) {
					index++;
					if(index > maxIndex) {
						index = 0;
					}
				}

				if(loop) {
					if(config.direction === "x") {
						//横向
						if(inst > 0) {
							$container.find("li").first().css("marginLeft", `${-inst}px`);
							$container.find("li").eq(1).css("marginLeft", 0);
							setTimeout(function() {
								$container.find("li").first().css("marginLeft", margin).appendTo($container);
							}, 500)
						}else{
							$container.find("li").css("transition","none");
							$container.find("li").first().css("marginLeft", inst);
							$container.find("li").eq(1).css("marginLeft", margin);
							$container.find("li").first().animate({"marginLeft":0},500)
							setTimeout(function(){
								$container.find("li").css("transition","ease 0.5s");
							},500)
						}
					} else if(config.direction === "y") {
						//纵向
						$container.find("li").first().css("marginTop", `${-inst}px`);
						$container.find("li").eq(1).css("marginTop", 0);
						setTimeout(function() {
							$container.find("li").first().css("marginTop", margin).appendTo($container);
						}, 500)
					}
				} else {
					if(config.direction === "x") {
						$container.css("transform", `translateX(${-index*distance}px)`);
					} else if(config.direction === "y") {
						$container.css("transform", `translateY(${-index*distance}px)`);
					}
				}
				$rotateIndex.eq(index).addClass("active").siblings().removeClass("active");
				end = new Date();
			}
		});

		//序号点(不可用于loop)
		$rotateIndex.click(function() {
			index = $(this).index() - 1;
			if(config.direction === "x") {
				$container.css("transform", `translateX(${-index*distance}px)`);
			} else if(config.direction === "y") {
				$container.css("transform", `translateY(${-index*distance}px)`);
			}
			$(this).addClass("active").siblings().removeClass("active");
		})
		return $container;
	}
});