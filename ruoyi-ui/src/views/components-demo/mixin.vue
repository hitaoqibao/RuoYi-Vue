<template>
  <div class="app-container">
    <div class="real-container">
      <el-row>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>Buttons</span>
          </div>
          <div style="margin-bottom:50px;">
            <el-col :span="4" class="text-center">
              <router-link class="pan-btn blue-btn" to="/documentation/index"
                >Documentation</router-link
              >
            </el-col>
            <el-col :span="4" class="text-center">
              <router-link class="pan-btn light-blue-btn" to="/icon/index"
                >Icons</router-link
              >
            </el-col>
            <el-col :span="4" class="text-center">
              <router-link class="pan-btn pink-btn" to="/excel/export-excel"
                >Excel</router-link
              >
            </el-col>
            <el-col :span="4" class="text-center">
              <router-link class="pan-btn green-btn" to="/table/complex-table"
                >Table</router-link
              >
            </el-col>
            <el-col :span="4" class="text-center">
              <router-link class="pan-btn tiffany-btn" to="/example/create"
                >Form</router-link
              >
            </el-col>
            <el-col :span="4" class="text-center">
              <router-link class="pan-btn yellow-btn" to="/theme/index"
                >Theme</router-link
              >
            </el-col>
          </div>
        </el-card>
      </el-row>

      <el-row :gutter="20" style="margin-top:20px;">
        <el-col :span="6">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>Material Design 的input</span>
            </div>
            <div style="height:100px;">
              <el-form :model="demo" :rules="demoRules">
                <el-form-item prop="title">
                  <md-input
                    v-model="demo.title"
                    icon="el-icon-search"
                    name="title"
                    placeholder="输入标题"
                    >标题</md-input
                  >
                </el-form-item>
              </el-form>
            </div>
          </el-card>
        </el-col>

        <el-col :span="6">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>图片hover效果</span>
            </div>
            <div class="component-item">
              <pan-thumb
                width="100px"
                height="100px"
                image="https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif"
              ></pan-thumb>
            </div>
          </el-card>
        </el-col>

        <el-col :span="6">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>水波纹 waves v-directive</span>
            </div>
            <div class="component-item">
              <el-button v-waves type="primary">水波纹效果</el-button>
            </div>
          </el-card>
        </el-col>

        <el-col :span="6">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>hover text</span>
            </div>
            <div class="component-item">
              <mallki class-name="mallki-text" text="vue-element-admin" />
            </div>
          </el-card>
        </el-col>
      </el-row>

      <el-row :gutter="20" style="margin-top:20px;">
        <el-col :span="6">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>Share</span>
            </div>
            <div class="component-item" style="height:420px;">
              <dropdown-menu
                :items="articleList"
                style="margin:0 auto;"
                title="测试"
              />
            </div>
          </el-card>
        </el-col>
        <el-col :span="18">
          <el-card>
            <div slot="header">
              <span>翻页时间</span>
            </div>
            <el-divider content-position="left">不带日期</el-divider>
            <flip-time :show="false"></flip-time>
            <el-divider content-position="left">带日期(传统格式)</el-divider>
            <flip-time :show="true" :content="['/', '/', '']"></flip-time>
            <el-divider content-position="left">带日期(年月日)</el-divider>
            <flip-time :show="true"></flip-time>
            <el-divider content-position="left">翻页倒计时(待实现)</el-divider>
            <el-form inline="true">
              <el-form-item>
                <flip-down :endDate="0"></flip-down>
              </el-form-item>
              <el-form-item>
                <el-input
                  :style="{ width: '200px' }"
                  v-model="downtime"
                  placeholder="默认为123456秒"
                ></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary">开始</el-button>
              </el-form-item>
            </el-form>
            <el-divider content-position="left">普通倒计时</el-divider>
            <el-form inline="true">
              <el-form-item>
                <el-tag>
                  <time-count-down
                    :deadline="deadline"
                    :complete-zero="true"
                    :left-second="0"
                    :ignore-day="false"
                    @done="done()"
                    @update="update()"
                  ></time-count-down>
                </el-tag>
              </el-form-item>
              <el-form-item>
                <el-tag>
                  <time-count-down
                    :deadline="deadline"
                    :complete-zero="true"
                    :left-second="0"
                    :ignore-day="false"
                    @done="done()"
                    @update="update()"
                    v-slot="time"
                  >
                    {{ time.day }}天 {{ time.hour }}时 {{ time.minute }}分
                    {{ time.second }}秒
                  </time-count-down>
                </el-tag>
              </el-form-item>
              <el-form-item>
                <el-input
                  v-model="deadline"
                  :style="{ width: '100px' }"
                  placeholder="请输入秒数"
                  size="mini"
                ></el-input>
              </el-form-item>
            </el-form>
          </el-card>
        </el-col>
      </el-row>
      <el-row :gutter="20" style="margin-top:20px;">
        <el-col :span="8">
          <el-card>
            <div slot="header">
              <span>时钟样式</span>
            </div>
            <clock-page></clock-page>
          </el-card>
        </el-col>

        <el-col :span="16">
          <el-card>
            <div slot="header" class="clearfix">
              <span>滑块验证</span>
            </div>
            <el-row>
              <el-col :span="8">
                <el-button @click="handleClick(1)">最简单用法</el-button>
                <puzzle-verification
                  v-model="isVerificationShow1"
                  :onSuccess="handleSuccess"
              /></el-col>
              <el-col :span="8">
                <el-button @click="handleClick(2)">拼图形滑块</el-button>
                <puzzle-verification
                  v-model="isVerificationShow2"
                  :puzzleImgList="puzzleImgList"
                  blockType="puzzle"
                  :onSuccess="handleSuccess"
                />
              </el-col>
              <el-col :span="8">
                <el-button @click="handleClick(3)">控制大小</el-button>
                <puzzle-verification
                  v-model="isVerificationShow3"
                  width="300"
                  height="200"
                  blockSize="80"
                  blockRadius="5"
                  :onSuccess="handleSuccess"
                />
              </el-col>
            </el-row>
            <el-row :style="{ marginTop: '45px' }">
              <el-col :span="8">
                <el-button @click="handleClick(4)">
                  控制误差
                </el-button>
                <puzzle-verification
                  v-model="isVerificationShow4"
                  :puzzleImgList="puzzleImgList"
                  deviation="20"
                  blockType="puzzle"
                  :onSuccess="handleSuccess"
                />
              </el-col>
              <el-col :span="8">
                <el-button @click="handleClick(5)"
                  >控制滑块出现位置范围</el-button
                >
                <puzzle-verification
                  v-model="isVerificationShow5"
                  wraperPadding="50"
                  :onSuccess="handleSuccess"
                />
              </el-col>
            </el-row>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import PanThumb from "@/components/PanThumb";
