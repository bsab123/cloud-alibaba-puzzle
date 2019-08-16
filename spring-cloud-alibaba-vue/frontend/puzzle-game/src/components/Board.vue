<template>
  <div class="box">
    <button @click="shuffle">重置</button>
    <transition-group
      name="cell"
      tag="div"
      class="container"
    >
      <div
        @click.prevent="clickBlock(index)"
        v-for="(puzzle,index) in puzzles"
        :key="puzzle"
        v-text="puzzle"
        :class="puzzle === '0' || puzzle === 0? 'cell cells':'cell'"
      ></div>
    </transition-group>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      puzzles: []
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    init() {
      axios
        .get("/api/puzzle-provider/init")
        .then(res => (this.puzzles = res.data))
        .catch(err => alert("vue_请启动服务"));
    },
    // 打乱
    shuffle() {
      axios.get("/api/consumer-reset/reset").then(res => {
        if (res.data[0] === "500") {
          this.puzzles = ["熔", "断", "了"];
        } else this.puzzles = res.data;
      });
    },

    // 点击方块
    clickBlock(index) {
      let param = new URLSearchParams();
      param.append("index", index);
      param.append("puzzles", this.puzzles);
      axios
        .post("/api/consumer-click/move/?index="+index+"&puzzles="+this.puzzles)
        .then(res => (this.puzzles = res.data));
    },

    // 是否通过
    pass() {
      if (this.puzzles[8] === "0" || this.puzzles[8] === 0) {
        const newPuzzles = this.puzzles.slice(0, 8);
        const isPass = newPuzzles.every((e, i) => e === i + 1);
        if (isPass) {
          alert("666！");
        }
      }
    }
  }
};
</script>

<style>
.box {
  width: 400px;
  margin: 60px auto 0;
}

.container {
  display: flex;
  flex-wrap: wrap;
  width: 306px;
  margin-top: 10px;
  border: 1px solid #ccc;
}
.cell {
  color: #fff;
  font-size: 20px;
  display: flex;
  justify-content: space-around;
  align-items: center;
  width: 100px;
  height: 100px;
  margin: 1px;
  -moz-box-shadow: 0px 0px 3px #333333;
  -webkit-box-shadow: 0px 0px 3px #333333;
  box-shadow: 0px 0px 3px #333333;
  background-color: #996666;
}
.cells {
  background-color: #fff;
  -moz-box-shadow: 0px 0px 0px #333333;
  -webkit-box-shadow: 0px 0px 0px #333333;
  box-shadow: 0px 0px 0px #333333;
  z-index: -999;
}
.cell-move {
  transition: transform 0.5s;
}
</style>
