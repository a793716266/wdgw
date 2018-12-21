//回复表单
Vue.component("replypostfrom", {
	template: `
			<div>
			  <input type="text" name="postid" id="postid" value="" />
			  <input type="text" name="userid" id="userid" value="" />
			  <input type="hidden" id="commencontent" value="" name="commencontent" maxlength="50" style="width: 0;" />
			  <input type="text" name="commentfloor" id="commentfloor" value="" />
			  <input type="text" name="commenttime" id="commenttime" value="" />
			  <input type="text" name="replierid" id="replierid" value="" />
			  <input type="text" name="level" id="level" value="0" />
		</div>
	`
})