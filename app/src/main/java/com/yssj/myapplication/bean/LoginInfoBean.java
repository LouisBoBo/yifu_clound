package com.yssj.myapplication.bean;

public class LoginInfoBean {

    private String orderToken;
    private UserInfoExtendDTO userInfoExtend;
    private Object userType;
    private String message;
    private int reviewers;
    private UserinfoDTO userinfo;
    private String token;
    private String status;

    public String getOrderToken() {
        return orderToken;
    }

    public void setOrderToken(String orderToken) {
        this.orderToken = orderToken;
    }

    public UserInfoExtendDTO getUserInfoExtend() {
        return userInfoExtend;
    }

    public void setUserInfoExtend(UserInfoExtendDTO userInfoExtend) {
        this.userInfoExtend = userInfoExtend;
    }

    public Object getUserType() {
        return userType;
    }

    public void setUserType(Object userType) {
        this.userType = userType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getReviewers() {
        return reviewers;
    }

    public void setReviewers(int reviewers) {
        this.reviewers = reviewers;
    }

    public UserinfoDTO getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserinfoDTO userinfo) {
        this.userinfo = userinfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class UserInfoExtendDTO {
        private int user_id;
        private int is_open;
        private int firstCashCardIsZero;
        private int showSpecialPage;
        private int bindBot;
        private int reviewers;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getIs_open() {
            return is_open;
        }

        public void setIs_open(int is_open) {
            this.is_open = is_open;
        }

        public int getFirstCashCardIsZero() {
            return firstCashCardIsZero;
        }

        public void setFirstCashCardIsZero(int firstCashCardIsZero) {
            this.firstCashCardIsZero = firstCashCardIsZero;
        }

        public int getShowSpecialPage() {
            return showSpecialPage;
        }

        public void setShowSpecialPage(int showSpecialPage) {
            this.showSpecialPage = showSpecialPage;
        }

        public int getBindBot() {
            return bindBot;
        }

        public void setBindBot(int bindBot) {
            this.bindBot = bindBot;
        }

        public int getReviewers() {
            return reviewers;
        }

        public void setReviewers(int reviewers) {
            this.reviewers = reviewers;
        }
    }

    public static class UserinfoDTO {
        private int user_id;
        private String nickname;
        private String phone;
        private String add_date;
        private int is_del;
        private int user_type;
        private String pic;
        private int email_status;
        private String hobby;
        private String bg_pic;
        private String imei;
        private int code_type;
        private int type;
        private int is_member;
        private int value;
        private int merge;
        private int user_mark;
        private String store_time;
        private int virtual_type;
        private int wx_sex;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAdd_date() {
            return add_date;
        }

        public void setAdd_date(String add_date) {
            this.add_date = add_date;
        }

        public int getIs_del() {
            return is_del;
        }

        public void setIs_del(int is_del) {
            this.is_del = is_del;
        }

        public int getUser_type() {
            return user_type;
        }

        public void setUser_type(int user_type) {
            this.user_type = user_type;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getEmail_status() {
            return email_status;
        }

        public void setEmail_status(int email_status) {
            this.email_status = email_status;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public String getBg_pic() {
            return bg_pic;
        }

        public void setBg_pic(String bg_pic) {
            this.bg_pic = bg_pic;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public int getCode_type() {
            return code_type;
        }

        public void setCode_type(int code_type) {
            this.code_type = code_type;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getIs_member() {
            return is_member;
        }

        public void setIs_member(int is_member) {
            this.is_member = is_member;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getMerge() {
            return merge;
        }

        public void setMerge(int merge) {
            this.merge = merge;
        }

        public int getUser_mark() {
            return user_mark;
        }

        public void setUser_mark(int user_mark) {
            this.user_mark = user_mark;
        }

        public String getStore_time() {
            return store_time;
        }

        public void setStore_time(String store_time) {
            this.store_time = store_time;
        }

        public int getVirtual_type() {
            return virtual_type;
        }

        public void setVirtual_type(int virtual_type) {
            this.virtual_type = virtual_type;
        }

        public int getWx_sex() {
            return wx_sex;
        }

        public void setWx_sex(int wx_sex) {
            this.wx_sex = wx_sex;
        }
    }
}