import MdInput from "@/components/MDinput";
import Mallki from "@/components/TextHoverEffect/Mallki";
import DropdownMenu from "@/components/Share/DropdownMenu";
import waves from "@/directive/waves/index.js"; // 水波纹指令
import FlipTime from "@/components/FlipTime"; //翻页时间
import FlipDown from "@/components/FlipDown"; //翻页倒计时
import ClockPage from "@/components/ClockPage"; //时钟
import TimeCountDown from "@/components/TimeCountDown"; //倒计时
import PuzzleVerification from "@/components/puzzleVerification"; //滑动验证

export default {
  name: "ComponentMixinDemo",
  components: {
    PanThumb,
    MdInput,
    Mallki,
    DropdownMenu,
    FlipTime,
    FlipDown,
    ClockPage,
    TimeCountDown,
    PuzzleVerification
  },
  directives: {
    waves
  },
  data() {
    const validate = (rule, value, callback) => {
      if (value.length !== 6) {
        callback(new Error("请输入六个字符"));
      } else {
        callback();
      }
    };
    return {
      demo: {
        title: ""
      },
      demoRules: {
        title: [{ required: true, trigger: "change", validator: validate }]
      },
      articleList: [
        { title: "测试1" },
        { title: "测试2" },
        { title: "测试3" },
        { title: "测试4" },
        { title: "测试5" },
        { title: "测试6" }
      ],
      // 倒计时时间
      downtime: "",
      // 普通倒计时
      deadline: "",
      // 滑动验证图片
      puzzleImgList: [
        require("@/assets/verification/thumbnail-img01.jpg"),
        require("@/assets/verification/thumbnail-img02.jpg"),
        require("@/assets/verification/thumbnail-img03.jpg")
      ],
      isVerificationShow1: false,
      isVerificationShow2: false,
      isVerificationShow3: false,
      isVerificationShow4: false,
      isVerificationShow5: false
    };
  },
  methods: {
    // 滑动验证样式
    handleClick(n) {
      switch (n) {
        case 1:
          this.isVerificationShow1 = !this.isVerificationShow1;
          break;
        case 2:
          this.isVerificationShow2 = !this.isVerificationShow2;
          break;
        case 3:
          this.isVerificationShow3 = !this.isVerificationShow3;
          break;
        case 4:
          this.isVerificationShow4 = !this.isVerificationShow4;
          break;
        default:
          this.isVerificationShow5 = !this.isVerificationShow5;
      }
    },
    handleSuccess() {
      console.log("验证成功了");
    }
  }
};
</script>

<style scoped>
.component-item {
  min-height: 100px;
}
</style>
