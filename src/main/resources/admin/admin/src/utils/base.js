const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootb95v2/",
            name: "springbootb95v2",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "超市管理系统"
        } 
    }
}
export default base
