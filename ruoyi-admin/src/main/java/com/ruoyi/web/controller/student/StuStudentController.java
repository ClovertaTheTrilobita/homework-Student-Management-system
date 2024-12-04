package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.StuStudent;
import com.ruoyi.system.service.IStuStudentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生Controller
 * 
 * @author SZF
 * @date 2024-12-04
 */
@RestController
@RequestMapping("/system/student")
public class StuStudentController extends BaseController
{
    @Autowired
    private IStuStudentService stuStudentService;

    /**
     * 查询学生列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuStudent stuStudent)
    {
        startPage();
        List<StuStudent> list = stuStudentService.selectStuStudentList(stuStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:export')")
    @Log(title = "学生", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuStudent stuStudent)
    {
        List<StuStudent> list = stuStudentService.selectStuStudentList(stuStudent);
        ExcelUtil<StuStudent> util = new ExcelUtil<StuStudent>(StuStudent.class);
        util.exportExcel(response, list, "学生数据");
    }

    /**
     * 获取学生详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:student:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuStudentService.selectStuStudentById(id));
    }

    /**
     * 新增学生
     */
    @PreAuthorize("@ss.hasPermi('system:student:add')")
    @Log(title = "学生", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuStudent stuStudent)
    {
        return toAjax(stuStudentService.insertStuStudent(stuStudent));
    }

    /**
     * 修改学生
     */
    @PreAuthorize("@ss.hasPermi('system:student:edit')")
    @Log(title = "学生", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuStudent stuStudent)
    {
        return toAjax(stuStudentService.updateStuStudent(stuStudent));
    }

    /**
     * 删除学生
     */
    @PreAuthorize("@ss.hasPermi('system:student:remove')")
    @Log(title = "学生", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuStudentService.deleteStuStudentByIds(ids));
    }
}
