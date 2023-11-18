import { localAxios } from "@/util/http-commons";

const local = localAxios();

function listSido(success, fail) {
  local.get(`http://localhost:8080/spring/map/sido`).then(success).catch(fail);
}

function listGugun(param, success, fail) {
  local.get(`http://localhost:8080/spring/map/gugun`, { params: param }).then(success).catch(fail);
}

export { listSido, listGugun };
