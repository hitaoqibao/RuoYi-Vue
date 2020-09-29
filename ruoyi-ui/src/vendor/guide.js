// 指引内容
const steps = [{
    element: ".el-scrollbar",
    popover: {
      title: "菜单栏",
      description: "点击菜单项可切换右侧菜单内容",
      position: "right"
    }
  }, {
    element: ".navbar",
    popover: {
      title: "面包屑导航",
      description: "用于显示 当前导航菜单的位置",
      position: "bottom"
    }
  },
  {
    element: ".tags-view-container",
    popover: {
      title: "标签栏",
      description: "可以右键tab页进行相关操作，当tab过多时通过鼠标滚轮来滚动",
      position: "bottom"
    }
  },
  {
    element: ".user-avatar",
    popover: {
      title: "用户中心",
      description: "包括个人中心、新手指引、布局设置和退出登录",
      position: "left"
    }
  },
]

export default steps
